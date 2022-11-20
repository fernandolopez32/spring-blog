package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
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

    // making my Dao
    private final PostRepository postDao;

    public PostController (PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/index")
    public String allPost(Model model){
        Post post1 = new Post(1,"first","my first post");
        Post post2 = new Post(2,"first","my second post");
        List<Post> allPost = new ArrayList<>(List.of(post1,post2));
        model.addAttribute("allPost",allPost);
        return "/post/index";
    }

    @GetMapping("/show")
    public String show(){
        return "/post/show";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        Post post1 = new Post(1,"first","my first post");
        Post post2 = new Post(2,"first","my second post");
        Post post3 = new Post(3,"yo","hey hey hey");
        List<Post> allPost = new ArrayList<>(List.of(post1,post2,post3));

        Post post = null;
        for(Post UserPost: allPost){
            if(UserPost.getId() == id){
                post = UserPost;
            }
        }
        model.addAttribute("post",post);
        return "/post/show";
    }


    @GetMapping("/post/create")
    public String createPostForm(){
        return "/post/create";
    }


    @PostMapping("/post/create")
    public String createPost(){
        return "/post/create";
    }


//    @PostMapping("/new")
//    public String addCoffee(@RequestParam(name="roast") String roast, @RequestParam(name="origin") String origin, @RequestParam(name="brand") String brand){
//        Coffee coffee = new Coffee(roast, origin, brand);
//        coffeeDao.save(coffee);
//        return "redirect:/coffee/all-coffees";
//    }


}
