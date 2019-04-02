<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>词频的统计</title>
	</head>
	<script type="text/javascript" >
	 /* 获取文件名的函数 */
	function one(){
		var fileName=document.getElementById("file").value;
		
		location.href="../WordCountServlet?fileName="+fileName+"&id=0";
	 }
		 
	     
	function two(){
		
		var word = document.getElementById("word").value;
		
		location.href="../WordCountServlet?word="+word+"&id=1";
	}
	function three(){
		var wordnum =  document.getElementById("wordnum").value;
		
		location.href="../WordCountServlet?wordnum="+wordnum+"&id=2";
		
	}
	function four(){
		  var wordlines =  document.getElementById("wordlines").value;	
		  location.href="../WordCountServlet?wordlines="+wordlines+"&id=3";
	}
	function five(){
		 var result= document.getElementById("result").value; 
		 location.href="../WordCountServlet?result="+result+"&id=4";
	}
	
	</script>
	<style type="text/css">
		#one{
		width: 800px;
		height: 500px;	
		background-color:antiquewhite;
		margin: 0 auto;
		}
		#two{
			margin:20px;
			padding: 20px;
		}
		#wordfile{
			margin:5px 0px 5px 0px;
		}
		#wordnum{
			margin: 5px 0px 5px 0px;
		}
		
		#time{
			margin: 5px 0px 5px 0px;
		}
		#wordlines{
			margin: 5px 0px 5px 0px;
		}
		#result{
			margin: 5px 0px 5px 0px;
			
		}
		#tit{
			text-align: center;
			color: red;
			font-size: 50px;
		}
		
	</style>
	
	<body>
	
		<div id="one"  >
			<p id="two" >
				<font id="tit" ><b>词频统计</b></font><br/><br/>
			
			
			选择文件:<input type="file" name="file" id="file"    />
		          <input type="button" id="butt1" value="上传"  onclick="one()"/><br/><br/>
			
			1.输入查找单词:<input type="text" id="word" />
			<input type="submit" id="butt2" value="统计"  onclick="two()"/>
			
			&nbsp;&nbsp;&nbsp;&nbsp;耗时:<input type="text" id="time"  size="3" />ms<br/><br/>
			2.高频词统计个数:<input type="text" id="wordnum" size="5"/>
			<input type="button" id="butt3" value="统计"  onclick="three()"/>
			&nbsp;&nbsp;&nbsp;&nbsp;耗时:<input type="text" id="time" size="3" />ms<br/><br/>
			3.统计文本行数即字符数<input type="submit" id="wordlines" value="统计行数与字符" onclick="four()" />
			&nbsp;&nbsp;&nbsp;&nbsp;耗时:<input type="text" id="time"  size="3" />ms<br/><br/>
			
			4.统计所有单词并将结果存放在result.txt 文件<input type="submit" id="result" value="存放"  onclick="five()"/>
			
			&nbsp;&nbsp;&nbsp;&nbsp;耗时:<input type="text" id="time" size="3" />ms<br/><br/>
			</p>
		</div>
	</body>
</html>

