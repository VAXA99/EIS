package Lab1_CDI.Calculator.Parameter;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class CosineOnlyParameters<T extends Number> implements TangentParameters<T> {

    private final T cosine;

    public CosineOnlyParameters(T cosine) {
        if (cosine.doubleValue() < -1 || cosine.doubleValue() > 1) {
            throw new IllegalArgumentException("Cosine must be between -1 and 1.");
        } else if (cosine.doubleValue() == 0) {
            throw new ArithmeticException("Tangent is not determined when cosine is equal to zero");
        }

        this.cosine = cosine;
    }

    @Override
    public List<T> getValues() {
        return Collections.singletonList(cosine);
    }
}
