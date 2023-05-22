package com.aninfo.model;
import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long numero;

    private Long cbuAccount;
    private Double sum;
    private String type;

    public Transaction(){}
    public Transaction(String type, Long cbuAccount, Double sum){
        this.type = type;
        this.cbuAccount = cbuAccount;
        this.sum = sum;
    }

    public Long getCbuAccount(){
        return cbuAccount;
    }
    public String getType(){
        return type;
    }

    public Double getSum(){
        return sum;
    }

}
