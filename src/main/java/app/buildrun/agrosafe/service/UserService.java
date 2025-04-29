package app.buildrun.agrosafe.service;


import org.springframework.stereotype.Service;

import app.buildrun.agrosafe.controller.CreateUserDto;
import app.buildrun.agrosafe.controller.UpdateUserDto;
import app.buildrun.agrosafe.entity.User;
import app.buildrun.agrosafe.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
//import java.util.List;
//import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //public UUID createUser(CreateUserDto createUserDto) {
        public UUID createUser(CreateUserDto createUserDto) {


        // DTO -> ENTITY
        var entity = new User(
                null,
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null);

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    
        }
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
        
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Optional<User> authenticateUser(String email, String password) {
        // Encontra o usuário pelo email
        Optional<User> user = userRepository.findByEmail(email);
    
        // Verifica se o usuário existe e se a senha está correta
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
    
        return Optional.empty();
    }
    
    

    public void updateUserById(String userId,UpdateUserDto updateUserDto) {

        var id = UUID.fromString(userId);

        var userEntity = userRepository.findById(id);

        if (userEntity.isPresent()) {
            var user = userEntity.get();

            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }

            if (updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }

            userRepository.save(user);
        }

    }

    public void deleteById(String userId) {

        var id = UUID.fromString(userId);

        var userExists = userRepository.existsById(id);

        if (userExists) {
            userRepository.deleteById(id);
        }
           
    }
        
}