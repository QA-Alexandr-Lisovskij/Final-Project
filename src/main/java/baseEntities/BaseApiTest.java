package baseEntities;


import core.ApiService;
import org.testng.annotations.BeforeTest;


public class BaseApiTest {
    @BeforeTest
    public void setUpApiTest(){
        ApiService.initApi();
    }
   
}
