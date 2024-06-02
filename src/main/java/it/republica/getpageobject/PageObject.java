package it.republica.getpageobject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	
	private static ChromeDriver driver;
	private static JavascriptExecutor js = (JavascriptExecutor) driver;
	private static WebDriverWait wait;
	private static Duration timeout = Duration.ofSeconds(10);
	
	public static void openConnection() {
		
		driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	
    	driver.get("https://www.repubblica.it/");
		
	}
	
	public static void closeConnection() {
		
		driver.quit();
	}

	public static void acceptCoockie() {
		
		wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("#iubenda-cs-banner > div > div > div > div.iubenda-banner-content.iubenda-custom-content > div.iubenda-cs-opt-group > div > button.iubenda-cs-accept-btn.iubenda-cs-btn-primary")))
				.click();

	}

	public static void printVideoDelGiorno() {

		WebElement sezione = driver.findElement(By.cssSelector("main > div > div > section"));
		System.out.println(sezione.findElement(By.tagName("h1")).getText() + "\n");

		List<WebElement> divs = sezione.findElements(By.cssSelector("div > div"));

		for (int i = 0; i < divs.size(); i++) {

			WebElement wb = divs.get(i);
			System.out.println("Titolo: " + wb.findElement(By.cssSelector("article > div > span > p")).getText());
			System.out.println("Notizia\n" + wb.findElement(By.cssSelector("article > div > h2 > a")).getText());
			if (i < divs.size() - 1)
				System.out.println();
		}

	}

	public static void scrollFull() {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

	}
	
	public static void scrollToClass_and_Tag(String className, String tagName) {
		
		String target = tagName + "." + className;
		
		js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.cssSelector(target));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	
	}

	public static void printH1() {

		System.out.println("\nH1\n");
		driver.findElements(By.tagName("h1")).forEach(x -> {
			if(x.getText() != null)
				System.out.println("] " + x.getText());
		});

	}

	public static void printH2() {

		System.out.println("\nH2\n");
		driver.findElements(By.tagName("h2")).forEach(x -> {
			if(x.getText() != null)
				System.out.println("] " + x.getText());
		});

	}
	
	public static void clickOnMenù() {
		
		driver.findElement(By.cssSelector("#repHamOpenButton")).click();
		
	}
	
	public static void getMenuObjectSectionList() throws InterruptedException {
		
		clickOnMenù();
		
		System.out.println("\n" + driver.findElement(By.cssSelector("#rep-nav-list > ul > li:nth-child(3) > p")).getText() + "\n");
		driver.findElement(By.cssSelector("#rep-nav-list > ul > li:nth-child(3) > ul")).findElements(By.tagName("li")).forEach(x -> {System.out.println(x.getText());});
		
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#rep-nav-list > ul > li:nth-child(5) > p")));
		actions.perform();
		System.out.println("\n" + driver.findElement(By.cssSelector("#rep-nav-list > ul > li:nth-child(4) > p")).getText() + "\n");
		driver.findElement(By.cssSelector("#rep-nav-list > ul > li:nth-child(4) > ul")).findElements(By.tagName("li")).forEach(x -> {System.out.println(x.getText());});
		
		
	}
	
	public static void scrollMenu() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.getElementsByClassName('rep-left-nav__list')[0].scrollHeight)");
		
	}
	
	public static void closeMenù() {
		
		driver.findElement(By.cssSelector("#repHamCloseButton")).click();
		
	}
	
	public static void findInSearchBar(String text) {
		
		driver.findElement(By.cssSelector("#repSearchToggleButton")).click();
		WebElement searchBar = driver.findElement(By.cssSelector("#repSearchForm > div > form > input[type=search]:nth-child(1)"));
		wait.until(ExpectedConditions.elementToBeClickable(searchBar)).click();
		driver.manage().timeouts().implicitlyWait(timeout);
		searchBar.sendKeys(text);
		driver.manage().timeouts().implicitlyWait(timeout);
		searchBar.sendKeys(Keys.ENTER);
		
		
	}

}
