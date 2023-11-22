package com.automation.buscacep.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver navegador;

    public WebDriver initWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        navegador = new FirefoxDriver();
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
