import Lab1_CDI.Calculator.Parameter.CosineOnlyParameters;
import Lab1_CDI.Calculator.Parameter.TangentParameters;
import Lab1_CDI.Component.TangentCalculator;
import lombok.NoArgsConstructor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Laboratory1 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            TangentCalculator tangentCalculator = container.select(TangentCalculator.class).get();

            TangentParameters<Double> parameters = new CosineOnlyParameters<Double>(0.0);


            double tangent = tangentCalculator.calculateTangent(parameters);
            System.out.println(tangent);

        } finally {
            weld.shutdown();
        }
    }
}
