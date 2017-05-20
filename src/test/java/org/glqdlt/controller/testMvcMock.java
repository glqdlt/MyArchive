package org.glqdlt.controller;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class testMvcMock {

	@Inject
	private WebApplicationContext ctx;

	private MockMvc mock;

	@Before
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testHome() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/"));

	}

	@Test
	public void testPowerOn() throws Exception {
		mock.perform(MockMvcRequestBuilders.post("/power/on"));

	}

}
