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
@JsonClassDescription(value = "wind")
public class ForecastWind {

    @JsonProperty("speed")
    private double forecastSpeed;
    @JsonProperty("deg")
    private double forecastDeg;

}
