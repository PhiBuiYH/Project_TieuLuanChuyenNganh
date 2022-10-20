package com.tanphi.laptopshop.security;

import com.tanphi.laptopshop.entity.Accounts;
import com.tanphi.laptopshop.entity.enums.IsDeleteStatus;
import com.tanphi.laptopshop.exception.DuplicateRecoredException;
import com.tanphi.laptopshop.repository.AccountsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountsRepo accountsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws DuplicateRecoredException {
        Accounts accounts=accountsRepo.findAccountsByGmailAndActiveAccount(username, IsDeleteStatus.NO.getCode());
        if (accounts == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserPrincipal.create(accounts);
    }
}