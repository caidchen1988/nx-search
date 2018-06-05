package com.nx.search.controller;

import com.nx.search.service.INxSearchService;
import com.nx.search.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 *
 * @author: caidchen
 * @create: 2018-03-20 9:14
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {
    @Autowired
    private INxSearchService jobService;

    @GetMapping("/")
    public String index() {
        return "index" ;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/search")
    public String search() {
        return "search";
    }

    @GetMapping(value = "/search/detail")
    public ModelAndView detail(@RequestParam("type") Integer type, @RequestParam("card") String card, @RequestParam("name") String name) {

        ModelAndView modelAndView = new ModelAndView("detail");
        Result result = null ;
        if(type == 2) {
            result = jobService.findOnlyByIdCard(card, name);
        } else {
            result = jobService.findOnlyByReport(card, name);
        }

        if(result != null && result.getSuccess()) {
            modelAndView.addObject("data", result.getData()) ;
        }

        return modelAndView;
    }
}
