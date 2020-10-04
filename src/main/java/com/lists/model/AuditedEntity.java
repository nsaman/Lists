package com.lists.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Created by nick on 10/9/2018.
 */
@Data
public abstract class AuditedEntity {
    @CreatedBy
    private String createUserID;

    @LastModifiedBy
    private String changeUserID;

    @CreatedDate
    private Long createTimestamp;

    @LastModifiedDate
    private Long changeTimestamp;
}