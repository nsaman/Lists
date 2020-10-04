package com.lists.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by nick on 10/9/2018.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditedEntity {
    @Column(name = "createUserID")
    @CreatedBy
    private String createUserID;

    @Column(name = "changeUserID")
    @LastModifiedBy
    private String changeUserID;

    @Column(name = "createTimestamp", nullable = false, updatable = false)
    @CreatedDate
    private Long createTimestamp;

    @Column(name = "changeTimestamp")
    @LastModifiedDate
    private Long changeTimestamp;
}