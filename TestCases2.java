package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtilities;

public class TestCases2 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test(description = "Verify that DOB error message is displayed")
    public void testCase1() {
        String expectedResult = "The date of birth is not valid";
        driver.findElement(By.name("birthday")).sendKeys("wrong_dub");
        BrowserUtilities.wait(1);
        String actualResult = driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
        WebElement errorMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");
    }

    @Test
    public void testCase2() {
        String expectedResult1 = "C++";
        String expectedResult2 = "Java";
        String expectedResult3 = "JavaScript";
        String actualResult1 = driver.findElement(By.xpath("//label[@for='inlineCheckbox1']")).getText();
        String actualResult2 = driver.findElement(By.xpath("//label[@for='inlineCheckbox2']")).getText();
        String actualResult3 = driver.findElement(By.xpath("//label[@for='inlineCheckbox3']")).getText();
        Assert.assertEquals(expectedResult1, actualResult1);
        Assert.assertEquals(expectedResult2, actualResult2);
        Assert.assertEquals(expectedResult3, actualResult3);
    }

    @Test
    public void testCase3() {
        driver.findElement(By.name("firstname")).sendKeys("A");
        BrowserUtilities.wait(1);
        String expectedResult = "first name must be more than 2 and less than 64 characters long";
        String actualResult = driver.findElement(By.xpath("//small[@data-bv-validator='stringLength']")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase4() {
        driver.findElement(By.name("lastname")).sendKeys("B");
        BrowserUtilities.wait(1);
        String expectedResult = "The last name must be more than 2 and less than 64 characters long";
        String actualResult = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase5() {
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("TestMaster");
        driver.findElement(By.name("email")).sendKeys("email@gmail.com");
        driver.findElement(By.name("password")).sendKeys("GoodEnough");
        driver.findElement(By.name("phone")).sendKeys("012-345-6789");
        driver.findElement(By.name("gender")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/2000");
        Select select = new Select(driver.findElement(By.name("department")));
        select.selectByValue("DE");
        Select select1 = new Select(driver.findElement(By.name("job_title")));
        select1.selectByIndex(4);
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtilities.wait(1);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtilities.wait(1);
        String expectedResult = "You've successfully completed registration!";
        String actualResult = driver.findElement(By.xpath("//p[contains(text(),'You')]")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCase6(){
        BrowserUtilities.wait(1);
        driver.get("https://www.tempmailaddress.com/");
        BrowserUtilities.wait(1);
        String email = driver.findElement(By.xpath("//span[@id='email']")).getText();
        System.out.println(email);
        BrowserUtilities.wait(1);
        driver.get("https://practice-cybertekschool.herokuapp.com/sign_up");
        BrowserUtilities.wait(1);
        driver.findElement(By.name("full_name")).sendKeys("yo");
        BrowserUtilities.wait(1);
        driver.findElement(By.name("email")).sendKeys(email);
        BrowserUtilities.wait(1);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtilities.wait(1);
        String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualResult = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        BrowserUtilities.wait(2);
        driver.get("https://www.tempmailaddress.com/");
        String expectedResult1 = "do-not-reply@practice.cybertekschool.com";
        String actualResult1 = driver.findElement(By.xpath("//span[@class='odMobil']")).getText();
        System.out.println(actualResult1);
        BrowserUtilities.wait(1);
        driver.findElement(By.xpath("//span[@class='odMobil']")).click();
        Assert.assertEquals(expectedResult1, actualResult1);
        String expectedResult2 = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualResult2 = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(expectedResult2, actualResult2);
        BrowserUtilities.wait(1);

    }

    @Test
    public void testCase7() {
        driver.get("https://practice-cybertekschool.herokuapp.com/upload");
        driver.findElement(By.name("file")).sendKeys("C:\\Users\\Yuriy\\Documents\\java\\test.txt");
        driver.findElement(By.id("file-submit")).click();
        String expectedResult = "test.txt";
        String actualResult = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        BrowserUtilities.wait(1);
    }

    @Test
    public void testCase8() {
        driver.get("https://practice-cybertekschool.herokuapp.com/autocomplete");
        driver.findElement(By.name("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String expectedResult = ("You selected: United States of America");
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        BrowserUtilities.wait(1);
    }

    @Test
    public void testCase9() {
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();
        String expectedResult = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        String actualResult  = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase10() {
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        driver.findElement(By.xpath("//a[@href='status_codes/301']")).click();
        String expectedResult = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        String actualResult  = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase11() {
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();
        String expectedResult = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        String actualResult  = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase12() {
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();
        String expectedResult = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        String actualResult  = driver.findElement(By.xpath("//p[contains(text(),'This')]")).getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }



}
