package com.codeup.springblog.services;

import com.codeup.springblog.models.SpringBlogUserDetails;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringBlogUserDetailsService implements UserDetailsService {

    public final UserRepository userDao;

    public SpringBlogUserDetailsService(UserRepository userDao){
        this.userDao = userDao;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User details not found for user " + username);
        }else {
            return new SpringBlogUserDetails(user.getId(),user.getEmail(),user.getUsername(),user.getPassword());
        }
    }
}
