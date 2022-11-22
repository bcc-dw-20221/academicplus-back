package com.academicplus.aplication.professor;

import java.util.List;

public record InputRegisterProfessorDTO(
        String personId,
        String universityId,
        List<String> qualifications
) {
}
