package lv.rgladisevs.betapp.data.bet;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
@IdClass(BetPK.class)
@Entity
@Table(name = "bet")
public class Bet implements Serializable {

  @Id
  @Column(name = "ip")
  private String ip;

  @Id
  @Column(name = "timestamp")
  private Long timestamp;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "odd")
  private String odd;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "currency")
  private String currency;

  @Transient
  private Long betOptionDatetime;

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getOdd() {
    return odd;
  }

  public void setOdd(String odd) {
    this.odd = odd;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Long getBetOptionDatetime() {
    return betOptionDatetime;
  }

  public void setBetOptionDatetime(Long betOptionDatetime) {
    this.betOptionDatetime = betOptionDatetime;
  }
}
