package demo.domain.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class
ForecastForCity {

    @JsonProperty("city")
    private ForecastCity forecastCity;
    @JsonProperty(value = "cnt")
    private int numOfLinesOfJson;
    @JsonProperty("list")
    private ForecastParameters[] forecastParameters;

}
