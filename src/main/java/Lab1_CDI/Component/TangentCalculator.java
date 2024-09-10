package Lab1_CDI.Component;

import Lab1_CDI.Calculator.Annotation.COSINE_ONLY;
import Lab1_CDI.Calculator.Annotation.SINE_COSINE;
import Lab1_CDI.Calculator.ITangentCalculator;
import Lab1_CDI.Calculator.Parameter.TangentParameters;
import Lab1_CDI.Interceptor.ProfileInterceptor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Interceptors(ProfileInterceptor.class) // Interceptor
@NoArgsConstructor
public class TangentCalculator {

    // Dependency injection point
    @Inject @COSINE_ONLY
    private ITangentCalculator calculator;

    public <T extends Number> double calculateTangent(TangentParameters<T> parameters) {
        return calculator.calculate(parameters);
    }

}
