package lv.rgladisevs.betapp.data.bet.option;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.core.MessageSendingOperations;

import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by rihards.gladisevs on 2016.03.29..
 */
public class BetOptionSubscriptionServiceImplTest {

  private static final String BET_TOPIC_URL = "/topic/updateBetOption";

  @Mock
  private BetOption betOption;

  @Mock
  private Observable<BetOption> betOptionObservable;

  @Mock
  private BetOptionObserverService betOptionObserverService;

  @Mock
  private MessageSendingOperations<String> messagingTemplate;

  @Mock
  private BetOptionStorageService betOptionStorageService;

  @Mock
  private BetOptionSubscriptionServiceImpl betOptionSubscriptionServiceMock;

  @InjectMocks
  private BetOptionSubscriptionServiceImpl betOptionSubscriptionService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Ignore // Problems with JavaRx unit testing
  @Test
  public void testInitBetOptionSubscription() throws Exception {
    //when(betOptionObserverService.getBetOptionObservable()).thenReturn(betOptionObservable);
    betOptionSubscriptionService.initBetOptionSubscription();
    verify(betOptionObserverService, times(1)).getBetOptionObservable();
    verify(betOptionObservable, times(1)).subscribe(any(), any(), any());
    verify(messagingTemplate, times(1)).convertAndSend(BET_TOPIC_URL, betOption);
    verify(betOptionStorageService, times(1)).updateOptionInMap(betOption);
  }
}