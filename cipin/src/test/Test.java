package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;  
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFrame; 

public class Test extends JFrame {  
	private static final long serialVersionUID = 1L;
    public static String[] wordCount ;
    public static Map<String, Integer> wordsCount;
	public static void main(String[] args) throws Exception {  
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("src/file.txt"));  
        List<String> lists = new ArrayList<String>();//存储过滤后单词的列表  
        String readLine = null;
		while((readLine = br.readLine()) != null){  
            String[] wordsArr1 = readLine.split("[^a-zA-Z]");//过滤出只含有字母的  
            for (String word : wordsArr1) {  
                if(word.length() != 0){  //去除长度为0的行  
                    lists.add(word);  
                }  
            }  
        }  
        br.close();  
        wordsCount= new TreeMap<String,Integer>();  //存储单词计数信息，key值为单词，value为单词数       
        //单词的词频统计  
        for (String li : lists) {  
            if(wordsCount.get(li) != null){  
                wordsCount.put(li,wordsCount.get(li) + 1);  
            }else{  
                wordsCount.put(li,1);  
            }  
        }
       System.out.println("********词频统计********"); 
       System.out.println("请选择需要的功能（输入功能代号1~5）");
       System.out.println("1.查询单词词频");
       System.out.println("2.查询单词词频柱状图");
       System.out.println("3.查询高频单词");
       System.out.println("4.将文本按字典顺序输出到result.txt");
       System.out.println("5.退出系统");
       int i = in.nextInt();
       switch(i){
       case 1: 	Wordcount wc = new Wordcount();
       		    System.out.println("请输入需要查询的单词：（单词间用逗号隔开）：");
       		    String s = in.next();
       		    wc.query(wordsCount, s);
       		    break;
       case 2:	Wordcount wc1 = new Wordcount();
    	   		System.out.println("请输入需要查询的单词：（单词间用逗号隔开）：");
		    	String s1 = in.next();
		    	wordCount = wc1.query(wordsCount, s1);
    	   		Test demo = new Test();
				demo.setVisible(true);
				break;
       case 3:	HighWordcount hwc = new HighWordcount();
       			System.out.println("请输入要查询单词的个数：（只能是正整数）：");
       			int n = in.nextInt();
       			hwc.SortMap(wordsCount, n);
       			break;
       case 4:	Wordout wo = new Wordout();
       			wo.sortMapByKeys(wordsCount);
       			break;
       case 5: 	break;
       }
    	   
    }  
	public Test(){
		super();
		setTitle("绘制柱形图");
		setBounds(wordCount.length, 200, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void paint(Graphics g){
		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;//柱形图左边界
		int topMargin = 50;//柱形图上边界
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height-topMargin;
		int rulerStep = ruler/20;//将当前的高度评分为20个单位
		g2.setColor(Color.WHITE);//绘制白色背景
		g2.fillRect(0, 0, Width, Height);//绘制矩形图
		g2.setColor(Color.LIGHT_GRAY);
		for(int i=0;i<rulerStep;i++){
			g2.drawString((400-20*i)+"个", 8, topMargin+rulerStep*i);//绘制Y轴上的数据
		}
		g2.setColor(Color.PINK);
		int m=0;
		for(int i = 0;i<wordCount.length;i++){
			int value = wordsCount.get(wordCount[i]);
			int step = (m+1)*40;//设置每隔柱形图的水平间隔为40
			g2.fillRoundRect(leftMargin+step*2,Height-value, 40, value, 40, 10);//绘制每个柱状条
			g2.drawString(wordCount[i], leftMargin+step*2, Height-value-5);	//标识每个柱状条		
			m++;
		}
	}
} 
