package demo.domain.current;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription(value = "main")
public class CurrentMain {

    @JsonProperty("temp")
    private double currentTemp;
    @JsonProperty("pressure")
    private double currentPressure;
    @JsonProperty("temp_min")
    private double currentTempMin;
    @JsonProperty("temp_max")
    private double currentTempMax;
    @JsonProperty("humidity")
    private int currentHumidity;

}
