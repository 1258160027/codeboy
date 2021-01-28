package com.yang.codeboy.jmeter;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-19
 */
@Mapper
@Repository
public interface OrderDAO {

    @Insert("insert into order_one values(#{order.id},#{order.number},#{order.name})")
    int insert(@Param("order") Order order);

}
