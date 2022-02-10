package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserUtil;
import utility.ConfigReader;
import utility.Driver;

import java.awt.*;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id=\"inputEmail\"]")
    public WebElement userNameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login-form\"]/button")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"borrowed_books\"]")
    public WebElement borrowedBooks;

    public void login(){
        Driver.getDriver().get(ConfigReader.read("ui_url"));
        BrowserUtil.waitFor(2);
        userNameInput.sendKeys(ConfigReader.read("ui_username"));
        BrowserUtil.waitFor(2);
        passwordInput.sendKeys(ConfigReader.read("ui_password"));
        BrowserUtil.waitFor(2);
        loginButton.click();

        BrowserUtil.waitFor(3);

    }




}
