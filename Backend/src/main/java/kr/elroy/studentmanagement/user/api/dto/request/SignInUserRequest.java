package kr.elroy.studentmanagement.user.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignInUserRequest {
    @Schema(description = "유저 이메일", example = "test@example.com", accessMode = Schema.AccessMode.READ_WRITE)
    private String email;
    @Schema(description = "유저 비밀번호", example = "qwer1234", accessMode = Schema.AccessMode.READ_WRITE)
    private String password;
}
