package com.yang.codeboy.mybatisfortest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-19
 */
@Mapper
public interface DMapper {

    @Select("select * from book limit #{limit}")
    Cursor<Book> scan(@Param("limit") int limit);

}
