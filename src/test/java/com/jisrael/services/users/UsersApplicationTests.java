package com.jisrael.services.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsersApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	@Test
	void WhenInvokeGetAll_ThenObtain200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/users")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}

}
