package lv.rgladisevs.betapp.data.bet.option;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
public interface BetOptionStorageService {

  BetOption getBetOptionFromMap(String matchName);

  void updateOptionInMap(BetOption betOption);

  List<BetOption> getBetOptionList();
}
