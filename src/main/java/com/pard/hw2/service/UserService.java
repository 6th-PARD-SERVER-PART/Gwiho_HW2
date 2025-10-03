package com.pard.hw2.service;


import com.pard.hw2.dto.UserDto;
import com.pard.hw2.dto.UserResponseDto;
import com.pard.hw2.entity.User;
import com.pard.hw2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.NetPermission;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .beltColor(userDto.getBeltColor())
                .network(userDto.getNetwork())
                .build();
        userRepository.save(user);
    }

    public UserDto findByNetwork(String network) {
        User user = userRepository.findByNetwork(network);

        return UserDto.builder()
                .beltColor(user.getBeltColor())
                .name(user.getName())
                .age(user.getAge())
                .network(user.getNetwork())
                .build();
    }

    public UserResponseDto findNameAndAge(int age) {
        User user = userRepository.findByAge(age);

        return UserResponseDto.builder()
                .studentName(user.getName())
                .age(user.getAge())
                .build();
    }

    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            UserDto userDto = UserDto.builder()
                    .name(user.getName())
                    .age(user.getAge())
                    .beltColor(user.getBeltColor())
                    .network(user.getNetwork())
                    .build();
            userDtos.add(userDto);
        });

        return userDtos;
    }

    public void updateByNetwork(String network, UserDto userDto) {
        User user = userRepository.findByNetwork(network);
        user.updateNetwork(userDto.getNetwork());

        userRepository.save(user);
    }

    public void deleteByBelt(String beltColor) {
        userRepository.deleteByBelt(beltColor);
    }
}
