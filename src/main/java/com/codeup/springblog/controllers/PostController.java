package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/index")
    public String index(){
        return "/post/index";
    }

    @GetMapping("/show")
    public String show(){
        return "post/show";
    }
//
//    @GetMapping("/post/{id}")
//    @ResponseBody
//    public String ViewIdividualPost(@PathVariable String post){
//        return "index page " + post;
//    }
//    @GetMapping("/post/create")
//    @ResponseBody
//    public String viewCreate(){
//        return "index page";
//    }
//    @PostMapping("/post/create")
//    @ResponseBody
//    public String create(){
//        return "index page";
//    }





}
