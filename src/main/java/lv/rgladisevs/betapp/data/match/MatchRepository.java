package lv.rgladisevs.betapp.data.match;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

  List<Match> findAll();

}
