package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    // making my Dao

    private final UserRepository userDao;
    private final PostRepository postDao;
    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

//    private final PostRepository postDao;
//
//    public PostController (PostRepository postDao) {
//        this.postDao = postDao;
//    }

    @GetMapping("/post/index")
    public String allPost(Model model){
        List<Post> allPost = postDao.findAll();
        model.addAttribute("allPost",allPost);
        return "/post/index";
    }

    @GetMapping("/post/show")
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
//    setting the params that are going to be inputted to the database
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
//        create a new post object with the params passed through the html
        Post post = new Post(title,body);
//        save object using the objectDao
        postDao.save(post);
//        finally show the page of your liking
        return "redirect:/post/index";
    }

//    @PostMapping("/new")
//public String addCoffee(@RequestParam(name="roast") String roast, @RequestParam(name="origin") String origin, @RequestParam(name="brand") String brand, @RequestParam(name="supplier") long id){
//    Supplier supplier = supplierDao.findById(id);
//    Coffee coffee = new Coffee(roast, origin, brand, supplier);
//    coffeeDao.save(coffee);
//    return "redirect:/coffee/all-coffees";
//}

//    @PostMapping("/new")
//    public String addCoffee(@RequestParam(name="roast") String roast, @RequestParam(name="origin") String origin, @RequestParam(name="brand") String brand){
//        Coffee coffee = new Coffee(roast, origin, brand);
//        coffeeDao.save(coffee);
//        return "redirect:/coffee/all-coffees";
//    }
//
    @GetMapping("/post/user-form")
    public String postForm(){
        return "post/user-form";
    }

//         Suppliers for relationship walk through
//    @GetMapping("/post/user-form")
//    public String showSuppliersForm(Model model){
//
//
//        List<Supplier> suppliers = supplierDao.findAll();
//
//
//        model.addAttribute("suppliers", suppliers);
//        return "/post/user-form";
//    }

    @PostMapping("user-form")
    public String insertSupplier(@RequestParam(name = "email")String email,@RequestParam(name = "username")String username,@RequestParam(name = "password")String password) {

        User user = new User(email,username,password);

        userDao.save(user);

        return "redirect:post/user-form";
    }


}
