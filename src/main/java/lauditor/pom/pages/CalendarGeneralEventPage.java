package lauditor.pom.pages;

import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lauditor.abstractclass.AbstractClass;

public class CalendarGeneralEventPage extends AbstractClass {
	private WebElement webElement;

	WebDriver driver;

	public CalendarGeneralEventPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	// Calendar Icon Leftside
	@FindBy(xpath = "//*[text()='Meetings']")
	WebElement meetingsMenu;

	public void MeetingsSideMenu() throws InterruptedException {
		Thread.sleep(3000);
		visibilityOfAllElements(meetingsMenu);
		meetingsMenu.click();
	}

	// Create Button
	@FindBy(xpath = "//*[text()='Create']")
	WebElement createMeetingsBtn;

	public void CreateMeetingsBtn() throws InterruptedException {
		Thread.sleep(3000);
		visibilityOfAllElements(createMeetingsBtn);
		createMeetingsBtn.click();

	}

	// Event Type Legal Matter
	@FindBy(xpath = "//input[@id='legalMatter']")
	WebElement legalMatterRadioBtn;

	public void LegalMatterRadioBtn() throws InterruptedException {
		Thread.sleep(3000);
		visibilityOfAllElements(legalMatterRadioBtn);
		legalMatterRadioBtn.click();
	}

	// Event type General Matter
	@FindBy(xpath = "//input[@id='generalMatter']")
	WebElement generalMatterRadioBtn;

	public void GeneralMatterRadioBtn() {
		visibilityOfAllElements(generalMatterRadioBtn);
		generalMatterRadioBtn.click();
	}

	// Event type OverHead
	@FindBy(xpath = "//input[@id='overHead']")
	WebElement overHeadRadioBtn;

	public void OverHead() {
		visibilityOfAllElements(overHeadRadioBtn);
		overHeadRadioBtn.click();
	}

	// Event type Others
	@FindBy(xpath = "//input[@id='Others']")
	WebElement othersRadioBtn;

	public void OthersRadioBtn() throws InterruptedException {
		Thread.sleep(3000);
		visibilityOfAllElements(othersRadioBtn);
		othersRadioBtn.click();
	}

	// Event type Remainders
	@FindBy(xpath = "//input[@id='Remainders']")
	WebElement remaindersRadioBtn;

	public void RemaindersRaditoBtn() {
		visibilityOfAllElements(remaindersRadioBtn);
		remaindersRadioBtn.click();

	}

// General Matter Selection Dropdown
	@FindBy(xpath = "(//div //select)[1]")
	WebElement MatterNameSelection;

	// General Matter Subject OR Task Selection
	@FindBy(xpath = "(//div //select)[4]")
	WebElement SubjectorTaskSelection;

	// Select the Event Date
	@FindBy(id = "datepicker")
	WebElement EventDatePicker;

	// Select Event Year
	@FindBy(xpath = "(//div[@class='bs-datepicker-head']//button[@class='current'])[2]")
	WebElement EventYear;

	// Select Exact Month
	@FindBy(xpath = "(//div[@class='bs-datepicker-head']//button[@class='current'])[1]")
	WebElement EventMonths;

	// Select all Dates
	@FindBy(xpath = "//td[@role='gridcell']")
	List<WebElement> EventDates;

	// Select Event Start Time
	@FindBy(xpath = "(//div //select)[2]")
	WebElement EventStartTime;

	// Select Event End Time
	@FindBy(xpath = "(//div //select)[3]")
	WebElement EventEndTime;

	// Select Time Zone
	@FindBy(xpath = "(//div //select)[5]")
	WebElement EventTimezone;

	// Select Event Repetitions
	@FindBy(xpath = "(//div//select)[6]")
	WebElement EventRepetition;

	// Event Save Button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement EventSaveBtn;

	// Event Save View Changes Alert

	@FindBy(xpath = "//button[text()='View Changes']")
	WebElement ESViewChanges;

	// Select All day Checkbox
	@FindBy(xpath = "//input[@id='allday']")
	WebElement AlldayCheckbox;

	public void AllDayCheckBox() throws InterruptedException {
		visibilityOfAllElements(AlldayCheckbox);
		AlldayCheckbox.click();
		Thread.sleep(2000);
	}

