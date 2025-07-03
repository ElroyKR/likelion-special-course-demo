package kr.elroy.studentmanagement.department.api;

import kr.elroy.studentmanagement.department.DepartmentService;
import kr.elroy.studentmanagement.department.api.dto.request.CreateDepartmentRequest;
import kr.elroy.studentmanagement.department.api.dto.response.DepartmentResponse;
import kr.elroy.studentmanagement.department.domain.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController implements DepartmentApi {
    private final DepartmentService departmentService;

    @Override
    public DepartmentResponse getDepartment(Long departmentId) {
        return toDepartmentResponse(departmentService.getDepartmentById(departmentId));
    }

    @Override
    public DepartmentResponse createDepartment(CreateDepartmentRequest request) {
        return toDepartmentResponse(departmentService.createDepartment(request));
    }

    private DepartmentResponse toDepartmentResponse(Department department) {
        return new DepartmentResponse(
                department.getId(),
                department.getName()
        );
    }
}
