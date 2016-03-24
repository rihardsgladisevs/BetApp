package lv.rgladisevs.betapp.data.bet.option;

import rx.subjects.PublishSubject;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
public interface BetOptionObserverService {
  PublishSubject<BetOption> getBetOptionObservable();

  void addBetOptionToObservable(BetOption betOption);
}
