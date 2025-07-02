package kr.elroy.studentmanagement.user.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.elroy.studentmanagement.user.api.dto.request.CreateUserRequest;
import kr.elroy.studentmanagement.user.api.dto.request.UpdateUserRequest;
import kr.elroy.studentmanagement.user.api.dto.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "유저 API")
@RequestMapping("/v1/users")
public interface UserApi {
    @Operation(summary = "유저 단건 조회")
    @GetMapping("/{userId}")
    UserResponse getUser(
            @PathVariable
            Long userId
    );

    @Operation(summary = "회원가입 요청")
    @PostMapping
    UserResponse signUp(
            @Valid
            @RequestBody
            CreateUserRequest request
    );

    @Operation(summary = "유저정보 수정")
    @PatchMapping("/{userId}")
    UserResponse updateUser(
            @PathVariable
            Long userId,

            @Valid
            @RequestBody
            UpdateUserRequest request
    );
}
