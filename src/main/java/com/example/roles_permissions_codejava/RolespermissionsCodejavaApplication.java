package com.example.roles_permissions_codejava;

import com.example.roles_permissions_codejava.Models.Role;
import com.example.roles_permissions_codejava.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RolespermissionsCodejavaApplication {

    @Autowired
    private RoleRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(RolespermissionsCodejavaApplication.class, args);


    }


//    @Bean
//    	CommandLineRunner runner() {
//        return args -> {
//            Role roleAdmin = new Role(1, "Admin", "manage everything");
//            Role roleDeveloper = new Role(2, "Developer", "fixes bugs");
//            Role roleUser = new Role(3, "User", "is a user");
//
//            List<Role> unbelievable;
//            unbelievable= repo.saveAll(List.of(roleAdmin, roleDeveloper, roleUser));
//            System.out.println(unbelievable);
//        };
//    }




    }
