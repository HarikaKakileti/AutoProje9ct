Feature: search and place order for products
@OffersPage
Scenario Outline: Search experience for product search in home and offers page

Given user is on greenkart landing page

When user searched with shortname <Name> and extracted actual  name of product
Then user searched with same shortname <Name> in offers page

Then validate the product name in offers page  matches  with landing page

Examples:
|Name|
|Tom|
|Beet|
