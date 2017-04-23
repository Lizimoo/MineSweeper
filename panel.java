package kk;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class panel extends JDialog{
	private JList list1;
	private JPanel p0,p1,p2,p3,p4;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JButton b1,b2;
	private String s[];
	hao haoba;
	panel(hao haoba){
		super(haoba, "扫雷统计信息",true);
		this.haoba=haoba;
	    s=new String[]{"初级","中级","高级"};
		p0=new JPanel();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		l1=new JLabel();
		l2=new JLabel();
		l3=new JLabel();
		l4=new JLabel();
		l5=new JLabel();
		l6=new JLabel();
		l7=new JLabel();
		
		l1.setText("已玩游戏：");
		l2.setText("已胜游戏：");
		l3.setText("获胜率：");
		l4.setText("最多连胜：");
		l5.setText("最多连败：");
		l6.setText("当前连局：");
		
		b1=new JButton("关闭");
		b2=new JButton("重置");
		b1.setPreferredSize(new Dimension(150,30));
		b2.setPreferredSize(new Dimension(150,30));
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		b2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
			
		});
		
		list1=new JList(s);
		list1.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
					if(list1.getSelectedIndex()==0){
						chuji();
					}
					else if(list1.getSelectedIndex()==1){
						zhongji();
					}
					else{
						gaoji();
					}
				}
			}
			
		});
		setSelection();
		list1.setVisibleRowCount(3);
		list1.setBackground(new Color(255,255,0));
		list1.setPreferredSize(new Dimension(160,120));
		p0.add(list1);
		p0.setPreferredSize(new Dimension(170,120));
		
		Border ld=BorderFactory.createTitledBorder("最佳时间");
		p1.setBorder(ld);
		l7.setPreferredSize(new Dimension(200,20));
		p1.add(l7);
		p1.setPreferredSize(new Dimension(220,120));
		
		p2.setLayout(new GridLayout(6,1));
		p2.setPreferredSize(new Dimension(220,150));
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		p2.add(l5);
		p2.add(l6);
		
		FlowLayout flow=new FlowLayout();
		flow.setAlignment(FlowLayout.RIGHT);
		p3.setLayout(flow);
		p3.add(p0);
		p3.add(p1);
		p3.add(p2);
		
	    p4.setLayout(flow);
	    p4.add(b1);
	    p4.add(b2);
	    add(p3,BorderLayout.CENTER);
	    add(p4,BorderLayout.SOUTH);
	    setSize(650,250);
	    setResizable(false);
	    setVisible(true);
	    
	}
	protected void  reset() {
		String []choice={" 是 "," 否  "};
		 int x=JOptionPane.showOptionDialog(null,
				    "你想将所有统计信息重置为零吗？", null,JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE, null, choice,choice[0]);
		 if(x==0){
			 haoba.winnum=0;
			 haoba.chujiplayall=0;
			 haoba.chujiwestdate="";
			 haoba.chujizuiduolianbai=0;
			 haoba.chujizuiduoliansheng=0;
			 
			 haoba.zhongjiwinnum=0;
			 haoba.zhongjiplayall=0;
			 haoba.zhongjiwestdate="";
			 haoba.zhongjizuiduolianbai=0;
			 haoba.zhongjizuiduoliansheng=0;
				
			 haoba.gaojiwinnum=0;
			 haoba.gaojiplayall=0;
			 haoba.gaojiwestdate="";
			 haoba.gaojizuiduolianbai=0;
			 haoba.gaojizuiduoliansheng=0; 
			try {
				BufferedWriter f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("chuji.txt")));
				String s=""+haoba.winnum;
				f.write(s);
				f.newLine();
				s=""+haoba.chujiplayall;
				f.write(s);
				f.newLine();
				s=""+haoba.chujizuiduolianbai;
				f.write(s);
				f.newLine();
				s=""+haoba.chujizuiduoliansheng;
				f.write(s);
				f.newLine();
				f.write(haoba.chujiwestdate);
				f.close();
			
				f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("zhongji.txt")));
				s=""+haoba.zhongjiwinnum;
				f.write(s);
				f.newLine();
				s=""+haoba.zhongjiplayall;
				f.write(s);
				f.newLine();
				s=""+haoba.zhongjizuiduolianbai;
				f.write(s);
				f.newLine();
				s=""+haoba.zhongjizuiduoliansheng;
				f.write(s);
				f.newLine();
				f.write(haoba.zhongjiwestdate);
				f.close();
				f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gaoji.txt")));
				s=""+haoba.gaojiwinnum;
				f.write(s);
				f.newLine();
				s=""+haoba.gaojiplayall;
				f.write(s);
				f.newLine();
				s=""+haoba.gaojizuiduolianbai;
				f.write(s);
				f.newLine();
				s=""+haoba.gaojizuiduoliansheng;
				f.write(s);
				f.newLine();
				f.write(haoba.gaojiwestdate);
				f.close();
				setSelection();
						
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		 }
		 if(x==1)return;
		 
	}
	public void chuji(){
		l2.setText("已胜游戏："+haoba.winnum);
		l1.setText("已玩游戏："+haoba.chujiplayall);
		l5.setText("最多连败："+haoba.chujizuiduolianbai);
		l4.setText("最多连胜："+haoba.chujizuiduoliansheng);
		if(haoba.chujiplayall==0)l3.setText("获胜率：0%");
		else l3.setText("获胜率："+(100*haoba.winnum/haoba.chujiplayall)+"%");
		l7.setText(haoba.chujiwestdate);
	}
	public void zhongji(){
		l2.setText("已胜游戏："+haoba.zhongjiwinnum);
		l1.setText("已玩游戏："+haoba.zhongjiplayall);
		l5.setText("最多连败："+haoba.zhongjizuiduolianbai);
		l4.setText("最多连胜："+haoba.zhongjizuiduoliansheng);
		if(haoba.zhongjiplayall==0)l3.setText("获胜率：0%");
		else l3.setText("获胜率："+(100*haoba.zhongjiwinnum/haoba.zhongjiplayall)+"%");
		l7.setText(haoba.zhongjiwestdate);
	}
	public void gaoji(){
		l2.setText("已胜游戏："+haoba.gaojiwinnum);
		l1.setText("已玩游戏："+haoba.gaojiplayall);
		l5.setText("最多连败："+haoba.gaojizuiduolianbai);
		l4.setText("最多连胜："+haoba.gaojizuiduoliansheng);
		if(haoba.gaojiplayall==0)l3.setText("获胜率：0%");
		else l3.setText("获胜率："+(100*haoba.gaojiwinnum/haoba.gaojiplayall)+"%");
		l7.setText(haoba.gaojiwestdate);
	}
	public void setSelection(){
		if(hao.N==30&&hao.M==16){
			setListIndex2();
			gaoji();
		}
		else if(hao.N==16&&hao.M==16){
			setListIndex1();
			zhongji();
		}
		else{
			setListIndex0();
			chuji();
		}
	}
	public void setListIndex0(){
		list1.setSelectedIndex(0);
	}
	public void setListIndex1(){
		list1.setSelectedIndex(1);
	}
	public void setListIndex2(){
		list1.setSelectedIndex(2);
	}
}