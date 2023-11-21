package com.automation.buscacep.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuscaCepPage {

    private WebDriver navegador;

    // Mapeamento de elementos
    private By campoEndereco = By.id("endereco");
    private By botaoPesquisar = By.id("btn_pesquisar");

    private By Localidade = By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[3]");
    // Construtor
    public BuscaCepPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    // Métodos para interação com a página
    public void preencherEndereco(String cep) {
        WebElement inputEndereco = navegador.findElement(campoEndereco);
        inputEndereco.sendKeys(cep);
    }

    public void clicarPesquisar() {
        WebElement btnPesquisar = navegador.findElement(botaoPesquisar);
        btnPesquisar.click();
    }

    public void assertions(String ResultadoEsperado) {
        WebElement elementoResultado = navegador.findElement(Localidade);
        String textoResultado = elementoResultado.getText();

        assertTrue(textoResultado.contains(ResultadoEsperado));
       // assertTrue(textoResultado.contains(estado));
    }
}
