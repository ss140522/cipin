package test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Wordcount {
	//��ʾ�û���Ҫ��ѯ�����ɸ����ʵĴ�Ƶ
		public String[]  query(Map<String, Integer> Map,String s) {
			Map<String,Integer> Map2 = new TreeMap<String, Integer>();  
			String[] word= s.split(",");
	        
	        int i;
	        for(i=0; i<word.length; i++) {
	        	for(Entry<String,Integer> entry : Map.entrySet()) { 
	        		if(word[i].equals(entry.getKey()))
	        		{
	        			Map2.put(entry.getKey(), entry.getValue());
	        			System.out.println(entry.getKey() + ":\t " + entry.getValue()); 
	        			break;
	        		}

	            } 
	        }
			return word;
	        
	    }
}
