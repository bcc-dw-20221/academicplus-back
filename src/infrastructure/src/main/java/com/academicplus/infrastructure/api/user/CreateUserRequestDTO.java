//package com.academicplus.infrastructure.api.user;
//
//import com.academicplus.aplication.user.create.CreateUserInputDTO;
//import com.academicplus.domain.shared.Gender;
//import com.academicplus.infrastructure.api.shared.AddressDTO;
//
//import java.time.LocalDate;
//
//public record CreateUserRequestDTO(
//        String name,
//        String cpf,
//        char sex,
//        String motherName,
//        String email,
//        LocalDate birthDate,
//        AddressDTO address
//) {
//    public CreateUserInputDTO toInput() {
//        final var s = switch (sex) {
//            case 'H' -> Gender.MALE;
//            case 'M' -> Gender.FEMALE;
//            default -> Gender.OTHER;
//        };
//        return new CreateUserInputDTO(name, cpf, s, motherName, email, birthDate, address.toAddress());
//    }
//}
