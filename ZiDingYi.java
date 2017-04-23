package kk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class ZiDingYi extends JDialog{
	private JLabel label=new JLabel("");
	private JLabel labelrow=new JLabel("高度(9-24):");
	private JLabel labelcol=new JLabel("宽度(9-30):");
	private JLabel labelnum=new JLabel("雷数(10-668):");
	private JTextField row;
	private JTextField col;
	private JTextField num;
	private JButton queding;
	private JButton quxiao;
	public static int s1=hao.M;
	public static int s2=hao.N;
	public static int s3=hao.NUM;
	private JRadioButton chujiButton, zhongjiButton,gaojiButton,zidingyiButton;
	public ZiDingYi(JFrame f){
		super(f,"选项",true);
	   chujiButton = new JRadioButton("<html>初级<br>10个雷<br>9X9网格</html>");
	   zhongjiButton = new JRadioButton("<html>中级<br>40个雷<br>16X16网格</html>");
	   gaojiButton = new JRadioButton("<html>高级<br>99个雷<br>16X30网格</html>");
	   zidingyiButton = new JRadioButton("自定义");

	   chujiButton.setSize(125,70);
	   zhongjiButton.setSize(125,70);
	   gaojiButton.setSize(125,70);
	   zidingyiButton.setSize(120,30);
	   chujiButton.setSelected(true);
	   chujiButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				row.setEnabled(false);
			    col.setEnabled(false);
			    num.setEnabled(false);
			    labelrow.setEnabled(false);
			    labelcol.setEnabled(false);
			    labelnum.setEnabled(false);
			}
			   
		   });
	  zhongjiButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				row.setEnabled(false);
			    col.setEnabled(false);
			    num.setEnabled(false);
			    labelrow.setEnabled(false);
			    labelcol.setEnabled(false);
			    labelnum.setEnabled(false);
			}
			   
		   });
	   gaojiButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				row.setEnabled(false);
			    col.setEnabled(false);
			    num.setEnabled(false);
			    labelrow.setEnabled(false);
			    labelcol.setEnabled(false);
			    labelnum.setEnabled(false);
			}
			   
		   });
	  zidingyiButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				row.setEnabled(true);
			    col.setEnabled(true);
			    num.setEnabled(true);
			    labelrow.setEnabled(true);
			    labelcol.setEnabled(true);
			    labelnum.setEnabled(true);
			}
			   
		   });
	   ButtonGroup group = new ButtonGroup();
	   group.add(chujiButton);
	   group.add(zhongjiButton);
	   group.add(gaojiButton);
	   group.add(zidingyiButton);
		JPanel p=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
	    row=new JTextField(5);
		col=new JTextField(5);
	    num=new JTextField(5);
	    row.setText("");
	    col.setText("");
	    num.setText("");
	    row.setSize(70,30);
	    col.setSize(70,30);
	    num.setSize(70,30);
	   
	    labelrow.setSize(115,30);
	    labelcol.setSize(115,30);
	    labelnum.setSize(115,30);
	     
	    row.setEnabled(false);
	    col.setEnabled(false);
	    num.setEnabled(false);
	    labelrow.setEnabled(false);
	    labelcol.setEnabled(false);
	    labelnum.setEnabled(false);
	    
	    label.setSize(120,30);
	    p1.setSize(220,200);
	    p1.setLayout(new GridLayout(3,1));
	    p1.add(chujiButton);
		p1.add(zhongjiButton);
		p1.add(gaojiButton);
		p2.setSize(250,200);
		 GridLayout grid=new GridLayout(5,2);
		 grid.setVgap(5);
	    p2.setLayout(grid);
	    p2.add(zidingyiButton);
		p2.add(label);
		p2.add(labelrow);
		p2.add(row);
		p2.add(labelcol);
		p2.add(col);
		p2.add(labelnum);
		p2.add(num);
		queding=new JButton("确定");
		queding.setSize(100, 80);
		queding.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(chujiButton.isSelected()==true){
					s1=9;
					s2=9;
					s3=10;
				}
				else  if(zhongjiButton.isSelected()==true){
				  s1=16;
				  s2=16;
				  s3=40;
			  }
				else if(gaojiButton.isSelected()==true){
				  s1=16;
				  s2=30;
				  s3=99;
			  }
				else  if(zidingyiButton.isSelected()==true){
				  
			if(row.getText().equals("")||col.getText().equals("")||num.getText().equals("")){
			
			}
			else{
			s1=	Integer.parseInt(row.getText());
			s2=	Integer.parseInt(col.getText());
			s3=	Integer.parseInt(num.getText());
			if(s1>24)row.setText("24");
			if(s1<9)row.setText("9");
			if(s2>30)col.setText("30");
			if(s2<9)col.setText("9");
			if((s3-14)>=s1*s2)s3=s1*s2-14;
			if(s3>668)num.setText("668");
			if(s3<10)num.setText("10");
			if(s1>24)s1=24;
			if(s1<9)s1=9;
			if(s2>30)s2=30;
			if(s2<9)s2=9;
			if(s3>668)s3=668;
			if(s3<10)s3=10;
			}
			}
				setVisible(false);
				return;
			}
			
		});
		quxiao=new JButton("取消");
		quxiao.setSize(100, 80);
		quxiao.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				row.setText("");
				col.setText("");
				num.setText("");
				setVisible(false);
				return;
			}
			
		});
		p3.setLayout(new GridLayout(1,3));
		JLabel label1=new JLabel("");
	
		p3.add(label1);
		
		p3.add(queding);
		p3.add(quxiao);
		p.setLayout(new GridLayout(1,2));
		Border ld= BorderFactory.createTitledBorder("难度");
		p.setBorder(ld);//设置面板边界
		p.add(p1);
		p.add(p2);
		add(p,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		 setSize(400,280);
		 this.setResizable(false);
		setVisible(true);
	}
}
	