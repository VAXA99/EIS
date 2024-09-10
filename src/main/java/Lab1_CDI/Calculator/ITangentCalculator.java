package Lab1_CDI.Calculator;

import Lab1_CDI.Calculator.Parameter.TangentParameters;

public interface ITangentCalculator {
    <T extends Number> double calculate(TangentParameters<T> parameters);
}
