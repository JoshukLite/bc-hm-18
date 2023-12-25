package org.thief.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thief.dto.NasaCamera;
import org.thief.repository.CameraRepository;
import org.thief.repository.dao.Camera;

@Service
@AllArgsConstructor
public class CameraService {

    private final CameraRepository cameraRepository;

    @Transactional
    public Camera findOrCreate(NasaCamera nasaCamera) {
        long cameraNasaId = nasaCamera.getId();
        return cameraRepository.findByNasaId(cameraNasaId)
                .orElseGet(() -> create(nasaCamera));
    }

    private Camera create(NasaCamera nasaCame) {
        Camera camera = new Camera();
        camera.setNasaId(nasaCame.getId());
        camera.setName(nasaCame.getName());
        return cameraRepository.save(camera);
    }
}
