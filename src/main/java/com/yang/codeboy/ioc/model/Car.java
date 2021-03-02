package com.yang.codeboy.ioc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

}
