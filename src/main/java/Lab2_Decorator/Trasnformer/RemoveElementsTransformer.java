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

    // Checks if a value is in the array of elements to remove
    private boolean contains(int value) {
        for (int element : elementsToRemove) {
            if (element == value) {
                return true; // Value found in elements to remove
            }
        }
        return false; // Value not found
    }

    // Transforms the array by removing specified elements
    @Override
    public int[] transform(int[] array) {
        int[] tempArray = new int[array.length]; // Temporary array to hold non-removed elements
        int count = 0; // Counter for non-removed elements

        // Iterate over the original array
        for (int value : array) {
            if (!contains(value)) {
                tempArray[count++] = value; // Add non-removed element to temp array
            }
        }

        return Arrays.copyOf(tempArray, count); // Return a copy of the filled portion of the temp array
    }
}
