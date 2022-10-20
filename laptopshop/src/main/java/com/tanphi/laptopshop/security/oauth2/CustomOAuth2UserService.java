package com.tanphi.laptopshop.security.oauth2;


import com.tanphi.laptopshop.entity.Accounts;
import com.tanphi.laptopshop.entity.enums.IsDeleteStatus;
import com.tanphi.laptopshop.repository.AccountsRepo;
import com.tanphi.laptopshop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Lazy
    private final AuthenticationService authenticationService;
    private final AccountsRepo accountsRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String provider = userRequest.getClientRegistration().getRegistrationId();
        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserFactory.getOAuth2UserInfo(provider, oAuth2User.getAttributes());
        Accounts user = accountsRepository.findAccountsByGmailAndActiveAccount(oAuth2UserInfo.getEmail(), IsDeleteStatus.NO.getCode());

        if (user == null) {
            user = authenticationService.registerOauth2User(provider, oAuth2UserInfo);
        } else {
            user = authenticationService.updateOauth2User(user, provider, oAuth2UserInfo);
        }
        return oAuth2User;
    }
}
