package com.yang.codeboy.model;

import javafx.util.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
@Data
@AllArgsConstructor
public class GirlFriend {
    private String name;
    private Integer age;
    private String address;

    public static void main(String[] args) {
    }
}
