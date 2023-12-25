package org.thief.repository.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pictures")
@Getter
@Setter
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long nasaId;
    @Column(nullable = false)
    private String imgSrc;
    @Column(nullable = false, insertable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camera_id", nullable = false)
    private Camera camera;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return nasaId == picture.nasaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nasaId);
    }
}
