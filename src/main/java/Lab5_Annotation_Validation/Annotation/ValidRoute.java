package Lab5_Annotation_Validation.Annotation;

import Lab5_Annotation_Validation.Validator.RouteValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RouteValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRoute {
    String message() default "Train schedule does not match the defined route";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
