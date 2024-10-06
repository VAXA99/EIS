package Lab1_CDI.Calculator;


import Lab1_CDI.Calculator.Annotation.COSINE_ONLY;
import Lab1_CDI.Calculator.Parameter.TangentParameters;
import lombok.NoArgsConstructor;

import java.util.List;

@COSINE_ONLY
@NoArgsConstructor
public class CosineOnlyCalculator implements ITangentCalculator {

    @Override
    public <T extends Number> double calculate(TangentParameters<T> parameters) {

        List<T> values = parameters.getValues();

        return calculateTangent(values.get(0));
    }

    public <T extends Number> double calculateTangent(T cosine) {

        // Logging
        System.out.println("Cosine only tangent calculation method: ");

        // Convert cosine to double for mathematical operations
        double cosValue = cosine.doubleValue();

        // sin = sqrt(1 - cos^2)
        double sinValue = Math.sqrt(1 - cosValue * cosValue);

        // Calculate tangent
        return sinValue / cosValue;
    }

}
