package com.yang.codeboy.mylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-13
 */
public class MyList {
    public static void main(String[] args) {
        ArrayList<Integer> recourse = new ArrayList<>(Arrays.asList(1,1,2,2,2,3,3,4,5,5,6,7,7,7,8,9));
        System.out.println("1----"+recourse);
        LinkedHashSet<Integer> target = new LinkedHashSet<>(recourse);
        System.out.println("2----"+target);
        ArrayList<Integer> result = new ArrayList<>(target);
        System.out.println("3----"+result);
        List<Integer> list = recourse.stream().distinct().collect(Collectors.toList());
        System.out.println("4----"+list);
        List<Integer> list1 = Stream.of(1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 6, 7, 7, 7, 8, 9).distinct().collect(Collectors.toList());
        System.out.println("5----"+list1);

    }
}
