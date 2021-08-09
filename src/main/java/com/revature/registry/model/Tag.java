package com.revature.registry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * A {@link Tag} is general metadata about a {@link Project}. Will be used to categorize and search for {@link Project}
 */

@Entity
@Data
public class Tag {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private String description;

    @Column(name = "is_enabled")
    private Boolean isEnabled;
}
