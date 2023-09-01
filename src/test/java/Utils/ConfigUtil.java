package Utils;

import java.util.Properties;

public  class ConfigUtil {
	

private	Properties properties;
private static ConfigUtil configutil;

	private ConfigUtil() {
		
	properties  =PropertiesUtils.loadProperties("src/test/java/config/production.properties");
			
	}
	
	public static ConfigUtil getInstance() {
		if(configutil==null) {
			configutil= new ConfigUtil();
			
		} 
		return configutil;
		
	}
	
	
	public String GetBaseUrl() {
String prop=properties.getProperty("baseurl");
if(prop!= null) return prop; {
	throw new RuntimeException("we could not find the base url in the property file");
}

}
 public String GetEmail() {	
	String Email= properties.getProperty("email");
	if(Email!=null) return Email ;{
		throw new RuntimeException("we could not find the email in the property file");
		}
	}
 public String GetPassword() {	
		String Password= properties.getProperty("password");
		if(Password!=null) return Password ;{
			throw new RuntimeException("we could not find the password in the property file");
			}
		}
}
