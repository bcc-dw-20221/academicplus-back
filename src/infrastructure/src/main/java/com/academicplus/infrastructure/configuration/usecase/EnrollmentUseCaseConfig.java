package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.student.EnrollStudentUseCase;
import com.academicplus.domain.course.CourseRepository;
import com.academicplus.domain.enrollment.EnrollmentRepository;
import com.academicplus.domain.person.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnrollmentUseCaseConfig {
    private final PersonRepository personRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentUseCaseConfig(
            final PersonRepository personRepository,
            final CourseRepository courseRepository,
            final EnrollmentRepository enrollmentRepository
    ) {
        this.personRepository = personRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Bean
    public EnrollStudentUseCase enrollStudentUseCase() {
        return new EnrollStudentUseCase(personRepository, courseRepository, enrollmentRepository);
    }
}
