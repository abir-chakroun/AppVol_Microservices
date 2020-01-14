package com.example.reservationservice;

import org.dom4j.tree.AbstractEntity;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.*;


@Table
@Entity(name = "ReservationItem")
public class ReservationItem extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ReservationId;

    @NotNull(message = "Reservation must corresponds to a Client")
    private long ClientId;
    @NotNull(message = "Reservation must corresponds to a Vol")
    private Long VolNum;

    @LastModifiedDate
    private Date created;

    public ReservationItem(long clientId, Long volNum) {
        ClientId = clientId;
        VolNum = volNum;
    }

    public long getClientId() {
        return ClientId;
    }

    public void setClientId(long clientId) {
        ClientId = clientId;
    }

    public Long getVolNum() {
        return VolNum;
    }

    public void setVolNum(Long volNum) {
        VolNum = volNum;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

