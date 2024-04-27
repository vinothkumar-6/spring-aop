package com.getajob.aopdemo.dao;

import com.getajob.aopdemo.entity.Account;

import java.util.List;

public interface AccountDAO {

    public void addAccount();

    public void addAccount(Account account);

    public void addBooleanAccount(Account account, boolean trueorflase );

    public List<Account> findAccount();
    public List<Account> findAccount(boolean value);

}
