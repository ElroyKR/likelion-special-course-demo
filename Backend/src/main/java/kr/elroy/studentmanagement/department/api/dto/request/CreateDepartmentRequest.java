package kr.elroy.studentmanagement.department.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "학과 생성 요청")
public record CreateDepartmentRequest(
        @Schema(description = "학과 이름", example = "컴퓨터공학과")
        String name
) {
}
