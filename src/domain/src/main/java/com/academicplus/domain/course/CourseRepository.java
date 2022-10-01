package com.academicplus.domain.course;

import java.util.List;

public interface CourseRepository {
    Course create(Course course);
    Course findById(CourseID courseID);
    boolean existsById(CourseID courseID);

    List<Course> findAll(); //TODO: Remove this
}
