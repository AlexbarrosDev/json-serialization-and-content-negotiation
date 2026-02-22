package com.alexdev.services;

import com.alexdev.dtos.request.UserCreateDTO;
import com.alexdev.dtos.response.UserDTO;
import com.alexdev.entities.User;
import com.alexdev.mappers.UserMapper;
import com.alexdev.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {

        return repository.findAll().stream()
                .map(UserMapper::entityToDTO).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {

        var user = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserMapper.entityToDTO(user);
    }

    @Transactional
    public UserDTO create(UserCreateDTO user) {

        User obj = new User(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getBirthDate(),
                user.getGender()
        );
        return UserMapper.entityToDTO(repository.save(obj));
    }

    @Transactional
    public UserDTO update(Long id, UserCreateDTO user) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User inválid"));

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setBirthDate(user.getBirthDate());
        entity.setGender(user.getGender());
        return UserMapper.entityToDTO(repository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        repository.deleteById(id);
    }
}
