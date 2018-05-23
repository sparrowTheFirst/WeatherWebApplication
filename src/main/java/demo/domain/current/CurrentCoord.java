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
@JsonClassDescription(value = "coord")
public class CurrentCoord {

    @JsonProperty("lat")
    private double currentLat;
    @JsonProperty("lon")
    private double currentLon;

}
