package demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wind {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double minDegree;
    private Double maxDegree;
    private String direction;

    public Double getMinDegree() {
        return minDegree;
    }

    public Double getMaxDegree() {
        return maxDegree;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}
