package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {
   
     
    public static final String  DEFAULT_CONFIG= "config";
    
	private static PropertyManager  instance = new  PropertyManager();
	
    private  final Map<String, Properties> propertiesMap = new HashMap<String, Properties>();
 
 


    private  PropertyManager()
    { }
    
    
    public static PropertyManager getInstance()
    {
    	return instance;
     }
    
    
    public Properties  getProperties(String name )
    {
    	
    	Properties properties = propertiesMap.get(name);
    	
    	if(properties==null){
    	
	    	synchronized (this.propertiesMap) 
	    	{
	    		  properties = propertiesMap.get(name);
	    		  if(properties==null)
	    		  {
	     			 properties  = PropertyLoader.loadProperties(name);
	    		     propertiesMap.put(name,properties );
	    		  }
	      		
	    	}
    	}
     	
    	return properties;
    
    }
    
    
 
 
    public String get(String name , String key) {
        return  (String)getProperties(name).get(key);
    }
    
 
 
    public String get(String name , String key, String defaultVal) {
        String val = get(name , key);
        return val == null ? defaultVal : val;
    }

 
    
    public String findValue(String name , String... keys) {
        for (String key : keys) {
            String value = get(name , key);
            if (value != null) {
                return value;
            }
        }
        return null;
    }
    
 
    
    public boolean getBoolean(String name  , String key) {
        String val = get(name , key);
        return Boolean.parseBoolean(val);
    }

    public boolean getBoolean(String name , String key, boolean defaultVal) {
        String val = get(name , key);
        return val == null ? defaultVal : Boolean.parseBoolean(val);
    }
 
    
    public long getLong(String name , String key) {
        String val = get(name , key);
        return Long.parseLong(val);
    }

    public long getLong(String name , String key, long defaultVal) {
        String val = get(name , key);
        return val == null ? defaultVal : Long.parseLong(val);
    }

    public int getInt(String name , String key, int defaultVal) {
        return (int) getLong(name , key, defaultVal);
    }

    
    public int getInt(String name , String key ) {
    	String val = get(name , key);
    	  
        return Integer.parseInt(val);
    }

    
    public double getDouble(String name , String key, double defaultVal) {
        String val = get(name , key);
        return val == null ? defaultVal : Double.parseDouble(val);
    }
    
    
}
