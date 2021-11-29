package Tests;

import Models.Pet.Pet;
import Utils.ApiRepository;
import Utils.RestResources;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTest {

    @Test
    public void shouldGetPetList() {
        ApiRepository api = new ApiRepository();
        api.Get(RestResources.PET_FINDBYSTATUS, "status", "available");
        assertEquals(200, api.response.statusCode());
        api.response.as(Pet.class);
    }
}
