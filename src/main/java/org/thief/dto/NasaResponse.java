package org.thief.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaResponse {
    private List<NasaPhoto> photos;

    public List<NasaPhoto> getPhotos() {
        return photos != null ? photos : Collections.emptyList();
    }
}
