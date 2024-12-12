package com.example.school_management_software.Controller;

import com.example.school_management_software.ApiResponse.ApiResponse;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers(){
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacherDetailsById(@PathVariable int id){
        Teacher teacher= teacherService.getTeacher(id);
        return ResponseEntity.status(200).body(teacher);
    }
}
