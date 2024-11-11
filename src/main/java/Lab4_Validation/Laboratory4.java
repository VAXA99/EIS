package Lab4_Validation;

import Lab4_Validation.Model.XmlValidatedTrain;
import Lab4_Validation.Model.CodeValidatedTrain;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class Laboratory4 {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        XmlValidatedTrain xmlTrain = new XmlValidatedTrain();
        xmlTrain.setName("Ласточка");
        xmlTrain.setTrainNumber("5678");
        xmlTrain.setRoute("Сочи - Адлер");
        xmlTrain.setNumberOfCars(5);

        System.out.println("Валидация XmlValidatedTrain:");
        validateAndPrint(validator, xmlTrain);

        CodeValidatedTrain codeTrain = new CodeValidatedTrain();
        codeTrain.setName("1234"); // Некорректное имя (должно содержать только буквы и пробелы)
        codeTrain.setTrainNumber("12A4"); // Некорректный номер (должен состоять только из 4 цифр)
        codeTrain.setRoute(null); // Поле не должно быть пустым
        codeTrain.setNumberOfCars(100); // Некорректное значение (должно быть от 1 до 50)

        System.out.println("\nВалидация CodeValidatedTrain:");
        validateAndPrint(validator, codeTrain);
    }

    private static <T> void validateAndPrint(Validator validator, T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (violations.isEmpty()) {
            System.out.println("Валидация прошла успешно!");
        } else {
            for (ConstraintViolation<T> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
        }
    }
}
