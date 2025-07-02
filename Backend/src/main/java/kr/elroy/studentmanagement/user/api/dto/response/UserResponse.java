package kr.elroy.studentmanagement.user.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "유저 응답")
public record UserResponse(
        @Schema(description = "유저 ID")
        Long userId,

        @Schema(description = "유저 이름")
        String name,

        @Schema(description = "유저 이메일")
        String email,

        @Schema(description = "유저 생일", nullable = true)
        LocalDate birthDate,

        @Schema(description = "유저 생성일시")
        LocalDateTime createdAt
) {
}