<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.lang.*, java.util.*" %>
<%@ page import="bean.TerminalInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"	+ request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<% 
	int pageNum=((Integer)request.getAttribute("pageNum")).intValue();
	System.out.print(pageNum);

%>
 <script type="text/javascript"	src="<%=basePath%>/js/jquery-1.7.1.js"></script>
<html>
<head>
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">  
</head>
<style>
/*分页的style**/
 .paginator {
   font: 18px normal Arial, Helvetica, sans-serif;
   color: #666666;
   margin-top: 20px;
   margin-bottom: 5px;
   line-height: 150%;
   background-color: #EEFFEE;
   text-align: center;
  }
  .paginator a, .thispage, .break {
   padding: 2px 4px;
  }
  .paginator a{
     cursor:pointer;
  }
  .paginator .prev {
   margin-right: 5px;
  }
  .paginator .next {
   margin-left: 5px;
  }
  .paginator .count {
   margin-left: 20px;
   font-size: 11px;
  }
  .thispage{
    font-size: 15px;
    font-weight:800;
  }
  /*分页的style**/
  
  /*table style*/
  body,table{
    font-size:16px;
}
table{
    table-layout:fixed;
    empty-cells:show; 
    border-collapse: collapse;
    margin:0 auto;
}

/** background: #2F589C url(th_bg2.gif); /
/*这个是借鉴一个论坛的样式*/
table.t1{
    border:1px solid #cad9ea;
    color:#666;
}
table.t1 th {
    background-image: url(th_bg1.gif);
    background-repeat::repeat-x;
    height:40px;
}
table.t1 td,table.t1 th{
    border:1px solid #cad9ea;
    padding:0 1em 0;
}
table.t1 td{
  text-align: center; 
   height:40px;
  }
table.t1 tr.a1{
    background-color:#f5fafe;
}
</style>
<body>
	<form id="queryform" action="<c:url value='/servlet/SearchTerminal'/>"  method="post">
        <div id="all">
         <!-- <div>打印<td class="cssDataCell"><a href="../General/PrintReport.jsp?report=qr.grf&amp;data=data/xmlCustomer.jsp?startLimit=<xml><row><terminal_imei>999ddbc890223</terminal_imei></row><row><terminal_imei>xxxddbc790223</terminal_imei></row><row><terminal_imei>555</terminal_imei></row></xml>" target="_blank">二维码</a></td></div>
         -->
         <h1>君泰华信</h1>
        <table width="60%"   border="1" class="t1">
        <div style="width:800px; margin-left:auto; margin-right:auto; height:40px">
         <lable>是否打印:</lable>
         <input type="hidden" id="printFlag" value="${isprint}">
         <select name="isprint" >
         <option id="printall" value="">全部</option>
         <option id="onlyy" value="1">是</option>
         <option id="onlyn" value="2">否</option>
        
        </select>
        <label>设备号:</label>
        <input type="text" id="keywords" ><input type="button" id="imeiSearch" value="搜索"/>
        <input type="button" id="printCode" value="打印"/>
        </div>
        <th width="5%"><input type="checkbox" id="allsrr" name="check1" value="111"/></th>
        <th width="20%">车机imei</th>
        <th width="10%">是否已打印</th>
        <th width="25%"
        >打印时间</th>
        <c:forEach var="terList" items="${proList}">
        <tr  class="a1">
            <td>
            <input type="checkbox" id="alls" name="checks" value="${terList.terminal_imei}"/>
            </td>
            <td>
            ${terList.terminal_imei}
            </td>
            <td>
            ${terList.isprint}
            </td>
            <td>
            ${terList.printDate}
            </td>
          </tr>
          </c:forEach>
          <input type="hidden" id="totalCount" value="${count}"/>
         </table>
         <div id="pagebar"  class="paginator"	style="background: #E4EDFA;MARGIN-RIGHT: auto; MARGIN-LEFT: auto; "></div>
		 </div>
		</form> 
     </body>
     
     <script>
    var t = document.getElementById("totalCount").value;
	var pageindex;
	var basepath ="<%=basePath%>";
     $(function(){  
		makePage(t,<%=pageNum%>,0);
	});  
var printFlag = $("#printFlag").val();
if(printFlag==1)
{
	$("#onlyy").attr("selected",'true');//全选
}else if(printFlag==2)
{
	$("#onlyn").attr("selected",'true');//全选
}else
{
	$("#printall").attr("selected",'true');//全选
}

