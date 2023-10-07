package com.example.community_service.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    @NotNull
    private String userId;

    @NotNull
    private String userPw;
}
