package ApiIntegration;

import Models.Pet.CategoryOrTag;
import Models.Pet.Pet;
import Utils.ApiRepository;
import Utils.RestResources;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pets {
    private ApiRepository apiRepository = new ApiRepository();
    private Pet petDetails;
    public static final String STATUS_AVAILABLE = "available",
            STATUS_PENDING = "pending",
            STATUS_SOLD = "sold";


    public List<Pet> getAllPetsByStatus(String status) {
        apiRepository.Get(RestResources.PET_FINDBYSTATUS, "status", status.toLowerCase());
        assertEquals(200, apiRepository.response.statusCode());
        return apiRepository.response.jsonPath().getList("", Pet.class);
    }

    public int addNewPet(String petName, String category, String status) {
        CategoryOrTag _categoryOrTag = new CategoryOrTag().setId(1).setName(category);
        List<CategoryOrTag> tags = new ArrayList<CategoryOrTag>();
        tags.add(_categoryOrTag);

        petDetails = new Pet()
                .setId((int) (Math.random() * 100))
                .setName(petName)
                .setCategory(_categoryOrTag)
                .setStatus(status)
                .setTags(tags)
                .setPhotoUrls(null);

        apiRepository.Post(petDetails, RestResources.PET);
        assertEquals(200, apiRepository.getResponse().statusCode());
        return petDetails.getId();
    }

    public Pet getPetById(int id, int expectedStatus) {
        apiRepository.Get(RestResources.PET + "/" + id);
        assertEquals(expectedStatus, apiRepository.response.statusCode());
        if (expectedStatus == 200)
            return apiRepository.getResponse().as(Pet.class);
        else
            return null;
    }

    public void deleteAPet(int id) {
        apiRepository.Delete(RestResources.PET + "/" + id);
        assertEquals(200, apiRepository.response.statusCode());
    }
}
