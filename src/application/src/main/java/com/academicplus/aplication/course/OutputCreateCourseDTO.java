package com.academicplus.aplication.course;

import com.academicplus.domain.course.CourseLevel;
import com.academicplus.domain.course.Grau;

public record OutputCreateCourseDTO(
        String id, String name,
        Long hours,
        CourseLevel level,
        Grau grau
) {
}
