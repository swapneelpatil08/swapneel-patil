package Models.Pet;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CategoryOrTag {
    private int id;
    private String name;
}
