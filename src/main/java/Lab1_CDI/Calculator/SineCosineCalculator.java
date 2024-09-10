package Lab1_CDI.Calculator;

import Lab1_CDI.Calculator.Annotation.SINE_COSINE;
import Lab1_CDI.Calculator.Parameter.TangentParameters;
import lombok.NoArgsConstructor;

import java.util.List;

@SINE_COSINE
@NoArgsConstructor
public class SineCosineCalculator implements ITangentCalculator {

    @Override
    public <T extends Number> double calculate(TangentParameters<T> parameters) {

        List<T> values = parameters.getValues();

        // TODO Rework this shit
        return calculateTangent(values.get(0), values.get(1));
    }

    public <T extends Number> double calculateTangent(T sine, T cosine) {

        // Logging
        System.out.println("Sine and cosine calculation method: ");

        // Convert sine cosine to double for mathematical operations
        double sinValue = sine.byteValue();
        double cosValue = cosine.byteValue();

        // If tangent is not determined
        if (cosValue == 0) {
            throw new ArithmeticException("Tangent is not determined when cosine is equal to zero");
        }

        // Calculate tangent
        return sinValue / cosValue;
    }
}
