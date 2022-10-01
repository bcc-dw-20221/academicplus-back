//package com.academicplus.infrastructure.api.user;
//
//import com.academicplus.aplication.user.create.CreateUserOutputDTO;
//import com.academicplus.aplication.user.create.CreateUserUseCase;
//import com.academicplus.aplication.user.find.FindUserByIdUseCase;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Objects;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    private final CreateUserUseCase createUserUseCase;
//    private final FindUserByIdUseCase findUserByIdUseCase;
//
//    public UserController(
//            final CreateUserUseCase createUserUseCase,
//            final FindUserByIdUseCase findUserByIdUseCase
//    ) {
//        this.createUserUseCase = Objects.requireNonNull(createUserUseCase);
//        this.findUserByIdUseCase = Objects.requireNonNull(findUserByIdUseCase);
//    }
//
//    @PostMapping
//    public ResponseEntity<CreateUserOutputDTO> createUser(@RequestBody CreateUserRequestDTO request) {
//        final var output = this.createUserUseCase.execute(request.toInput());
//        return ResponseEntity.status(HttpStatus.CREATED).body(output);
//    }
//}
