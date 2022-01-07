package com.example.ios_back.service;

import com.example.ios_back.domain.Authority;
import com.example.ios_back.domain.User;
import com.example.ios_back.repository.UserRepository;

public class AuthorityPolicyImpl implements AuthorityPolicy{

    private final UserRepository userRepository;

    public AuthorityPolicyImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Authority getAuthorityByUser(User user) {
        return user.getAuthority();
    }
}
