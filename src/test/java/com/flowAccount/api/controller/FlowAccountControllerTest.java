package com.flowAccount.api.controller;

import com.flowAccount.api.SpringRestApiTestApplication;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRestApiTestApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FlowAccountControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void shouldFetchAllAccounts() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(FlowAccountsController.URI)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
               // .andExpect(jsonPath("$", hasSize(9)))
                .andReturn();
    }


    @Test
    public void shouldFindAccountById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(FlowAccountsController.URI + "2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.object_id").value(2))
                .andExpect(jsonPath("$.flow_name").value("JFKGAT"))
                .andExpect(jsonPath("$.flow_type").value("FLOW"))
                .andExpect(jsonPath("$.is_deleted").value(false))
                //.andExpect(jsonPath("$.*", hasSize(4)))
                .andReturn();
    }


   // @Test
    public void shouldSaveFlowAccount() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post(FlowAccountsController.URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"flow_name\": \"BRS-GAT-NY\",\"flow_type\": \"FLOW\",\"is_deleted\": \"false\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.flow_name").value("BRS-GAT-NY"))
                .andExpect(jsonPath("$.flow_type").value("FLOW"))
                .andExpect(jsonPath("$.is_deleted").value(false))
               // .andExpect(jsonPath("$.*", hasSize(4)))
                .andReturn();

    }

    @Test
    public void shouldGetEndpoint() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(FlowAccountsController.URI)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
    }


}