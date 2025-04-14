package com.users.userservice.application.services.impl;

import com.users.userservice.application.dto.request.LoginUserRequest;
import com.users.userservice.application.dto.response.LoginUserResponse;
import com.users.userservice.application.services.IAuthService;
import com.users.userservice.application.utils.JwtUtils;
import com.users.userservice.application.utils.constants.ApplicationConstants;
import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.input.AuthServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthServicePort authServicePort;
    private final JwtUtils jwtUtils;

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        String email = loginUserRequest.email();
        String password = loginUserRequest.password();
        Authentication authentication = this.authenticate(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtils.createToken(authentication);
        return new LoginUserResponse(email, ApplicationConstants.LOGIN_MESSAGE, accessToken);
    }

    public Authentication authenticate (String email, String password) {
        UserModel user = authServicePort.login(email, password);
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
        return new UsernamePasswordAuthenticationToken(user.getId(), password, authorities);
    }
}
