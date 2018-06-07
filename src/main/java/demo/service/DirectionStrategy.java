package demo.service;

public class DirectionStrategy {

    private String direction;

    public DirectionStrategy(Double degrees) {
        String result = "N north";
        if (degrees > 11.25 && degrees <= 33.75) {
            result = "NNE north-northeast";
        }
        if (degrees > 33.75 && degrees <= 56.25) {
            result = "NE northeast";
        }
        if (degrees > 56.25 && degrees <= 78.75) {
            result = "ENE east-northeast";
        }
        if (degrees > 78.75 && degrees <= 101.25) {
            result = "E east";
        }
        if (degrees > 101.25 && degrees <= 123.75) {
            result = "ESE east-southeast";
        }
        if (degrees > 123.75 && degrees <= 146.25) {
            result = "SE southeast";
        }
        if (degrees > 146.25 && degrees <= 168.75) {
            result = "SSE south-southeast";
        }
        if (degrees > 168.75 && degrees <= 191.25) {
            result = "S south";
        }
        if (degrees > 191.25 && degrees <= 213.75) {
            result = "SSW south-southwest";
        }
        if (degrees > 213.75 && degrees <= 236.25) {
            result = "SW southwest";
        }
        if (degrees > 236.25 && degrees <= 258.75) {
            result = "WSW west-southwest";
        }
        if (degrees > 258.75 && degrees <= 281.25) {
            result = "W west";
        }
        if (degrees > 281.25 && degrees <= 303.75) {
            result = "WNW west-northwest";
        }
        if (degrees > 303.75 && degrees <= 326.25) {
            result = "NW northwest";
        }
        if (degrees > 326.25 && degrees <= 348.75) {
            result = "NNW north-northwest";
        }
        this.direction = result;
    }

    @Override
    public String toString() {
        return direction;
    }
}
