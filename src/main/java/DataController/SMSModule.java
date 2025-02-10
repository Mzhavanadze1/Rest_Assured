package DataController;

import DataBaseAccessSQL.DataBaseAccessSQL;
import Models.SMSModule.GetSMSRequestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SMSModule {
    public static String queryOfSMSModuleTask = """
            use SMSModuleDB
            
            IF OBJECT_ID('tempbd..#temp') is not null
            DROP
              TABLE #temp
            
            
            select
              a.LenTelNum,
              max(a.PersonId) as PersonId into #temp
            from
              (
                select
                  len(a.TelNumber) as LenTelNum,
                  a.PersonId
                from
                  dbo.AdSMSConsent as a
                where
                  a.PersonId is not null
              ) as a
            group by
              a.LenTelNum
            
            select
              a.*,
              b.TelNumber,
              b.Consent
            from
              #temp as a
              inner join dbo.AdSMSConsent as b on a.PersonId = b.PersonId
              and a.LenTelNum = len(b.TelNumber)
            order by
              a.LenTelNum
            
            """;

    public static List<GetSMSRequestModel> getSMSRequestModels(String query) throws SQLException, ClassNotFoundException {
        List<GetSMSRequestModel> getSMSRequestModels = new ArrayList<>();
        Connection databBaseAccessSQL = DataBaseAccessSQL.connectSQL();
        ResultSet resultSet;

        assert databBaseAccessSQL != null;
        PreparedStatement preparedStatement = databBaseAccessSQL.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            GetSMSRequestModel getSMSRequestModel = new GetSMSRequestModel();
            getSMSRequestModel.setPersonId(resultSet.getString("PersonId"));
            getSMSRequestModel.setTelNumber(resultSet.getString("TelNumber"));
            getSMSRequestModel.setConsent(resultSet.getString("Consent"));
            getSMSRequestModels.add(getSMSRequestModel);


        }


        return getSMSRequestModels;
    }
}
