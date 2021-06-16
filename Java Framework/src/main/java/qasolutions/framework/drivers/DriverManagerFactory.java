package qasolutions.framework.drivers;

public class DriverManagerFactory {
	
	public static DriverManager getDriverManager() {
		DriverManager driverManager;
		String driverType = System.getProperty("browser", "chrome");
		
		switch(driverType) {
			case "chrome":
				driverManager = new ChromeDriverManager();
				break;
			default:
				driverManager = new ChromeDriverManager();
				break;
		}
			
		return driverManager;
	}
}