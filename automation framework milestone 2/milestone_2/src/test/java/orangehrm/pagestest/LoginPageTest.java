package orangehrm.pagestest;

import org.testng.annotations.Test;


import orangehrm.basetest.BaseTest;
import orangehrm.pages.LoginPage;
import orangehrm.dataprovider.LoginDataProvider;
import orangehrm.driverfactory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class LoginPageTest extends BaseTest {
    private static final Logger log= LogManager.getLogger(LoginPageTest.class);
    @Test(
        dataProvider = "loginData",
        dataProviderClass = LoginDataProvider.class
    )
    public void loginTest(String username, String password) {
    	Reporter.log("login test started",true);
        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(username, password);
    }
}

