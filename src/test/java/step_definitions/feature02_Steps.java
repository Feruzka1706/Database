package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utility.DB_Util;

public class feature02_Steps {

    String actualBorrowedBooksAmount;
    String expectedBorrowedBookAmount;
    LoginPage login=new LoginPage();


    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        System.out.println("*******************************************");
        System.out.println("***** Connection is DONE via HOOKS ********");
        System.out.println("*******************************************");

    }



    @When("I execute query to inner join users and book_borrow on Id")
    public void i_execute_query_to_inner_join_users_and_book_borrow_on_id() {
          String query=" select count(*) from users u" +
                  " inner join book_borrow bb on u.id = bb.user_id where bb.is_returned=0";
          DB_Util.runQuery(query);
         actualBorrowedBooksAmount= DB_Util.getFirstRowFirstColumn();
        System.out.println(actualBorrowedBooksAmount);

    }



    @Then("verify amount of people who had borrowed books")
    public void verify_amount_of_people_who_had_borrowed_books() {

        login.login();
      expectedBorrowedBookAmount=login.borrowedBooks.getText();
        System.out.println(expectedBorrowedBookAmount);
        Assertions.assertEquals(expectedBorrowedBookAmount,actualBorrowedBooksAmount);

    }




}
