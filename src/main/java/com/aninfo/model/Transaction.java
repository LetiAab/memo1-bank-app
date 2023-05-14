package com.aninfo.model;
import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;
    private Long cbuAccount;
    private Double sum;
    private String type;

    public Transaction(){
    }

    public Transaction(String type, Long cbuAccount, Double sum){
        this.type = type;
        this.cbuAccount = cbuAccount;
        this.sum = sum;
    }
    public void setCbuAccount(Long cbu) {
        this.cbuAccount = cbu;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setSum(Double sum) {
        this.sum = sum;
    }

}
