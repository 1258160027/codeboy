package com.yang.codeboy.celue;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
public class Test {
    public static void main(String[] args) {
        Buyer b1 = new VipBuyer();
        Cashier c1 = new Cashier(b1);
        BigDecimal quote = c1.quote(BigDecimal.valueOf(200));
        System.out.println("普通会员商品的最终价格为：" + quote.doubleValue());
        b1 = new SuperVipBuyer();
        c1 = new Cashier(b1);
        quote = c1.quote(BigDecimal.valueOf(200));
        System.out.println("超级会员商品的最终价格为：" + quote.doubleValue());
    }
}
