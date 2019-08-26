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
public class Author implements Serializable {

    private static final long serialVersionUID = -822403941;

    private UUID      id;
    private String    firstName;
    private String    lastName;
    private Timestamp birthDate;
    private Boolean   isDeleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Author() {}

    public Author(Author value) {
        this.id = value.id;
        this.firstName = value.firstName;
        this.lastName = value.lastName;
        this.birthDate = value.birthDate;
        this.isDeleted = value.isDeleted;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Author(
        UUID      id,
        String    firstName,
        String    lastName,
        Timestamp birthDate,
        Boolean   isDeleted,
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
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
        StringBuilder sb = new StringBuilder("Author (");

        sb.append(id);
        sb.append(", ").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(birthDate);
        sb.append(", ").append(isDeleted);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}