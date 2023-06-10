package com.kawa.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kawa.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Test class for the CustomerResource REST controller.
 *
 * @see CustomerResource
 */
@IntegrationTest
class CustomerResourceIT {

    private MockMvc restMockMvc;

    @Autowired
    CustomerResource customerResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        //CustomerResource customerResource = new CustomerResource();

        restMockMvc = MockMvcBuilders.standaloneSetup(customerResource).build();
    }

    /**
     * Test getAllCustomer
     */
    @Test
    void testGetAllCustomer() throws Exception {
        restMockMvc.perform(get("/api/customer")).andExpect(status().isOk());
    }

    /**
     * Test getCustomerById
     */
    @Test
    void testGetCustomerById() throws Exception {
        restMockMvc.perform(get("/api/customer/get-customer-by-id")).andExpect(status().isOk());
    }
}
