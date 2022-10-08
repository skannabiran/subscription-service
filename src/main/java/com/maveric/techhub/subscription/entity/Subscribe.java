package com.maveric.techhub.subscription.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Subscribe")
@EntityListeners(AuditingEntityListener.class)
public class Subscribe {
    @Id
    @Column
    private String id;
    @Column
    private String subscriberId;
    @Column
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
