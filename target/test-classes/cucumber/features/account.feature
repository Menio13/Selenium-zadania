Feature: Hotel Users

  Scenario: new address creation

    Given an open browser with https://mystore-testlab.coderslab.pl
    When user is logged in
    And address page is opened
    And address form is populated with <Alias> and <Address> and <City> and <Zip Code> and <Country> and <Phone> and submitted
    Then address is created
    And close browser

    Examples:
      | Alias | Address | City   | Zip Code | Country        | Phone      |
      | Jan   | test    | Krakow | 31-111   | United Kingdom | 4937249327 |