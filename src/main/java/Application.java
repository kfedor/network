import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class Application {

    public static void main(String[] args) {
        PC pc1 = new PC(UUID.randomUUID());
        PC pc2 = new PC(UUID.randomUUID());
        PC pc3 = new PC(UUID.randomUUID());
        PC pc4 = new PC(UUID.randomUUID());

        Cable c1 = new Cable(UUID.randomUUID());
        Cable c2 = new Cable(UUID.randomUUID());
        Cable c3 = new Cable(UUID.randomUUID());
        Cable c4 = new Cable(UUID.randomUUID());

        c1.connect(pc1, pc2);
        c2.connect(pc2, pc3);
        c3.connect(pc3, pc4);
        c4.connect(pc4, pc1);

        recursion(pc1, new HashSet<>());
    }

    private static void recursion(PC current, Set<PC> visited) {
        System.out.println("Current PC: " + current.getId());

        if(visited.contains(current)){
            System.out.println("В этой точке мы уже были");
            return;
        }

        visited.add(current);

        ArrayList<Cable> cables = current.getCables();

        for (Cable cable : cables) {
            if (cable == null) {
                break;
            }

            PC another = cable.getAnother(current);
            System.out.println("Current: " + current.getId() + "; Another: " + another.getId());
            recursion (current, visited);
        }
    }
}