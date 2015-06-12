package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConnUtil;
import util.PropertyManager;
import util.reqeustParam;
import util.requestHeader;

import bean.TerminalInfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SearchTerminal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static String remoteServer = "http://125.211.221.231:10080/sshop/";
//	public static String remoteServer = "http://218.8.127.3:10189/zdc/";
	//公司平台标识
	public static int clientPlatform = 1;
		
	public static String backage_name = "reserve.brand.get";
	//public static String remoteServer = "http://192.168.0.100:8080/sshop_zdc/";

	//public static String remoteServer = "http://127.0.0.1:8080/sshop_zdc/";//
	//public static String remoteServer = "http://192.168.1.165:8080/sshop_zdc/";//
	public static final String remoteServer = PropertyManager.getInstance().get("remoteServer", "remoteServer");

	//应用密钥
	public static String appKey = "sshop";
	//内容签名密钥
	public static String signKey = "1qazxsw2";
	//公司标识
	public static int appid = 1;
	
    public static String jsonParam(Map param) throws Exception{
		
		requestHeader rh = new requestHeader();
		rh.setAppid(appid);
		rh.setCommand_id(1000);//客户端使用
		rh.setPlatform(clientPlatform);
		rh.setScreenX(1024);//终端屏幕尺寸-宽
		rh.setScreenY(769);//终端屏幕尺寸-高
		rh.setTerm_id("111111");//终端标识
		rh.setTimestamp();//客户端使用
		rh.setUser_id(1);//(可选)
		reqeustParam rp = new reqeustParam();
		rp.setHead(rh);
		rp.setBody(param);
		return new ObjectMapper().writeValueAsString(rp);
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
		*/
		String terminal_imei = request.getParameter("params");
		String  pageNum =request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		String isprint = request.getParameter("isprint");
	    int num = 1;
	    int size = 10;
	    if(null!=pageNum && !"".equals(pageNum))
	    {
	       num = Integer.parseInt(pageNum);
	     }
	    if(null!=pageSize && !"".equals(pageSize))
	    {
	        size = Integer.parseInt(pageSize);
	    }
	     
        
		//查询省份信息
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("terminal_imei",terminal_imei);
		paramMap.put("pageSize",size);
		paramMap.put("startLimit",(num-1)*size);
		paramMap.put("isprint", isprint);
		String result2="";

		try {
			result2 = ConnUtil.sendPostZip(
					remoteServer, 
					"qrcodeTerminalInfo.get",//服务名
					jsonParam(paramMap), //拼接报文
					appKey, //appkey
					signKey//signKey
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/////////////////////////////
		List<TerminalInfo> list2=new ArrayList<TerminalInfo>();
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode2 = mapper2.readTree(result2);
		JsonNode bodyNode2 = jsonNode2.get("body");
		
		JsonNode bodyNodes = bodyNode2.get("Data");
		//System.out.println("1111" + bodyNodes.asText());
		Iterator element = bodyNodes.elements();
		System.out.println("body:" + bodyNode2);
		while(element.hasNext())
		{
			JsonNode data = mapper2.readTree(element.next() + "");
			TerminalInfo terminal = new TerminalInfo();
			terminal.setTerminal_imei(data.get("terminal_imei").asText());
			terminal.setIsprint(data.get("isprint").asText());
			terminal.setPrintDate(data.get("print_date").asText());
			list2.add(terminal);
		}
		//////////////////////////////////////////////
		HashMap<String,Object> paramMap2=new HashMap<String,Object>();
		paramMap2.put("terminal_imei", terminal_imei);
		paramMap2.put("isprint", isprint);
		String result="";

		System.out.println("remoteServer--------->"+remoteServer);
		try {
			result = ConnUtil.sendPostZip(
				remoteServer, 
				"qrcodeCount.get",//服务名
				jsonParam(paramMap), //拼接报文
				appKey, //appkey
				signKey//signKey
				);
			} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		int count = bodyNode.get("count").asInt();
		request.setAttribute("count", count);
		request.setAttribute("proList", list2);
		request.setAttribute("pageNum",num);
		request.setAttribute("isprint",isprint);
		request.getRequestDispatcher("/data/page2.jsp").forward(request, response);
	
		
	}

}
