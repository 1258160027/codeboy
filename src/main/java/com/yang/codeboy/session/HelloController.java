package com.yang.codeboy.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-02
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;
    @GetMapping("/set")
    public String set(HttpSession session){
        session.setAttribute("user","mylove");
        return String.valueOf(port);
    }
    @GetMapping("/get")
    public String get(HttpSession session){
        return session.getAttribute("user")+":"+port;
    }

}
