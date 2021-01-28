package com.yang.codeboy.celue;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
public class Cashier {
    private Buyer buyer;

    public Cashier(Buyer buyer){
        this.buyer = buyer;
    }

    public BigDecimal quote(BigDecimal orderPrice){
        return this.buyer.calPrice(orderPrice);
    }


}
