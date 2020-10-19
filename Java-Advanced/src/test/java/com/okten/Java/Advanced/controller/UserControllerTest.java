package com.okten.Java.Advanced.controller;

import com.okten.JavaAdvanced.controller.UserController;
import com.okten.JavaAdvanced.entity.User;
import com.okten.JavaAdvanced.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenUsersWhenGettingAllUsersReturnsSuccessfulRequest() throws Exception {
        User user1 = new User(1, "name", 22, "email", "password", null);

        BDDMockito.given(userService.getAllUsers())
                .willReturn(Arrays.asList(user1));

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
