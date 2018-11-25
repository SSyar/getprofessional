package mainPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class orderCheckOut {
	
	WebDriver driver;
	public orderCheckOut(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

		public void oc() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("HP LP3065");
	
		WebElement searchClick;
		searchClick = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
		searchClick.click();
	    System.out.println("Product searched");
		
		WebElement clickProduct;
		clickProduct = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a"));
		clickProduct.click();
	
		WebElement addtocart;
		addtocart = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
		addtocart.click();
	    System.out.println("Added to cart");
	
		WebElement checkout;
		checkout = driver.findElement(By.xpath("//*[@id=\"cart-total\"]"));
		checkout.click(); 
		
		driver.get("https://demo.opencart.com/index.php?route=checkout/checkout");
	    System.out.println("Checkout");
	    
	    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"collapse-payment-address\"]/div/form/div[1]/label"));
		
		String text = msg.getText();	
		String expectedText = "I want to use an existing address";
		
		 if (text.contentEquals(expectedText))
		 { 
				WebElement contBilling;
				contBilling = driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]"));
				contBilling.click(); 
		 }else{
			

				driver.findElement(By.xpath("//*[@id=\"input-payment-firstname\"]")).sendKeys("Shahzada");
				driver.findElement(By.xpath("//*[@id=\"input-payment-lastname\"]")).sendKeys("Shaheryar");
				driver.findElement(By.xpath("//*[@id=\"input-payment-address-1\"]")).sendKeys("Address 1");
				driver.findElement(By.xpath("//*[@id=\"input-payment-city\"]")).sendKeys("My City");
				driver.findElement(By.xpath("//*[@id=\"input-payment-postcode\"]")).sendKeys("75300");
				driver.findElement(By.xpath("//*[@id=\"input-payment-country\"]")).sendKeys("Pakistan");
				driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]")).sendKeys("Sindh");
				
				WebElement contBilling;
				contBilling = driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]"));
				contBilling.click(); 
		 }

			Thread.sleep(4000);
		 	WebElement deliveryDetails;
			deliveryDetails = driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]"));
			deliveryDetails.click(); 
            System.out.println("Delivery details");
			
			Thread.sleep(4000);
			WebElement deliveryMethod  = driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]"));
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("arguments[0].scrollIntoView()", deliveryMethod);		
			deliveryMethod.click();
            System.out.println("Delivery method");
			
			Thread.sleep(4000);			
			WebElement paymentMethod;
			paymentMethod = driver.findElement(By.xpath("//input [@type='checkbox']"));
			paymentMethod.click();
			
			Thread.sleep(2000);
			WebElement paymentMethodButton;
			paymentMethodButton = driver.findElement(By.xpath("//input [@type=\"button\" and @id=\"button-payment-method\"]"));
			paymentMethodButton.click();
            System.out.println("Payment button");

			Thread.sleep(2000);
			WebElement confirmOrderButton;
			confirmOrderButton = driver.findElement(By.xpath("//*[@id=\"button-confirm\"]"));
			confirmOrderButton.click();
            System.out.println("Order confirmed");
			
			Thread.sleep(2000);
			String actualpagetitle = driver.getTitle();
			String expectedTitle = "Your order has been placed!";
			 
			if (actualpagetitle.contentEquals(expectedTitle)){
		            System.out.println("Test Passed!");
		        } else {
		            System.out.println("Test Failed");
		        }


	}
}
