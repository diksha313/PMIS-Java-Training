package com.example.RestAPI.controller;

import com.example.RestAPI.entity.Course;
import com.example.RestAPI.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class UpdateCourseController {
    private final CourseService courseService;
    public UpdateCourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long courseId,
            @RequestBody Course coursedetails) {
        Course updatedCourse = courseService.updateCourse(courseId, coursedetails);
        if (updatedCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedCourse);
    }
}
