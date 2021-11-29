
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Data
public class Cable {

    private UUID id;
    private PC left;
    private PC right;

    public Cable(UUID id) {
        this.id = id;
    }

    public void connect(PC pc) {
        if (this.left == null) {
            this.left = pc;
        } else if (this.right == null) {
            this.right = pc;
        } else {
            throw new IllegalStateException(
                    "This cable is already connected to two PC: " +
                            "left = " + this.left +
                            "; right = " + this.right);
        }
        pc.plugIn(this);
    }

    public void connect(PC left, PC right) {
        connect(left);
        connect(right);
    }

    public PC getAnother(PC pc) {
        if (this.left.equals(pc)) {
            return right;
        } else if (this.right.equals(pc)) {
            return this.left;
        } else {
            throw new IllegalArgumentException("This cable is not connected to PC: id " + pc.getId());
        }
    }

    @Override
    public String toString() {
        return "Cable{" +
                "id=" + id +
                ", left=" + ofNullable(left)
                .map(PC::getId)
                .orElse(null) +
                ", right=" + ofNullable(right)
                .map(PC::getId)
                .orElse(null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cable cable = (Cable) o;
        return Objects.equals(id, cable.id)
                && Objects.equals
                (ofNullable(left)
                                .map(PC::getId)
                                .orElse(null),
                        ofNullable(left)
                                .map(PC::getId)
                                .orElse(null))
                && Objects.equals
                (ofNullable(right)
                                .map(PC::getId)
                                .orElse(null),
                        ofNullable(right)
                                .map(PC::getId)
                                .orElse(null));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                ofNullable(left)
                        .map(PC::getId)
                        .orElse(null),
                ofNullable(right)
                        .map(PC::getId)
                        .orElse(null));
    }
}