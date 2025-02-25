package org.credobankTestAutomation.CssLibraryDemo;

import org.credobankTestAutomation.CssLibraryDemo.Models.DataBaseAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class DataControlerCreateUser {
    DataBaseAccess DBAccess = new DataBaseAccess();


    String query_CheckPersonalNumber = """
            if exists (select top 1 * from CredoBnk.dbo.tbl_Person as a where a.PersonalN = ?)
            begin
            select 1 as result
             end
             else
             begin
             select 0 as result
             end
            """;

    String query_CheckPersonMobile = """
            if exists (select top 1 * from CredoBnk.person.Contact as a where a.Contact like ? and a.ContactTypeId='29792')
                        begin
                        select 1 as result
                         end
                         else
                         begin
                         select 0 as result
                         end
            """;

    String query_GetToken = """
            exec CredoBnk.dbo.GetSystemAuthorizationToken
            """;


    public String getCssToken() throws SQLException, ClassNotFoundException {
        Connection dataBaseAccess = DBAccess.connectSQL();
        ResultSet result = null;
        PreparedStatement preparedStatement = dataBaseAccess.prepareStatement(query_GetToken);
        result = preparedStatement.executeQuery();
        String token = "";
        while (result.next()) {
            token = result.getString("Token");
        }

        return token;
    }

    public String generateRandomNumber() throws SQLException, ClassNotFoundException {
        Random random = new Random();
        String phoneNumber = null;
        for (int i = 0; i < 10; i++) {
            int index = 593;
            int phoneNum = random.nextInt(100000, 999999);
            phoneNumber = String.valueOf((index) + String.valueOf(phoneNum));

            if (CheckMobile(phoneNumber)) {
                break;
            }
        }
        return phoneNumber;

    }

    boolean CheckMobile(String phoneNumber) throws SQLException, ClassNotFoundException {
        Connection dataBaseAccess = DBAccess.getInstance();

        PreparedStatement preparedStatement = dataBaseAccess.prepareStatement(query_CheckPersonMobile);
        preparedStatement.setString(1,"%"+ phoneNumber +"%");
        boolean phoneNotExist = false;
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        if (resultSet.getString("result").equals("0")) {
            phoneNotExist = true;

        }

        return phoneNotExist;
    }


    public Long generatePersonalN() throws SQLException, ClassNotFoundException {
        Random random = new Random();

        long personalN = 0;
        for (int i = 0; i < 10; i++) {
                personalN = random.nextLong(10000000000L, 99999999999L);
                personalN = Long.parseLong(String.valueOf(personalN));
                if (CheckPersonalN(personalN)==0){
                    break;
                }



            System.out.println(personalN);
        }

        return personalN;

    }



    int CheckPersonalN(Long personalN) throws SQLException, ClassNotFoundException {
    Connection dataBaseAccess = DBAccess.connectSQL();
    int result=0;
    PreparedStatement preparedStatement = dataBaseAccess.prepareStatement(query_CheckPersonalNumber);
    preparedStatement.setString(1, String.valueOf(personalN));
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
        result=Integer.valueOf(resultSet.getString("result"));

    }
    return result;
}

}




