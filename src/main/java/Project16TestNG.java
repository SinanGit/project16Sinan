//import org.junit.BeforeClass;
//import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Project16TestNG {

    private static Object WebDriverWait;


//  Note-1: Use TestNG for your tests
//  Note-2: Do not forget to delete whatever you have created manually if needed in order to keep the data clean for other testers please.

    //  Setup for your test cases:
//  Open a browser and navigate to https://test.campus.techno.study/
//  Dismiss the cookie message by clicking on "Got it!" button
//  Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
//  Navigate to HumanResources > Employees through the left menu
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", MyConstants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get("https://test.campus.techno.study/");
        wait = new WebDriverWait(driver, 7);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void login() {

        // Navigate to https://test.campus.techno.study/
        // Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();
        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        driver.findElement(By.cssSelector("input[data-placeholder=\"Username\"]")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.cssSelector("input[data-placeholder=\"Password\"")).sendKeys("TechnoStudy123@");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
    }

    //  Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)
    @Test(dependsOnMethods = "login")
    public void CreateEmployee() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".group-items>:nth-child(5)")));
        driver.findElement(By.cssSelector(".group-items>:nth-child(5)")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Employees']")));
        driver.findElement(By.xpath("//*[text()='Employees']")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-add-button button > .mat-button-wrapper > fa-icon > svg")));
        driver.findElement(By.cssSelector("ms-add-button button > .mat-button-wrapper > fa-icon > svg")).click();
    }

    @Test(dependsOnMethods = "CreateEmployee")
    public void sendingKeys() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'ms-text-field-2')]")));
        driver.findElement(By.xpath("//*[contains(@id, 'ms-text-field-2')]")).sendKeys("Sinan");
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("ms-text-field-2"))));
        driver.findElement(By.id("ms-text-field-3")).sendKeys("Yorulmaz");
    }


//  Test 2: Verify that an existing employee can be deleted
//  Test 3: Verify that the first name of an existing employee can be updated --> (passes)
//  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
//  Test 5: Verify that the document number of an existing employee can be updated --> (passes)
//  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
//  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
//  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
//  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)

//  Use a data provider to do the Tests 10-15
//  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
//  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
//  Test 12: Verify that an employee without entering an Employee ID cannot be created --> (passes)
//  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
//  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^,... for the name --> (fails!!!)
//  Test 15: Add your own test data for the data provider for a negative testing of creating an employee (feel free to add more than one case)

//  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)
//  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
//  Test 18:Verify that the photo of an existing employee can be changed --> (passes)
//  Test 19: Verify that the photo of an existing employee can be deleted --> (passes)

//  Write at least three different test cases for the search options of your own!

//  Close the browser

//  Good luck!

}

