$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PurchaseItem.feature");
formatter.feature({
  "line": 3,
  "name": "User can purchase items",
  "description": "",
  "id": "user-can-purchase-items",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9000795700,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "User purchases 2 items",
  "description": "",
  "id": "user-can-purchase-items;user-purchases-2-items",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the user user is logged into the site",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user changes the size of an item",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "adds it to their basket",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "adds another item to the basket",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the sizes and cost calculations are correct",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "the user can purchase the items",
  "keyword": "And "
});
formatter.match({
  "location": "PurchaseItem.the_user_user_is_logged_into_the_site()"
});
formatter.result({
  "duration": 2890068699,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.the_user_changes_the_size_of_an_item()"
});
formatter.result({
  "duration": 3411252000,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.adds_it_to_their_basket()"
});
formatter.result({
  "duration": 1404993900,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.adds_another_item_to_the_basket()"
});
formatter.result({
  "duration": 3933442200,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.the_sizes_and_cost_calculations_are_correct()"
});
formatter.result({
  "duration": 386024800,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.the_user_can_purchase_the_items()"
});
formatter.result({
  "duration": 6516081300,
  "status": "passed"
});
formatter.after({
  "duration": 2638478000,
  "status": "passed"
});
formatter.before({
  "duration": 7772848600,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "user can add a message to a purchased item",
  "description": "",
  "id": "user-can-purchase-items;user-can-add-a-message-to-a-purchased-item",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "there is a product in the order hisory",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "the user adds a message to a particular product ordered",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "the message will appear under messages",
  "keyword": "Then "
});
formatter.match({
  "location": "AddMessage.there_is_a_product_in_the_order_history()"
});
formatter.result({
  "duration": 12905351000,
  "status": "passed"
});
formatter.match({
  "location": "AddMessage.the_user_adds_a_message_to_a_particular_product_ordered()"
});
formatter.result({
  "duration": 2690830699,
  "status": "passed"
});
formatter.match({
  "location": "AddMessage.the_message_will_appear_under_messages()"
});
formatter.result({
  "duration": 293778699,
  "status": "passed"
});
formatter.after({
  "duration": 696166000,
  "status": "passed"
});
formatter.before({
  "duration": 7667993200,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Assertion fails causing screenshot",
  "description": "",
  "id": "user-can-purchase-items;assertion-fails-causing-screenshot",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "there is an assertion fail",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "the failure occurs",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "a screenshot is taken",
  "keyword": "Then "
});
formatter.match({
  "location": "AssertionFail.there_is_an_assertion_fail()"
});
formatter.result({
  "duration": 2706975800,
  "status": "passed"
});
formatter.match({
  "location": "AssertionFail.the_failure_occurs()"
});
formatter.result({
  "duration": 1198430800,
  "status": "passed"
});
formatter.match({
  "location": "AssertionFail.a_screenshot_is_taken()"
});
formatter.result({
  "duration": 929399,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.fail(Assert.java:95)\r\n\tat com.automationpractice.WEB_Tests.stepDefinitions.AssertionFail.a_screenshot_is_taken(AssertionFail.java:58)\r\n\tat ✽.Then a screenshot is taken(PurchaseItem.feature:25)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1108637901,
  "status": "passed"
});
});