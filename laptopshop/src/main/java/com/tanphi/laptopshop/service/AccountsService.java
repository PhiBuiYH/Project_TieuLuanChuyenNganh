package com.tanphi.laptopshop.service;


import com.tanphi.laptopshop.entity.Accounts;

public interface AccountsService {
    Accounts findAccountByGmail(String email);
}
