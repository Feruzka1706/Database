package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.BooksPage;
import pages.LoginPage;
import utility.BrowserUtil;
import utility.DB_Util;

import javax.sql.rowset.BaseRowSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Feature05_Steps {
    LoginPage login = new LoginPage();
    BooksPage bookPage = new BooksPage();
    Map<String, String> expectedBookMap = new LinkedHashMap<>();
    Map<String, String> actualBookMap = new LinkedHashMap<>();

    @Given("I am in the homepage of library app")
    public void iAmInTheHomepageOfLibraryApp() {
        login.login();
    }


    @When("I navigate to {string} page")
    public void i_navigate_to_page(String module) {

        bookPage.navigateModule(module);
        BrowserUtil.waitFor(2);

    }


    @And("I open a book called {string}")
    public void iOpenABookCalled(String targetBook) {
        bookPage.searchBookBox.sendKeys(targetBook);
        BrowserUtil.waitFor(3);
        expectedBookMap.put(bookPage.nameHeader.getText().toLowerCase(), bookPage.bookName.getText());
        BrowserUtil.waitFor(2);
        expectedBookMap.put(bookPage.authorHeader.getText().toLowerCase(), bookPage.bookAuthor.getText());
        BrowserUtil.waitFor(2);
        expectedBookMap.put(bookPage.yearHeader.getText().toLowerCase(), bookPage.bookYear.getText());
        BrowserUtil.waitFor(2);
    }


    @When("I execute query to get the book information from books table")
    public void i_execute_query_to_get_the_book_information_from_books_table() {
        String query = "select name, author, year from books " +
                " where name ='Harry Potter' and author='Djoan Rowling'";

        DB_Util.runQuery(query);
        actualBookMap = DB_Util.getRowMap(1);
    }


    @Then("verify book DB and UI information must match")
    public void verify_book_db_and_ui_information_must_match() {

        Assertions.assertEquals(expectedBookMap, actualBookMap);

    }


}

