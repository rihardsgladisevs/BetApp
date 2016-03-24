package lv.rgladisevs.betapp.data.bet.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
@Service
public class BetOptionSubscriptionServiceImpl implements BetOptionSubscriptionService {

  private static final Logger log = LoggerFactory.getLogger(BetOptionSubscriptionServiceImpl.class);

  @Autowired
  private BetOptionObserverService betOptionObserverService;

  @Autowired
  private BetOptionStorageService betOptionStorageService;

  @Autowired
  private MessageSendingOperations<String> messagingTemplate;

  @Override
  public void initBetOptionSubscription() {
    betOptionObserverService.getBetOptionObservable()
        .subscribe(this::processBetOption,
                   throwable -> log.error("Error! {}", throwable.getMessage()),
                   () -> log.debug("done"));
  }

  protected void processBetOption(BetOption betOption) {
    log.debug("Added: {}", betOption);
    updateBetOptionInStorage(betOption);
    pushBetOptionToWebSocket(betOption);
  }

  protected void pushBetOptionToWebSocket(BetOption betOption) {
    String destination = "/topic/options";
    messagingTemplate.convertAndSend(destination, betOption);
  }

  protected void updateBetOptionInStorage(BetOption betOption) {
    betOptionStorageService.updateOptionInMap(betOption);
  }
}
