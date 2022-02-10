package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utility.DB_Util;
import utility.TestBase;

import java.util.List;
import java.util.Map;

public class Test01 extends TestBase {


    @Test
    public void testPractice(){

        String query="select * from employees where manager_id !=0";
        DB_Util.runQuery(query);
        //DB_Util.displayAllData();
        int rowCount=DB_Util.getRowCount();
        System.out.println(rowCount);
        Assertions.assertEquals(106,rowCount);

        String query2 ="select * from employees where first_name ='Neena'";
        DB_Util.runQuery(query2);
        Map<String,String> map1= DB_Util.getRowMap(1);
        //System.out.println(map1);
        //DB_Util.displayAllData();

        Assertions.assertEquals("Neena",map1.get("FIRST_NAME"));

        String query3="Select  first_name, job_id from employees  " +
                "where mod( employee_id, 2) != 0 group by  first_name,job_id ";

        DB_Util.runQuery(query3);
        //System.out.println(DB_Util.getAllRowAsListOfMap());
        int rowNums=DB_Util.getRowCount();
        System.out.println(rowNums);
        List<String> lastColumnData = DB_Util.getRowDataAsList(rowNums-1);
        System.out.println(lastColumnData);


    }


}
