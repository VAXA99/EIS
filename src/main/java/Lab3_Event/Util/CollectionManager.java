package Lab3_Event.Util;

import Lab3_Event.Annotation.Added;
import Lab3_Event.Annotation.Removed;
import lombok.Getter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CollectionManager {

    @Getter
    private List<Integer> list = new ArrayList<>();

    @Inject
    @Added
    private Event<List<Integer>> listAddedEvent;

    @Inject
    @Removed
    private Event<List<Integer>> listRemovedEvent;

    public void addItem(Integer item) {
        list.add(item);
        listAddedEvent.fire(new ArrayList<>(list));
        System.out.println("List after addition: " + list); // Print the list after addition
    }

    public void removeItem(Integer item) {
        if (list.contains(item)) {
            list.remove(item);
            listRemovedEvent.fire(new ArrayList<>(list));
            System.out.println("List after removal: " + list); // Print the list after removal
        } else {
            System.out.println("Item " + item + " not found in the list."); // Optional: Notify if the item is not found
        }
    }

}
