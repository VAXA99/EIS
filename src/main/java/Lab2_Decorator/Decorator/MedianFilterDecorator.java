package Lab2_Decorator.Decorator;

import Lab2_Decorator.Trasnformer.ArrayTransformer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.Arrays;

// Decorator for applying a median filter to an array transformer
@Decorator
@AllArgsConstructor
@NoArgsConstructor
public class MedianFilterDecorator implements ArrayTransformer {

    @Inject
    @Delegate
    private ArrayTransformer arrayTransformer;

    @Override
    public int[] transform(int[] array) {
        System.out.println("Median filter decorator applied");

        int[] transformedArray = arrayTransformer.transform(array);
        System.out.println("Array after original transformation: " + Arrays.toString(transformedArray));

        int[] filteredArray = applyMedianFilter(transformedArray);
        System.out.println("Array after applying median filter: " + Arrays.toString(filteredArray));

        return filteredArray;
    }

    private int[] applyMedianFilter(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = medianOfNeighbors(array, i);
        }
        return result;
    }

    private int medianOfNeighbors(int[] array, int index) {
        int start = Math.max(0, index - 2);
        int end = Math.min(array.length - 1, index + 2);
        int[] neighbors = Arrays.copyOfRange(array, start, end + 1);
        Arrays.sort(neighbors);
        return neighbors[neighbors.length / 2];
    }
}
