package com.tanphi.laptopshop.security.oauth2;

import com.tanphi.laptopshop.entity.Accounts;
import com.tanphi.laptopshop.entity.enums.IsDeleteStatus;
import com.tanphi.laptopshop.repository.AccountsRepo;
import com.tanphi.laptopshop.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtProvider jwtProvider;
    @Autowired
    AccountsRepo accountsRepo;

    @Value("${hostname}")
    private String hostname;
//    String hostname1="localhost:8080";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = (String) oAuth2User.getAttributes().get("email");
        String token = jwtProvider.createToken(email, "CUSTOMER");
        Accounts account=accountsRepo.findAccountsByGmailAndActiveAccount(email, IsDeleteStatus.NO.getCode());;
        String Id=account.getAccountId().toString();
        String username=account.getUsername();
        String provider=account.getProvider().toString();
        String uri = UriComponentsBuilder.fromUriString(hostname + "/oauth2/redirect")
                .queryParam("token", token).queryParam("id",Id).queryParam("username",username).queryParam("userRoles","CUSTOMER").queryParam("provider",provider)
                .build().toUriString();
        getRedirectStrategy().sendRedirect(request, response, uri);
    }
}
