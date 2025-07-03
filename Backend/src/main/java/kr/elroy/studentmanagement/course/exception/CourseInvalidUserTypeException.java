package kr.elroy.studentmanagement.course.exception;

import kr.elroy.studentmanagement.exception.DomainException;
import kr.elroy.studentmanagement.exception.ErrorCode;

public class CourseInvalidUserTypeException extends DomainException {
    public CourseInvalidUserTypeException() {
        super(ErrorCode.COURSE_INVALID_USER_TYPE);
    }
}
