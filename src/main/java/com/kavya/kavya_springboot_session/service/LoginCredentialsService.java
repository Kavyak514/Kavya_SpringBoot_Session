package com.kavya.kavya_springboot_session.service;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.LoginCredentials;
import com.kavya.kavya_springboot_session.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginCredentialsService {

    LoginRepository loginRepository;

    @Autowired
    public LoginCredentialsService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Response saveCredentials(LoginCredentials loginCredentials) {
        Response response = new Response();
        LoginCredentials loginCredentials1 = loginRepository.save(loginCredentials);
        response.setMessage("Successfully Inserted");
        response.setStatus("200");
        response.setLoginCredentials(loginCredentials1);
        return response;
    }
}
