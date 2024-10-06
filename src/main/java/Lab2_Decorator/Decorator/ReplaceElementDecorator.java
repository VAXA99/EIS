package Lab2_Decorator.Decorator;

import Lab2_Decorator.Trasnformer.ArrayTransformer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.Arrays;

// Decorator for replacing specified elements in an array transformer
@Decorator
@AllArgsConstructor
@NoArgsConstructor
public class ReplaceElementDecorator implements ArrayTransformer {

    @Inject
    @Delegate
    private ArrayTransformer arrayTransformer;

    private int[] elementsToReplace = {3, 4};
    private int newElement = 0;

    @Override
    public int[] transform(int[] array) {
        System.out.println("Replace element decorator applied");

        int[] transformedArray = arrayTransformer.transform(array);
        System.out.println("Array after original transformation: " + Arrays.toString(transformedArray));

        // Replace specified elements in the transformed array
        for (int i = 0; i < transformedArray.length; i++) {
            if (shouldReplace(transformedArray[i])) {
                transformedArray[i] = newElement; // Replace element
            }
        }

        System.out.println("Array after replacing elements: " + Arrays.toString(transformedArray));
        return transformedArray;
    }

    private boolean shouldReplace(int element) {
        for (int e : elementsToReplace) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }
}
