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
@JsonClassDescription(value = "sys")
public class CurrentSys {

    @JsonProperty("country")
    private String currentCountry;
    @JsonProperty("sunrise")
    private long currentSunrise;
    @JsonProperty("sunset")
    private long currentSunset;
}
