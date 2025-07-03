package kr.elroy.studentmanagement.course.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 생성 요청")
public record CreateCourseRequest(
        @Schema(description = "교수 ID", example = "1")
        Long professorId,

        @Schema(description = "학과 ID", example = "1")
        Long departmentId,

        @Schema(description = "강의 이름", example = "자바 프로그래밍")
        String name
) {
}
