package com.example.tests;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class CT02ValidarCriticaCamposObrigatorios {
  private WebDriver driver;
  private String baseUrl;
 // private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final String pathChromeDriver = "D:\\Projetos\\ws-eclipse\\Drivers_Navegadores\\chromedriver.exe";

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", pathChromeDriver);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    baseUrl = "https://livros.inoveteste.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCT02ValidarCriticaCamposObrigatorios() throws Exception {
    // Acessa a página de contato do site Inove Teste
    driver.get(baseUrl + "/contato");
    // Clica no botão Enviar sem preencher os campos
    driver.findElement(By.cssSelector("input.wpcf7-form-control.wpcf7-submit")).click();
    // Valida as críticas dos campos obrigatórios
    assertEquals(driver.findElement(By.cssSelector("span.wpcf7-not-valid-tip")).getText(), "O campo e obrigatorio");
    assertEquals(driver.findElement(By.cssSelector("span.wpcf7-form-control-wrap.your-email > span.wpcf7-not-valid-tip")).getText(), "O campo e obrigatorio");
    assertEquals(driver.findElement(By.cssSelector("span.wpcf7-form-control-wrap.your-subject > span.wpcf7-not-valid-tip")).getText(), "O campo e obrigatorio");
    assertEquals(driver.findElement(By.cssSelector("span.wpcf7-form-control-wrap.your-message > span.wpcf7-not-valid-tip")).getText(), "O campo e obrigatorio");
    assertEquals(driver.findElement(By.xpath("//div[@id='wpcf7-f372-p24-o1']/form/div[2]")).getText(), "Um ou mais campos possuem um erro. Verifique e tente novamente.");
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
