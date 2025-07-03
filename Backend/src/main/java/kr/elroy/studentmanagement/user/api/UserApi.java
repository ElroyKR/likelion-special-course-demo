package kr.elroy.studentmanagement.user.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.elroy.studentmanagement.user.api.dto.request.CreateUserRequest;
import kr.elroy.studentmanagement.user.api.dto.request.SignInUserRequest;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "404", description = "잘못된 사용자"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping("/{userId}")
    UserResponse getUser(
            @PathVariable
            Long userId
    );

    @Operation(summary = "회원가입 요청")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "404", description = "잘못된 사용자"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @PostMapping
    UserResponse signUp(
            @Valid
            @RequestBody
            CreateUserRequest request
    );

    @Operation(summary = "유저정보 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "404", description = "잘못된 사용자"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @PatchMapping("/{userId}")
    UserResponse updateUser(
            @PathVariable
            Long userId,

            @Valid
            @RequestBody
            UpdateUserRequest request
    );

    @Operation(summary = "로그인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "로그인 실패"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @PostMapping("/login")
    UserResponse signIn(
            @RequestBody
            SignInUserRequest signInUserRequest
    );
}
