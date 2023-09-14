package com.example.community_service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
