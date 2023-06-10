package com.kawa.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kawa.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Test class for the OrderResource REST controller.
 *
 * @see OrderResource
 */
@IntegrationTest
class OrderResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        OrderResource orderResource = new OrderResource();
        restMockMvc = MockMvcBuilders.standaloneSetup(orderResource).build();
    }

    /**
     * Test id
     */
    @Test
    void testId() throws Exception {
        restMockMvc.perform(get("/api/order/id")).andExpect(status().isOk());
    }
}
