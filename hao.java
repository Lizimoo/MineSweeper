package kk;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
public class hao extends JFrame implements Runnable {
	private static List<Button1> list;
	private int cols;
	private int rows;
	private static thread1 h;
	private static Thread hh;
	private static Button1 array[][];
	private static JPanel p;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem xinyouxi;
	private JMenuItem tongji;
	private JMenuItem xuanxiang;
	private JMenuItem tuichu;
	static int M=16;
	static int N=16;
	static int NUM=40;
	static int allnum=M*N-NUM;
	private JLabel shijian;
	private JLabel shengyilei;
	private JPanel p1;
	private JLabel l1;
	private JLabel l3;
	private int ssss;
	private boolean jishi=false;
	private int miao=0;
	private int shengyulei;
	private String[]choices;
	private String qingxuanze,shuyin;
	int winnum=0;
	int chujiplayall=0;
	String chujiwestdate="";
	int chujizuiduolianbai=0;
	int chujizuiduoliansheng=0;
	
	int zhongjiwinnum=0;
	int zhongjiplayall=0;
	String zhongjiwestdate="";
	int zhongjizuiduolianbai=0;
	int zhongjizuiduoliansheng=0;
	
	int gaojiwinnum=0;
	int gaojiplayall=0;
	String gaojiwestdate="";
	int gaojizuiduolianbai=0;
	int gaojizuiduoliansheng=0;
	panel pan=null;
	Point presspoint;
	TrayIcon tray;
	hao(){
		super("java扫雷");
//		this.setUndecorated(true);
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				presspoint=e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Point p=e.getPoint();
				Point location=hao.this.getLocation();
				int x=location.x+p.x-presspoint.x;
				int y=location.y+p.y-presspoint.y;
				hao.this.setLocation(x, y);
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		 try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				System.err.println("不能被设置外观的原因:" + e);
			}
		bar=new JMenuBar();
		shijian=new JLabel();
		shijian.setBackground(new Color(51,0,255));
		shengyilei=new JLabel();
		shengyilei.setBackground(new Color(51,0,255));
		
		l1=new JLabel("",JLabel.RIGHT);
	     l3=new JLabel("",JLabel.RIGHT);
	    
		FlowLayout flow=new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		p1=new JPanel(flow);
		p1.setBackground(new Color(102,102,255));
		this.TimeNumPanel();
		p1.add(l1);
		p1.add(shijian);
		p1.add(l3);
		p1.add(shengyilei);
		hh=new Thread(this);
		
