package elements;

import org.openqa.selenium.By;

public class Auth {

    public static By register_element = By.xpath("//*[@id=\"root\"]/div/nav/div/div/div[2]/div/a[2]");
    public static By registerPageHeading=By.xpath("//*[@id=\"root\"]/div/main/div/div/div[1]/h1");
    public static By email = By.xpath("//*[@id=\"email\"]");
    public static By phone = By.xpath("//*[@id=\"phone\"]");
    public static By username = By.xpath("//*[@id=\"username\"]");
    public static By password = By.xpath("//*[@id=\"password\"]");
    public static By confirmPassword = By.xpath("//*[@id=\"confirmPassword\"]");
    public static By createAccountButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div/form/button");

}
