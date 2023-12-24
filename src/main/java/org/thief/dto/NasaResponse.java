package org.thief.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaResponse {
    private List<NasaPhoto> photos;

    public List<NasaPhoto> getPhotos() {
        return ListUtils.emptyIfNull(photos);
    }
}
