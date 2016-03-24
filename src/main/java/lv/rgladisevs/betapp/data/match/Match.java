package lv.rgladisevs.betapp.data.match;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
@Entity
@Table(name = "match")
public class Match implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @NotEmpty
  @Column(name = "name")
  private String name;

  public Match() {}

  public Match(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
