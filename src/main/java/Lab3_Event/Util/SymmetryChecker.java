package Lab3_Event.Util;

import Lab3_Event.Annotation.Added;
import Lab3_Event.Annotation.Removed;

import javax.enterprise.event.Observes;
import java.util.List;

public class SymmetryChecker {

    // Method to handle the event when items are added
    public void checkSymmetryOnAdd(@Observes @Added List<Integer> list) {
        System.out.println(outputSymmetric(isSymmetric(list)));
    }

    // Method to handle the event when items are removed
    public void checkSymmetryOnRemove(@Observes @Removed List<Integer> list) {
        System.out.println(outputSymmetric(isSymmetric(list)));
    }

    public boolean isSymmetric(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return true; // Empty list is symmetric
        }
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            if (!list.get(i).equals(list.get(n - 1 - i))) {
                return false; // Asymmetry
            }
        }
        return true; // List is symmetric
    }

    public String outputSymmetric(boolean symmetric) {
        return symmetric ? "Symmetric" : "Asymmetric";
    }
}
