package com.academicplus.aplication.student;

public record OutputEnrollStudentDTO(String id) {
    public static OutputEnrollStudentDTO from(String id) {
        return new OutputEnrollStudentDTO(id);
    }
}
