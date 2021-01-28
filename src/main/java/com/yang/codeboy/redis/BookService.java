package com.yang.codeboy.redis;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-16
 */
@Service
public class BookService  {

    @Resource
    private BookMapper bookMapper;

    @CacheEvict(value = RedisConfig.REDIS_KEY_DATABASE,key = "'my:book:'+#id")
    public int update(Integer id,Book book){
        book.setId(id);
        return bookMapper.updateById2(id);
    }

//    @CacheEvict(value = RedisConfig.REDIS_KEY_DATABASE,key = "'my:book:'+#id")
//    public int delete(Integer id){
//        return bookMapper.deleteById(id);
//    }

    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE,key = "'my:book:'+#id",unless = "#result==null")
    public Book getOne(Integer id){
        return bookMapper.getOne(id);
    }


    public List<Book> list() {
        return bookMapper.selectList();
    }
}
