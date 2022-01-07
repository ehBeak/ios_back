package com.example.ios_back.authoritypolicy;

import com.example.ios_back.config.AppConfig;
import com.example.ios_back.domain.Authority;
import com.example.ios_back.domain.User;
import com.example.ios_back.service.AuthorityPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AuthorityPolicyTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("권한 받아오는 테스트")
    void getAuthorityByUser() {
        // given
        User user1 = new User();
        user1.setAuthority(Authority.TEACHER);
        user1.setName("teacher");

        User user2 = new User();
        user2.setAuthority(Authority.STUDENT);
        user2.setName("student");

        // when
        AuthorityPolicy authorityPolicy = ac.getBean(AuthorityPolicy.class);
        Authority authority1 = authorityPolicy.getAuthorityByUser(user1);
        Authority authority2 = authorityPolicy.getAuthorityByUser(user2);

        // then
        Assertions.assertThat(authority1).isEqualTo(Authority.TEACHER);
        Assertions.assertThat(authority2).isEqualTo(Authority.STUDENT);
    }
}
