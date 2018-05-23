package demo.domain.current;

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
public class CurrentWind {

    @JsonProperty("speed")
    private double currentSpeed;
    @JsonProperty("deg")
    private double currentDeg;

}
