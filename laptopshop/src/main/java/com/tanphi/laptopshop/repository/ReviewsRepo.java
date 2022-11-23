package com.tanphi.laptopshop.repository;

import com.tanphi.laptopshop.entity.Reviews;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepo extends JpaRepository<Reviews,Integer> {
}
