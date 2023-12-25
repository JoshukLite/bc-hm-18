package org.thief.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaPhoto {
    private long id;
    @JsonProperty("img_src")
    private String imgSrc;
    private NasaCamera camera;
}
