package io.github.matheusbeoulve;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceTest extends PlaywrightFixture {

    // Instale nodejs
    // https://nodejs.org/en
    // Execute o comando apos a instalacao:
    // npm install -g playwright
    // Apos instalado use o comando:
    // playwright codengen saucedemo.com
    // Voce pode substituir o site (saucedemo.com)
    // por qualquer outro caso queira tentar em outros sites

    @Test
    void deveAbrirInventarioAposEstarLogado() {
        page.navigate("https://www.saucedemo.com/");
        page.locator("[data-test=\"username\"]").click();
        page.locator("[data-test=\"username\"]").fill("standard_user");
        page.locator("[data-test=\"password\"]").click();
        page.locator("[data-test=\"password\"]").fill("secret_sauce");
        page.locator("[data-test=\"login-button\"]").click();
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    void deveAparecerErroDeUsuarioBloqueado() {
        page.navigate("https://www.saucedemo.com/");
        page.locator("[data-test=\"username\"]").click();
        page.locator("[data-test=\"username\"]").fill("locked_out_user");
        page.locator("[data-test=\"password\"]").click();
        page.locator("[data-test=\"password\"]").fill("secret_sauce");
        page.locator("[data-test=\"login-button\"]").click();
        assertThat(page.locator("[data-test=\"error\"]"))
                .containsText("Epic sadface: Sorry, this user has been locked out.");
    }

    // Feito na aula

    @Test
    void deveAparecerErroAoDigitarSenhaErrada() {

    }

    // Para voce fazer

    @Test
    void deveIrAoProdutoSauceLabsBackpack() {

    }

    @Test
    void deveFazerLoginSairEVoltarATelaDeLoginDoUsuario() {

    }

    // Bonus

    @Test
    void deveValidarQueAImagemDeTodosOsProdutosSaoDiferente() {

    }
}
