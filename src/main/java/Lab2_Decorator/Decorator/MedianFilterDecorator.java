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

    // Injecting the original ArrayTransformer to be decorated
    @Inject
    @Delegate
    private ArrayTransformer arrayTransformer;

    // Transforms the array using the original transformer and applies the median filter
    @Override
    public int[] transform(int[] array) {
        int[] transformedArray = arrayTransformer.transform(array); // Get transformed array
        return applyMedianFilter(transformedArray); // Apply median filter
    }

    // Applies median filter to the given array
    private int[] applyMedianFilter(int[] array) {
        int[] result = new int[array.length]; // Resultant array to hold filtered values
        for (int i = 0; i < array.length; i++) {
            result[i] = medianOfNeighbors(array, i); // Get median of neighbors for each element
        }
        return result; // Return the filtered array
    }

    // Computes the median of the neighbors for a given index
    private int medianOfNeighbors(int[] array, int index) {
        int start = Math.max(0, index - 2); // Start index for neighbor range
        int end = Math.min(array.length - 1, index + 2); // End index for neighbor range
        int[] neighbors = Arrays.copyOfRange(array, start, end + 1); // Extract neighbors
        Arrays.sort(neighbors); // Sort the neighbors to find the median
        return neighbors[neighbors.length / 2]; // Return the median value
    }
}
