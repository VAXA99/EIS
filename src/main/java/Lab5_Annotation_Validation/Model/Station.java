package Lab5_Annotation_Validation.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    @NotNull(message = "Station name must not be null")
    private String name;

    @NotNull(message = "Station ESR must not be null")
    private String ESR; // ЕСР станции

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return name.equals(station.name) && ESR.equals(station.ESR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ESR);
    }

}
