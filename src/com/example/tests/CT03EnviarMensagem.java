package com.example.tests;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class CT03EnviarMensagem {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final String pathFirefoxDriver = "D:\\Projetos\\ws-eclipse\\Drivers_Navegadores\\gechodriver.exe";


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecho.driver", pathFirefoxDriver);
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "https://livros.inoveteste.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCT03EnviarMensagem() throws Exception {
    // Acessa a página de contato do site Inove Teste
    driver.get(baseUrl + "/contato");
    // Preenche todos os campos do formulário de contato
    driver.findElement(By.name("your-name")).clear();
    driver.findElement(By.name("your-name")).sendKeys("Hugo Peres");
    driver.findElement(By.name("your-email")).clear();
    driver.findElement(By.name("your-email")).sendKeys("contato@inoveteste.com.br");
    driver.findElement(By.name("your-subject")).clear();
    driver.findElement(By.name("your-subject")).sendKeys("Curso Gratuito de Selenium");
    driver.findElement(By.name("your-message")).clear();
    driver.findElement(By.name("your-message")).sendKeys("Quais são os módulos desse curso?");
    // Clica no botão Enviar
    driver.findElement(By.cssSelector("input.wpcf7-form-control.wpcf7-submit")).click();
    // Valida a mensagem de sucesso do envio
    Thread.sleep(20000);
    assertEquals(driver.findElement(By.xpath("//div[@id='wpcf7-f372-p24-o1']/form/div[2]")).getText(), "Agradecemos a sua mensagem. Responderemos em breve.");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  /*private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/
}
