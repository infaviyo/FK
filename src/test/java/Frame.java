import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class Frame {
	static WebDriver driver;

@BeforeClass
public static void Browserlunch() {
	System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	System.out.println("browserlunch");}
	
@Test
public void m1() throws InterruptedException {
Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mi mobile");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println("browserQuit");}

@Test
public void m2() throws FileNotFoundException, InterruptedException {
Thread.sleep(2000);
WebElement MIMobiles=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
String MI = MIMobiles.getText();
File file=new File(".//target/mobliedetails.xlxs");
FileOutputStream f=new FileOutputStream(file);
HSSFWorkbook w=new HSSFWorkbook();
HSSFSheet s = w.createSheet("miname");
HSSFRow r = s.createRow(0);
HSSFCell c = r.createCell(0);
c.setCellValue(MI);}

@Test
public void m3() {
driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
System.out.println("test1");}

@Test
public void m4() {
String mi = driver.getWindowHandle();
Set<String> mobile = driver.getWindowHandles();
for(String x :mobile) {
	if(!x.equals(mi)) {
driver.switchTo().window(x);}}
System.out.println("test2");}

@AfterClass
public static void BrowserQuit() throws IOException {
      TakesScreenshot tk=(TakesScreenshot) driver;
     File b = tk.getScreenshotAs(OutputType.FILE);
     File d=new File("C:\\Users\\vetrivel\\eclipse-workspace\\FW\\screenshot\\fk.png");
     FileUtils.copyFile(b,d);
     System.out.println("test 3");
}}

