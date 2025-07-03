package kr.elroy.studentmanagement.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("U0001", HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    DEPARTMENT_NOT_FOUND("D0001", HttpStatus.NOT_FOUND, "학과를 찾을 수 없습니다."),
    COURSE_NOT_FOUND("C0001", HttpStatus.NOT_FOUND, "강의를 찾을 수 없습니다.");

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}