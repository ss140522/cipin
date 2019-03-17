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
        List<String> lists = new ArrayList<String>();//�洢���˺󵥴ʵ��б�  
        String readLine = null;
		while((readLine = br.readLine()) != null){  
            String[] wordsArr1 = readLine.split("[^a-zA-Z]");//���˳�ֻ������ĸ��  
            for (String word : wordsArr1) {  
                if(word.length() != 0){  //ȥ������Ϊ0����  
                    lists.add(word);  
                }  
            }  
        }  
        br.close();  
        wordsCount= new TreeMap<String,Integer>();  //�洢���ʼ�����Ϣ��keyֵΪ���ʣ�valueΪ������       
        //���ʵĴ�Ƶͳ��  
        for (String li : lists) {  
            if(wordsCount.get(li) != null){  
                wordsCount.put(li,wordsCount.get(li) + 1);  
            }else{  
                wordsCount.put(li,1);  
            }  
        }
       System.out.println("********��Ƶͳ��********"); 
       System.out.println("��ѡ����Ҫ�Ĺ��ܣ����빦�ܴ���1~5��");
       System.out.println("1.��ѯ���ʴ�Ƶ");
       System.out.println("2.��ѯ���ʴ�Ƶ��״ͼ");
       System.out.println("3.��ѯ��Ƶ����");
       System.out.println("4.���ı����ֵ�˳�������result.txt");
       System.out.println("5.�˳�ϵͳ");
       int i = in.nextInt();
       switch(i){
       case 1: 	Wordcount wc = new Wordcount();
       		    System.out.println("��������Ҫ��ѯ�ĵ��ʣ������ʼ��ö��Ÿ�������");
       		    String s = in.next();
       		    wc.query(wordsCount, s);
       		    break;
       case 2:	Wordcount wc1 = new Wordcount();
    	   		System.out.println("��������Ҫ��ѯ�ĵ��ʣ������ʼ��ö��Ÿ�������");
		    	String s1 = in.next();
		    	wordCount = wc1.query(wordsCount, s1);
    	   		Test demo = new Test();
				demo.setVisible(true);
				break;
       case 3:	HighWordcount hwc = new HighWordcount();
       			System.out.println("������Ҫ��ѯ���ʵĸ�������ֻ��������������");
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
		setTitle("��������ͼ");
		setBounds(wordCount.length, 200, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void paint(Graphics g){
		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;//����ͼ��߽�
		int topMargin = 50;//����ͼ�ϱ߽�
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height-topMargin;
		int rulerStep = ruler/20;//����ǰ�ĸ߶�����Ϊ20����λ
		g2.setColor(Color.WHITE);//���ư�ɫ����
		g2.fillRect(0, 0, Width, Height);//���ƾ���ͼ
		g2.setColor(Color.LIGHT_GRAY);
		for(int i=0;i<rulerStep;i++){
			g2.drawString((400-20*i)+"��", 8, topMargin+rulerStep*i);//����Y���ϵ�����
		}
		g2.setColor(Color.PINK);
		int m=0;
		for(int i = 0;i<wordCount.length;i++){
			int value = wordsCount.get(wordCount[i]);
			int step = (m+1)*40;//����ÿ������ͼ��ˮƽ���Ϊ40
			g2.fillRoundRect(leftMargin+step*2,Height-value, 40, value, 40, 10);//����ÿ����״��
			g2.drawString(wordCount[i], leftMargin+step*2, Height-value-5);	//��ʶÿ����״��		
			m++;
		}
	}
} 
