package org.example.Islambek.service;

import org.example.Islambek.model.Role;
import org.example.Islambek.model.User;
import org.example.Islambek.repositories.RoleRepository;
import org.example.Islambek.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }
        return user;
    }



    public void updateUserName(Long id, String username) {
        User userName = userRepository.findByUsername(username);


        User user = userRepository.findById(id).get();
        user.setUsername(username);
        userRepository.saveAndFlush(user);

    }

    public void createUser(User user) {
        Role role = roleRepository.findUserRole("USER");
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setRoles(Collections.singletonList(role));
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.saveAndFlush(newUser);
    }

    public void updateUser(Long id, User user) {
        User userDb = userRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(passwordEncoder.encode(user.getPassword())); // plaintext password

            userRepository.saveAndFlush(userDb);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }



}
