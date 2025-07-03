package kr.elroy.studentmanagement.department.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.elroy.studentmanagement.department.api.dto.request.CreateDepartmentRequest;
import kr.elroy.studentmanagement.department.api.dto.response.DepartmentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "학과 API")
@RequestMapping("/v1/departments")
public interface DepartmentApi {
    @Operation(summary = "학과 단건 조회")
    @GetMapping("/{departmentId}")
    DepartmentResponse getDepartment(
            @PathVariable Long departmentId
    );

    @Operation(summary = "학과 생성 요청")
    @PostMapping
    DepartmentResponse createDepartment(
            @RequestBody
            CreateDepartmentRequest request
    );
}
