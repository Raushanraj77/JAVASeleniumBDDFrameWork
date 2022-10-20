Feature: Place the order for Products

@Checkout
Scenario Outline: Search experince for Product search in both Home and Offers Page

Given User is on GreenCart landing Page
When User searched with shortname <Name> and extracted actual name of Product
And Added "3" items of the selected Product to cart
Then User proceed to checkout and validate the <Name> items in checkout page
And User has ability to enter promocode and place order

Examples:
| Name |
| Beans|
| Bear |