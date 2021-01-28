package com.yang.codeboy.celue;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
public interface Buyer {
    BigDecimal calPrice(BigDecimal orderPrice);
}
