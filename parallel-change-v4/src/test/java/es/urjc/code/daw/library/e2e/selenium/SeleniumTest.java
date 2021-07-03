package es.urjc.code.daw.library.e2e.selenium;

import static org.junit.jupiter.api.Assertions.assertThrows;

import es.urjc.code.daw.library.Application;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

  @LocalServerPort
  int port;

  private WebDriver driver;
  private WebDriverWait wait;

  @BeforeAll
  public static void setupClass() {
    WebDriverManager.firefoxdriver().setup();
  }

  @BeforeEach
  public void setupTest() {
    this.driver = new FirefoxDriver();
    this.wait = new WebDriverWait(driver, 10);
  }

  @AfterEach
  public void teardown() {
    if (this.driver != null) {
      this.driver.quit();
    }
  }

  @Test
  @DisplayName("Añadir un nuevo libro y comprobar que se ha creado")
  public void createBookTest() throws Exception {

    // GIVEN: Partiendo de que estamos en la página principal de la libreria
    this.driver.get("http://localhost:" + this.port + "/");

    // WHEN: Creamos un nuevo libro

    String title = "FAKE BOOK";
    String preface = "Contenido de prueba";

    this.createNewBook(title, preface);

    // THEN: Esperamos que el libro creado aparezca en la nueva página resultante

    wait.until(ExpectedConditions.textToBe(By.id("bookTitle"), title));
    wait.until(ExpectedConditions.textToBe(By.id("bookPreface"), preface));
  }

  @Test
  @DisplayName("Borrar un libro y comprobar que no existe")
  public void deleteBookTest() throws Exception {

    // GIVEN: Partiendo de que estamos en la página principal de la libreria
    this.driver.get("http://localhost:" + this.port + "/");

    // WHEN:

    // Creamos un nuevo libro

    String title = "FAKE BOOK TO DELETE";
    String preface = "Contenido de prueba 2";

    this.createNewBook(title, preface);

    // Y lo borramos
    driver.findElement(By.xpath("//*[text()='Remove']")).click();

    // THEN: Comprobamos que el libro no existe

    assertThrows(NoSuchElementException.class, () -> {
      driver.findElement(By.linkText(title));
    });

  }

  private void createNewBook(String title, String preface) {
    // Hacemos click en "New book"
    driver.findElement(By.xpath("//*[text()='New book']")).click();
    // Rellenamos el formulario
    driver.findElement(By.name("title")).sendKeys(title);
    driver.findElement(By.name("preface")).sendKeys(preface);
    // Enviamos el formulario
    driver.findElement(By.id("Save")).click();
  }

}