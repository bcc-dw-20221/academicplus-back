package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.course.CreateCourseUseCase;
import com.academicplus.domain.course.CourseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class CourseUseCaseConfig {
    private final CourseRepository courseRepository;

    public CourseUseCaseConfig(final CourseRepository courseRepository) {
        this.courseRepository = Objects.requireNonNull(courseRepository);
    }

    @Bean
    public CreateCourseUseCase createCourseUseCase() {
        return new CreateCourseUseCase(courseRepository);
    }
}
