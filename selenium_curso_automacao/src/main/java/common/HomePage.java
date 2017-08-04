package common;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Utils;

import java.util.concurrent.TimeUnit;


/**
 * Pagina que disponibiliza os serviÃ§os (aÃ§Ãµes) presentes na home page do CLASSEDETESTES.WORDPRESS.COM
 * @author andresilveiraleite
 *
 */
public class HomePage {

	/**
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/**
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 5);
	}
	
	/**
	 * DefiniÃ§Ã£o Ãºnica dos locators utilizados na pagina
	 */
//  static By homeMenuItem = By.id("menu-item-103"); //O item de menu pode ser acessado por id ou pelo texto exibido no link
	static By homeMenuItem = By.linkText("HOME");
	static By seleniumMenuItem = By.linkText("SELENIUM");
	static By cursoSeleniumSubMenuItem = By.linkText("CURSO SELENIUM");
	static By formularioSimplesMenuItem = By.linkText("FORMULÃ�RIO SIMPLES");

	
	static By hiddenOptionsButton = By.cssSelector("a.widget-handle.genericon");
	static By searchField = By.name("s");
	static By deixeUmaRespostaBox = By.id("comment");
	static By mudarLinkText = By.linkText("Mudar");
	static By emailField = By.id("email");
	static By authorField = By.id("author");
	static By urlField = By.id("url");
	static By submitCommentButton = By.id("comment-submit");
	static By pageHeaderTitle = By.className("entry-title");
	static By searchResultsTitle = By.cssSelector("h1.page-title");
	
	public HomePage() {
	}

	/**
	 * Clicar no link HOME do menu
	 */
	public static void clickHomeMenuItem(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(homeMenuItem));
		driver.findElement(homeMenuItem).click();
	}	
	
	/**
	 * Clicar no link SELENIUM do menu
	 */
	public static void clickSeleniumMenuItem(){
		//wait.until(ExpectedConditions.elementToBeClickable(seleniumMenuItem));
//		Utils.isClickable(seleniumMenuItem);
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.findElement(seleniumMenuItem).click();
	}	
	
	/**
	 * Clicar no item de subMenu indicado
	 */
	public static void clicksubMenuItem(String subMenu){
		By correctLocator = null;
		if (subMenu.equalsIgnoreCase("Curso Selenium")){
			correctLocator = cursoSeleniumSubMenuItem;
		} else if (subMenu.equalsIgnoreCase("FormulÃ¡rio Simples")){
			correctLocator = formularioSimplesMenuItem;
		}
		Utils.isVisible(correctLocator);
		driver.findElement(correctLocator).click();
	}	
	
	/**
	 * Clicar no item que abre as opcoes escondidas
	 */
	public static void showHiddenOptions(){
		driver.findElement(hiddenOptionsButton).click();
	}	
	
	
	/**
	 * Digita o texto passado no campo de busca
	 */
	public static void performSearch(String searchText) { 
		Utils.isClickable(searchField);
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(searchText);
	}
	
	/**
	 * Realizar Busca (pressionar tecla ENTER)
	 */
	public static void clickSearchButton() { 
		driver.findElement(searchField).sendKeys(Keys.RETURN); 
	}

	/**
	 * Verifica se o titulo da pagina (exibido no navegador) e o esperado
	 */
	public static void isHeaderTitleCorrect(String expectedTitle){
		assertThat("TÃ­tulo da pÃ¡gina Incorreto", driver.findElement(pageHeaderTitle).getText(), is(expectedTitle));
	}
	
	
	/**
	 * Verifica se o titulo exibido na pagina possui o valor esperado
	 */
	public static void isTitleCorrect(String expectedTitle){
		assertThat("TÃ­tulo Incorreto", driver.getTitle(), is(expectedTitle));
		 // em caso de falha:
	     // messagem de erro:
	     // Titulo Incorreto
	     // valor esperado: expectedTitle
	     // valor capturado: driver.getTitle()

		//Assert.assertEquals("C.E.S.A.R (English version)", driver.getTitle()); //Deprecated, mas pode ser utilizada.
	}
	
	/**
	 * Verifica se o titulo da pagina de resultados de busca estÃ¡ correto
	 */
	public static void isSearchResultCorrect(String expectedTitle){
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsTitle));
		assertThat("TÃƒÂ­tulo Incorreto", driver.findElement(searchResultsTitle).getText(), is(expectedTitle));
	}
	
}