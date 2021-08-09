package com.revature.registry.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * An {@link Organization} refers to a Github Organization.
 *
 * Typically, the root/first {@link Iteration} Github Repository will be found in the `revaturelabs` Organization.
 * Subsequent sprints have an individual {@link Organization} created, with as many {@link Repository}'s
 * as required to meet the applications needs.
 */

@Entity
@Data
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "organization")
    @JsonIgnoreProperties("organization")
    private List<Repository> repositories = new ArrayList<>();
}
