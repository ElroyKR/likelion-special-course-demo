package kr.elroy.studentmanagement.department;

import kr.elroy.studentmanagement.department.api.dto.request.CreateDepartmentRequest;
import kr.elroy.studentmanagement.department.domain.Department;
import kr.elroy.studentmanagement.department.exception.DepartmentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Transactional
    public Department createDepartment(CreateDepartmentRequest request) {
        Department department = Department.builder()
                .name(request.name())
                .build();
        return departmentRepository.save(department);
    }

    @Transactional(readOnly = true)
    public Department getDepartmentById(Long id) {
        return departmentRepository
                .findById(id)
                .orElseThrow(DepartmentNotFoundException::new);
    }
}
