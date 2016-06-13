package flight.busyflight.provider.controller;

import flight.busyflight.ApiTestBase;
import flight.busyflight.Application;
import flight.busyflight.TestApplication;
import flight.busyflight.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kcai on 13/06/2016.
 */
//@SpringApplicationConfiguration(TestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
@Profile("test")
public class FlightProviderControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // verify the json with the expected output from CrazyAir
    @Test
    public void shouldPostCrazyAirFlights() throws Exception {
        MvcResult result = mvc.perform(post("/provider/crazyair").content("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
    }

    // verify the json with the expected output from ToughJet
    public void shouldPostToughJetFlights() throws Exception {
    }

    @Test
    public void testToughJetShouldHaveTaxAndDiscount() {

    }

    @Test
    public void testCrazyAirShouldNotHaveTaxAndDiscount() {

    }
}
