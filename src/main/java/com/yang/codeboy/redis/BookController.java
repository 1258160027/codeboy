package com.yang.codeboy.redis;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import com.yang.codeboy.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-16
 */
@RestController
@RequestMapping("/redis")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public Book getOne(@PathVariable Integer id){
        return bookService.getOne(id);
    }

    @GetMapping("/simpleTest")
    public Book simpleTest(){
        List<Book> bookList = bookService.list();
        Book book = bookList.get(0);
        String key = "redis:simple:" + book.getId();
        redisTemplate.opsForValue().set(key,book);
        Book one = (Book) redisTemplate.opsForValue().get(key);
        return one;
    }

    @GetMapping("/hashTest")
    public Book hashTest(){
        List<Book> bookList = bookService.list();
        Book book = bookList.get(0);
        String key = "redis:hash:" + book.getId();
        Map<String,Object> value = BeanUtil.beanToMap(book);
        redisService.hSetAll(key,value);
        Map<Object,Object> cacheValue = redisService.hGetAll(key);
        Book one = BeanUtil.mapToBean(cacheValue,Book.class,true);
        return one;
    }

    @GetMapping("/setTest")
    public Set<Object>  setTest(){
        List<Book> bookList = bookService.list();
        String key = "redis:set:all";
        redisService.sAdd(key, (Object[]) ArrayUtil.toArray(bookList,Book.class));
        redisService.sRemove(key,bookList.get(0));
        Set<Object> set = redisService.sMembers(key);
        return set;
    }

    @GetMapping("/listTest")
    public List<Object>  listTest(){
        List<Book> bookList = bookService.list();
        String key = "redis:list:all";
        redisService.lPushAll(key, (Object[]) ArrayUtil.toArray(bookList,Book.class));
        redisService.lRemove(key,1,bookList.get(0));
        List<Object> list = redisService.lRange(key,0,3);
        return list;
    }

}
