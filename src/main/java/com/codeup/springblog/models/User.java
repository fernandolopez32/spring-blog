package com.codeup.springblog.models;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Object id;
    @Column(nullable = false, length = 80)
    private final Object email;
    @Column(nullable = false, length = 50)
    private final Object username;

    @Column(nullable = false, length = 50)
    private final Object password;



    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }



}
