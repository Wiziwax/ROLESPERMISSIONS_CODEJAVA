package com.example.roles_permissions_codejava.Controllers;

import com.example.roles_permissions_codejava.Models.Product;
import com.example.roles_permissions_codejava.Models.Role;
import com.example.roles_permissions_codejava.Services.ProductService;
import com.example.roles_permissions_codejava.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("api/v1/")
public class AppController {

    @Autowired
    private ProductService service;
    @Autowired
    private RoleRepository repo;



//    private static final List<Role> roles= Arrays.asList(
//            new Role( 1,"Admin", "manages everything" ),
//            new Role(2,"Developer", "fixes bugs"),
//            new Role(3,"User", "is a user")
//
//
//
//    );

    @GetMapping("/savealready")
    public void testCreateFirstRole(){
        Role roleAdmin = new Role(1,"Admin", "manage everything");
        Role roleDeveloper = new Role(2,"Developer", "fixes bugs");
        Role roleUser = new Role(3,"User", "is a user");
        repo.saveAll(List.of(roleAdmin, roleDeveloper, roleUser));

    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "roles/new-roles";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

//    @GetMapping(path="{studentId}")
//    public Role getStudent(@PathVariable("studentId") Integer studentId){
//        return roles.stream()
//                .filter(student -> studentId.equals(student.getId()))
//                .findFirst()
//                .orElseThrow(()->new IllegalStateException("Student" + studentId + "does not exist"));
//    }
}