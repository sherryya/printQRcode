﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String data = request.getParameter("data");
if(null == data||"".equals(data))
{
	data="";
}

XML_GenOneRecordset(response, data);
%> 
