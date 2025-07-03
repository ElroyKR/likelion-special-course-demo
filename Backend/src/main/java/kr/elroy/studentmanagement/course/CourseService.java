package kr.elroy.studentmanagement.course;

import kr.elroy.studentmanagement.course.api.dto.request.CreateCourseRequest;
import kr.elroy.studentmanagement.course.domain.Course;
import kr.elroy.studentmanagement.course.exception.CourseInvalidUserTypeException;
import kr.elroy.studentmanagement.course.exception.CourseNotFoundException;
import kr.elroy.studentmanagement.department.DepartmentRepository;
import kr.elroy.studentmanagement.department.domain.Department;
import kr.elroy.studentmanagement.department.exception.DepartmentNotFoundException;
import kr.elroy.studentmanagement.user.UserRepository;
import kr.elroy.studentmanagement.user.domain.User;
import kr.elroy.studentmanagement.user.enums.UserType;
import kr.elroy.studentmanagement.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public Course createCourse(CreateCourseRequest request) {
        User professor = userRepository.findById(request.professorId())
                .orElseThrow(UserNotFoundException::new);

        if (professor.getUserType() != UserType.PROFESSOR) {
            throw new CourseInvalidUserTypeException();
        }

        Department department = departmentRepository.findById(request.departmentId())
                .orElseThrow(DepartmentNotFoundException::new);


        Course course = Course.builder()
                .name(request.name())
                .professor(professor)
                .department(department)
                .build();

        return courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public Course getCourse(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(CourseNotFoundException::new);
    }
}
