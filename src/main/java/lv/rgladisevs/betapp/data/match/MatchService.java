package lv.rgladisevs.betapp.data.match;

import java.util.List;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
public interface MatchService {

  List<Match> getAllMatches();

  Match saveMatch(Match match);
}
