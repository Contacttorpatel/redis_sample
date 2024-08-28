package com.java.cache.service;

import com.java.cache.Customer;

public interface CustomerService {

    public Customer getCustomerById(String id);

    public void evictAllCacheValues();

    public void evictSingleCacheValue(String cacheKey);

    public void evictAllCacheValues(String cacheName);
}
