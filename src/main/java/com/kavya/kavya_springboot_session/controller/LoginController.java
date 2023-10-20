package com.kavya.kavya_springboot_session.controller;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.LoginCredentials;
import com.kavya.kavya_springboot_session.service.LoginCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    LoginCredentialsService loginCredentialsService;

    @Autowired
    public LoginController(LoginCredentialsService loginCredentialsService) {
        this.loginCredentialsService = loginCredentialsService;
    }

    @PostMapping("/saveCredentials")
    public Response saveEmployee(@RequestBody LoginCredentials loginCredentials) {
        return loginCredentialsService.saveCredentials(loginCredentials);
    }
}
