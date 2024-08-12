package com.saverio.ksdemo.banking;


import com.saverio.ksdemo.controller.BankAccountController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.mockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BankAccountApplication.class)
@AutoConfigureMockMvc
public abstract class BankAccountTestBase {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BankAccountController()).build();
        mockMvc(this.mockMvc); // Configura RestAssuredMockMvc con l'istanza MockMvc
    }
}
