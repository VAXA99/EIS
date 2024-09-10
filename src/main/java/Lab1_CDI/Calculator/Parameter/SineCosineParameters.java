package Lab1_CDI.Calculator.Parameter;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class SineCosineParameters<T extends Number> implements TangentParameters<T> {

    private final T sine;
    private final T cosine;

    public SineCosineParameters(T sine, T cosine) {
        if (Math.abs(sine.doubleValue()) > 1 || Math.abs(cosine.doubleValue()) > 1) {
            throw new IllegalArgumentException("Sine and cosine must be between -1 and 1.");
        } else if (cosine.doubleValue() == 0) {
            throw new ArithmeticException("Tangent is not determined when cosine is equal to zero");
        }

        this.sine = sine;
        this.cosine = cosine;
    }

    @Override
    public List<T> getValues() {
        return Arrays.asList(sine, cosine);
    }
}
