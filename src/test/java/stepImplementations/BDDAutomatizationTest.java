package stepImplementations;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;

import java.io.File;

public class BDDAutomatizationTest {

    WebDriver driver;
    WebElement buscarPalabraBrowser, pageDown, buscarLinkResultante, primerProcesoAutomatico ;
    JavascriptExecutor js;


    @Given("el usuario abre el browser")
    public void elUsuarioAbreElBrowser() {
        System.out.println("el usuario abre el browser");
    //        open driver
        driver = utilities.DriverFactory.open("chrome");
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

    }

    @And("acceptar las condiciones de google")
    public void acceptarLasCondicionesDeGoogle() {

        pageDown = new WebDriverWait(driver, 10).until(

                ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'I agree')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageDown);
        pageDown.click();

    }

    @When("buscamos la palabra automatización {string}")
    public void buscamosLaPalabraAutomatización(String palabra) {
        System.out.println("Searching " + palabra);
        buscarPalabraBrowser = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*/input[contains(@aria-label,'Search')]")));
        buscarPalabraBrowser.sendKeys(palabra);
        buscarPalabraBrowser.sendKeys(Keys.ENTER);
    }

    @And("buscamos el link de la Wikipedia resultante")
    public void buscamosElLinkDeLaWikipediaResultante() {
        buscarLinkResultante = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'la enciclopedia libre')]")));
        buscarLinkResultante.click();
    }

    @Then("comprobamos en qué año se hizo el primer proceso automático")
    public void comprobamosEnQueAnnoSeHizoElPrimerProcesoAutomatico() {
        System.out.println("comprobamos en qué año se hizo el primer proceso automático");
        primerProcesoAutomatico = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.xpath
                        ("//*[contains(text(),'1801')]")));
        Assert.assertTrue(primerProcesoAutomatico.getText().contains("1801"));
    }

    @And("realizamos un screenshot de la página de la Wikipedia")
    public void realizamosUnScreenshotDeLaPaginaDeLaWikipedia() throws Exception {
        System.out.println("realizamos un screenshot de la página de la Wikipedia");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("src\\test\\screenShot\\screenshot.png"));

    }

    @And("cerrar el browser el terminar las prueba")
    public void cerrarElBrowser() {

        driver.close();
    }
}
