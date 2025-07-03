package kr.elroy.studentmanagement.department.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "학과 응답")
public record DepartmentResponse(
        @Schema(description = "학과 ID", example = "1")
        Long departmentId,

        @Schema(description = "학과 이름", example = "컴퓨터공학과")
        String name
) {
}
