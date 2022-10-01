package com.academicplus.aplication.course;

import com.academicplus.domain.course.CourseLevel;
import com.academicplus.domain.course.Grau;

public record InputCreateCourseDTO(String name, long hours, CourseLevel level, Grau grau) {
}
