package Models.Pet;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Pet {
    private int id;
    private CategoryOrTag category;
    private String name;
    private List<String> photoUrls;
    private List<CategoryOrTag> tags;
    private String status;
}
