import com.company.domain.Shoe;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.ShoeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShoeServiceTest {

    private final ShoeService service = new ShoeService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Shoe>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Shoe>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void findBySizeTest() {
        Double size = 52D;
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findBySize(size);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by size method is not passed!");
    }

    @Test
    public void findByOwnerTest() {
        String owner = "men";
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findByOwner(owner);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by owner method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 100D;
        Double min = 50D;
        ResponseEntity<DataDTO<List<Shoe>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void findByTypeTest() {
        String type = "sandals";
        ResponseEntity<DataDTO<List<Shoe>>> responseEntity = service.findByType(type);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by type method is not passed!");
    }
}
