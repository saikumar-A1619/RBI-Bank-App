package com.minibanking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vgrobankings")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String holdername;
    private String holderaccountnumber;
    private String holderage;
    private String holderaddress;
    private double holderbalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoldername() {
        return holdername;
    }

    public void setHoldername(String holdername) {
        this.holdername = holdername;
    }

    public String getHolderaccountnumber() {
        return holderaccountnumber;
    }

    public void setHolderaccountnumber(String holderaccountnumber) {
        this.holderaccountnumber = holderaccountnumber;
    }

    public String getHolderage() {
        return holderage;
    }

    public void setHolderage(String holderage) {
        this.holderage = holderage;
    }

    public String getHolderaddress() {
        return holderaddress;
    }

    public void setHolderaddress(String holderaddress) {
        this.holderaddress = holderaddress;
    }

    public double getHolderbalance() {
        return holderbalance;
    }

    public void setHolderbalance(double holderbalance) {
        this.holderbalance = holderbalance;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + id +
                ", holdername='" + holdername + '\'' +
                ", holderaccountnumber='" + holderaccountnumber + '\'' +
                ", holderage='" + holderage + '\'' +
                ", holderaddress='" + holderaddress + '\'' +
                ", holderbalance=" + holderbalance +
                '}';
    }
}
