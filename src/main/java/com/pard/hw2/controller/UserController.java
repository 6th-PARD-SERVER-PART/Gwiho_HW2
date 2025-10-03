package com.pard.hw2.controller;

import com.pard.hw2.dto.UserDto;
import com.pard.hw2.dto.UserResponseDto;
import com.pard.hw2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String save(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "저장완료!!";
    }

    @GetMapping("/{network}")
    public UserDto findById(@PathVariable String network) {
        return userService.findByNetwork(network);
    }

    @GetMapping("/{age}/nameAndAge")
    public UserResponseDto findByNameAndAge(@PathVariable int age){
        return userService.findNameAndAge(age);
    }

    @PatchMapping("/{network}")
    public String updateByNetwork(@PathVariable String network, @RequestBody UserDto userDto) {
        userService.updateByNetwork(network, userDto);
        return "수정완료!";
    }

    @DeleteMapping("/{belt}")
    public String deleteByBelt(@PathVariable("belt") String beltColor){
        userService.deleteByBelt(beltColor);
        return("삭제완료!");
    }

    @GetMapping("")
    public List<UserDto> findAll(){
        return userService.findAll();
    }
}
