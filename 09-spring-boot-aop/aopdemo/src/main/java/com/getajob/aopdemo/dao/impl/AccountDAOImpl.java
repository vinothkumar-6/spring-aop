package com.getajob.aopdemo.dao.impl;

import com.getajob.aopdemo.dao.AccountDAO;
import com.getajob.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println("Adding Account");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("Adding account paramater object"+account.toString());
    }

    @Override
    public void addBooleanAccount(Account account, boolean trueorflase) {
        System.out.println("AccountName : "+ account.getName()+"Account Level : "+account.getLevel()+ "Boolean : "+trueorflase);
    }

    @Override
    public List<Account> findAccount(){
//
        return findAccount(false);
    }

    @Override
    public List<Account> findAccount(boolean value){

        if(value){
            throw new RuntimeException("No soup for you");
        }
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("Vinoth Kumar","1"));
        accountList.add(new Account("Vihaan Sathish Kumar","2"));
        accountList.add(new Account("Suhashini Sathish Kumar","3"));
        return accountList;
    }
}
