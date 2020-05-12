# INSTALL_MULTIPLE_APP_SHOPIFY

<b>I. Introduction:</b> </br>
This is a project to create multiple Shopify stores and install the Original app for multiplestores depends on the CSV file.<br>
Each store will select a different plan depends on the Store type column in the sheet.
<br>
<b>Infomation: </b>
- Programming language: Java
- Automation tool: Selenium
- Library used: TestNG
- Design pattern: Page Object Model
<br>

<b>II. How to use? </b> <br>
There are 2 features in this project. <br> <br>
<b>1. Create multiple Shopify stores: </b> <br>
This feature can be run by using "runCreateShopifyStore.xml" via the TestNG plugin. <br>
You can config the parameter in the Constants.java in src/main/java/commons. <br>
The parameter you can change: <br>
- EMAIL: this is the format of email, when running the methods, the tool will add the random number (4 digits) and @mail.com automatically. <br>
- STORE NAME: this is the format of store name, when running the methods, the tool will add the random number (4 digits) to store name.<br>
- PASSWORD: This password will be used for all the stores, should not change. <br>

<b> How to define the number of the store that I want to create? </b>
To define the number of reapeat, access the file in the directory: src/test/java/createStore.java <br>
Check the @Test annotation. There is a "invocationCount" parameter beside the @Test annotation.<br>
Change the number of "invocationCount" value.<br>
For example: If you want to create 50 Shopify store. Change this: <b>@Test(invocationCount=50)</b>. <br>
After run the "runCreateShopifyStore.xml", the data will be recorded automatically to <b>storeData.csv</b> file the directory: src/test/resources/ <br>
This file will contains the parameters of the stores that was created: <br>
- Store URL <br>
- Email <br>
- Store name <br>

The password is same as the Constants.PASSWORD parameter <br>
<br>
<b>2. Install Original app and select the plan. </b> <br>
