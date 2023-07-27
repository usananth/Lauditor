package lauditor.abstractclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
	}

	public void pageDown() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void visibilityOfElementWait(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void webDriverWaitelementToBeSelected(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void visibilityOfAllElements(WebElement actionBtn) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(actionBtn));
	}

	public void elementtoBeClickableWait() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div //img[@class='mattersicon'])[1]")));

	}

	public void selectDocumentorRemoveDocument(String[] NameList, List<WebElement> allNamesText,
			List<WebElement> removeOrSelectBtn) throws InterruptedException {
		Thread.sleep(2000);
		List<String> groupNames = Arrays.asList(NameList);
		String textGroup = new String();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement checkboxSelectedGroupName;
		for (int i = 0; i < allNamesText.size(); i++) {
			textGroup = allNamesText.get(i).getText();
			// System.out.println("All Group Name Text "+textGroup);
			if (groupNames.contains(textGroup)) {
				// Thread.sleep(2000);
				checkboxSelectedGroupName = removeOrSelectBtn.get(i);
				visibilityOfAllElements(checkboxSelectedGroupName);
				Thread.sleep(2000);
				executor.executeScript("arguments[0].click();", checkboxSelectedGroupName);
				i--;
			}
		}

	}

	public static void getFile(String path) throws InterruptedException {
		File directory = new File(path);
		String allimages = "";
		File[] flist = directory.listFiles();

		for (File file : flist) {
			if (file.isFile()) {
				allimages = allimages + "\"" + file.getName() + "\"" + " ";
			}
		}

		try {
			Thread.sleep(5000);
			Runtime.getRuntime().exec("D:\\ExeFiles\\getthefolder.exe" + " " + directory + File.separator);
			Thread.sleep(5000);
			Runtime.getRuntime().exec("D:\\ExeFiles\\selectalltoopen.exe" + " " + allimages);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
