package Lab1_CDI;

import Lab1_CDI.Calculator.Parameter.CosineOnlyParameters;
import Lab1_CDI.Calculator.Parameter.SineCosineParameters;
import Lab1_CDI.Calculator.Parameter.TangentParameters;
import Lab1_CDI.Component.TangentCalculator;
import lombok.NoArgsConstructor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@NoArgsConstructor
public class Laboratory1 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            TangentCalculator tangentCalculator = container.select(TangentCalculator.class).get();

            TangentParameters<Double> parameters = new CosineOnlyParameters<Double>(0.3);

//            TangentParameters<Double> parameters = new SineCosineParameters<>(0.3, 0.5);

            double tangent = tangentCalculator.calculateTangent(parameters);
            System.out.println("Result: " + tangent);

        } finally {
            weld.shutdown();
        }
    }
}
