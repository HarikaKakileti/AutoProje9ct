Feature: place order for products
@PlaceOrder
Scenario Outline: Search for product search in home and checkout

Given user is on greenkart landing page

When user searched with shortname <Name> and extracted actual  name of product

And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order



Examples:
|Name|
|Tom|
