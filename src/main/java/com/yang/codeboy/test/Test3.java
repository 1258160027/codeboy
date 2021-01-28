package com.yang.codeboy.test;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-07
 */
public class Test3 {
    public static void main(String[] args) {
        // 获取当前日期，倒推一天
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = now.plusDays(-1);
        // 一天中的零点和一天中的最后时间
        LocalDateTime startDate = LocalDateTime.of(dateTime.toLocalDate(), LocalTime.MIN);
        LocalDateTime endDate = LocalDateTime.of(dateTime.toLocalDate(), LocalTime.MAX);
        // 格式化时间
        String beginTime = DateUtil.format(startDate,"yyyy-MM-dd HH:mm:ss");
        String endTime = DateUtil.format(endDate,"yyyy-MM-dd HH:mm:ss");
        System.out.println(beginTime+"-------------"+endTime);
    }
}
