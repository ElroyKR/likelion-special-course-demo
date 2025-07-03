package kr.elroy.studentmanagement.course.api;

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
    @GetMapping("/{courseId}")
    CourseResponse getCourse(
            @PathVariable
            Long courseId
    );

    @PostMapping
    CourseResponse createCourse(
            @RequestBody
            CreateCourseRequest request
    );
}