$("#imeiSearch").click(function(){

	var params=$("#keywords").val();
	var pageInput2 = ("<input type='hidden' value='"+params+"' name='params'  id='formParams'/>");
	$("#queryform").append(pageInput2);
	$("#queryform").submit();

});
$("#printCode").click(function(){
    var x = document.getElementsByName("checks");
    var dataText = "<xml>";
    var imeiStr = "";
	for (var i=0;i<x.length;i++)
	{
		if(x[i].checked==true)
		{
		   imeiStr = imeiStr +  "<row><terminal_imei>"+x[i].value+"</terminal_imei></row>";
		}
		
	}
	dataText = dataText+imeiStr+"</xml>";
	//var printUrl = basepath+"General/PrintReport.jsp?report=qr.grf&amp;dataText="+dataText+"&amp;data=data/qrcode.jsp";
	var printUrl = basepath+"General/PrintReport.jsp?report=qr.grf&data=data/xmlCustomer.jsp?data="+dataText+"";
	window.open(printUrl);
});
$("#allsrr").click(function(){
	var x = document.getElementsByName("checks");
	
	for (var i=0;i<x.length;i++)
	{
	if($("#allsrr").attr("checked")=='checked')
	{
	    
	    $("[name='checks']").attr("checked",'true');//全选
	}else if($("#allsrr").attr("checked")==undefined)
	{
		$("[name='checks']").removeAttr("checked");  //取消全选
	}
	}
});
/**
 * 生成分页控件
 * @param isum
 */
function makePage(isum,pageindex,flag)
{   
	var params=$("#keywords").val();

	/*
	$.ajax({
		type : "post",
		url : reqUrl,
		data : requestJson,
		dataType : "",
		success : function(data, textStatus) {
			//alert(data);
		}
	});
	*/
	//$.get(url, requestJson,
	//		   function(data){
	//		     //alert("Data Loaded: " + data);
	//		   });
		var count = isum;
		var perpage = 10;
		var currentpage = pageindex;
		if (currentpage==null){
		 currentpage = 1;
		}else{
		 currentpage = parseInt(currentpage);
		}
		var pagecount = Math.ceil(count/perpage);
		var pagestr = "";
		var breakpage = 6;
		var currentposition = 2;
		var breakspace = 3;  // 逗号前后分别展示几个页码
		var maxspace = 2;  // 如当前展示6条则当点到第八条时前面有逗号隐藏
		var prevnum = currentpage-currentposition;
		var nextnum = currentpage+currentposition;
		if(prevnum<1) prevnum = 1;
		if(nextnum>pagecount) nextnum = pagecount;
		pagestr += (currentpage==1)?'<span class="prev">< 前页</span>':'<span class="prev">< <a  onclick="makePage('+isum+','+(currentpage-1)+','+1+');">前页</a></span>';
		if(prevnum-breakspace>maxspace){
		 for(i=1;i<=breakspace;i++)
		  pagestr += '<a onclick="getNearPoi_pageIndex('+i+');">'+i+'</a>';
		 pagestr += '<span class="break">...</span>';
		 for(i=pagecount-breakpage+1;i<prevnum;i++)
		  pagestr += '<a onclick="makePage('+isum+','+i+','+1+')">'+i+'</a>';
		}else{
		 for(i=1;i<prevnum;i++)
		  pagestr += '<a onclick="makePage('+isum+','+i+','+1+');">'+i+'</a>';
		}
		for(i=prevnum;i<=nextnum;i++){
		 pagestr += (currentpage==i)?'<span class="thispage">'+i+'</span>':'<a onclick="makePage('+isum+','+i+','+1+');">'+i+'</a>';
		}
		if(pagecount-breakspace-nextnum+1>maxspace){
		 for(i=nextnum+1;i<=breakpage;i++)
		  pagestr += '<a onclick="makePage('+isum+','+i+','+1+');">'+i+'</a>';
		 pagestr += '<span class="break">...</span>';
		 for(i=pagecount-breakspace+1;i<=pagecount;i++)
		  pagestr += '<a onclick="makePage('+isum+','+i+','+1+');">'+i+'</a>';
		}else{
		 for(i=nextnum+1;i<=pagecount;i++)
		  pagestr += '<a onclick="makePage('+isum+','+i+','+1+');">'+i+'</a>';
		}
		pagestr += (currentpage==pagecount)?'<span class="next">后页 ></span>':'<span class="next"><a onclick="makePage('+isum+','+(currentpage+1)+','+1+');">后页</a> ></span>';
		document.getElementById("pagebar").innerHTML = pagestr;
		
		//alert('flag'+flag);
		
		if(flag==1){
			var pageInput1 = ("<input type='hidden' value='"+pageindex+"' name='pageNum'  id='formPageNo'/>");
			var pageInput2 = ("<input type='hidden' value='"+params+"' name='params'  id='formParams'/>");
			var pageInput3 = ("<input type='hidden' value='"+10+"' name='pageSize'  id='formPageSize'/>");
	
			$("#queryform").append(pageInput1);
			$("#queryform").append(pageInput2);
			$("#queryform").append(pageInput3);
			$("#queryform").submit();
		}
}


</script>
 </html>
