package com.example.roles_permissions_codejava.Repositories;
import com.example.roles_permissions_codejava.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
