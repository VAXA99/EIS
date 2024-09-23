package Lab2_Decorator.Decorator;

import Lab2_Decorator.Trasnformer.ArrayTransformer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

// Decorator for replacing specified elements in an array transformer
@Decorator
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceElementDecorator implements ArrayTransformer {

    // Injecting the original ArrayTransformer to be decorated
    @Inject
    @Delegate
    private ArrayTransformer arrayTransformer;

    private int[] elementsToReplace = {3, 4};
    private int newElement = 0;

    // Transforms the array and replaces specified elements
    @Override
    public int[] transform(int[] array) {
        int[] transformedArray = arrayTransformer.transform(array);

        // Replace specified elements in the transformed array
        for (int i = 0; i < transformedArray.length; i++) {
            if (shouldReplace(transformedArray[i])) {
                transformedArray[i] = newElement; // Replace element
            }
        }

        return transformedArray;
    }

    // Checks if an element should be replaced
    private boolean shouldReplace(int element) {
        for (int e : elementsToReplace) {
            if (e == element) {
                return true; // Element matches one to replace
            }
        }
        return false; // No match found
    }
}
