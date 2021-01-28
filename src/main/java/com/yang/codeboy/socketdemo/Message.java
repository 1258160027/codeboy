package com.yang.codeboy.socketdemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-03
 */
@Data
@AllArgsConstructor
public class Message implements Serializable {
    private String content;
}
