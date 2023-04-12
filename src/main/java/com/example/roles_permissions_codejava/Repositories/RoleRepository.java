package com.example.roles_permissions_codejava.Repositories;


import com.example.roles_permissions_codejava.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Override
    public List<Role> findAll();

}
