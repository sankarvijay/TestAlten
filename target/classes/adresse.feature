Feature: Change a subscriber's address

  Scenario Outline:   Modification of the address of a subscriber residing in France with or without effect date
    Given a subscriber with a main address "<active>" in France
    When the adviser connected to "<canal>" changes the subscriber's address
    Then the modified subscriber's address is recorded on all the subscriber's contracts
    And an address modification movement is created

    Examples:
      | canal | active |
      | FACE  | inactive |
      | EC    | active |