package com.yang.codeboy.config;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

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
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer number;
    private String name;
}
