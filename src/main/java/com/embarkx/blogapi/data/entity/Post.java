package com.embarkx.blogapi.data.entity;

import com.embarkx.blogapi.data.dto.PostDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = PostDto.MAX_TITLE_LENGTH)
    private String title;

    @Column(nullable = false, length = PostDto.MAX_CONTENT_LENGTH)
    private String content;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void truncateCreatedAtToMicroseconds() {
        if (createdAt != null) {
            createdAt = createdAt.truncatedTo(ChronoUnit.MICROS);
        }
    }
}