package nwnu.word;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;

import java.util.Scanner;
import java.util.TreeMap;

/**
****************************
*@类名    WordCount.java
*@作者    yanglulu
*@日期    2019年4月1日 下午8:25:48
*@版本    v1.0
*@描述
*
****************************
**/
public class WordCount {

	//统计所有单词
	public TreeMap  count(String fileName) throws ServletException, IOException{

		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		String line = fileName;
		File file = new File(line);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader reader = new BufferedReader(isr);
		//将文本中的英文词语放在集合里面
        while((line=reader.readLine())!=null){
        	line = line.toLowerCase();//忽略大小写
        	String[] str = line.split("[^a-zA-Z]");//过滤出只含有字母的  
        	for(int i = 0; i<str.length; i++){
        		String word = str[i].trim();
        		if(map.containsKey(word) &&  word.length() != 0){
        			map.put(word, map.get(word)+1);
        		}else{
        			map.put(word, 1);
        		}
        	}
        }	
		return map;
		
		 
	}
	

	
	
	
	//查找单词之后进行与词群里面查找单词的个数
	public String[]  bijiao(TreeMap<String, Integer> tm,String words) {//在这个方法中，需要传入的是之前存入单词的集合，用户输入的字符串
		TreeMap<String,Integer> map1 = new TreeMap<String, Integer>();  
		String[] word= words.split(";");//通过分号来截取用户传入的字符串
        int i;
        for(i=0; i<word.length; i++) {
        	for(Entry<String,Integer> entry : tm.entrySet()) { 
        		if(word[i].equals(entry.getKey()))//与集合中的单词比较
        		{
        			map1.put(entry.getKey(), entry.getValue());
        			//System.out.println(entry.getKey() + "的个数是" + entry.getValue()); 
        			break;
        		}
            } 
        }
		return word;
        
    }
	//单词的存放
	public void cunfang(TreeMap<String, Integer> tm){

		//统计该文本所有单词数量及词频数，并能将单词及词频数按字典顺序输出到文件result.txt
		BufferedWriter bw = null;
		try {
			File file1 = new File("result.txt");
			
			
			if (!file1.exists()) {
				file1.createNewFile();
			}
			FileWriter fw = new FileWriter(file1.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        Iterator<String> it1 = tm.keySet().iterator();
        while(it1.hasNext())
        {
        	String key = (String) it1.next();
        	Integer value = tm.get(key);
        	
        	try {
				bw.write(key+"="+value+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	
	
	 //高频词的统计 整数k
	 public void gaopin(TreeMap<String,Integer> tm,int k){
		
		 ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(tm.entrySet());
		 Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){  
		  public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
		         return o2.getValue() - o1.getValue(); 
		    }  
		   }); 
		     //输出前k个数
		    for(int i = 0; i<k; i++){  
		     System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());  
		        }     
		    }
	 
	 //统计文本行数与字符
	 public int [] statistics(String fileName) throws IOException{
	 
		String line = fileName;
		System.out.println(fileName);
		File file = new File(line);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader br = new BufferedReader(isr);
	  int charNum= 0 ;//字符数
	  int wordsNum= 0;//数字数
	  int lineNum = 0;//行数
	  //以流的形式读入文件
	  
	  while( br.read()!= -1){
	  String s = br.readLine();
	  charNum+=s.length();
	  wordsNum +=s.split(" ").length;
	  lineNum ++;
	  }
	  isr.close();//关闭
	  int [] linenum={charNum,wordsNum,lineNum,};
	  for(int i=0;i<linenum.length;i++){
		  System.out.println(linenum[i]);
		  
	  }
	 // System.out.println("字符数:"+charNum+"\n单词数:"+wordsNum+"\n行数:"+lineNum);
	  return linenum;
	 }
}
