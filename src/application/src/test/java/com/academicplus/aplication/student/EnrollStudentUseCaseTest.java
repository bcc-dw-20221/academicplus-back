package com.academicplus.aplication.student;

import com.academicplus.domain.course.CourseRepository;
import com.academicplus.domain.enrollment.EnrollmentRepository;
import com.academicplus.domain.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class EnrollStudentUseCaseTest {
    @InjectMocks
    private EnrollStudentUseCase useCase;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private EnrollmentRepository enrollmentRepository;

    @Test
    void shouldEnrollPersonInACourse() {
        final var cpf = "111.111.111-11";
        final var course = "1";
        final var input = new InputEnrollStudentDTO(cpf, course);

        doReturn(true).when(personRepository).existsById(any());
        doReturn(true).when(courseRepository).existsById(any());
        doAnswer(returnsFirstArg()).when(enrollmentRepository).create(any());

        final OutputEnrollStudentDTO output = useCase.execute(input);

        assertNotNull(output.id());
    }

}