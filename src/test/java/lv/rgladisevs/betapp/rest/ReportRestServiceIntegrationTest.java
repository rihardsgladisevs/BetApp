package lv.rgladisevs.betapp.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Collections;
import java.util.List;

import lv.rgladisevs.betapp.Application;
import lv.rgladisevs.betapp.data.bet.Bet;
import lv.rgladisevs.betapp.data.bet.BetService;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by rihards.gladisevs on 2016.03.29..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ReportRestServiceIntegrationTest {

  private static final String BASE_URL = "/reports";
  private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

  private MockMvc mockMvc;

  private List<Bet> betList;

  @Mock
  private BetService betService;

  @InjectMocks
  private ReportRestService reportRestService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = standaloneSetup(reportRestService).build();

    Bet bet = RestTestUtils.getBetFromFile();
    this.betList = Collections.singletonList(bet);
  }

  @Test
  public void testGetBetCountByIp() throws Exception {
    final String ip = "0.0.0.0";
    final String url = BASE_URL + "/bets/ip/{ip}/count";
    final Long expectedCount = 0L;
    final String expectedResult = String.valueOf(expectedCount);

    when(betService.getBetCountByIp(ip)).thenReturn(expectedCount);

    RequestBuilder requestBuilder = get(url, ip)
        .accept(MediaType.parseMediaType(CONTENT_TYPE));
    MvcResult result = this.mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE))
        .andReturn();

    verify(betService, times(1)).getBetCountByIp(ip);
    assertEquals(expectedResult, result.getResponse().getContentAsString());
  }

  @Test
  public void testGetBetListByNameAndOdd() throws Exception {
    String name = "1x2";
    String type = "win";
    String url = BASE_URL + "/bets";

    when(betService.getBetListByNameAndType(name, type)).thenReturn(betList);

    RequestBuilder requestBuilder = get(url)
        .param("name", name)
        .param("type", type)
        .accept(MediaType.parseMediaType(CONTENT_TYPE));
    MvcResult result = this.mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE))
        .andReturn();

    verify(betService, times(1)).getBetListByNameAndType(name, type);
    List<Bet> deserializedResult = new ObjectMapper()
        .readValue(result.getResponse().getContentAsString(), new TypeReference<List<Bet>>() {});
    assertThat(betList, hasSize(deserializedResult.size()));
    assertThat(betList.get(0), equalTo(deserializedResult.get(0)));
  }

  @Test
  public void testDeleteBetByTimestamp() throws Exception {
    final Long timestamp = 123456L;
    final String url = BASE_URL + "/timestamp/{timestamp}";

    RequestBuilder requestBuilder = delete(url, timestamp)
        .accept(MediaType.parseMediaType(CONTENT_TYPE));
    MvcResult result = this.mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andReturn();
    assertThat(result.getResponse().getContentLength(), equalTo(0));
  }
}