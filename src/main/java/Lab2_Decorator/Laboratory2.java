package Lab2_Decorator;

import Lab2_Decorator.Trasnformer.TransformerBean;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Arrays;

public class Laboratory2 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            int[] array = {1, 2, 100, 3, 4, 5, 6, 7, 200, 9};

            TransformerBean transformerBean = container.select(TransformerBean.class).get();

            int[] modifiedArray = transformerBean.transform(array);

        } finally {
            weld.shutdown();
        }
    }

}
