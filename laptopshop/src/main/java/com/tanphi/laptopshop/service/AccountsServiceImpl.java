package com.tanphi.laptopshop.service;

import com.tanphi.laptopshop.entity.Accounts;
import com.tanphi.laptopshop.entity.enums.IsDeleteStatus;
import com.tanphi.laptopshop.repository.AccountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Autowired
    AccountsRepo accountsRepo;
    @Override
    public Accounts findAccountByGmail(String email) {
        return accountsRepo.findAccountsByGmailAndActiveAccount(email, IsDeleteStatus.NO.getCode());
    }
}
