package lv.rgladisevs.betapp.data.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
@Service
@Transactional
public class MatchServiceImpl implements MatchService {

  @Autowired
  private MatchRepository matchRepository;

  @Override
  public List<Match> getAllMatches() {
    return matchRepository.findAll();
  }

  @Override
  public Match saveMatch(Match match) {
    return matchRepository.save(match);
  }
}
