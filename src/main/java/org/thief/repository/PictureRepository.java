package org.thief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thief.repository.dao.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    boolean existsByNasaId(long nasaId);
}
