package com.redis.redisWithAnotation.service;

import com.redis.redisWithAnotation.model.Company;
import com.redis.redisWithAnotation.repository.CompanyRepository;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private final CacheManager cacheManager;

    public CompanyService(CompanyRepository companyRepository, CacheManager cacheManager) {
        this.companyRepository = companyRepository;
        this.cacheManager = cacheManager;
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Cacheable("companyName")
    public Company getById(Long id) {
        System.out.println("asdassadas");
        return companyRepository.findById(id).get();
    }


    @CacheEvict(value = "companyName", key = "#id")
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Cacheable("companyName")
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
    @CachePut(value = "companyName", key = "#id")
    public Company updateCompany(Long id,Company company) {
        Company oldCompany = companyRepository.findById(id).get();
        oldCompany.setName(company.getName());
        oldCompany.setCity(company.getCity());
        oldCompany.setAddress(company.getAddress());
        return companyRepository.save(oldCompany);
    }
}
