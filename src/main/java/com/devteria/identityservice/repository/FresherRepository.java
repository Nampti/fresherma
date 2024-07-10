package com.devteria.identityservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devteria.identityservice.dto.response.FresherResponse;
import com.devteria.identityservice.entity.Fresher;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, Long>{

   

}
