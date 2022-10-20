package com.tanphi.laptopshop.service;

import com.tanphi.laptopshop.entity.Accounts;
import com.tanphi.laptopshop.entity.enums.ActiveAccountStatus;
import com.tanphi.laptopshop.entity.enums.AuthProvider;
import com.tanphi.laptopshop.entity.enums.Roles;
import com.tanphi.laptopshop.exception.DuplicateRecoredException;
import com.tanphi.laptopshop.exception.SendMailException;
import com.tanphi.laptopshop.repository.AccountsRepo;
import com.tanphi.laptopshop.request.register.RegistrationRequest;
import com.tanphi.laptopshop.security.JwtProvider;
import com.tanphi.laptopshop.security.oauth2.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.tanphi.laptopshop.email.MailSender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService_impl implements AuthenticationService {

    private final JwtProvider jwtProvider;
    private final MailSender mailSender;
    @Autowired
    private AccountsRepo accountsRepo;

    @Value("${hostname}")
    private String hostname;

    @Override
    public Map<String, String> login(String username,Integer role) {
        Accounts account = accountsRepo.findAccountsByUsernameAndRoles(username,role);
        String id=account.getAccountId().toString();
//        String imageLink=account;

        String userRole = account.getRoles().toString();
        String token = jwtProvider.createToken(username, userRole);

        Map<String, String> response = new HashMap<>();
        response.put("id",id);
        response.put("username", username);
        response.put("token", token);
        response.put("userRole", userRole);
        return response;
    }

    @Override
    public void registerUser(RegistrationRequest request) {
        List<Accounts> list=accountsRepo.findAll();
        for(Accounts accountsEntity:list)
        {
            if(accountsEntity.getUsername().equals(request.getGmail()) || accountsEntity.getGmail().equals(request.getGmail()))
            {
                throw new DuplicateRecoredException("Tài khoản đã tồn tại rồi");
            }
        }
        Accounts accountRegister = new Accounts();
        accountRegister.setUsername(request.getGmail());
        accountRegister.setPasswords(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)));
        accountRegister.setGmail(request.getGmail());
        accountRegister.setActivationCode(UUID.randomUUID().toString());
        accountRegister.setActiveAccount(ActiveAccountStatus.ACTIVE.getCode());
        accountRegister.setProvider(AuthProvider.LOCAL.getCode());
        accountRegister.setRoles(Roles.CUSTOMER.getCode());
        accountRegister.setPasswordresetCode(null);
        accountsRepo.save(accountRegister);

        String subject = "Mã xác thực đăng kí tài khoản";
        String template = "registration-template";
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("fullname", request.getFirstname()+" "+request.getLastname());
        attributes.put("registrationUrl", "https://shoppt-reactapp.vercel.app"+ "/activate/" + accountRegister.getActivationCode());
        mailSender.sendMessageHtml(request.getGmail(), subject, template, attributes);
    }

    @Override
    public boolean activateUser(String code)
    {
        Accounts account=accountsRepo.findAccountsByActivationCode(code);
        if(account==null)
        {
            return false;
        }
        account.setActivationCode(null);
        account.setActiveAccount(ActiveAccountStatus.ACTIVE.getCode());
        accountsRepo.save(account);
        return true;
    }


    @Override
    public boolean sendPasswordResetCode(String email) {
        Accounts account=accountsRepo.findAccountsByGmail(email);
        if (account == null) return false;
        if(account.getPasswordresetCode()!=null)
        {
            throw new SendMailException("Mã đặt lại mật khẩu đã gửi về email, vui lòng kiểm tra lại!!!");
        }
        account.setPasswordresetCode(UUID.randomUUID().toString());
        accountsRepo.save(account);

        String subject = "Đặt lại mật khẩu";
        String template = "password-reset-template";
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("fullname", account.getFirstname()+" "+account.getLastname());
        attributes.put("resetUrl", "https://shoppt-reactapp.vercel.app"+ "/reset/" + account.getPasswordresetCode());
        mailSender.sendMessageHtml(account.getGmail(), subject, template, attributes);
        return true;
    }

    @Override
    public Accounts findByPasswordResetCode(String code) {
        Accounts account=accountsRepo.findAccountsByPasswordresetCode(code);
        return account;
    }

    @Override
    public String passwordReset(String email, String password) {
        Accounts account=accountsRepo.findAccountsByGmail(email);
        account.setPasswords(BCrypt.hashpw(password,BCrypt.gensalt(12)));
        account.setPasswordresetCode(null);
        accountsRepo.save(account);
        return "Mật khẩu đã thay đổi thành công";
    }

    @Override
    public Accounts registerOauth2User(String provider, OAuth2UserInfo oAuth2UserInfo) {
        Accounts account = new Accounts();
        account.setUsername(oAuth2UserInfo.getEmail());
        account.setGmail(oAuth2UserInfo.getEmail());
        account.setFirstname(oAuth2UserInfo.getFirstName());
        account.setLastname(oAuth2UserInfo.getLastName());
        account.setActiveAccount(ActiveAccountStatus.ACTIVE.getCode());
        account.setRoles(Roles.CUSTOMER.getCode());
        account.setProvider(AuthProvider.valueOf(provider.toUpperCase()).getCode());
        accountsRepo.save(account);
        return account;
    }

    @Override
    public Accounts updateOauth2User(Accounts accounts, String provider, OAuth2UserInfo oAuth2UserInfo) {
        return accounts;
    }
}
