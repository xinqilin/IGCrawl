import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CrawlIG {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(DesiredCapabilities.chrome());

		driver.navigate().to("要抓的URL?hl=zh-tw");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 抓一開始的頁面
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(By.xpath("//article[@class='FyNDV']/div[1]/div/*"));
		System.out.println(rows.size());
		WebElement firstRow = rows.get(0);
		WebElement firstPic = firstRow.findElements(By.cssSelector("._9AhH0")).get(0);
		firstPic.click();

		Thread.sleep(500);
		WebElement data = firstRow.findElements(By.cssSelector(".KL4Bh > img")).get(0);
		System.out.println(data.getAttribute("alt"));
		System.out.println(data.getAttribute("src"));
		System.out.println(driver.findElement(By.cssSelector(".c-Yi7 > time")).getAttribute("title"));
		System.out.println("======================");

		for (int i = 1; i <= 50; i++) {
			driver.findElement(By.xpath("//a[contains(@class,'HBoOv')]")).click();
			Thread.sleep(500);
			try {
				WebElement movie = driver.findElement(By.xpath("//img[@class='_8jZFn']"));
				System.out.println(movie.getAttribute("src"));
				WebElement text = driver.findElement(By.xpath("//div[@class='C4VMK']/span"));
				System.out.println(text.getText());
				System.out.println(driver.findElement(By.cssSelector(".c-Yi7 > time")).getAttribute("title"));

			} catch (Exception e) {
				Thread.sleep(500);
				List<WebElement> wes = driver.findElements(By.xpath("//div[@class='KL4Bh']/img"));
				System.out.println("we = " + wes.size());
				WebElement we = wes.get(wes.size() - 1);
				System.out.println(we.getAttribute("alt"));
				System.out.println(we.getAttribute("src"));
				System.out.println(driver.findElement(By.cssSelector(".c-Yi7 > time")).getAttribute("title"));
			}
			System.out.println("======================");
		}

//				for (int i = 1; i <= 50; i++) { 
//					
////					List<WebElement> data = row.findElements(By.cssSelector(".KL4Bh > img"));
////					List<WebElement> time = row.findElements(By.cssSelector("._9AhH0"));
//						WebElement e = data.get(i);
//						System.out.println(e.getAttribute("alt"));
//						System.out.println(e.getAttribute("src"));
//
//						e2.click();
//						Thread.sleep(2000);
//						System.out.println(driver.findElement(By.cssSelector(".c-Yi7 > time")).getAttribute("title"));
//						driver.findElement(By.className("ckWGn")).click();
//
//						System.out.println("==========================");
//					
//				}
//				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

}
