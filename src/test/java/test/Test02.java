package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utility.ConfigReader;
import utility.DB_Util;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Test02 {

    @BeforeAll
    public static void setUp(){
        String url=ConfigReader.read("library2.database.url");
        String username=ConfigReader.read("library2.database.username");
        String password=ConfigReader.read("library2.database.password");
        DB_Util.createConnection(url,username,password);
    }

    @AfterAll
    public static void tearDown(){
        DB_Util.destroy();
    }


    @Test
    public void test01(){
        String query="select id from users";

        DB_Util.runQuery(query);
        List<String> listId =DB_Util.getColumnDataAsList(1);
        //System.out.println(listId);
        Set<String > uniqueId= new LinkedHashSet<>(listId);
        Assertions.assertTrue(listId.size() == uniqueId.size());



    }

    @Test
    public void testScenario2(){

        String query="Select * from users";
        List<String> expectedColumns=Arrays.asList("Id", "full_name", "email", "password",
                         "user_group_id", "image", "extra_data", "status",
                         "is_admin", "start_date", "end_date", "address");

        DB_Util.runQuery(query);
       List<String> actualColumns= DB_Util.getAllColumnNamesAsList();
        System.out.println(actualColumns);
        for (int i = 0,  j=0; i <actualColumns.size() ; i++, j++) {

      Assertions.assertEquals((expectedColumns.get(j)).toLowerCase(),actualColumns.get(i) );

        }


    }


    @Test
    public static void testFeature2(){

    }



}
