package org.thief.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thief.dto.NasaPhoto;
import org.thief.repository.PictureRepository;
import org.thief.repository.dao.Camera;
import org.thief.repository.dao.Picture;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final PictureRepository pictureRepository;

    @Transactional
    public void createIfNotFound(Camera camera, NasaPhoto nasaPhoto) {
        long nasaPhotoId = nasaPhoto.getId();
        if (!pictureRepository.existsByNasaId(nasaPhotoId)) {
            Picture picture = new Picture();
            picture.setNasaId(nasaPhotoId);
            picture.setImgSrc(nasaPhoto.getImgSrc());
            picture.setCamera(camera);
            pictureRepository.save(picture);
        }
    }
}
