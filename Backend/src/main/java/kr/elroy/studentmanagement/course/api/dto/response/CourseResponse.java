package kr.elroy.studentmanagement.course.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 응답")
public record CourseResponse(
        @Schema(description = "강의 ID", example = "1")
        Long courseId,

        @Schema(description = "교수 ID", example = "1")
        Long professorId,

        @Schema(description = "학과 ID", example = "1")
        Long departmentId,

        @Schema(description = "강의 이름", example = "자바 프로그래밍")
        String name
) {
}