	// View Events Calendar Event title
	// @FindBy(xpath = "//span [@class='cal-event-)
	@FindBy(xpath = "//div //div [@class='cal-event']")
	List<WebElement> CEventTitles;

	// WebElement eventDetils = driver.findElement(By.xpath("//div //div
	// [@class='cal-event']"));
	// List<WebElement> CEventTitles =
	// driver.findElements(By.xpath("//div[@class='cal-event']"));
	String EName = "11.30 AM Nginx-General - Draft agreements";

	// 12:30 PM AKS-Legal - Case filling
	public void CollectionofEventTitles(String Eventname) throws InterruptedException {

		// while (!CollectionofEventTitles.getText().contains(EventName)) {
		for (int i = 0; i < CEventTitles.size(); i++) {

			String Eventsname = CEventTitles.get(i).getText();
			Thread.sleep(3000);
			if (Eventname.equals(Eventsname)) {
				Thread.sleep(3000);
				WebElement MeetingClick = CEventTitles.get(i);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				Thread.sleep(3000);
				executor.executeScript("arguments[0].click();", MeetingClick);

			}
		}
	}

//		while (!EventMonths.getText().contains(EMonth)) {
//			driver.findElement(By.xpath("//div[@class='bs-datepicker-head']//button[@class='next']")).click();
//		}

	public void ESaveViewChanges() throws InterruptedException {
		visibilityOfAllElements(ESViewChanges);
		ESViewChanges.click();
		Thread.sleep(2000);
		ScrollToUp();
		Thread.sleep(2000);

	}

	public void EventStratTime(String EStartTime) throws InterruptedException {
		visibilityOfAllElements(EventStartTime);
		EventStartTime.click();
		Select select = new Select(EventStartTime);
		select.selectByVisibleText(EStartTime);
		Thread.sleep(1000);
	}

	public void EventEndTime(String EEndTime) throws InterruptedException {
		visibilityOfAllElements(EventEndTime);
		EventEndTime.click();
		Select select = new Select(EventEndTime);
		select.selectByVisibleText(EEndTime);
		Thread.sleep(1000);
	}

	public void MatterNameSelection(String MatterName) throws InterruptedException {
		visibilityOfAllElements(MatterNameSelection);
		MatterNameSelection.click();
		Select select = new Select(MatterNameSelection);
		Thread.sleep(2000);
		select.selectByVisibleText(MatterName);
		Thread.sleep(2000);
	}

	public void SubjectORTaskSelection(String SelectTask) throws InterruptedException {
		Thread.sleep(2000);
		visibilityOfAllElements(SubjectorTaskSelection);
		SubjectorTaskSelection.click();
		Select select = new Select(SubjectorTaskSelection);
		Thread.sleep(2000);
		select.selectByVisibleText(SelectTask);

	}

	public void EventDatePickerSelection(String EDate, String EMonth, String EYear) throws InterruptedException {
		visibilityOfAllElements(EventDatePicker);
		EventDatePicker.click();
		pageDown();
		Thread.sleep(2000);
		while (!EventYear.getText().contains(EYear)) {
			driver.findElement(By.xpath("//div[@class='bs-datepicker-head']//button[@class='next']")).click();
		}
		while (!EventMonths.getText().contains(EMonth)) {
			driver.findElement(By.xpath("//div[@class='bs-datepicker-head']//button[@class='next']")).click();
		}

		Thread.sleep(3000);
		for (int i = 0; i < EventDates.size(); i++) {
			String Date = EventDates.get(i).getText();
			if (Date.equalsIgnoreCase(EDate)) {
				EventDates.get(i).click();
				break;
			}

		}
	}

	public void RepetitionSelection(String SelectRepetition) throws InterruptedException {
		Thread.sleep(3000);
		visibilityOfAllElements(EventRepetition);
		EventRepetition.click();
		Select select = new Select(EventRepetition);
		Thread.sleep(2000);
		select.selectByVisibleText(SelectRepetition);
		Thread.sleep(3000);
	}

	public void EventSaveBtn() throws InterruptedException {
		Thread.sleep(2000);
		ScrollToBottom();
		visibilityOfAllElements(EventSaveBtn);
		Thread.sleep(2000);
		EventSaveBtn.click();
	}

	public void pageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
	}

	public void ScrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
	}

	public void ScrollToUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)");
	}

}
