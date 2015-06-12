package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GetPropertiesUtil implements ServletContextListener{
	private ServletContext servletContext; 
	private String removeServer;
	
	public String getRemoveServer() {
		return removeServer;
	}
	public void setRemoveServcer(String removeServer) {
		this.removeServer = removeServer;
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		servletContext = servletContextEvent.getServletContext();
		String url = this.getClass().getClassLoader()
				.getResource("remoteServer.properties").toString().substring(5);
		url = url.replace("%20", " ");
		InputStream is;
		try {
			is = new BufferedInputStream(new FileInputStream(url));
			Properties prop = new Properties();  
			prop.load(is);
			servletContext.setAttribute("remoteServer", prop.get("remoteServer"));
			System.out.print("removeServer:"+removeServer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
		
	}
	
}
