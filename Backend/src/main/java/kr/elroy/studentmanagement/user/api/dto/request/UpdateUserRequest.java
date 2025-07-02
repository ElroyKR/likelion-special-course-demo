package kr.elroy.studentmanagement.user.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;

@Schema(description = "유저 정보 수정 요청")
public record UpdateUserRequest(
        @Nullable
        @Schema(description = "유저 이름", nullable = true)
        String name,

        @Nullable
        @Schema(description = "유저 주소", nullable = true)
        String address,

        @Nullable
        @Schema(description = "유저 생일", nullable = true)
        LocalDate birthDate
) {
}