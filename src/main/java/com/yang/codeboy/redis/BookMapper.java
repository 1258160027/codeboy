package com.yang.codeboy.redis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-16
 */
@Mapper
@Repository
public interface BookMapper {

    @Select("select * from book")
    List<Book> selectList();

    @Select("select * from book where id = #{id}")
    Book getOne(Integer id);

    @Update("update book set bookName where id = #{id}")
    int updateById2(Integer id);


}
