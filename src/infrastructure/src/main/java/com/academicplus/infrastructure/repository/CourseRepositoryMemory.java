package com.academicplus.infrastructure.repository;

import com.academicplus.domain.course.Course;
import com.academicplus.domain.course.CourseID;
import com.academicplus.domain.course.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryMemory implements CourseRepository {
    private static final List<Course> courses = new ArrayList<>();

    @Override
    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(CourseID courseID) {
        return courses.stream().filter(c -> c.getId().equals(courseID)).findFirst().orElse(null);
    }

    @Override
    public boolean existsById(CourseID courseID) {
        return courses.stream().anyMatch(c -> c.getId().equals(courseID));
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }
}
