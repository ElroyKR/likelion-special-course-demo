package kr.elroy.studentmanagement.user.exception;

import kr.elroy.studentmanagement.exception.DomainException;
import kr.elroy.studentmanagement.exception.ErrorCode;

public class InvalidPasswordException extends DomainException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
