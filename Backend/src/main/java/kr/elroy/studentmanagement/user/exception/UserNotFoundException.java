package kr.elroy.studentmanagement.user.exception;


import kr.elroy.studentmanagement.exception.DomainException;
import kr.elroy.studentmanagement.exception.ErrorCode;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}