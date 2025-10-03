package com.pard.hw2.repository;

import com.pard.hw2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<Long, User> userRepository = new HashMap<>();
    private long sequence = 0L;

    public void save(User user) {
        if (user.getId() == null) {
            user = User.builder()
                    .id(++sequence)
                    .name(user.getName())
                    .age(user.getAge())
                    .beltColor(user.getBeltColor())
                    .network(user.getNetwork())
                    .build();
        }
        userRepository.put(user.getId(), user);
    }

    public User findByNetwork(String network) {
        return userRepository.values().stream()
                .filter(u -> Objects.equals(u.getNetwork(), network))
                .findFirst()
                .orElse(null);
    }

    public User findByAge(int age) {
        return userRepository.values().stream()
                .filter(u -> u.getAge() == age)
                .findFirst()
                .orElse(null);
    }

    public List<User> findAll() {
        return userRepository.values().stream().toList();
    }

    public void deleteByBelt(String beltColor) {
        List<Long> idsToRemove = new ArrayList<>();
        for (Map.Entry<Long, User> e : userRepository.entrySet()) {
            if (Objects.equals(e.getValue().getBeltColor(), beltColor)) {
                idsToRemove.add(e.getKey());
            }
        }
        idsToRemove.forEach(userRepository::remove);
    }
}
