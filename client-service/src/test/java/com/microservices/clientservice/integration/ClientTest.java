package com.microservices.clientservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.clientservice.dto.client.ClientRequestDTO;
import com.microservices.clientservice.dto.client.ClientResponseDTO;
import com.microservices.clientservice.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ClientTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveClient() throws Exception{

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TestUtilGenerator.getClientRequestDTO()))
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nombres").exists())
                .andReturn();

        ClientResponseDTO resultSaveClient = objectMapper.readValue(result.getResponse().getContentAsString(), ClientResponseDTO.class);

        mvc.perform(MockMvcRequestBuilders
                .get("/clientes")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect((status().isOk()))
                .andExpect(jsonPath("$[0].id").exists());


    }
}
