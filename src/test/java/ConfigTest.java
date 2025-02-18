import DataController.SMSModule;
import Models.SMSModule.PostConsent.PostSmsRequestModel;
import org.testng.annotations.DataProvider;

import java.sql.SQLException;
import java.util.List;

import static DataController.SMSModule.queryOfSMSModuleTaskPost;

public class ConfigTest {
    @DataProvider(name = "PostSMSModuleTest")
    public Object[][] PostSMSModuleTest() throws SQLException, ClassNotFoundException {
        List<PostSmsRequestModel> postSmsRequestModels = SMSModule.postSmsRequestModels(queryOfSMSModuleTaskPost);
        Object[][] data;
        data = SMSModule.postSmsRequest(postSmsRequestModels);


        return data;
    }
}
