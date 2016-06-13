package flight.busyflight.controller;

import flight.busyflight.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by kcai on 13/06/2016.
 */
//TODO complete these tests
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
@Profile("test")
public class BusyFlightControllerTest {

    //TODO complete the tests

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testBadInput() {

    }

    @Test
    public void testBadContentType() {

    }

    @Test
    public void testInputMatches() {

    }

    @Test
    public void testOutputIsJson() {

    }

    @Test
    public void testOutputAggregates() {

    }

    @Test
    public void testOutputMatches() {

    }

    @Test
    public void testOutputOrderedByFare() {

    }

    @Test
    public void testDateShouldBeInISO8601() {

    }
}
