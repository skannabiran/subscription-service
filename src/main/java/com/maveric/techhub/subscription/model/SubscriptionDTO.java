package com.maveric.techhub.subscription.model;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class SubscriptionDTO {

    private String id;
    @Column
    private String subscriberId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
