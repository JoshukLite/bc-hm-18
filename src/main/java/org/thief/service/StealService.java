package org.thief.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.thief.dto.NasaPhoto;
import org.thief.dto.NasaResponse;
import org.thief.repository.dao.Camera;

import java.net.URI;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StealService {
    private static final String URL_BASE = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";
    private static final String URL_PARAM_SOL = "sol";
    private static final String URL_PARAM_API_KEY = "api_key";

    private final CameraService cameraService;
    private final PictureService pictureService;

    private final RestTemplate restTemplate;

    @Value("${thief.nasa-api-key}")
    private String apiKey;

    @Transactional
    public void stealNasaData(int sol) {
        URI requestUri = UriComponentsBuilder.fromUriString(URL_BASE)
                .queryParam(URL_PARAM_SOL, sol)
                .queryParam(URL_PARAM_API_KEY, apiKey)
                .build()
                .toUri();
        ResponseEntity<NasaResponse> response = restTemplate.getForEntity(requestUri, NasaResponse.class);
        NasaResponse nasaResponse = Objects.requireNonNull(response.getBody(),
                "Nasa response is empty. URL - '%s', 'sol' parameter - '%d'".formatted(URL_BASE, sol));
        for (NasaPhoto nasaPhoto : nasaResponse.getPhotos()) {
            Camera camera = cameraService.findOrCreate(nasaPhoto.getCamera());
            pictureService.createIfNotFound(camera, nasaPhoto);
        }
    }
}
