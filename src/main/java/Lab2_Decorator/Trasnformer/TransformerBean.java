package Lab2_Decorator.Trasnformer;

import javax.inject.Inject;

public class TransformerBean {

    // Dependency injection point
    @Inject
    private ArrayTransformer arrayTransformer;

    public int[] transform(int[] array) {
        return arrayTransformer.transform(array);
    }
}
