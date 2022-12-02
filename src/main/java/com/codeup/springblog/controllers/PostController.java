package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    // making my Dao

    private final UserRepository userDao;
    private final PostRepository postDao;

    private final EmailService emailService;
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @GetMapping("/index")
    public String allPost(Model model){
        List<Post> allPost = postDao.findAll();
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


    @GetMapping("/create")
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());
        return "/post/create";
    }


    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userId = loggedInUser.getId();
        if (userId == 0){
            return "redirect:/login";
        }

        loggedInUser = userDao.findById(userId);
        post.setUser(loggedInUser);
        postDao.save(post);

        emailService.prepareAndSend(loggedInUser,post.getTitle(),post.getBody());
        return "redirect:/post/index";
    }

    @GetMapping("/user-form")
    public String postForm(){
        return "post/user-form";
    }


    @PostMapping("user-form")
    public String insertSupplier(@RequestParam(name = "email")String email,@RequestParam(name = "username")String username,@RequestParam(name = "password")String password) {
        User user = new User(email,username,password);
        userDao.save(user);
        return "redirect:post/index";
    }
    @GetMapping("/{id}/edit")
    public String editForm(Model model,@PathVariable long id){
        long currentUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if(currentUserId == 0){
            return "redirect:/login";
        }
        Post post = postDao.findById(id);
        if(post.getUser().getId() != currentUserId){
            return "redirect:/post/show";
        }
        model.addAttribute("post", post);
        return "/post/edit";
    }
    @PostMapping("/{id}/edit")
    public String editMethod(@ModelAttribute Post post){
        long currentUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();

        if(currentUserId == 0){
            return "redirect:/login";
        }
        User user = userDao.findById(currentUserId);

        post.setUser(user);
        postDao.save(post);
        return "redirect:/post/index";
    }


}
