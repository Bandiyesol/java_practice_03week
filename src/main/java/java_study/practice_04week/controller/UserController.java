package java_study.practice_04week.controller;

import java_study.practice_04week.dto.UserSignupRequestDto;
import java_study.practice_04week.dto.UserSignupResponseDto;
import java_study.practice_04week.repository.UserRepository;
import java_study.practice_04week.service.UserService;
import java_study.practice_04week.user.UserEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<UserSignupResponseDto> signup(@RequestBody UserSignupRequestDto request) {
        UserSignupResponseDto response = userService.signUpUser(request);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/changename/{id}")
    public ResponseEntity<UserSignupResponseDto> changeName(@PathVariable Long id,@RequestBody String name) {
        UserSignupResponseDto response = userService.changeName(id, name);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/changemail/{id}")
    public ResponseEntity<UserSignupResponseDto> changeEmail(@PathVariable Long id,@RequestBody String email) {
        UserSignupResponseDto response = userService.changeEmail(id, email);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/changepassword/{id}")
    public ResponseEntity<UserSignupResponseDto> changePassword(@PathVariable Long id,@RequestBody String password) {
        UserSignupResponseDto response = userService.changePassword(id, password);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<UserEntity> userList() {
        return userRepository.findAll();
    }

    @DeleteMapping("/deleteinfo/{id}")
    public ResponseEntity<UserSignupResponseDto> deleteInfo(@PathVariable Long id) {
        userService.deleteInfo(id);
        return ResponseEntity.noContent().build();
    }
}
