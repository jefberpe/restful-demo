/*
 * This file is generated by jOOQ.
 */
package com.demo.demo1.model.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Book implements Serializable {

    private static final long serialVersionUID = 1875016747;

    private UUID      id;
    private String    title;
    private String    description;
    private Timestamp publishDate;
    private Boolean   isDeleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Book() {}

    public Book(Book value) {
        this.id = value.id;
        this.title = value.title;
        this.description = value.description;
        this.publishDate = value.publishDate;
        this.isDeleted = value.isDeleted;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Book(
        UUID      id,
        String    title,
        String    description,
        Timestamp publishDate,
        Boolean   isDeleted,
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book (");

        sb.append(id);
        sb.append(", ").append(title);
        sb.append(", ").append(description);
        sb.append(", ").append(publishDate);
        sb.append(", ").append(isDeleted);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
