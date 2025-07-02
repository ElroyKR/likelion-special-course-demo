package kr.elroy.studentmanagement.user.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import org.jspecify.annotations.NonNull;

import java.time.LocalDate;

@Schema(description = "회원가입 요청")
public record CreateUserRequest(
        @NonNull
        @Schema(description = "이름")
        String name,

        @NonNull
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
        @Schema(description = "패스워드")
        String password,

        @NonNull
        @Email
        @Schema(description = "이메일")
        String email,

        @PastOrPresent
        @Schema(description = "생년월일")
        LocalDate birthDate
) {
}