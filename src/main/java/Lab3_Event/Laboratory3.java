package Lab3_Event;

import Lab3_Event.Util.CollectionManager;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory3 {
    protected static Weld weld;

    protected static WeldContainer container;

    public static void main(String args[]) throws Exception {
        weld = new Weld();
        container = weld.initialize();

        try {
            CollectionManager collectionManager = container.select(CollectionManager.class).get();

            collectionManager.addItem(7);
            collectionManager.addItem(8);
            collectionManager.addItem(9);
            collectionManager.addItem(10);
            collectionManager.addItem(9);
            collectionManager.addItem(8);
            collectionManager.addItem(7);

            collectionManager.removeItem(7); // Duplicate removal

        } finally {
            weld.shutdown();
        }
    }

}
