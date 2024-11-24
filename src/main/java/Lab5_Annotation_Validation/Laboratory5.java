package Lab5_Annotation_Validation;

import Lab5_Annotation_Validation.Model.Station;
import Lab5_Annotation_Validation.Model.Train;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Arrays;
import java.util.List;

public class Laboratory5 {
    public static void main(String[] args) {
        Station station1 = new Station("Station A", "ESR1");
        Station station2 = new Station("Station B", "ESR2");
        Station station3 = new Station("Station C", "ESR3");

        // Валидный маршрут и расписание
        List<Station> route = Arrays.asList(station1, station2, station3);
        List<Station> schedule = Arrays.asList(station1, station2);

        Train validTrain = new Train(schedule, route);

        // Невалидное расписание (не по порядку)
        List<Station> invalidSchedule = Arrays.asList(station2, station1);
        Train invalidTrain = new Train(invalidSchedule, route);

        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        System.out.println("Valid Train:");
        validator.validate(validTrain).forEach(violation -> System.out.println(violation.getMessage()));

        System.out.println("\nInvalid Train:");
        validator.validate(invalidTrain).forEach(violation -> System.out.println(violation.getMessage()));
    }
}
