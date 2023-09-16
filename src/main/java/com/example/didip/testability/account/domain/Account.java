package com.example.didip.testability.account.domain;

import lombok.*;

import java.util.UUID;

/*
Testability : 얼마나 쉽게 Input을 변경하고, Output을 쉽게 검증할 수 있는가 ?
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Account {

    private final String username;
    private final String authToken;

    //Testability 낮은사례 - [input&output - 감춰진 의존성] - 호출자는 모르는 입력 존재
    public static Account createV1(String username) {
        //authToken가 내부생성되므로 캡슐화 되지 않음
        return Account.builder()
                .username(username)
                .authToken(UUID.randomUUID().toString())
                .build();
    }
}
