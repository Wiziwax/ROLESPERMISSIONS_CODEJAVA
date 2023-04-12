package com.example.roles_permissions_codejava.Controllers;


import com.example.roles_permissions_codejava.Models.Role;
import com.example.roles_permissions_codejava.Models.User;
import com.example.roles_permissions_codejava.Repositories.RoleRepository;
import com.example.roles_permissions_codejava.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/")
    public String displayUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "users/list-users";
    }

    @GetMapping("/new")
    public String displayUserForm(Model model){

        User aUser= new User();
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("allRoles", roleList);
        model.addAttribute("user", aUser);
        return "users/new-users";
    }

    @PostMapping("save")
    public String createUserForm(User user, Model model){
        userRepository.save(user);
        //Use a redirect to prevent duplicate submissions
        return "redirect:/users/";
    }


}
