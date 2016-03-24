package lv.rgladisevs.betapp.data.bet.option;

import rx.subjects.PublishSubject;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
public interface BetOptionStorageService {

  BetOption getBetOptionFromMap(String matchName);

  void updateOptionInMap(BetOption betOption);
}
