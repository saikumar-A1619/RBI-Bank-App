package com.minibanking.repository;


import com.minibanking.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbiRepository extends JpaRepository<CustomerDetails,Long> {


    public CustomerDetails findByholderaccountnumber(String holderaccountnumber);
}
