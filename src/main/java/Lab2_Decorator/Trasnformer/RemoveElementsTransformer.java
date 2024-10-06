package Lab2_Decorator.Trasnformer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Default;
import java.util.Arrays;

// Transformer for removing specified elements from an array
@Default
@AllArgsConstructor
@NoArgsConstructor
public class RemoveElementsTransformer implements ArrayTransformer {

    private int[] elementsToRemove = {1, 2};

    private boolean contains(int value) {
        for (int element : elementsToRemove) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] transform(int[] array) {
        System.out.println("Default implementation of ArrayTransformer applied");
        System.out.println("Array before transformation: " + Arrays.toString(array));

        int[] tempArray = new int[array.length];
        int count = 0;

        for (int value : array) {
            if (!contains(value)) {
                tempArray[count++] = value;
            }
        }

        int[] resultArray = Arrays.copyOf(tempArray, count);
        System.out.println("Array after removing elements: " + Arrays.toString(resultArray));
        return resultArray;
    }
}
