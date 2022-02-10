package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

import java.util.List;

public class BooksPage {

    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(xpath ="//span[@class='title']" )
    public List<WebElement> listModules;


    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBookBox;


    @FindBy(xpath = "//tr/th[@data-name='B.name']")
    public WebElement nameHeader;


    @FindBy(xpath = "//tr/th[@data-name='B.author']")
    public WebElement authorHeader;

    @FindBy(xpath = "//tr/th[@data-name='B.year']")
    public WebElement yearHeader;

    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public WebElement bookName;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement bookAuthor;

    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    public WebElement bookYear;

    @FindBy(xpath = "//*[@id=\"tbl_books\"]/tbody/tr[1]/td[5]")
    public WebElement bookCategory;


     public void navigateModule(String moduleName){
         //books

//             if(moduleName.equalsIgnoreCase("Dashboard")){
//                 listModules.get(0).click();
//             }else if(moduleName.equalsIgnoreCase("Users")){
//                 listModules.get(1).click();
//             }else {
//                 listModules.get(2).click();
//             }

         for(WebElement eachModule: listModules){

             if(moduleName.equalsIgnoreCase(eachModule.getText())){
                 eachModule.click();
             }
         }


     }



}
