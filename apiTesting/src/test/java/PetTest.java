import ApiIntegration.Pets;
import Models.Pet.Pet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetTest {
    Pets petsIntegration = new Pets();

    @Test
    public void shouldGetPetList() {
        List<Pet> pets = petsIntegration.getAllPetsByStatus(Pets.STATUS_AVAILABLE);
        assertTrue(pets.size()>0);
    }

    @Test
    public void shouldBeAbleToAddNewPet() {
        String petName = "Tiger 1", category = "Tiger";
        petsIntegration.addNewPet(petName, category, Pets.STATUS_AVAILABLE);
        Pet details = petsIntegration.getPetById();
        assertEquals(petName, details.getName());
        assertEquals(category, details.getCategory().getName());
        assertEquals(Pets.STATUS_AVAILABLE, details.getStatus());
    }
}
