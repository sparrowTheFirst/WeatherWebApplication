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
@JsonClassDescription(value = "main")
public class ForecastMain {

    @JsonProperty("temp")
    private double forecastTemp;
    @JsonProperty("pressure")
    private double forecastPressure;
    @JsonProperty("temp_min")
    private double forecastTempMin;
    @JsonProperty("temp_max")
    private double forecastTempMax;
    @JsonProperty("humidity")
    private int forecastHumidity;

}