		hh.start();
		menu=new JMenu("游戏");
		xinyouxi=new JMenuItem("新游戏");
		xinyouxi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 XinYouXi();
			}
			 
		 });
		 tongji=new JMenuItem("统计信息");
		 tongji.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(pan==null){
					pan=new panel(hao.this);
					
				}
				else {
					if(N==30&&M==16){
						pan.setListIndex2();
						pan.gaoji();
					}
					else if(N==16&&M==16){
						pan.setListIndex1();
						pan.zhongji();
					}
					else{
						pan.setListIndex0();
						pan.chuji();
					}
					pan.setVisible(true);
				}
				
			}
			 
		 });
		 xuanxiang=new JMenuItem("选项");
		 xuanxiang.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					   new ZiDingYi(hao.this);
					   if(M==ZiDingYi.s1&&ZiDingYi.s2==N&&ZiDingYi.s3==NUM)return;
						M=ZiDingYi.s1;
						N=ZiDingYi.s2;
						NUM=ZiDingYi.s3;
						allnum=M*N-NUM;
						 remove(p);
						 mobanmethod();
						 Button1.setfail(false);
						setSize(600*N/16,640*M/16);
						 TimeNumPanel();
						add(p,BorderLayout.CENTER);
						 add(p1,BorderLayout.SOUTH);
						 setVisible(true);
			}
			 
		 });
		 tuichu=new JMenuItem("退出");
		 tuichu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			//System.exit(0);
			/*	try {
					Desktop.getDesktop().browse(new URI("http://www.baidu.com"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				if(tray!=null){
					hao.this.setVisible(false);
					return;
				}
				SystemTray systemtray=SystemTray.getSystemTray();
				tray=new TrayIcon(Toolkit.getDefaultToolkit().getImage("image/repare.jpg"));
				tray.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						hao.this.setVisible(true);
					}
					
				});
				PopupMenu p=new PopupMenu();
				MenuItem item=new MenuItem("tui chu");
				item.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
					
				});
				p.add(item);
				tray.setPopupMenu(p);
				try {
					systemtray.add(tray);
					hao.this.setVisible(false);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			 
		 });
		 menu.add(xinyouxi);
		 menu.add(tongji);
		 menu.add(xuanxiang);
		 menu.add(tuichu);
		 bar.add(menu);
         mobanmethod();
        add(bar,BorderLayout.NORTH);
		 add(p,BorderLayout.CENTER);
		 add(p1,BorderLayout.SOUTH);
		 setVisible(true);	
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600*N/16,640*M/16);
			
	 }
	public void TimeNumPanel(){//时间和剩余雷模板
		 jishi=false;
		 miao=0;
		 shengyulei=NUM;
		 h=new thread1();
		 ssss=8*N/16;
		 l1.setText("<html><font size="+ssss+" color=white>时间</font></html>");
	     l3.setText("<html><font size="+ssss+" color=white>雷数</font></html>");
	     l3.setPreferredSize(new Dimension(200*N/16,50*M/16));
		 l1.setPreferredSize(new Dimension(110*N/16,50*M/16));
		 p1.setPreferredSize(new Dimension(600*N/16,50*M/16));
		 shijian.setPreferredSize(new Dimension(110*N/16,50*M/16));
		 shengyilei.setPreferredSize(new Dimension(110*N/16,50*M/16));
		 shijian.setText("<html><font size="+ssss+" color=white>"+miao+"</font></html>");
		 shengyilei.setText("<html><font size="+ssss+" color=white>"+shengyulei+"</font></html>");
	}
	public void mobanmethod(){//创建MXN个Button1(砖块)添加到panel中
		 p=new JPanel();
		p.setLayout(new GridLayout(M,N));
		p.setSize(600*N/16,600*N/16);
		array=new Button1[M][N];
	
		for(int i=0;i<M;i++)
			{for(int j=0;j<N;j++){
				array[i][j]=Button1.getButton();
				array[i][j].setrow(i);
				array[i][j].setcol(j);
		array[i][j].setBgIcon16();
		array[i][j].setPreferredSize(new Dimension(37,37));
		p.add(array[i][j]);
		array[i][j].addMouseListener(new MouseListener(){//为每个砖块添加鼠标点击事件监控

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(Button1.getfail()==true){
					h.stop();
					for(int b1=0;b1<M;b1++){
						for(int b2=0;b2<N;b2++){
							if(array[b1][b2].getwakai()==false){
								if(array[b1][b2].getlei()==false&&array[b1][b2].getbiaoji()==true)array[b1][b2].setbiaocuo();
								if(array[b1][b2].getlei()==true){
									if(array[b1][b2].getbiaoji()==true)array[b1][b2].setbiaodui();
									else array[b1][b2].setIconOver16();
								}
							}
						}
					}
						
					diaglog();
					return;
				}
             if(e.getButton()==MouseEvent.BUTTON3){ //右击事件
            	 if(((Button1)e.getSource()).getwakai()==false){
            		 if(((Button1)e.getSource()).getbiaoji()==false&&((Button1)e.getSource()).getwenhao()==false){
            			 ((Button1)e.getSource()).setbiaoji(); 
            			 ((Button1)e.getSource()).setbiaoji(true); 
            			 shengyulei--;
            				shengyilei.setText("<html><font size="+ssss+" color=white>"+shengyulei+"</font></html>");
            		 }
            		 else if( ((Button1)e.getSource()).getwenhao()==false){
            			 ((Button1)e.getSource()).setwen();
            			 ((Button1)e.getSource()).setwenhao(true);
            			 ((Button1)e.getSource()).setbiaoji(false); 
            			 shengyulei++;
            			shengyilei.setText("<html><font size="+ssss+" color=white>"+shengyulei+"</font></html>");
            		 }
            		 else{
            			 ((Button1)e.getSource()).setBgIcon16();
            			 ((Button1)e.getSource()).setwenhao(false);
            		 }
            	 }
				return;	
             }

             else if(((Button1)e.getSource()).getwakai()==false&&((Button1)e.getSource()).getbiaoji()==false){	
				((Button1)e.getSource()).setwakai(true);
				if(((Button1)e.getSource()).getlei()==true){
					jishi=false;
					Button1.setfail(true);
					((Button1)e.getSource()).setonebao(true);
				 rows=	((Button1)e.getSource()).getrow();
				 cols=	((Button1)e.getSource()).getcol();
				 ((Button1)e.getSource()).t.start();
					h.start();
				}
				else{
					int rowrow=((Button1)e.getSource()).getrow();
					int colcol=((Button1)e.getSource()).getcol();
					if(jishi==false)RandomMethod(rowrow,colcol);
					jishi=true;
					if(((Button1)e.getSource()).getleinum()==0){
						((Button1)e.getSource()).setnumber0();
						allnum--;
						lin(array,rowrow,colcol);
					}
					else{
					if(((Button1)e.getSource()).getleinum()==1)((Button1)e.getSource()).setnumber1();
					if(((Button1)e.getSource()).getleinum()==2)((Button1)e.getSource()).setnumber2();
					if(((Button1)e.getSource()).getleinum()==3)((Button1)e.getSource()).setnumber3();
					if(((Button1)e.getSource()).getleinum()==4)((Button1)e.getSource()).setnumber4();
					if(((Button1)e.getSource()).getleinum()==5)((Button1)e.getSource()).setnumber5();
					if(((Button1)e.getSource()).getleinum()==6)((Button1)e.getSource()).setnumber6();
					if(((Button1)e.getSource()).getleinum()==7)((Button1)e.getSource()).setnumber7();
					if(((Button1)e.getSource()).getleinum()==8)((Button1)e.getSource()).setnumber8();
					allnum--;
				}
				}
			}
  
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(((Button1)e.getSource()).getwakai()==false&&((Button1)e.getSource()).getwenhao()==false&&Button1.getfail()==false&&((Button1)e.getSource()).getbiaoji()==false)
					((Button1)e.getSource()).setrepare();
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				if(((Button1)e.getSource()).getwakai()==false&&((Button1)e.getSource()).getwenhao()==false&&Button1.getfail()==false&&((Button1)e.getSource()).getbiaoji()==false)
					((Button1)e.getSource()).setBgIcon16();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
		});
		}
			}
			
      // RandomMethod();
       DuQuShuJu();
		
	}
	public void DuQuShuJu(){//将初级、中级、高级难度的统计信息从文件读入程序
		try{
			BufferedReader bfin=new BufferedReader(new InputStreamReader(new FileInputStream("chuji.txt")));
			String  s=bfin.readLine();
			if(s!=null){
				   winnum=Integer.parseInt(s);
				   chujiplayall=Integer.parseInt(bfin.readLine());
				   chujizuiduolianbai=Integer.parseInt(bfin.readLine());
				   chujizuiduoliansheng=Integer.parseInt(bfin.readLine());
				   s=bfin.readLine();
				   if(s!=null)chujiwestdate=s;
			   }
			bfin.close();
				
			 } catch (Exception e) {
					e.printStackTrace();
					}
	
		 try {
				BufferedReader bfin=new BufferedReader(new InputStreamReader(new FileInputStream("zhongji.txt")));
				String  s=bfin.readLine();
				if(s!=null){
					   zhongjiwinnum=Integer.parseInt(s);
					   zhongjiplayall=Integer.parseInt(bfin.readLine());
					   zhongjizuiduolianbai=Integer.parseInt(bfin.readLine());
					   zhongjizuiduoliansheng=Integer.parseInt(bfin.readLine());
					   s=bfin.readLine();
					   if(s!=null)zhongjiwestdate=s;
				   }
				bfin.close();
					
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		 try {
			    
			 BufferedReader bfin=new BufferedReader(new InputStreamReader(new FileInputStream("gaoji.txt")));
				String  s=bfin.readLine();
				if(s!=null){
					   gaojiwinnum=Integer.parseInt(s);
					   gaojiplayall=Integer.parseInt(bfin.readLine());
					   gaojizuiduolianbai=Integer.parseInt(bfin.readLine());
					   gaojizuiduoliansheng=Integer.parseInt(bfin.readLine());
					   s=bfin.readLine();
					   if(s!=null)gaojiwestdate=s;
				   }
				bfin.close();
					
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		
		 
		 
	}
	public void RandomMethod(int x1,int y1){ //随机布雷，并将是雷的Button1加入list中
		list=new ArrayList<Button1>();
		int x, y;
		Random r=new Random();
	//	for(int i=0;i<NUM;i++){//随机产生NUM个地雷
	//		 x=(int)r.nextInt(M);
		//	 y=(int)(int)r.nextInt(N);
		//	if(array[x][y].getlei()==true||(x==x1&&y==y1))i--;
		//	else {
		//		array[x][y].setlei(true);
		//		list.add(array[x][y]);
		//	}
		
		//}
		int a[]=new int[M*N];
		for(int i=0;i<M*N;i++)a[i]=i;
		int t=a[x1*N+y1];
		a[x1*N+y1]=a[M*N-1];
		a[M*N-1]=t;
		for(int i=1;i<=NUM;i++){
			x=r.nextInt(M*N-i);
			t=a[x];
			a[x]=a[M*N-i-1];
			a[M*N-i-1]=t;
		}
		for(int i=M*N-NUM-1;i<M*N-1;i++){
			x=a[i]/N;
			y=a[i]%N;
			array[x][y].setlei(true);
			list.add(array[x][y]);
		}
		int count=0;
		for(int i=0;i<M;i++){ //计算每块砖块周围八块有多少地雷
			for(int j=0;j<N;j++){
				if(array[i][j].getlei()==false){
				if(i-1>=0)if(j-1>=0)if(array[i-1][j-1].getlei()==true)count++;
				if(i-1>=0)if(array[i-1][j].getlei()==true)count++;
				if(i-1>=0)if(j+1<N)if(array[i-1][j+1].getlei()==true)count++;	
				if(j-1>=0)if(array[i][j-1].getlei()==true)count++;	
				if(j+1<N)if(array[i][j+1].getlei()==true)count++;		
				if(i+1<M)if(j+1<N)if(array[i+1][j+1].getlei()==true)count++;	
				if(i+1<M)if(j-1>=0)if(array[i+1][j-1].getlei()==true)count++;	
				if(i+1<M)if(array[i+1][j].getlei()==true)count++;	
				array[i][j].setleinum(count);
				count=0;
				}
			}
		}
	}
	 public static void lin(Button1 b[][],int x,int y){//翻开周围八块砖块，如果被翻开砖块周围的雷是0则执行递归
		 if(x-1>=0)if(y-1>=0)if(b[x-1][y-1].getwakai()==false)if(b[x-1][y-1].getbiaoji()==false)
			 if(b[x-1][y-1].getleinum()==0){
			 b[x-1][y-1].setnumber0();
			 b[x-1][y-1].setwakai(true);
			 allnum--;
			 lin(b,x-1,y-1);
		 }else{
			 if(b[x-1][y-1].getleinum()==1) b[x-1][y-1].setnumber1();
			 if(b[x-1][y-1].getleinum()==2) b[x-1][y-1].setnumber2();
			 if(b[x-1][y-1].getleinum()==3) b[x-1][y-1].setnumber3();
			 if(b[x-1][y-1].getleinum()==4) b[x-1][y-1].setnumber4();
			 if(b[x-1][y-1].getleinum()==5) b[x-1][y-1].setnumber5();
			 if(b[x-1][y-1].getleinum()==6) b[x-1][y-1].setnumber6();
			 if(b[x-1][y-1].getleinum()==7) b[x-1][y-1].setnumber7();
			 if(b[x-1][y-1].getleinum()==8) b[x-1][y-1].setnumber8();
			 b[x-1][y-1].setwakai(true);
			 allnum--;
			 }
		 //
		 if(x-1>=0)if(b[x-1][y].getwakai()==false)if(b[x-1][y].getbiaoji()==false)
			 if(b[x-1][y].getleinum()==0){
			 b[x-1][y].setnumber0();
			 b[x-1][y].setwakai(true);
			 allnum--;
			 lin(b,x-1,y);
		 }else{
			 if(b[x-1][y].getleinum()==1) b[x-1][y].setnumber1();
			 if(b[x-1][y].getleinum()==2) b[x-1][y].setnumber2();
			 if(b[x-1][y].getleinum()==3) b[x-1][y].setnumber3();
			 if(b[x-1][y].getleinum()==4) b[x-1][y].setnumber4();
			 if(b[x-1][y].getleinum()==5) b[x-1][y].setnumber5();
			 if(b[x-1][y].getleinum()==6) b[x-1][y].setnumber6();
			 if(b[x-1][y].getleinum()==7) b[x-1][y].setnumber7();
			 if(b[x-1][y].getleinum()==8) b[x-1][y].setnumber8();
			 b[x-1][y].setwakai(true);
			 allnum--;
			 }
		 //
		 if(x-1>=0)if(y+1<N)if(b[x-1][y+1].getwakai()==false)if(b[x-1][y+1].getbiaoji()==false)
			 if(b[x-1][y+1].getleinum()==0){
			 b[x-1][y+1].setnumber0();
			 b[x-1][y+1].setwakai(true);
			 allnum--;
			 lin(b,x-1,y+1);
		 }else{
			 if(b[x-1][y+1].getleinum()==1) b[x-1][y+1].setnumber1();
			 if(b[x-1][y+1].getleinum()==2) b[x-1][y+1].setnumber2();
			 if(b[x-1][y+1].getleinum()==3) b[x-1][y+1].setnumber3();
			 if(b[x-1][y+1].getleinum()==4) b[x-1][y+1].setnumber4();
			 if(b[x-1][y+1].getleinum()==5) b[x-1][y+1].setnumber5();
			 if(b[x-1][y+1].getleinum()==6) b[x-1][y+1].setnumber6();
			 if(b[x-1][y+1].getleinum()==7) b[x-1][y+1].setnumber7();
			 if(b[x-1][y+1].getleinum()==8) b[x-1][y+1].setnumber8();
			 b[x-1][y+1].setwakai(true);
			 allnum--;
			 }
		 //
		 if(y-1>=0)if(b[x][y-1].getwakai()==false)if(b[x][y-1].getbiaoji()==false)
			 if(b[x][y-1].getleinum()==0){
			 b[x][y-1].setnumber0();
			 b[x][y-1].setwakai(true);
			 allnum--;
			 lin(b,x,y-1);
		 }else{
			 if(b[x][y-1].getleinum()==1) b[x][y-1].setnumber1();
			 if(b[x][y-1].getleinum()==2) b[x][y-1].setnumber2();
			 if(b[x][y-1].getleinum()==3) b[x][y-1].setnumber3();
			 if(b[x][y-1].getleinum()==4) b[x][y-1].setnumber4();
			 if(b[x][y-1].getleinum()==5) b[x][y-1].setnumber5();
			 if(b[x][y-1].getleinum()==6) b[x][y-1].setnumber6();
			 if(b[x][y-1].getleinum()==7) b[x][y-1].setnumber7();
			 if(b[x][y-1].getleinum()==8) b[x][y-1].setnumber8();
			 b[x][y-1].setwakai(true);
			 allnum--;
			 }
				
		 //
		if(y+1<N)if(b[x][y+1].getwakai()==false)if(b[x][y+1].getbiaoji()==false)
			if(b[x][y+1].getleinum()==0){
			 b[x][y+1].setnumber0();
			 b[x][y+1].setwakai(true);
			 allnum--;
			 lin(b,x,y+1);
		 }else{
			 if(b[x][y+1].getleinum()==1) b[x][y+1].setnumber1();
			 if(b[x][y+1].getleinum()==2) b[x][y+1].setnumber2();
			 if(b[x][y+1].getleinum()==3) b[x][y+1].setnumber3();
			 if(b[x][y+1].getleinum()==4) b[x][y+1].setnumber4();
			 if(b[x][y+1].getleinum()==5) b[x][y+1].setnumber5();
			 if(b[x][y+1].getleinum()==6) b[x][y+1].setnumber6();
			 if(b[x][y+1].getleinum()==7) b[x][y+1].setnumber7();
			 if(b[x][y+1].getleinum()==8) b[x][y+1].setnumber8();
			 b[x][y+1].setwakai(true);
			 allnum--;
			 }
		//
		 if(x+1<M)if(y-1>=0)if(b[x+1][y-1].getwakai()==false)if(b[x+1][y-1].getbiaoji()==false)
			 if(b[x+1][y-1].getleinum()==0){
			 b[x+1][y-1].setnumber0();
			 b[x+1][y-1].setwakai(true);
			 allnum--;
			 lin(b,x+1,y-1);
		 }else{
			 if(b[x+1][y-1].getleinum()==1) b[x+1][y-1].setnumber1();
			 if(b[x+1][y-1].getleinum()==2) b[x+1][y-1].setnumber2();
			 if(b[x+1][y-1].getleinum()==3) b[x+1][y-1].setnumber3();
			 if(b[x+1][y-1].getleinum()==4) b[x+1][y-1].setnumber4();
			 if(b[x+1][y-1].getleinum()==5) b[x+1][y-1].setnumber5();
			 if(b[x+1][y-1].getleinum()==6) b[x+1][y-1].setnumber6();
			 if(b[x+1][y-1].getleinum()==7) b[x+1][y-1].setnumber7();
			 if(b[x+1][y-1].getleinum()==8) b[x+1][y-1].setnumber8();
			 b[x+1][y-1].setwakai(true);
			 allnum--;
			 }
		 //
		 if(x+1<M)if(b[x+1][y].getwakai()==false)if(b[x+1][y].getbiaoji()==false)
			 if(b[x+1][y].getleinum()==0){
			 b[x+1][y].setnumber0();
			 b[x+1][y].setwakai(true);
			 allnum--;
			 lin(b,x+1,y);
		 }else{
			 if(b[x+1][y].getleinum()==1)b[x+1][y].setnumber1();
			 if(b[x+1][y].getleinum()==2)b[x+1][y].setnumber2();
			 if(b[x+1][y].getleinum()==3)b[x+1][y].setnumber3();
			 if(b[x+1][y].getleinum()==4)b[x+1][y].setnumber4();
			 if(b[x+1][y].getleinum()==5)b[x+1][y].setnumber5();
			 if(b[x+1][y].getleinum()==6)b[x+1][y].setnumber6();
			 if(b[x+1][y].getleinum()==7)b[x+1][y].setnumber7();
			 if(b[x+1][y].getleinum()==8)b[x+1][y].setnumber8();
			 b[x+1][y].setwakai(true);
			 allnum--;
			 }
		 //
		 if(x+1<M)if(y+1<N)if(b[x+1][y+1].getwakai()==false)if(b[x+1][y+1].getbiaoji()==false)
			 if(b[x+1][y+1].getleinum()==0){
			 b[x+1][y+1].setnumber0();
			 b[x+1][y+1].setwakai(true);
			 allnum--;
			 lin(b,x+1,y+1);
		 }else{
			 if(b[x+1][y+1].getleinum()==1) b[x+1][y+1].setnumber1();
			 if(b[x+1][y+1].getleinum()==2) b[x+1][y+1].setnumber2();
			 if(b[x+1][y+1].getleinum()==3) b[x+1][y+1].setnumber3();
			 if(b[x+1][y+1].getleinum()==4) b[x+1][y+1].setnumber4();
			 if(b[x+1][y+1].getleinum()==5) b[x+1][y+1].setnumber5();
			 if(b[x+1][y+1].getleinum()==6) b[x+1][y+1].setnumber6();
			 if(b[x+1][y+1].getleinum()==7) b[x+1][y+1].setnumber7();
			 if(b[x+1][y+1].getleinum()==8) b[x+1][y+1].setnumber8();
			 b[x+1][y+1].setwakai(true);
			 allnum--;
			 }
	
	 }
	 public void diaglog(){//输了时弹出对话框
		 choices= new String[]{"退出", "重玩游戏","新游戏"};  
		 shuyin="你输了";
		 qingxuanze="请选择";
		 if(N==9&&M==9){//更改初级连胜和连败信息并输出到文件中
			 chujizuiduoliansheng=0;
			 chujizuiduolianbai++;
			 chujiplayall++;
			 try {
					BufferedWriter f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("chuji.txt")));
					String s=""+winnum;
					f.write(s);
					f.newLine();
					s=""+chujiplayall;
					f.write(s);
					f.newLine();
					s=""+chujizuiduolianbai;
					f.write(s);
					f.newLine();
					s=""+chujizuiduoliansheng;
					f.write(s);
					f.newLine();
					f.write(chujiwestdate);
					f.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }
		 if(N==16&&M==16){//更改中级连胜和连败信息并输出到文件中
			 zhongjizuiduoliansheng=0;
			 zhongjizuiduolianbai++;
			 zhongjiplayall++;
			 try {
				 BufferedWriter f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("zhongji.txt")));
					String s=""+zhongjiwinnum;
					f.write(s);
					f.newLine();
					s=""+zhongjiplayall;
					f.write(s);
					f.newLine();
					s=""+zhongjizuiduolianbai;
					f.write(s);
					f.newLine();
					s=""+zhongjizuiduoliansheng;
					f.write(s);
					f.newLine();
					f.write(zhongjiwestdate);
					f.close();
			
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		 }
		 if(N==30&&M==16){//更改高级连胜和连败信息并输出到文件中
			 gaojizuiduoliansheng=0;
			 gaojizuiduolianbai++;
			 gaojiplayall++;
			 try {
				 BufferedWriter f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gaoji.txt")));
					String s=""+gaojiwinnum;
					f.write(s);
					f.newLine();
					s=""+gaojiplayall;
					f.write(s);
					f.newLine();
					s=""+gaojizuiduolianbai;
					f.write(s);
					f.newLine();
					s=""+gaojizuiduoliansheng;
					f.write(s);
					f.newLine();
					f.write(gaojiwestdate);
					f.close();
							
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		 }
	     DuiHuaKuanXuanZe();
			return;
	 }
	 public void DuiHuaKuanXuanZe(){//游戏输了或赢了就弹出对话框，输赢显示的对话框只是shuyin属性和qingxuanze属性不同。
		 int xx=JOptionPane.showOptionDialog(null,
				    ""+shuyin, ""+qingxuanze,JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
				if(xx==0){
					System.exit(0);
					}
				if(xx==1){//选择重玩游戏只需要对已有对象进行重新初始化属性
					for(int i=0;i<M;i++)
					{for(int j=0;j<N;j++){
					array[i][j].t=new Thread(array[i][j]);
					array[i][j].setwakai(false);
					array[i][j].setlei(false);
					array[i][j].setbiaoji(false);
					array[i][j].setwenhao(false);
					array[i][j].setonebao(false);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					array[i][j].setBgIcon16();
					}
					}
					int ux,uy;
					Button1.setfail(false);
					for(Button1 b:list){
						b.setBgIcon16();
						ux=b.getrow();
						uy=b.getcol();
						array[ux][uy].setlei(true);
					}
					 miao=0;
					 jishi=false;
					 shengyulei=NUM;
					shijian.setText("<html><font size="+ssss+" color=white>"+miao+"</font></html>");
					shengyilei.setText("<html><font size="+ssss+" color=white>"+shengyulei+"</font></html>");
					 h=new thread1();
					 allnum=M*N-NUM;
					 DuQuShuJu();
			}
			if(xx==2){//选择新游戏
				XinYouXi();
			}
	 }
	 public void XinYouXi(){//新游戏需要对已有对象进行属性初始化和重新布雷
		 miao=0;
		 jishi=false;
		 for(int i=0;i<M;i++)
			{for(int j=0;j<N;j++){
			array[i][j].t=new Thread(array[i][j]);
			array[i][j].setwakai(false);
			array[i][j].setlei(false);
			array[i][j].setbiaoji(false);
			array[i][j].setwenhao(false);
			array[i][j].setonebao(false);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			array[i][j].setBgIcon16();
			}
			}
			//RandomMethod();
			 Button1.setfail(false);
			 allnum=M*N-NUM;
			 h=new thread1();
			 shengyulei=NUM;
			shijian.setText("<html><font size="+ssss+" color=white>"+miao+"</font></html>");
			shengyilei.setText("<html><font size="+ssss+" color=white>"+shengyulei+"</font></html>");
			DuQuShuJu();
	 }
	class thread1 extends Thread{ //以圆的方式爆炸
	public void run() {
        int x;
        int y;
		for(Button1 aa:list){
		 x=aa.getrow();
		 y=aa.getcol();
		int he=(Math.abs(rows-x))*(Math.abs(rows-x))+(Math.abs(cols-y))*(Math.abs(cols-y));//求平方和
		aa.setpingfanghe(he);//将求得的平方和赋给Button1对象的pingfanghe属性
		}
		Comparator compare=new Comparator(){

			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO 自动生成的方法存根
				if(Button1.class.isInstance(arg0)&&Button1.class.isInstance(arg1)){
				Button1 b0=(Button1)arg0;
				Button1 b1=(Button1)arg1;
				return b0.getpingfanghe()>b1.getpingfanghe()?1:b0.getpingfanghe()<b1.getpingfanghe()?-1:0;	
				}
				return 1;
			}
			
		};
		Collections.sort(list,compare);
		for(int b1=0;b1<M;b1++){
			for(int b2=0;b2<N;b2++){
				if(array[b1][b2].getwakai()==false){
					if(array[b1][b2].getlei()==false&&array[b1][b2].getbiaoji()==true)array[b1][b2].setbiaocuo();
					if(array[b1][b2].getlei()==true){
						if(array[b1][b2].getbiaoji()==true)array[b1][b2].sethouqi();
						else array[b1][b2].setIconBegin16();
					}
				}
			}
		}
			for(Button1 b:list)//取出set的Button1对象并启动相应的线程打到动态爆炸效果
			{		
			if(b.getwakai()==false){
					try {
						h.sleep(35);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					b.t.start();
					
				}
				}
				diaglog();
				return;
	}
	}
	@Override
	public void run() { 
		// TODO 自动生成的方法存根
		while(true){
			if(allnum==0){//监控是否获胜
				
				if(N==9&&M==9){
					try {
				
					allnum--;
					Date d=new Date();
					String date =d.toLocaleString();
					int time1=miao;
				    int time;
					if(!chujiwestdate.equals("")){
						time=Integer.parseInt(chujiwestdate.substring(0,4).replaceAll(" ",""));
						if(time1<time) {
							chujiwestdate=""+time1+"    "+date;
						}
					}
					else chujiwestdate=""+time1+"    "+date;
					winnum++;
					chujizuiduoliansheng++;
					chujiplayall++;
					chujizuiduolianbai=0;
					BufferedWriter f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("chuji.txt")));
					String s=""+winnum;
					f.write(s);
					f.newLine();
					s=""+chujiplayall;
					f.write(s);
					f.newLine();
					s=""+chujizuiduolianbai;
					f.write(s);
					f.newLine();
					s=""+chujizuiduoliansheng;
					f.write(s);
					f.newLine();
					f.write(chujiwestdate);
					f.close();
				
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					System.err.println(e);
					e.printStackTrace();
				}
				}
				
				if(N==16&&M==16){
					try {
				
					allnum--;
					Date d=new Date();
					String date =d.toLocaleString();
					int time1=miao;
				    int time;
					if(!zhongjiwestdate.equals("")){
						time=Integer.parseInt(zhongjiwestdate.substring(0,4).replaceAll(" ",""));
						if(time1<time) {
							zhongjiwestdate=""+time1+"    "+date;
						}
					}
					else zhongjiwestdate=""+time1+"    "+date;
					winnum++;
					zhongjizuiduoliansheng++;
					zhongjiplayall++;
					zhongjizuiduolianbai=0;
					BufferedWriter f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("zhongji.txt")));
					String s=""+zhongjiwinnum;
					f.write(s);
					f.newLine();
					s=""+zhongjiplayall;
					f.write(s);
					f.newLine();
					s=""+zhongjizuiduolianbai;
					f.write(s);
					f.newLine();
					s=""+zhongjizuiduoliansheng;
					f.write(s);
					f.newLine();
					f.write(zhongjiwestdate);
					f.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					System.err.println(e);
					e.printStackTrace();
				}
				}
				
				if(N==30&&M==16){
					try {
				
					allnum--;
					Date d=new Date();
					String date =d.toLocaleString();
					int time1=miao;
				    int time;
					if(!gaojiwestdate.equals("")){
						time=Integer.parseInt(gaojiwestdate.substring(0,4).replaceAll(" ",""));
						if(time1<time) {
							gaojiwestdate=""+time1+"    "+date;
						}
					}
					else gaojiwestdate=""+time1+"    "+date;
					winnum++;
					gaojizuiduoliansheng++;
					gaojiplayall++;
					gaojizuiduolianbai=0;
					BufferedWriter f=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gaoji.txt")));
					String s=""+gaojiwinnum;
					f.write(s);
					f.newLine();
					s=""+gaojiplayall;
					f.write(s);
					f.newLine();
					s=""+gaojizuiduolianbai;
					f.write(s);
					f.newLine();
					s=""+gaojizuiduoliansheng;
					f.write(s);
					f.newLine();
					f.write(gaojiwestdate);
					f.close();
				} catch (IOException e) {
					System.err.println(e);
					e.printStackTrace();
				}
				}
				choices=new String[]{"退出", "重玩游戏","新游戏"};  
				 shuyin="恭喜你你赢了";
				 qingxuanze="请选择";
				 DuiHuaKuanXuanZe();
				
			}
			else if(jishi==true){//每隔1秒更新时间显示
					try {
						miao++;
						shijian.setText("<html><font size="+ssss+" color=white>"+miao+"</font></html>");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
		}
	}	
	public static void main(String[]args){
	new hao();

	}
}