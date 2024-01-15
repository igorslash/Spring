package com.example.restapiservice;

import com.example.restapiservice.dto.UsersDto;
import com.example.restapiservice.entity.Users;
import com.example.restapiservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public void createUser(UsersDto usersDto) {
        // создание пользователя
        log.info("Creating user: {}", usersDto);
        userRepository.save(Users.builder()
                .name(usersDto.getName())
                .userName(usersDto.getUserName())
                .email(usersDto.getEmail())
                .build());
    }
    public Iterable<Users> getAllUsers() {
        // получение всех пользователей
        return userRepository.findAll();
    }

    public Users getUser(Long id) {
        // получение пользователя по идентификатору
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found"));
    }
    public void deleteUser(Long id) {
        // удаление пользователя
        userRepository.deleteById(id);
    }
    public Users updateUser(Long id, Users users) {
        //обновление пользователя
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(users.getName());
                    user.setUserName(users.getUserName());
                    user.setEmail(users.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public Users findUserByEmail(String email) {
        //поиск пользователя по почте
        return userRepository.findUserByEmail(email);
    }
}
