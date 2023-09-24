Feature: Adding product to cart scenario

  Background:
    Given siteye gidilir
    When Burger menüye tıklanır
    And Rastgele bir kategori seçilir

  Scenario: Add to cart
    When Burger menüye tıklanır
    And Rastgele bir kategoriye tıklanır
    And Seçilen kategori içinden bölüm seçilir