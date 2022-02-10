package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import utility.DB_Util;

public class Feature03_Steps {

    String actualBookName;

    @Given("Establish the database connections")
    public void establish_the_database_connections() {
        System.out.println("*******************************************");
        System.out.println("***** Connection is DONE via HOOKS ********");
        System.out.println("*******************************************");


    }


    @When("I execute query to left outer inner join books and book_borrow on Book_Id")
    public void i_execute_query_to_left_outer_inner_join_books_and_book_borrow_on_book_id() {
        String query="select bc.name, count(bb.book_id) from book_categories bc" +
                "    inner join books b on bc.id = b.book_category_id" +
                "    inner join book_borrow bb on b.id = bb.book_id" +
                "   group by bc.name order by 2 desc";
        DB_Util.runQuery(query);
       actualBookName= DB_Util.getCellValue(1,1);
        System.out.println(actualBookName);
    }


    @Then("verify {string} is the most popular book genre")
    public void verify_is_the_most_popular_book_genre(String expectedBookName) {
        Assertions.assertEquals(expectedBookName,actualBookName);

    }


 }
