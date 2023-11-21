package com.automation.buscacep.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private WebDriver navegador;

    public WebDriver initWebDriver() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        return navegador;
    }

    public void openSite(String url) {
        navegador.get(url);
    }

    public void quitWebDriver() {
        if (navegador != null) {
            navegador.quit();
        }
    }
}
