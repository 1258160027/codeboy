package com.yang.codeboy.mylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-13
 */
public class TestSet {
    public static void main(String[] args) {
        ArrayList<Integer> recourse = new ArrayList<>(Arrays.asList(1,1,2,2,2,3,3,4,5,5,6,7,7,7,8,9));
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < recourse.size(); i++) {
            if (set.add(recourse.get(i))){
                result.add(recourse.get(i));
            }
        }
        System.out.println(result);
    }
}
