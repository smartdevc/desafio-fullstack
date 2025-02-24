package com.previred.previredchallenge.service;




import com.previred.previredchallenge.model.User;
import com.previred.previredchallenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        if (user.getId() != null && user.getId() == 0) {
            user.setId(null);
        }
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setNombres(userDetails.getNombres());
            user.setApellidos(userDetails.getApellidos());
            user.setRut(userDetails.getRut());
            user.setDv(userDetails.getDv());
            user.setFechaNacimiento(userDetails.getFechaNacimiento());
            user.setCorreoElectronico(userDetails.getCorreoElectronico());
            user.setContrasena(userDetails.getContrasena());
            return userRepository.save(user);
        });
    }

    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}