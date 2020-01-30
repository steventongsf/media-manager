package com.sfhuskie.mediamanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Media implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private Genre genre;
    @Column(name = "length")
    private long length;
    @Column(name = "rating")
    private int rating;
    @Column(name = "timesPlayed")
    private long timesPlayed;
    @Column(name = "notes")
    private String notes;
    @Column(name = "location")
    private String location;

    
    public boolean isNew() {
        return this.id == null;
    }

}

