package com.grafanaScereenshot.dashboardScreenshot;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class commonMethods {
	public static void scroll(WebDriver driver, int pixel) {
		Actions a = new Actions(driver);
		WebElement el = driver.findElement(By.xpath(elements.scrollbutton));
		a.moveToElement(el).clickAndHold().moveByOffset(0, pixel).release().perform();

	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath, String pod, String dashboardname)
			throws Exception {
		final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String time = sdf1.format(timestamp);
		// System.out.println(sdf1.format(timestamp));
		String filename = pod + "_" + dashboardname + "_" + time;
		Shutterbug.shootPage(webdriver, Capture.FULL, true).withName(filename).save(fileWithPath);
	}

	@SuppressWarnings("deprecation")
	public static WebElement getElementByXpath(WebDriver driver, long time, String xpath) {
		WebElement element = null;
		// element = (new WebDriverWait(driver,
		// time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		element = (new WebDriverWait(driver, time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		// element.click();
		return element;

	}

	public static void zoom(WebDriver webdriver, double pixel) {
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("document.body.style.zoom = '" + pixel + "'");
	}

	public static long returnEpoch(String dateString) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Parse the string to LocalDateTime
		LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

		// Convert LocalDateTime to epoch seconds with fixed offset (+00:00)
		long epochSeconds = dateTime.toEpochSecond(ZoneOffset.UTC);
		return epochSeconds;
	}

	public static long addHoursAndReturnEpoch(String dateString, String addHours) throws ParseException {

		// Split the input string into hours and minutes strings
		String[] timeArray = addHours.split(":");

		// Parse the hours and minutes strings into integers
		int hours = Integer.parseInt(timeArray[0]);
		int minutes = Integer.parseInt(timeArray[1]);
		// Create a SimpleDateFormat object with the input date format
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Parse the input date string into a Date object
		Date date = inputFormat.parse(dateString);

		// Create a Calendar object and set it to the parsed date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// Add 10 hours and 30 minutes to the Calendar object
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		calendar.add(Calendar.MINUTE, minutes);

		// Convert the Calendar object to a Date object
		Date newDate = calendar.getTime();
		System.out.println("newDate: " + newDate);
		// Create a SimpleDateFormat object with the output date format
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// outputFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		// TimeZone.getTimeZone("UTC")

		// Format the new date as a string in the output format
		String outputDateString = outputFormat.format(newDate);
		System.out.println("outputDateString " + outputDateString);
		// Convert the output date string to epoch time
		long epochTime = outputFormat.parse(outputDateString).getTime();

		// Print the output epoch time
		System.out.println(epochTime);
		return epochTime;

	}

	public static boolean isElementPresent(WebDriver webdriver, String xpath) throws InterruptedException {
		boolean exists = webdriver.findElements(By.xpath(xpath)).size() != 0;
		// if does not exist waiting for 2 sec and verifiying if it will load when given
		// time

		if (exists == false) {
			Thread.sleep(2000);
			exists = webdriver.findElements(By.xpath(xpath)).size() != 0;
		}

		return exists;
	}

	public static boolean isKeywordPresentInString(WebDriver webdriver, String xpath, String keyword) {
		boolean isPresent = false;
		String val = (commonMethods.getElementByXpath(webdriver, 1000, xpath)).getAttribute("innerText");
		isPresent = val.contains(keyword);
		return isPresent;
	}

	public static boolean isElementavailable(String Element, WebDriver driver) {
		int attempts = 0;
		boolean exists = false;
		do {
			try {
				// Check if the element is displayed
				exists = driver.findElements(By.xpath(Element)).size() != 0;
				if (exists) {
					break;
				}
			} catch (Exception e) {
				// Catch any exceptions and ignore them
			}

			// Sleep for a short period of time before trying again
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Increment the attempts counter
			attempts++;
		} while (attempts < 50);
		return exists;
	}
}
