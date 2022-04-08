package com.smarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarts.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer> {
	
}
