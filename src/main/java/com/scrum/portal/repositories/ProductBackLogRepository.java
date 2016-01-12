package com.scrum.portal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.scrum.portal.dto.ProductBackLogUserStory;

public interface ProductBackLogRepository extends CrudRepository<ProductBackLogUserStory, Integer>{
	

}
