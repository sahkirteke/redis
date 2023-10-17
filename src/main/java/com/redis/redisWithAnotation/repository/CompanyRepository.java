package com.redis.redisWithAnotation.repository;

import com.redis.redisWithAnotation.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
