package org.example.demo666.controller;

import org.example.demo666.component.LoginProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void loginPostLoginSucceedsTest() {
        given(loginProcessor.login())
                .willReturn(true);

        String result = loginController.loginPost("username", "password", model);

        assertEquals("redirect:/main", result);

    }

    @Test
    public void loginPostLoginFailsTest() {
        given(loginProcessor.login())
                .willReturn(false);

        String result =
                loginController.loginPost("username", "password", model);

        assertEquals("login.html", result);

        verify(model)
                .addAttribute("message", "Login failed!");
    }
}