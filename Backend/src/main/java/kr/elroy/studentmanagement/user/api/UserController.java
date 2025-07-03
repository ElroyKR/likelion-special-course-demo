package kr.elroy.studentmanagement.user.api;

import kr.elroy.studentmanagement.user.UserService;
import kr.elroy.studentmanagement.user.api.dto.request.CreateUserRequest;
import kr.elroy.studentmanagement.user.api.dto.request.SignInUserRequest;
import kr.elroy.studentmanagement.user.api.dto.request.UpdateUserRequest;
import kr.elroy.studentmanagement.user.api.dto.response.UserResponse;
import kr.elroy.studentmanagement.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public UserResponse getUser(Long userId) {
        return toUserResponse(userService.getUserById(userId));
    }

    @Override
    public UserResponse signUp(CreateUserRequest request) {
        return toUserResponse(userService.createUser(request));
    }

    @Override
    public UserResponse updateUser(Long userId, UpdateUserRequest request) {
        return toUserResponse(userService.updateUser(userId, request));
    }

    @Override
    public UserResponse signIn(SignInUserRequest signInUserRequest) {
        return toUserResponse(userService.loginUser(signInUserRequest));
    }

    private UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getCreatedAt()
        );
    }
}