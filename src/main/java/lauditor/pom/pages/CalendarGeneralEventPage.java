package lauditor.pom.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

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

	@FindBy(xpath = "//div //div [@class='cal-event']")
	List<WebElement> EventNames;

	public void CalendarEventsCollection(String Eventname) throws InterruptedException {

		Thread.sleep(2000);
		for (int i = 0; i < EventNames.size(); i++) {
			String EventCollections = EventNames.get(i).getText();
			Thread.sleep(1000);
			// System.out.println("All Group Name Text "+allCalendarTextName);
			if (Eventname.equals(EventCollections)) {
				Thread.sleep(1000);
				WebElement EventClick = EventNames.get(i);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", EventClick);
			}

		}

	}

	@FindBy(xpath = "//*[text()='Week']")
	WebElement EventViewWeek;

	public void WeekView() throws InterruptedException {
		Thread.sleep(2000);
		visibilityOfAllElements(EventViewWeek);
		EventViewWeek.click();
	}

	public void CalendarEventsCollection_Week(String Eventname) throws InterruptedException {
		WeekView();
		Thread.sleep(3000);
		for (int i = 0; i < EventNames.size(); i++) {
			String EventCollections = EventNames.get(i).getText();
			Thread.sleep(1000);
			// System.out.println("All Group Name Text "+allCalendarTextName);
			if (Eventname.equals(EventCollections)) {
				Thread.sleep(1000);
				WebElement EventClick = EventNames.get(i);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", EventClick);
			}

		}

	}

	@FindBy(xpath = "//img[@class='lefticon']")
	WebElement LeftArrowClick;

	@FindBy(xpath = "//img[@class='righticon']")
	WebElement RightArrowClick;

	public void RightArrow_LeftArrow_Date(String EDate) throws InterruptedException {

		Thread.sleep(3000);
		int EventDates = Integer.parseInt(EDate);
		String DateLabel = driver.findElement(By.xpath("//label[@class='tdate']")).getText();
		String DLable1 = DateLabel.split(",")[1];
		String DLabel2 = DLable1.trim();
		String EventDate = DLabel2.split(" ")[1];
		int TodayDate = Integer.parseInt(EventDate);
//		while (!(TodayDate == EventDates)) {
//			TodayDate++;
//			RightArrowClick.click();

		int DateDiff = EventDates - TodayDate;
		boolean flag=true;
		if (DateDiff < 0) {
			flag = false;
			DateDiff = -1 * DateDiff;
		}

		for (int i = 0; i < DateDiff; i++) {
			if (flag == false) {
				Thread.sleep(1000);
				LeftArrowClick.click();
			} else {
				Thread.sleep(1000);
				RightArrowClick.click();
			}
		}

	}

	public void RightArrow_LeftArrow_Week(String EDate) throws InterruptedException {

		Thread.sleep(2000);
		int EventDates = Integer.parseInt(EDate);
		String DateLabel = driver.findElement(By.xpath("//label[@class='tdate']")).getText();
		String DLable1 = DateLabel.split(",")[1];
		String DLabel2 = DLable1.trim();
		String EventDate = DLabel2.split(" ")[1];
		int TodayDate = Integer.parseInt(EventDate);
		int DateDiff = EventDates - TodayDate;
		boolean flag = true;
		if (DateDiff < 0) {
			flag = false;
			DateDiff = -1 * DateDiff;
		}

		for (int i = 0; i < DateDiff; i++) {
			if (flag == false) {
				Thread.sleep(1000);
				LeftArrowClick.click();
			} else {
				Thread.sleep(1000);
				RightArrowClick.click();
			}
		}

	}

	public void ESaveViewChanges() throws InterruptedException {

		visibilityOfAllElements(ESViewChanges);
		ESViewChanges.click();
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

	// Meeting name assert
	@FindBy(xpath = "//div //p[@class='casestudy1']")
	WebElement MatterNameText;

	public void AssertMeetingName(String actual) throws InterruptedException {
		Thread.sleep(3000);
		String ExpMatterName = MatterNameText.getText();
		assertEquals(actual, ExpMatterName);
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
		js.executeScript("window.scrollBy(0,-250)");
	}

}
