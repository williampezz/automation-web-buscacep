package com.automation.buscacep.Test;

import com.automation.buscacep.Pages.BuscaCepPage;
import com.automation.buscacep.core.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Teste de busca de CEP")
public class BuscaCepTest {

    private WebDriver navegador;
    private BuscaCepPage buscaCepPage;
    private DriverFactory driverFactory;

    @BeforeEach
    public void setUp() {
        driverFactory = new DriverFactory();
        navegador = driverFactory.initWebDriver();
        buscaCepPage = new BuscaCepPage(navegador);

        driverFactory.openSite("https://buscacepinter.correios.com.br/app/endereco/index.php");
    }

    @Test
    public void testBuscaCep() {

        buscaCepPage.preencherEndereco("69005-040");
        buscaCepPage.clicarPesquisar();
        buscaCepPage.assertions("Manaus/AM");

    }

    @Test
    public void testBuscaName() {

        buscaCepPage.preencherEndereco("Lojas Bemol");
        buscaCepPage.clicarPesquisar();
        buscaCepPage.assertions("Manaus/AM");

    }
    @AfterEach
    public void tearDown() {
        driverFactory.quitWebDriver();
    }

}