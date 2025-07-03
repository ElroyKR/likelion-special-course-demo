package kr.elroy.studentmanagement.course.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.elroy.studentmanagement.course.api.dto.request.CreateCourseRequest;
import kr.elroy.studentmanagement.course.api.dto.response.CourseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "강의 API")
@RequestMapping("/v1/courses")
public interface CourseApi {
    @Operation(summary = "강의 단건 조회")
    @GetMapping("/{courseId}")
    CourseResponse getCourse(
            @PathVariable
            Long courseId
    );

    @Operation(summary = "강의 생성 요청")
    @PostMapping
    CourseResponse createCourse(
            @RequestBody
            CreateCourseRequest request
    );
}
