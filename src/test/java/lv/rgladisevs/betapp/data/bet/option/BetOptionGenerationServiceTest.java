package lv.rgladisevs.betapp.data.bet.option;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import lv.rgladisevs.betapp.TestUtils;
import lv.rgladisevs.betapp.data.match.Match;
import lv.rgladisevs.betapp.data.match.MatchService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rihards.gladisevs on 2016.03.29..
 */
public class BetOptionGenerationServiceTest {

  private List<Match> matchList;

  @Mock
  private MatchService matchService;

  @Mock
  private BetOptionObserverService betOptionObserverService;

  @InjectMocks
  private BetOptionGenerationService betOptionGenerationService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    Match match = TestUtils.getMatchFromFile();
    this.matchList = Collections.singletonList(match);
  }

  @Test
  public void testGenerateAndUpdateBetOptions() throws Exception {
    when(matchService.getAllMatches()).thenReturn(matchList);
    betOptionGenerationService.generateAndUpdateBetOptions();
    verify(matchService, times(1)).getAllMatches();
    verify(betOptionObserverService, times(1)).addBetOptionToObservable(any());
  }
}