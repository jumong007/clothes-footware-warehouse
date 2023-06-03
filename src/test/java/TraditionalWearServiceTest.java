import com.company.domain.TraditionalWear;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.TraditionalWearService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TraditionalWearServiceTest {

    private final TraditionalWearService service = new TraditionalWearService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<TraditionalWear>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<TraditionalWear>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void findBySizeTest() {
        Double size = 52D;
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findBySize(size);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by size method is not passed!");
    }

    @Test
    public void findByOwnerTest() {
        String owner = "men";
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findByOwner(owner);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by owner method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 100D;
        Double min = 50D;
        ResponseEntity<DataDTO<List<TraditionalWear>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void findByCountryTest() {
        String job = "Uzbekistan";
        ResponseEntity<DataDTO<List<TraditionalWear>>> responseEntity = service.findByCountry(job);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by job method is not passed!");
    }
}
