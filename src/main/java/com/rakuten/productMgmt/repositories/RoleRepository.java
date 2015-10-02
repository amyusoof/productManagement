package com.rakuten.productMgmt.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.productMgmt.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable> {

}
