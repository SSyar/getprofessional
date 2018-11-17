

package ContactUsCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class wixsite {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\SSyar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();				
		driver.get("https://qatestid12.wixsite.com/qaspecialist");	
		
		WebElement contactclick;
		contactclick = driver.findElement(By.id("comp-ifgtula74label"));
		contactclick.click();
		 
		 Thread.sleep(2000);

		 WebElement name;
		 name = driver.findElement(By.id("comp-jhrgftz1input"));
		 name.sendKeys("Shahzada Shaheryar");
		 
		 WebElement email;
		 email = driver.findElement(By.id("comp-jhrggrufinput"));
		 email.sendKeys("shahzada.shaheryar@xynotech.com");

		 WebElement subject;
		 subject = driver.findElement(By.id("comp-jhrgh32ainput"));
		 subject.sendKeys("My inquiry");
		 
		 WebElement inquiry;
		 inquiry = driver.findElement(By.id("comp-jhrgk2pstextarea"));
		 inquiry.sendKeys("Hello this this test message");

		 WebElement submitButton;  
		 submitButton = driver.findElement(By.id("comp-jhrgemmllink"));
//		 submitButton = driver.findElement(By.xpath("//*[@id=\"comp-jhrgemmllink\"]"));
		 submitButton.click(); 
	     
		 WebElement msg = driver.findElement(By.id("comp-jhrgemmd"));
		 
		 Thread.sleep(2000);
		 
		 String text = msg.getText();
		 String expectedText = "Thanks for submitting!";

		 
		 if (text.contentEquals(expectedText))
		 { 
		     System.out.println("Test Passed!");
		 }else{
		     System.out.println("Test Failed");
		 }
		 
//		 String confirmation = driver.getText();
//		 String confirmText = "Thanks for submitting!";
		 
//		 if (confirmation.contentEquals(confirmText)){
//	            System.out.println("Test Passed!");
//	        } else {
//	            System.out.println("Test Failed");
//	        }
		
//		driver.close();
		
//		driver.quit();
		
	}

	
	

}

