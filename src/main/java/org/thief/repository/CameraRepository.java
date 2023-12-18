package org.thief.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thief.repository.dao.Camera;

import java.util.Optional;

public interface CameraRepository extends JpaRepository<Camera, Long> {
    Optional<Camera> findByNasaId(long nasaId);
}
