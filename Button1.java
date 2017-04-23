package kk;

public class Button1 extends MyButton implements Runnable{
	private static Button1 b=null;
	private boolean wakai=false;
	private static boolean fail=false;
	private boolean lei=false;
	private boolean biaoji=false;
	private boolean wenhao=false;
	private int leinum=0;
	private int row;
	private int col;
	private int pingfanghe;
	private boolean onebao=false;
    Thread t;
	private Button1(){}
	public static Button1 getButton(){
	b=new Button1();
	b.t=new Thread(b);
	return b;
	}
    public void setIconRed(){
    	this.SetIcon("image\\3.jpg");
    }
    public void setBgIcon16(){
    	this.SetIcon("image\\16.jpg");
    }
    public void setrepare(){
    	this.SetIcon("image\\repare.jpg");
    }
    public void setIconOver16(){
    	this.SetIcon("image\\17.jpg");
        }
    public void setIconBegin16(){
    	this.SetIcon("image\\18.jpg");
   }
    public void setBao16(){
    	this.SetIcon("image\\19.jpg");
    }
    public void setBao161(){
    	this.SetIcon("image\\20.jpg");
    }
    public void setnumber0(){
    	this.SetIcon("image\\110.jpg");
    }
    
    public void setnumber1(){
    	this.SetIcon("image\\111.jpg");
    }
    public void setnumber2(){
    	this.SetIcon("image\\112.jpg");
    }
    public void setnumber3(){
    	this.SetIcon("image\\113.jpg");
    }
    public void setnumber4(){
    	this.SetIcon("image\\114.jpg");
    }
    public void setnumber5(){
    	this.SetIcon("image\\115.jpg");
    }
    public void setnumber6(){
    	this.SetIcon("image\\116.jpg");
    }
    public void setnumber7(){
    	this.SetIcon("image\\117.jpg");
    }
    public void setnumber8(){
    	this.SetIcon("image\\118.jpg");
    }
    public void setbiaoji(){
    	this.SetIcon("image\\biaoji.jpg");
    }
    public void setbiaocuo(){
    	this.SetIcon("image\\biaocuo.jpg");
    }
    public void setbiaodui(){
    	this.SetIcon("image\\biaodui.jpg");
    }
    public void setwen(){
    	this.SetIcon("image\\wen.jpg");
    }
    public void sethouqi(){
    	this.SetIcon("image\\4houqi.jpg");
    }
    public void setwakai(boolean wakai){
    	this.wakai=wakai;
    }
    public boolean getwakai(){
    	return wakai;
    }
    public static void setfail(boolean f){
    	fail=f;
    }
    public static boolean getfail(){
    	return fail;
    }
    public void setlei(boolean lei){
    	this.lei=lei;
    }
    public boolean getlei(){
    	return lei;
    }
    public void setleinum(int leinum){
    	this.leinum=leinum;
    }
    public int getleinum(){
    	return leinum;
    }
    public void setrow(int row){
    	this.row=row;
    }
    public int getrow(){
    	return row;
    }
    public void setcol(int col){
    	this.col=col;
    }
    public int getcol(){
    	return col;
    }
    public void setbiaoji(boolean biaoji){
    	this.biaoji=biaoji;
    }
    public boolean getbiaoji(){
    	return biaoji;
    }
    public void setwenhao(boolean wenhao){
    	this.wenhao=wenhao;
    }
    public boolean getwenhao(){
    	return wenhao;
    }
    public void setpingfanghe(int pingfanghe){
    	this.pingfanghe=pingfanghe;
    }
    public int getpingfanghe(){
    	return pingfanghe;
    }
    public void setonebao(boolean onebao){
    	this.onebao=onebao;
    }
    public boolean getonebao(){
    	return onebao;
    }
	@Override
	public void run() {
		for(int i=0;i<2;i++){
			 this.setBao16();
			 try {
				Thread.sleep(80);
			
			this.setBao161();
				
				 Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		if(this.getonebao()==false) {
			if(this.getbiaoji()==true)this.setbiaodui();
			else this.setIconOver16();
		}
		else this.setIconRed();
	}
	}
	
