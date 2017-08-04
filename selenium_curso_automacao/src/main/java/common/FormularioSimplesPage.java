package common;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Utils;



/*
 * Executa todas as acoes na pagina formulario simples
 */
public class FormularioSimplesPage {

	/*
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/*
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	 // The home page contains several HTML elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.
	static By nameField = By.id("g9-nome");
	static By emailField = By.id("g9-email");
	static By websiteField = By.id("g9-website");
	static By comentarioField = By.name("g9-comentrio");
	static By enviarButtonLocator = By.xpath("//input[@value='Enviar »']");
	static By tituloMensagemFormularioSimples = By.cssSelector("h3");
	static By mensagemDetalhadaFormularioSimples = By.cssSelector("li.form-error-message");

	public FormularioSimplesPage() {
	}

	
	
	/**
	 * Preenche o campo nome
	 */
	public static void fillOutNome(String nome){
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(nome);
	}
	
	/**
	 * Preenche o campo email
	 */
	public static void fillOutEmail(String email){
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}
	
	/**
	 * Preenche o campo website
	 */
	public static void fillOutWebsite(String assunto){
		driver.findElement(websiteField).clear();
		driver.findElement(websiteField).sendKeys(assunto);
	}
	
	/**
	 * Preenche o campo comentario
	 */
	public static void fillOutComentario(String mensagem){
		driver.findElement(comentarioField).clear();
		driver.findElement(comentarioField).sendKeys(mensagem);
	}
	
	/**
	 * Clica no bot�o enviar do formulario simples
	 */
	public static void clickEnviarButton(){
		driver.findElement(enviarButtonLocator).click();
	}
	/**
	 * Preenche o formulario simples com todas as informacoes
	 */
	public static void fillOutFormularioSimples(String nome, String email, String website, String comentario){
		fillOutNome(nome);
		fillOutEmail(email);
		fillOutWebsite(website);
		fillOutComentario(comentario);
		clickEnviarButton();
	}
	
	
	/**
	 * Verifica se a mensagem de sucesso é exibida no formulario simples
	 */
	public static void assertSuccessMessageIsShown(){
		Utils.isVisible(tituloMensagemFormularioSimples);
		assertThat("Mensagem de Sucesso não está correta",  driver.findElement(tituloMensagemFormularioSimples).getText(), is("A mensagem foi enviada (voltar)"));
	}
	
	/**
	 * Verifica se a mensagem de erro é exibida no formulario simples
	 */
	public static void assertErrorMessageIsShown() {
		Utils.isVisible(tituloMensagemFormularioSimples);
		assertThat("Mensagem de Erro não está correta", driver.findElement(tituloMensagemFormularioSimples).getText(), is("Erro!"));
	}

	/**
	 * Verifica se a mensagem de erro detalhada
	 * � exibida após submeter o formulario
	 * Verifica a primeira mensagem detalhada exibida
	 */
	public static void assertDetailedErrorMessageIsShown(String errorMessage){
		Utils.isVisible(mensagemDetalhadaFormularioSimples);
		assertThat("Mensagem detalhada está errada", driver.findElement(mensagemDetalhadaFormularioSimples).getText(), is(errorMessage));
	}
	
}