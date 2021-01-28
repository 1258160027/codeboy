package com.yang.codeboy.test;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-04
 */
public class Test2 {
    public static void main(String[] args) {
        Book book = Book.builder().name("三十而立").price(null).build();
        Book book2 = new Book();
//        System.out.println(book);
        Optional<Book> opt = Optional.ofNullable(book);
        Optional<Book> opt2 = Optional.of(book2);
        if (opt.isPresent()){
            Book book1 = opt.get();
            Book book3 = opt.orElse(new Book("222", 1));
            System.out.println(book1);
        }
    }
}
