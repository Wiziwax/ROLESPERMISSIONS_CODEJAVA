package com.example.roles_permissions_codejava.Controllers;

import com.example.roles_permissions_codejava.Models.Role;
import com.example.roles_permissions_codejava.Repositories.RoleRepository;
import com.example.roles_permissions_codejava.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("roles")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String displayRoles(Model model){
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);

        return "roles/list-roles";
    }

    @GetMapping("/new")
    public String displayRoleForm(Model model) {

        Role aRole = new Role();
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("allRoles", roleList);
        model.addAttribute("role", aRole);
        return "roles/new-roles";
    }

    @PostMapping("save")
    public String createRoleForm(Role role) {
        roleRepository.save(role);
        //Use a redirect to prevent duplicate submissions

        return "redirect:/roles/";
    }
}