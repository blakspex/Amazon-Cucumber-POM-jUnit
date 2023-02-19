# Amazon-Cucumber-POM-jUnit
Sample Amazon Regression structure

Additional Test for Regression might include:
* Checking for Broken links on any given page
* Checking for Login, Password Reset, Account creation functionalities
* Checking pre-existing Cart, Wishlist and Account information is unaffected
* Checking Search functionality
* Checking Menu functionality


For this project, Page Object Model has been used for Regression, as we will be testing only critical functionalities and those prone to be impacted by the new upgrade. Hence, individual product pages need not be tested.

For test reports, HTML report has been used but an Extent report can also be incorporated with Cucumber framework. Alternatively, TestNG framework can be used for flexibilty and easy implementation of Parallel testing.
Here, Driver Factory has been used for testing across supported browsers, which can be done by updating the browser name in configuration file.

Hooks have been used for implementing pre and post testing steps. In TestNG we can use available annotations to implement the same. For failed scenarios, screenshots are automatically captured.

In the Runner class, the path to Feature package has been provided, thus allowing execution of multiple feature files if necessary.
