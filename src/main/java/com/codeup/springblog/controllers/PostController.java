package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping
    public String allPost(Model model){
        Post post1 = new Post(1,"first","my first post");
        Post post2 = new Post(2,"first","my second post");
        List<Post> allPost = new ArrayList<>(List.of(post1,post2));

        model.addAttribute("allPost",allPost);

        return "/post/index";
    }

    @GetMapping("/index")
    public String index(){
        return "/post/index";
    }

    @GetMapping("/show")
    public String show(){
        return "/post/show";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable String post, Model model){
        Post post1 = new Post(1,"first","my first post");
        Post post2 = new Post(2,"first","my second post");
        Post post3 = new Post(3,"yo","hey hey hey");
        List<Post> allPost = new ArrayList<>(List.of(post1,post2,post3));
//        for(Post UserPost: allPost){
//            if(UserPost.getId() == id){
//                post = userPost
//            }
//
//        }


        model.addAttribute("post",post3);
        return "/post/show";
    }




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
