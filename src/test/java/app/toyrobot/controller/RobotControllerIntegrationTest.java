package app.toyrobot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.toyrobot.web.dto.InputCommand;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RobotControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPlaceRobotThenGetCreated() throws Exception {

        final InputCommand placeCommand = new InputCommand();
        placeCommand.setCommand("PLACE 0,0,NORTH");

        mockMvc.perform(post("/rest/v1/robot")
                .content(asJsonString(placeCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    public void whenGetRobotThenO() throws Exception {
        mockMvc.perform(get("/rest/v1/robot/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.output").exists());
    }

    @Test
    public void whenMoveRobotOk() throws Exception {
        
        final InputCommand moveCommand = new InputCommand();
        moveCommand.setCommand("MOVE");

        mockMvc.perform(put("/rest/v1/robot/1")
                .content(asJsonString(moveCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
