package Lab5_Annotation_Validation.Validator;

import Lab5_Annotation_Validation.Annotation.ValidRoute;
import Lab5_Annotation_Validation.Model.Station;
import Lab5_Annotation_Validation.Model.Train;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.List;

public class RouteValidator implements ConstraintValidator<ValidRoute, Train> {

    @Override
    public boolean isValid(Train train, ConstraintValidatorContext context) {
        if (train.getSchedule() == null || train.getRoute() == null) {
            return true; // Null-поля проверяются другими аннотациями
        }

        List<Station> schedule = train.getSchedule();
        List<Station> route = train.getRoute();

        // Проверяем, что расписание — это подмножество маршрута
        if (!new HashSet<>(route).containsAll(schedule)) {
            return false;
        }

        // Проверяем порядок станций в расписании относительно маршрута
        int lastIndex = -1;
        for (Station station : schedule) {
            int currentIndex = route.indexOf(station);
            if (currentIndex < 0 || currentIndex < lastIndex) {
                return false;
            }
            lastIndex = currentIndex;
        }
        return true;
    }
}
