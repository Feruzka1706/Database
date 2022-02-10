package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import utility.DB_Util;

public class Feature04_Steps {

    String actualUserName;

    @When("I execute query to inner join users and book_borrow on user_id")
    public void i_execute_query_to_inner_join_users_and_book_borrow_on_user_id() {
          String query= "select u.full_name, count(*) from users u inner join " +
                  "    book_borrow bb  on u.id = bb.user_id " +
                  "group by u.full_name order by count(*) desc";

        DB_Util.runQuery(query);
       actualUserName= DB_Util.getFirstRowFirstColumn();
        System.out.println(actualUserName);

    }


    @Then("verify {string} the user who reads the most")
    public void verify_the_user_who_reads_the_most(String expectedUserName) {

        System.out.println(actualUserName);
        Assertions.assertEquals(expectedUserName,actualUserName);
    }




}
