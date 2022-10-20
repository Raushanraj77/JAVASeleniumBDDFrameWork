Feature: Search and Place the order for Products

@Offer
Scenario: Search experince for Product search in both Home and Offers Page

Given User is on GreenCart landing Page
When User searched with shortname "Tom" and extracted actual name of Product for Single Value
Then User searched for "Tom" shortname in offers page for Single Value
And Validate product name in offers page matches with landing page

@Offer
Scenario Outline: Search experince for Product search in both Home and Offers Page With Different Values

Given User is on GreenCart landing Page
When User searched with shortname <Name> and extracted actual name of Product
Then User searched for <Name> shortname in offers page
And Validate product name in offers page matches with landing page

Examples:
| Name |
| Bea  |
| Pot  |