package kr.elroy.studentmanagement.course.api;

import kr.elroy.studentmanagement.course.CourseService;
import kr.elroy.studentmanagement.course.api.dto.request.CreateCourseRequest;
import kr.elroy.studentmanagement.course.api.dto.response.CourseResponse;
import kr.elroy.studentmanagement.course.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CourseController implements CourseApi {
    private final CourseService courseService;

    @Override
    public CourseResponse getCourse(Long courseId) {
        return toCourseResponse(courseService.getCourse(courseId));
    }

    @Override
    public CourseResponse createCourse(CreateCourseRequest request) {
        return toCourseResponse(courseService.createCourse(request));
    }

    private CourseResponse toCourseResponse(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getProfessor().getId(),
                course.getDepartment().getId(),
                course.getName()
        );
    }
}
