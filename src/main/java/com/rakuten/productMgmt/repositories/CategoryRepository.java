package com.rakuten.productMgmt.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.productMgmt.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Serializable> {

}
