package com.ebuy.shared.database.entity;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
/**
 * @created 11/12/2020 - 6:34 PM
 * @project ebuy
 * @author Abdur Rahim Nisahd
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        @CreatedBy
        @Column(updatable = false)
        private String createdBy;

        @CreatedDate
        @Column(updatable = false)
        private LocalDateTime created;

        @LastModifiedBy
        @Column()
        private String modifiedBy;

        @LastModifiedDate
        @Column()
        private LocalDateTime modified;

        @Column(name = "isDeleted", nullable = false, columnDefinition = "boolean default false")
        private boolean isDeleted;
}
