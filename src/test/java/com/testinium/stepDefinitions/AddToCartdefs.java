package com.testinium.stepDefinitions;

import com.testinium.step.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.testinium.pages.AddToCart.*;

public class AddToCartdefs extends BaseStep {

    @When("Burger menüye tıklanır")
    public void burger_Menüye_Tıklanır() {
        clickToBy(burgerMenu);
    }

    @And("Rastgele bir kategori seçilir")
    public void rastgeleBirKategoriSeçilir() {

    }
}
