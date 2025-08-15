package com.minibanking.controller;

import com.minibanking.model.CustomerDetails;
import com.minibanking.service.RbiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/RBI")
public class RbiController {

    @Autowired
    private RbiService rbiService;

    //Account Number Generation

    public String accnogenerartion() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        String deffauitNum = "8008";
        buffer.append(deffauitNum);
        for (int i = 0; i < 8; i++) {
            buffer.append(random.nextInt(9) + 1);
        }
        return buffer.toString();
    }


    @PostMapping(value = "/addCusomerDetails")
    public CustomerDetails addCustomerDetails(@RequestBody CustomerDetails customerDetails) {
        customerDetails.setHolderaccountnumber(accnogenerartion());
        return rbiService.addCustomerDetails(customerDetails);
    }


    @GetMapping(value = "/getCustomerDetails")
    public List<CustomerDetails> getCustomerDetails() {
        return rbiService.getCustomerDetails();
    }

    @GetMapping(value = "/getaccountnumber/{accountnumber}")
    public CustomerDetails getDetailsByholderaccountnumber(@PathVariable String accountnumber) {
        return rbiService.getDetailsByaccountnumber(accountnumber);
    }

    @GetMapping(value = "/getBalance/{accountnumber}")
    public double getBalance(@PathVariable String accountnumber) {

        return rbiService.getBalance(accountnumber);
    }


    @PostMapping(value = "/addBalance")
    public String getCreditDetails(@RequestBody CustomerDetails customerDetails) {

        CustomerDetails getBalance = rbiService.getDetailsByaccountnumber
                (customerDetails.getHolderaccountnumber());

        if (getBalance == null) {
            return "Account number " + customerDetails.getHolderaccountnumber() + " not found";
        } else {
            getBalance.setHolderaccountnumber(customerDetails.getHolderaccountnumber());
            double balance = getBalance.getHolderbalance() + customerDetails.getHolderbalance();
            getBalance.setHolderbalance(balance);
            rbiService.addBalance(getBalance);
            return "Credited " + customerDetails.getHolderbalance() + " successfully";
        }
    }


    @PostMapping(value = "/takeBalance")
    public String takeBalance(@RequestBody CustomerDetails customerDetails) {
        CustomerDetails getBalance = rbiService.getDetailsByaccountnumber
                (customerDetails.getHolderaccountnumber());
        if (getBalance == null) {
            return customerDetails.getHolderaccountnumber() + "is Invalide";
        } else {
            if (getBalance.getHolderbalance() < customerDetails.getHolderbalance()) {
                return "Insufficient Balance";
            } else {
                getBalance.setHolderaccountnumber(customerDetails.getHolderaccountnumber());
                double balance = getBalance.getHolderbalance() - customerDetails.getHolderbalance();
                getBalance.setHolderbalance(balance);
                rbiService.takeBalance(getBalance);
                return "Debite " + customerDetails.getHolderbalance() + " successfully";
            }
        }
    }
}

