package CalcTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculator {
	
	WebDriver driver;
	
	@BeforeClass
	public void init() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver = new ChromeDriver();
		driver.navigate().to("https://vast-dawn-73245.herokuapp.com/");
	}
	
	@Test(description = "Positive number operation")
	//Tests calculator
	
	public void positiveNumbers(){
		
		
		WebElement firstNumber = driver.findElement(By.name("firstNumber"));
		firstNumber.sendKeys("31");
		
		WebElement secondNumber = driver.findElement(By.name("secondNumber"));
		secondNumber.sendKeys("31");
		
		WebElement submitbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		submitbtn.click();
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div"));
		String result = calculatorTextBox.getText();
		
		//Verify that result 
		Assert.assertEquals(result, "62");
	}
	
	@Test(description = "negative number operation")
	//Tests calculator
	public void negativeNumbers(){
		
		WebElement firstNumber = driver.findElement(By.name("firstNumber"));
		firstNumber.sendKeys("-2");
		
		WebElement secondNumber = driver.findElement(By.name("secondNumber"));
		secondNumber.sendKeys("-2");
		
		WebElement submitbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		submitbtn.click();
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div"));
		String result = calculatorTextBox.getText();
		
		//Verify that result 
		Assert.assertEquals(result, "-4");
	}
	
	@Test(description = "decimal number operation")
	//Tests calculator
	public void decimalNumbers(){
		
		WebElement firstNumber = driver.findElement(By.name("firstNumber"));
		firstNumber.sendKeys("12.4");
		
		WebElement secondNumber = driver.findElement(By.name("secondNumber"));
		secondNumber.sendKeys("24.3");
		
		WebElement submitbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		submitbtn.click();
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div"));
		String result = calculatorTextBox.getText();
		
		//Verify that result 
		Assert.assertEquals(result, "36.7");
	}
	
	@Test(description = "blank number operation")
	//Tests calculator
	public void blankNumbers(){
		
		//Create chrome driver's instance
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		//Set implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch 
		driver.get("https://vast-dawn-73245.herokuapp.com/");
		
		WebElement firstNumber = driver.findElement(By.name("firstNumber"));
		firstNumber.sendKeys("");
		
		WebElement secondNumber = driver.findElement(By.name("secondNumber"));
		secondNumber.sendKeys("");
		
		WebElement submitbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		submitbtn.click();
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div"));
		String result = calculatorTextBox.getText();
		
		//Verify that result 
		Assert.assertEquals(result, "NaN");
	}
	
	@AfterClass
	public void quit() {
		driver.close();
	}
	
}