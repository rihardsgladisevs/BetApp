package lv.rgladisevs.betapp.rest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import lv.rgladisevs.betapp.TestUtils;
import lv.rgladisevs.betapp.data.bet.Bet;
import lv.rgladisevs.betapp.data.bet.BetService;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rihards.gladisevs on 2016.03.29..
 */
public class ReportRestServiceTest {

  private List<Bet> betList;

  @Mock
  private BetService betService;

  @InjectMocks
  private ReportRestService reportRestService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    Bet bet = TestUtils.getBetFromFile();
    betList = Collections.singletonList(bet);
  }

  @Test
  public void testGetBetCountByIp() throws Exception {
    final String ip = "0.0.0.0";
    final Long expectedCount = 0L;
    when(betService.getBetCountByIp(ip)).thenReturn(expectedCount);
    Long result = reportRestService.getBetCountByIp(ip);
    verify(betService, times(1)).getBetCountByIp(ip);
    assertEquals(expectedCount, result);
  }

  @Test
  public void testGetBetListByNameAndOdd() throws Exception {
    String name = "1x2";
    String type = "win";
    when(betService.getBetListByNameAndType(name, type)).thenReturn(betList);
    List<Bet> result = reportRestService.getBetListByNameAndOdd(name, type);
    verify(betService, times(1)).getBetListByNameAndType(name, type);
    assertThat(betList, hasSize(result.size()));
    assertEquals(betList.get(0), result.get(0));
  }

  @Test
  public void testDeleteBetByTimestamp() throws Exception {
    Long timestamp = 777L;
    reportRestService.deleteBetByTimestamp(timestamp);
    verify(betService, times(1)).deleteBetByTimestamp(timestamp);
  }
}