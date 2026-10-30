package com.example.RestAPI.repository;
import com.example.RestAPI.entity.Course;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Repository
public class CourseRepository {
    private final Map<Long, Course> courses = new ConcurrentHashMap<>();

    public CourseRepository() {
        // Initialize with some sample courses
        courses.put(1L, new Course(1L, "Java", "Learn the basics of Java programming."));
        courses.put(2L, new Course(2L, "Spring Boot", "Build RESTful APIs with Spring Boot."));
    }
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }
    public Course findById(Long id) {
        return courses.get(id);
    }
    public Course save(Course course) {
        courses.put(course.getId(), course);
        return course;
    }
    public void deleteById(Long id) {
        courses.remove(id);
    }
}
