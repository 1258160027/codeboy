package com.yang.codeboy.testmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-23
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            Integer key = iterator1.next();
            System.out.println(key+"---"+map.get(key));
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
        map.forEach((key,value)->{
            System.out.println(key+"---"+value);
        });
        map.entrySet().parallelStream().forEach((a)->{
            System.out.println(a.getKey()+"---"+a.getValue());
        });
        map.entrySet().stream().forEach((a)->{
            System.out.println(a.getKey()+"---"+a.getValue());
        });
    }
}
