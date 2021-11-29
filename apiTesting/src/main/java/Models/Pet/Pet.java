package Models.Pet;

import lombok.Getter;

import java.util.List;

@Getter
public class Pet {
    private int id;
    private CategoryOrTag category;
    private String name;
    private List<String> photoUrls;
    private CategoryOrTag tags;
    private String status;
}
