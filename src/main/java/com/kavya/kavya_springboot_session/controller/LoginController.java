package com.kavya.kavya_springboot_session.controller;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.LoginCredentials;
import com.kavya.kavya_springboot_session.service.LoginCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    LoginCredentialsService loginCredentialsService;

    @Autowired
    public LoginController(LoginCredentialsService loginCredentialsService) {
        this.loginCredentialsService = loginCredentialsService;
    }

    @PostMapping("/login/saveCredentials")
    public Response saveEmployee(@RequestBody LoginCredentials loginCredentials) {
        return loginCredentialsService.saveCredentials(loginCredentials);
    }

    @GetMapping("/login/verifyCredentials/{id}")
    public Response saveEmployee(@PathVariable int id, @RequestBody LoginCredentials loginCredentials) {
        return loginCredentialsService.verifyCredentials(id, loginCredentials);
    }
}
