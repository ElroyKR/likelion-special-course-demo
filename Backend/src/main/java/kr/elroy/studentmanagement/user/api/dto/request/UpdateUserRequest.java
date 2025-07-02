package kr.elroy.studentmanagement.user.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.elroy.studentmanagement.user.enums.UserType;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;

@Schema(description = "유저 정보 수정 요청")
public record UpdateUserRequest(
        @Nullable
        @Schema(description = "유저 이름", nullable = true)
        String name,

        @Nullable
        @Schema(description = "유저 생일", nullable = true)
        LocalDate birthDate,

        @Nullable
        @Schema(description = "유저 타입", nullable = true)
        UserType userType
) {
}