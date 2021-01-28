package com.yang.codeboy.jmeter;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-19
 */
@Data
@EqualsAndHashCode
@Builder
@ToString
@TableName("order_one")
public class Order {
    private Long id;
    private Integer number;
    private String name;
}
