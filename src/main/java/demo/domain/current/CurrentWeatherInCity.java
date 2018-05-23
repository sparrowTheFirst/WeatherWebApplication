package demo.domain.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeatherInCity {

    @JsonProperty("name")
    private String nameOfCity;
    @JsonProperty("main")
    private CurrentMain currentMain;
    @JsonProperty("wind")
    private CurrentWind currentWind;
    @JsonProperty("dt")
    private long dateOfCalculation;
    @JsonProperty("sys")
    private CurrentSys currentSys;
    @JsonProperty("coord")
    private CurrentCoord currentCoord;
    @JsonProperty("weather")
    private CurrentWeather[] currentWeathers;

}
