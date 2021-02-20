package com.yang.codeboy;


import com.yang.codeboy.es.Book;
import com.yang.codeboy.es.BookRepository;
import com.yang.codeboy.io.InHandlerDemo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class CodeboyApplicationTests {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private SearchOperations searchOperations;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testAdd(){
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setId((long)i);
            book.setName("白雪公主"+i);
            book.setPrice(15.9F);
            book.setType("童话");
            book.setBuyDate(new Date());
            bookRepository.save(book);
        }
        for (int i = 5; i < 10; i++) {
            Book book = new Book();
            book.setId((long) i);
            book.setName("老人与海"+i);
            book.setType("寓言");
            book.setBuyDate(new Date());
            book.setPrice(10.9F);
            bookRepository.save(book);
        }
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(1L);
        book.setPrice(22F);
        book.setName("白雪公主21");
        Book bookView = bookRepository.getById(book.getId());
        if (bookView != null){
            BeanUtils.copyProperties(book,bookView);
            bookRepository.save(bookView);
        }
    }

    @Test
    void save(){
        /*
        Book book = new Book();
        book.setId(1L);
        book.setPrice(22F);
        book.setName("白雪公主21");
        Book book2 = new Book();
        book.setId(11L);
        book.setPrice(212F);
        book.setName("白雪公主212");
        //redisTemplate.opsForValue().set("book",book);
        redisTemplate.opsForSet().add("book1",book);
        redisTemplate.opsForSet().add("book1",book2);
         */
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("price",11);
        map.put("name","白雪公主212");
        redisTemplate.opsForHash().putAll("bookMap",map);
    }

    @Test
    public void testInHandlerLifeCircle() {
        final InHandlerDemo handlerDemo = new InHandlerDemo();
        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(handlerDemo);
            }
        };
        EmbeddedChannel channel = new EmbeddedChannel(i);
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(1);
        channel.writeInbound(buf);
        channel.flush();
        channel.writeInbound(buf);
        channel.flush();
        channel.close();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
