package kr.elroy.studentmanagement.course.exception;

import kr.elroy.studentmanagement.exception.DomainException;
import kr.elroy.studentmanagement.exception.ErrorCode;

public class CourseNotFoundException extends DomainException {
    public CourseNotFoundException() {
        super(ErrorCode.COURSE_NOT_FOUND);
    }
}
