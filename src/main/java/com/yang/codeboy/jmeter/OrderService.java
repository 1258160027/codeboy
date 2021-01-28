package com.yang.codeboy.jmeter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-19
 */
@Service
public class OrderService{

    @Autowired
    private OrderDAO orderDAO;

    public int insert(Order order){
        return orderDAO.insert(order);
    }


}
