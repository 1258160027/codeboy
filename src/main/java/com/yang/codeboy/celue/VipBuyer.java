package com.yang.codeboy.celue;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
public class VipBuyer implements Buyer{
    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        int  superVipExpiredDays  = 15;
        int superVipLeadDiscountTimes  = 0;
        if(superVipExpiredDays < 7 && superVipLeadDiscountTimes == 0){
            return orderPrice.multiply(new BigDecimal(0.8));
        }
        return orderPrice.multiply(new BigDecimal(0.9));
    }
}
