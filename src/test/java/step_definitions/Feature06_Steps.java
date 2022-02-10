package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.BooksPage;
import pages.LoginPage;
import utility.BrowserUtil;
import utility.DB_Util;

public class Feature06_Steps {
    LoginPage login = new LoginPage();
    BooksPage booksPage= new BooksPage();

    String expectedCategoryName;
    String actualCategoryName;



    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {

        String query= "select bc.name from books b inner join book_categories bc " +
                "   on b.book_category_id=bc.id " +
                "  where b.name='Harry Potter' and b.author='Djoan Rowling' " +
                "group by bc.name ";
        DB_Util.runQuery(query);
        actualCategoryName=DB_Util.getFirstRowFirstColumn();
        System.out.println("Actual:"+actualCategoryName);

    }



    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        BrowserUtil.waitFor(2);
          expectedCategoryName= booksPage.bookCategory.getText();
        System.out.println("Expected:"+expectedCategoryName);

        Assertions.assertEquals(expectedCategoryName, actualCategoryName);

    }

}
