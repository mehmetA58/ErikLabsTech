
Feature: Yazılım Test Otomasyonu – Ödev-Erik Labs TECH

Background:
  Given I am on the ENONBİR site
  Then I'm verifying the "n11"

  @QuickTest1
  Scenario: 1.odev

    When I'm move to Magazalar
    And I select MagazalarıGör
    Then I click the Tüm Magazalar button.
    And I print the Tüm Magazalar in the letter A.
    And I closed the pages

  @QuickTest2
    Scenario: 2.odev

      Then I am searching "Kulaklik"
      And I sorted the results according to "REVIEWS"
      And I listed the products with Free Kargo
      Then I added the first and last product to the cart.
      And I'm in the basket
      Then I made two for the cheapest of the products.
      And I proceeded to the checkout step as a guest user
      And I closed the pages
