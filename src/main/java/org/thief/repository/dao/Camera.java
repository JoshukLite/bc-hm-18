package org.thief.repository.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "cameras")
@Getter
@Setter
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long nasaId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, insertable = false, updatable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "camera", fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    private List<Picture> pictures;
}
