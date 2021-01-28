package com.yang.codeboy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-19
 */
@Service
public class Order1Service {

    @Autowired
    private Order1DAO order1DAO;

    public int insert(Order order){
        return order1DAO.insert(order);
    }


}
