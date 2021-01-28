package com.yang.codeboy.mybatisfortest;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-19
 */
@RestController
public class DController {
    @Autowired
    DMapper dMapper;

    @GetMapping("/scan/{limit}")
    @Transactional
    public void scan(@PathVariable("limit") int limit){
        try(Cursor<Book> cursor = dMapper.scan(limit)){
            cursor.forEach(foo ->{
                System.out.println(foo);
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
