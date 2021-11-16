Feature: Cart button

  Background:
    Given I open main page
    And Cart is empty

  Scenario: Click on empty cart button
    When I click on cart button
    Then I see the empty Shopping-cart summary page

  Scenario: Remove product from cart dropdown
    When I add product to cart
    And I click continue shopping button
    And I click remove product from cart dropdown
    Then Cart is empty

  Scenario: Add product from start page to cart and check cart dropdown
    When I add product to cart
    And I click continue shopping button
    Then Added product should be visible in cart dropdown

  Scenario Outline: Add different products in different quantities, check cart product
    When I add 1st product to cart with quick view button
    And Increase quantity to <quantity1>
    And I click add to cart button
    And I click continue shopping button
    When I add 2nd product to cart with quick view button
    And Increase quantity to <quantity2>
    And I click add to cart button
    And I click continue shopping button
    Then Check product counter on cart button is <productCounter>
    Examples:
      | quantity1 | quantity2 | productCounter |
      |    2      |   6       |    8           |
      |    7      |   3       |    10          |

  Scenario: Cart is empty after complete checkout
    When I add product to cart
    And I click proceed to checkout button
    And I click proceed to checkout button at order page
    And I enter email
    And I enter password
    And I click sing in button
    And I confirm address clicking on proceed to checkout button
    And I click on terms of service check box and proceed to checkout button
    And I click pay by bank wire button
    And I confirm order
    Then Cart is empty
