package kr.elroy.studentmanagement.user;

import kr.elroy.studentmanagement.user.api.dto.request.CreateUserRequest;
import kr.elroy.studentmanagement.user.api.dto.request.SignInUserRequest;
import kr.elroy.studentmanagement.user.api.dto.request.UpdateUserRequest;
import kr.elroy.studentmanagement.user.domain.User;
import kr.elroy.studentmanagement.user.exception.InvalidPasswordException;
import kr.elroy.studentmanagement.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User createUser(CreateUserRequest request) {
        final String encodedPassword = bCryptPasswordEncoder.encode(request.password());

        final User entity = User.builder()
                .name(request.name())
                .password(encodedPassword)
                .email(request.email())
                .birthDate(request.birthDate())
                .userType(request.userType())
                .build();

        return userRepository.save(entity);
    }

    @Transactional
    public User updateUser(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        if (request.name() != null) {
            user.setName(request.name());
        }

        if (request.birthDate() != null) {
            user.setBirthDate(request.birthDate());
        }

        if (request.userType() != null) {
            user.setUserType(request.userType());
        }

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User loginUser(SignInUserRequest signInUserRequest){
        User user = userRepository.findByEmail(signInUserRequest.getEmail()).orElseThrow(UserNotFoundException::new);
        if (bCryptPasswordEncoder.matches(signInUserRequest.getPassword(), user.getPassword())) {
            return user;
        } else throw new InvalidPasswordException();
    }
}