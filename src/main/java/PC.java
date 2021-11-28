
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class PC {

    private UUID id;
    public ArrayList<Cable> cables = new ArrayList<>();

    public PC(UUID id) {
        this.id = id;
    }

    public void plugIn(Cable cable) {
        cables.add(0, cable);
    }

        @Override
        public String toString () {
            return "PC{" +
                    "id=" + id +
                    ", cables=" + cables +
                    '}';
        }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PC pc = (PC) o;
            return Objects.equals(id, pc.id) && Objects.equals(cables, pc.cables);
        }

        @Override
        public int hashCode () {
            return Objects.hash(id, cables);
        }
    }


