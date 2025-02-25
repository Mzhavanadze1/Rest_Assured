import org.credobankTestAutomation.CssLibraryDemo.CreatePersonTest;
import org.credobankTestAutomation.CssLibraryDemo.DataControlerCreateUser;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateClientTest {

    @Test
    public void phoneNum() throws Exception {
        CreatePersonTest createPersonTest= new CreatePersonTest();
        createPersonTest.Create("106062");

    }
}
