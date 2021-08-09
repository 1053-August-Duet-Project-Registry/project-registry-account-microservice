package com.revature.registry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * A {@link Repository} refers to a Github Repository belonging to an {@link Organization}.
 */

@Entity
@Data
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String url;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
