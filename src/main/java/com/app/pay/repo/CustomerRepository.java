package com.app.pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pay.dto.CustomerOrder;

public interface CustomerRepository extends JpaRepository<CustomerOrder, Integer> {

}
