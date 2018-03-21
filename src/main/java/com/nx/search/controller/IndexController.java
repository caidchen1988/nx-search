package com.nx.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页
 *
 * @author: caidchen
 * @create: 2018-03-20 9:14
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index" ;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


}
