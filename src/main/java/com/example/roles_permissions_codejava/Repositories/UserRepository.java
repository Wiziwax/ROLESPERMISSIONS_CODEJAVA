package com.example.roles_permissions_codejava.Repositories;

import com.example.roles_permissions_codejava.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    public List<User> findAll();
}