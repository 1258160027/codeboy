package com.yang.codeboy.test;

import lombok.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    private String name;
    private Integer price;
}
