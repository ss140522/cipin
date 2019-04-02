package nwnu.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nwnu.word.WordCount;

/**
 * Servlet implementation class WordCountServlet
 */
@WebServlet("/WordCountServlet")
public class WordCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static TreeMap<String,Integer> map;
	public static String[] str;
	public static String fileName;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求与响应的编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id=null;
		
		//接受页面数据
		
		fileName = request.getParameter("fileName");//文件名
		String  words = request.getParameter("word");//指定单词
		String wordnum = request.getParameter("wordnum");//高频数
		String wordlines = request.getParameter("wordlines");//行数
		String result = request.getParameter("result");//存放
		id=request.getParameter("id");
		
		if(id.equals("0")){
			//文件的上传
			WordCount wordCount = new WordCount();
			map=wordCount.count(fileName);
			out.print("<script>alert('上传成功！！');location.href='html/WordCount.jsp'</script>");	
		   
		}else if(id.equals("1")){
			//指定单词的查找
			WordCount wordCount = new WordCount();
			str=wordCount.bijiao(map, words);
			
			
			out.print("<script>alert('sss');location.href='html/WordCount.jsp'</script>");	
			
		}else if(id.equals("2")){
			//高频词的统计
			WordCount wordCount = new WordCount();
			int k=Integer.parseInt(wordnum);
			wordCount.gaopin(map, k);
			
		}else if(id.equals("3")){
			//行数统计
			WordCount wordCount = new WordCount();
			wordCount.statistics(fileName);
			
		}else if(id.equals("4")){
			//写入文件
			WordCount cunfang = new WordCount();
			cunfang.cunfang(map);
			out.print("<script>alert('存放成功');location.href='html/WordCount.jsp'</script>");	
			
		}
		
		
		
		//所有单词
		 // 统计了所有的单词
		/*Iterator iterator=map.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		       }*/		
		
		
	    
		
		
		
		

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
