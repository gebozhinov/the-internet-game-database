package bg.softuni.theinternetgamedatabase.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class TestUserController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistrationSuccess() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/register")
                        .param("username", "test")
                        .param("email", "test@test.com")
                        .param("age", "25")
                        .param("password", "qwerty123")
                        .param("confirmPassword", "qwerty123")
        ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"))
        ;
    }
    @Test
    void testRegistrationFailure() throws Exception {
        mockMvc.perform(
          MockMvcRequestBuilders.post("/register")
                  .param("username", "test")
                  .param("email", "test@test.com")
                  .param("age", "25")
                  .param("password", "qwerty")
                  .param("confirmPassword", "qwerty")
        ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/register"));
    }

}
