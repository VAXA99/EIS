package Lab3_Event.Util;

import Lab3_Event.Annotation.Added;
import Lab3_Event.Annotation.Removed;

import javax.enterprise.event.Observes;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueValueCounter {

    // Set to keep track of unique values
    private final Set<Integer> uniqueValues = new HashSet<>();

    // Method to handle the event when items are added
    public void countUniqueOnAdd(@Observes @Added List<Integer> list) {
        uniqueValues.addAll(list); // Add all items from the list to the set
        System.out.println("Unique count after addition: " + uniqueValues.size());
    }

    // Method to handle the event when items are removed
    public void countUniqueOnRemove(@Observes @Removed List<Integer> list) {
        uniqueValues.addAll(list); // Add all items from the list to the set
        System.out.println("Unique count after removal: " + uniqueValues.size());
    }
}
