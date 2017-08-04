package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Selenium;

/**
 * Classe com métodos de apoio, que otimizam a codificação das classes de página.
 * @author andresilveiraleite
 *
 */
public abstract class Utils {	
	
	private static final WebDriver driver;
	private static final WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Método para verificar a visibilidade de um elemento utilizando o locator
	 * @param locator
	 */
	public static void isVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * Método para verificar a visibilidade de um elemento utilizando o ID
	 * @param id
	 */
	public static void isVisible(String id) {
		isVisible(By.id(id));
	}
	
	/**
	 * Método para verificar a presença de um elemento utilizando o locator
	 * @param locator
	 */
	public static void isLocated(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * é�todo para verificar a presença de um elemento utilizando o ID
	 * @param id
	 */
	public static void isLocated(String id) {
		isLocated(By.id(id));
	}
	
	/**
	 * Método para verificar se um elemento é clicável utilizando o locator
	 * @param locator
	 */
	public static void isClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
	 * Método para verificar se um elemento é clicável utilizando o ID
	 * @param id
	 */
	public static void isClickable(String id) {
		isClickable(By.id(id));
	}
	
	
	/**
	 * Método para capturar screenshot
	 * @param fileName - Nome do arquivo
	 */
	public static void takeScreenshot(String fileName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date data = new Date();
	    try {
			FileUtils.copyFile(scrFile, new File("D:\\SeleniumScreenShots\\"+fileName+ data.getTime()+".jpeg"),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Pause for X milliseconds.
	 * 
	 * @param iTimeInMillis
	 */
	@Deprecated
	public static void wait(final int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
