package com.java.cache.service.impl;

import com.java.cache.Customer;
import com.java.cache.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig( cacheNames = {"Customer"})
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CacheManager cacheManager;

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Override
    @Cacheable( key = "#id")
    public Customer getCustomerById(String id){
        LOG.info("Getting customer information for id {}", id);
        return new Customer("User" + id, "contact_us@rpmail.com", id);

    }

    @Override
    @CacheEvict(value = "Customer", allEntries = true)
    public void evictAllCacheValues() {
        LOG.info("Getting customer Cleared");
    }
    @Override
    @CacheEvict(value = "Customer", key = "#id")
    public void evictSingleCacheValue(String id) {
        LOG.info("Getting customer Cleared for key Id");
    }
    @Override
    public void evictAllCacheValues(String cacheName) {
        cacheManager.getCache(cacheName).clear();
    }



}
