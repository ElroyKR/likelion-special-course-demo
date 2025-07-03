package kr.elroy.studentmanagement.department.exception;

import kr.elroy.studentmanagement.exception.DomainException;
import kr.elroy.studentmanagement.exception.ErrorCode;

public class DepartmentNotFoundException extends DomainException {
    public DepartmentNotFoundException() {
        super(ErrorCode.DEPARTMENT_NOT_FOUND);
    }
}
