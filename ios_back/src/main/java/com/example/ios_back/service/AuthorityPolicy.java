package com.example.ios_back.service;

import com.example.ios_back.domain.Authority;
import com.example.ios_back.domain.User;

public interface AuthorityPolicy {

    // 권한 얻어오기 - userId
    Authority getAuthorityByUser(User user);

}
