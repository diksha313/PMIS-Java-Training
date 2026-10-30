package com.example.RestAPI.service;


import com.example.RestAPI.entity.Course;
import com.example.RestAPI.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final AtomicLong nextId = new AtomicLong(3);
    // Start from 3 since we have two sample courses
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id) {
        return courseRepository.findById(id);
    }
    public Course createCourse(Course course) {
        course.setId(nextId.getAndIncrement());
        return courseRepository.save(course);
    }
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id);
        if(course==null) {
            return null;
        }
        course.setTitle(courseDetails.getTitle());
        course.setDescription(courseDetails.getDescription());
        return courseRepository.save(course);
    }
    public boolean deleteCourse(Long id) {
        Course course = courseRepository.findById(id);
        if(course==null) {
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }
}
