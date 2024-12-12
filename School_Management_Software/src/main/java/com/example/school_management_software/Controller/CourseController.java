package com.example.school_management_software.Controller;

import com.example.school_management_software.ApiResponse.ApiResponse;
import com.example.school_management_software.Model.Course;
import com.example.school_management_software.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity<?> addCourse(@PathVariable Integer teacher_id,@RequestBody @Valid Course course) {
        courseService.addCourse(teacher_id, course);
        return ResponseEntity.status(200).body(new ApiResponse("course added successfully"));
    }

    @PutMapping("/update/{course_id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer course_id,@RequestBody @Valid Course course) {
        courseService.updateCourse(course_id, course);
        return ResponseEntity.status(200).body(new ApiResponse("course updated successfully"));
    }

    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer course_id) {
        courseService.deleteCourse(course_id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted successfully"));
    }

    @GetMapping("/get-teacher-name/course-id/{id}")
    public ResponseEntity<?> getTeacherName(@PathVariable int id) {
        String nameOfTeacher = courseService.getCourseTeacherName(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Name : " + nameOfTeacher));
    }
}
