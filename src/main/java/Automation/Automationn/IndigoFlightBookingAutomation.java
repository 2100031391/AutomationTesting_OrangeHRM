package Automation.Automationn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class IndigoFlightBookingAutomation {
    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/Users/DELL/Downloads/chromedriver-win64/chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 1. Navigate to the URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        // Verify landing on the correct page
        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();
        System.out.println("Current URL: " + currentUrl);
        System.out.println("Page Title: " + pageTitle);

        // Ensure that the correct page has been loaded
        if (!currentUrl.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
            System.out.println("Error: Wrong page loaded!");
            driver.quit();
            return;
        }
        
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for login to complete
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));

        // Navigate to the "PIM" tab
        WebElement pimTab = driver.findElement(By.xpath("//span[text()='PIM']"));
        pimTab.click();

        // Click on "Add Employee"
        WebElement addEmployeeButton = driver.findElement(By.xpath("//button[text()=' Add ']"));
        addEmployeeButton.click();

        // Enter employee details (First Name, Middle Name, Last Name)
        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement middleName = driver.findElement(By.name("middleName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        firstName.sendKeys("John");
        middleName.sendKeys("A");
        lastName.sendKeys("Doe");

        // Use an explicit wait to ensure the "Create Login Details" checkbox is clickable
        WebElement createLoginDetailsSwitch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")));

        // Click the switch to ensure it's in the "on" position (create login details)
        if (!createLoginDetailsSwitch.isSelected()) {
            createLoginDetailsSwitch.click();
        }

        // Enter login details (username, password, confirm password)
        WebElement empUsername = driver.findElement(By.xpath("//label[text()='Username']/following::input[1]"));
        WebElement empPassword = driver.findElement(By.xpath("//label[text()='Password']/following::input[1]"));
        WebElement empConfirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[1]"));
        empUsername.sendKeys("john.doe123");
        empPassword.sendKeys("Password@123");
        empConfirmPassword.sendKeys("Password@123");

        // Click "Save" button to create the employee
        WebElement saveEmployeeButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveEmployeeButton.click();
     // Wait for the employee to be saved
        //Thread.sleep(3000);
        try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

        // Navigate to the "Admin" tab
        WebElement adminTab = driver.findElement(By.xpath("//span[text()='Admin']"));
        adminTab.click();

        // Click on "User Management" -> "Users"
        WebElement userManagement = driver.findElement(By.xpath("//span[text()='User Management']"));
        WebElement usersOption = driver.findElement(By.xpath("//a[text()='Users']"));
        userManagement.click();
        usersOption.click();

        // Click on "Add" to create a new user
        WebElement addUserButton = driver.findElement(By.xpath("//button[text()=' Add ']"));
        addUserButton.click();

        // Select "Admin" as the user role
//        WebElement userRoleDropdown = driver.findElement(By.xpath("//label[text()='User Role']/following::div[1]"));
//        userRoleDropdown.click();
//        WebElement selectAdminRole = driver.findElement(By.xpath("//span[text()='Admin']"));
//        selectAdminRole.click();
//
//        // Select the newly created employee from the Employee Name field
//        WebElement employeeNameField = driver.findElement(By.xpath("//label[text()='Employee Name']/following::input[1]"));
//        employeeNameField.sendKeys("John A Doe");
//        try {
//      Thread.sleep(2000);
//    } catch (InterruptedException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } // Wait for dropdown suggestions
//        WebElement employeeSuggestion = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-dropdown']/div/span"));
//        employeeSuggestion.click();
//
//        // Provide a unique username and password for the new admin user
//        WebElement newAdminUsername = driver.findElement(By.xpath("//label[text()='Username']/following::input[1]"));
//        WebElement newAdminPassword = driver.findElement(By.xpath("//label[text()='Password']/following::input[1]"));
//        WebElement newAdminConfirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[1]"));
//        newAdminUsername.sendKeys("admin.johndoe");
//        newAdminPassword.sendKeys("AdminPassword@123");
//        newAdminConfirmPassword.sendKeys("AdminPassword@123");
//
//        // Click "Save" button to create the admin user
//        WebElement saveUserButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        saveUserButton.click();
//
//        // Wait for the user creation to complete
//        try {
//      Thread.sleep(3000);
//    } catch (InterruptedException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }

        // Log out from the current session
        WebElement profileIcon = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
        profileIcon.click();
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
        logoutButton.click();

        // Log in with the newly created admin user
        username.sendKeys("admin.johndoe");
        password.sendKeys("AdminPassword@123");
        loginButton.click();

        // Wait for login to complete
        try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

        // Optionally, you can add assertions, screenshots, or logging to track the process.

        // Close the browser
        driver.quit();

       
    }
}