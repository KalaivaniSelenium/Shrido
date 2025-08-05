package com.thinktimetechno.hooks;

import com.thinktimetechno.Warehouse.endpoints.TripEndpoints;
import com.thinktimetechno.Warehouse.endpoints.UserEndpoints;
import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.driver.TargetFactory;
import com.thinktimetechno.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
	private UserEndpoints userendpoint;
	private TripEndpoints tripendpoint;
    public TestContext() {

    }

//	public UserEndpoints getUserEndpoints() {
//		if (userendpoint == null) {
//			userendpoint = new UserEndpoints();
//		}
//		return userendpoint;
//	}
//   
//	public TripEndpoints getTripEndpoints() {
//		if (tripendpoint == null) {
//			tripendpoint = new TripEndpoints();
//		}
//		return tripendpoint;
//	}
   

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}
