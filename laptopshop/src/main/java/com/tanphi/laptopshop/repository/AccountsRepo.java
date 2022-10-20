package com.tanphi.laptopshop.repository;

import com.tanphi.laptopshop.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepo extends JpaRepository<Accounts,Integer> {
    Accounts findAccountsByGmailAndActiveAccount(String email,Integer status);
    Accounts findAccountsByActivationCode(String code);
    Accounts findAccountsByGmail(String email);
    Accounts findAccountsByPasswordresetCode(String code);
    Accounts findAccountsByUsernameAndRoles(String username,Integer roles);
}
