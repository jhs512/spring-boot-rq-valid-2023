package com.sbs.demo5.base.initData;

import com.sbs.demo5.domain.member.entity.Member;
import com.sbs.demo5.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {
    @Value("${custom.security.oauth2.client.registration.kakao.devUserOauthId}")
    private String kakaoDevUserOAuthId;

    @Bean
    public ApplicationRunner init(MemberService memberService) {
        return args -> {
            Member member1 = memberService.join("admin", "1234", "admin", "admin@test.com", "").getData();
            Member member2 = memberService.join("user1", "1234", "nickname1", "user1@test.com", "").getData();
            Member member3 = memberService.join("user2", "1234", "nickname2", "user2@test.com", "").getData();
            Member member4 = memberService.join("user3", "1234", "nickname3", "user3@test.com", "").getData();

            memberService.setEmailVerified(member1);
            memberService.setEmailVerified(member2);
            memberService.setEmailVerified(member3);

            IntStream.rangeClosed(4, 50).forEach(i -> memberService.join("user" + i, "1234", "nickname" + i, "user" + i + "@test.com", ""));

            Member memberByKakao = memberService.whenSocialLogin("KAKAO", "KAKAO__%s".formatted(kakaoDevUserOAuthId), "홍길동", "");
        };
    }
}
