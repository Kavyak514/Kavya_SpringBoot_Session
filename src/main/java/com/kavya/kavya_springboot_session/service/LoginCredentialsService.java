package com.kavya.kavya_springboot_session.service;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.LoginCredentials;
import com.kavya.kavya_springboot_session.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginCredentialsService {

    LoginRepository loginRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginCredentialsService(LoginRepository loginRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.loginRepository = loginRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //SHA-256 ALGORITHM.
    //DES ALGORITHM.
    //BCRYPT ALGORITHM.

    public Response saveCredentials(LoginCredentials loginCredentials) {
        Response response = new Response();
        loginCredentials.setUsername(bCryptPasswordEncoder.encode(loginCredentials.getUsername()));
        loginCredentials.setPassword(bCryptPasswordEncoder.encode(loginCredentials.getPassword()));
        LoginCredentials loginCredentials1 = loginRepository.save(loginCredentials);
        response.setMessage("Successfully Inserted");
        response.setStatus("200");
        response.setLoginCredentials(loginCredentials1);
        return response;
    }

    public Response verifyCredentials(int id, LoginCredentials loginCredentials) {
        Optional<LoginCredentials> credentials = loginRepository.findById(id);
        if (credentials.isPresent()) {
            Response response = new Response();
            boolean b = bCryptPasswordEncoder.matches(loginCredentials.getUsername(), credentials.get().getUsername());
            boolean a = bCryptPasswordEncoder.matches(loginCredentials.getPassword(), credentials.get().getPassword());
            if (a && b) {
                response.setMessage("Successfully Verified");
                response.setStatus("200");
            } else {
                response.setMessage("Wrong Credentials");
                response.setStatus("200");
            }
            return response;
        }
        return null;
    }
}
