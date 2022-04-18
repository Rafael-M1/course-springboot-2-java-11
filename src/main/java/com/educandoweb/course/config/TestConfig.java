package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888-8888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777-7777", "123456");
        
        Order o1 = new Order(null, Instant.parse("2022-01-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2022-02-02T10:42:07Z"), u2);
        Order o3 = new Order(null, Instant.parse("2022-03-04T05:12:07Z"), u1);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }


}
