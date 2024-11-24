package Lab5_Annotation_Validation.Model;


import Lab5_Annotation_Validation.Annotation.ValidRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidRoute
public class Train {
    @Valid
    private List<Station> schedule; // Расписание

    @Valid
    private List<Station> route; // Маршрут
}
