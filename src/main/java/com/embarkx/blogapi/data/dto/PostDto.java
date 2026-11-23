package com.embarkx.blogapi.data.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public final class PostDto {

    public static final int MAX_TITLE_LENGTH = 100;
    public static final int MAX_CONTENT_LENGTH = 5000;
    public static final String TITLE_CANNOT_BE_EMPTY = "Title cannot be empty";
    public static final String CONTENT_CANNOT_BE_EMPTY = "Content cannot be empty";
    public static final String TITLE_MUST_NOT_EXCEED_MAX_CHARACTERS = "Title must not exceed {max} characters";
    public static final String CONTENT_MUST_NOT_EXCEED_MAX_CHARACTERS = "Content must not exceed {max} characters";

    @Nullable
    private final Integer id;

    @NotBlank(message = TITLE_CANNOT_BE_EMPTY)
    @Size(max = PostDto.MAX_TITLE_LENGTH, message = TITLE_MUST_NOT_EXCEED_MAX_CHARACTERS)
    private final String title;

    @NotBlank(message = CONTENT_CANNOT_BE_EMPTY)
    @Size(max = PostDto.MAX_CONTENT_LENGTH, message = CONTENT_MUST_NOT_EXCEED_MAX_CHARACTERS)
    private final String content;

    @Nullable
    private final LocalDateTime createdAt;


    public PostDto(@Nullable Integer id, String title, String content, @Nullable LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PostDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.content, that.content) &&
                Objects.equals(this.createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createdAt);
    }

    @Override
    public String toString() {
        return "PostDto[" +
                "id=" + id + ", " +
                "title=" + title + ", " +
                "content=" + content + ", " +
                "createdAt=" + createdAt + ']';
    }

}