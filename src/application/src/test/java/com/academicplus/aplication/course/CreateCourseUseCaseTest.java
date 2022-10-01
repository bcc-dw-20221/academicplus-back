package com.academicplus.aplication.course;

import com.academicplus.domain.course.CourseID;
import com.academicplus.domain.course.CourseLevel;
import com.academicplus.domain.course.Grau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateCourseUseCaseTest {

    private CreateCourseUseCase useCase;

    @Test
    void h() {
        final var name = "Bacharelado em Ciência da Computação";
        final var hours = 3000;
        final var level = CourseLevel.BACHAREL;
        final var grau = Grau.SUPERIOR;

        final var input = new InputCreateCourseDTO(name, hours, level, grau);

        final OutputCreateCourseDTO output = useCase.execute(input);
    }

}