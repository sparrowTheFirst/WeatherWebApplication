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
@JsonClassDescription(value = "list")
public class ForecastParameters {

    @JsonProperty("dt_txt")
    private String dateOfCalculation;
    @JsonProperty("main")
    private ForecastMain forecastMain;
    @JsonProperty("wind")
    private ForecastWind forecastWind;
    @JsonProperty("weather")
    private ForecastWeather[] forecastWeathers;

}
