package com.scrum.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrum.portal.dto.Product;;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
