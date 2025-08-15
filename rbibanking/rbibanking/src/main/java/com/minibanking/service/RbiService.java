package com.minibanking.service;

import com.minibanking.model.CustomerDetails;
import com.minibanking.repository.RbiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RbiService {

    @Autowired
    private RbiRepository rbiRepository;


    public List<CustomerDetails> getCustomerDetails() {
       return rbiRepository.findAll();
    }

    public CustomerDetails getDetailsByaccountnumber(String accountnumber) {
        return rbiRepository.findByholderaccountnumber(accountnumber);
    }

    public  double getBalance(String accountnumber){
        CustomerDetails details=rbiRepository.findByholderaccountnumber(accountnumber);
        return details.getHolderbalance();
    }

    public CustomerDetails addCustomerDetails(CustomerDetails customerDetails) {
        return rbiRepository.save(customerDetails);
    }

    public String addBalance(CustomerDetails customerDetails) {
         rbiRepository.save(customerDetails);
         return "Balance Credited";
    }

    public String takeBalance(CustomerDetails customerDetails) {
        rbiRepository.save(customerDetails);
        return "Balance Debited";
    }
}
