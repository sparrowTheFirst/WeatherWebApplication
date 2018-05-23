package demo.domain.forecast;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription(value = "coord")
public class ForecastCoord {

    @JsonProperty("lat")
    private double forecastLat;
    @JsonProperty("lon")
    private double forecastLon;

}
