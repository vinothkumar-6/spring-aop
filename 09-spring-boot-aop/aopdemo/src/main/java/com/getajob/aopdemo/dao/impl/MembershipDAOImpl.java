package com.getajob.aopdemo.dao.impl;
import com.getajob.aopdemo.dao.MembershipDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println("Adding Membership Account");
    }

    @Override
    public boolean addSillyAccount() {
        System.out.println("Adding Membership addSillyAccount");
        return false;
    }


}
