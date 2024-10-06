package Lab2_Decorator.Trasnformer;

import javax.inject.Inject;
import java.util.Arrays;

public class TransformerBean {

    @Inject
    private ArrayTransformer arrayTransformer;

    public int[] transform(int[] array) {
        System.out.println("Transforming array: " + Arrays.toString(array));
        return arrayTransformer.transform(array);
    }
}
