package com.revature.registry.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A {@link Project} is one of the Capstone Projects managed by the Center of Excellence. A {@link Project} is composed
 * of many {@link Iteration}s, can only be in one {@link Status} at a time, and progresses through each {@link Phase}s
 * in the order presented. A {@link Project} is searchable and filterable by {@link Tag}s.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    private String description;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Account owner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "project_tags_jt", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = {
            @JoinColumn(name = "tag_id") })
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<Iteration> iterations = new ArrayList<>();
}
