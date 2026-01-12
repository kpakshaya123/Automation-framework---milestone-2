package orangehrm.dataprovider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

public class LoginDataProvider {
    private static final Logger log= Logger.getLogger(LoginDataProvider.class);
    @DataProvider(name = "loginData", parallel = false)
    public static Object[][] getLoginData() {
    	Reporter.log("Data Provider value inserted",true);
        return new Object[][]{
                {"Admin", "admin123"},
                {"InvalidUser", "admin123"},
                {"Admin", "wrongPass"}
        };
    }
}

