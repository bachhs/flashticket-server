package com.bachhs.flashticket.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bachhs.flashticket.constant.RoleName;
import com.bachhs.flashticket.model.Role;
import com.bachhs.flashticket.model.User;
import com.bachhs.flashticket.payload.LoginForm;
import com.bachhs.flashticket.payload.RegisterForm;
import com.bachhs.flashticket.payload.Response;
import com.bachhs.flashticket.repository.RoleRepository;
import com.bachhs.flashticket.repository.UserRepository;
import com.bachhs.flashticket.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm registerForm) {

        if (userRepository.existsByEmail(registerForm.getEmail())) {
            return new ResponseEntity<>(new Response("Email already exists"), HttpStatus.CONFLICT);
        }

        Role userRole;
        try {
            userRole = roleRepository.findByName(RoleName.ROLE_USER).get();
            User user = new User(registerForm.getEmail(), passwordEncoder.encode(registerForm.getPassword()),
                    registerForm.getName(), registerForm.getPhoneNumber(), registerForm.getBirthday(),
                    registerForm.getGender(), Collections.singleton(userRole));
            User result = userRepository.save(user);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(registerForm.getEmail(), registerForm.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("user", result);
            response.put("accessToken", jwt);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return new ResponseEntity<>(new Response("Cannot create user"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginWithEmail(@RequestBody LoginForm loginForm) {

        if (!userRepository.existsByEmail(loginForm.getEmail())) {
            return new ResponseEntity<>(new Response("Email not exists"), HttpStatus.NOT_FOUND);
        }
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);

            User user = (User) authentication.getPrincipal();

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("user", user);
            response.put("accessToken", jwt);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return new ResponseEntity<>(new Response("Something went wrong, please try again"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginWithToken(Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();

            Map<String, Object> response = new HashMap<String, Object>();
            response.put("user", user);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response("Something went wrong, please try again"), HttpStatus.BAD_REQUEST);
        }
    }
}
