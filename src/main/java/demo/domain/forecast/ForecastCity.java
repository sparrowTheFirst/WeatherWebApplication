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
@JsonClassDescription(value = "city")
public class ForecastCity {

    @JsonProperty("name")
    private String nameOfCity;
    @JsonProperty("country")
    private String forecastCountry;
    @JsonProperty("coord")
    private ForecastCoord forecastCoord;

}
