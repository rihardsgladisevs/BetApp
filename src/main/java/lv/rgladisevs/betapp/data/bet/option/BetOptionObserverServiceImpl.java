package lv.rgladisevs.betapp.data.bet.option;

import org.springframework.stereotype.Service;

import rx.subjects.PublishSubject;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
@Service
public class BetOptionObserverServiceImpl implements BetOptionObserverService {

  private PublishSubject<BetOption> betOptionObservable = PublishSubject.create();

  @Override
  public PublishSubject<BetOption> getBetOptionObservable() {
    return betOptionObservable;
  }

  @Override
  public void addBetOptionToObservable(BetOption betOption) {
    betOptionObservable.onNext(betOption);
  }
}
