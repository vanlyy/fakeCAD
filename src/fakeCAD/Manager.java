package fakeCAD;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Manager extends JPanel implements ActionListener, MouseListener,MouseMotionListener {
	


	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<JButton> buttons2  = new ArrayList<JButton>();
	private ArrayList<JButton> buttons1 = new ArrayList<JButton>();
	
	public JPanel jpanel1,jpanel2,jpanel3;
	
	private String array[] = {"直线","圆形","矩形","文本"};
	private Color colors[] = {Color.BLACK,Color.WHITE,Color.GRAY,Color.BLUE,Color.YELLOW,Color.GREEN,Color.RED};
	private String array2[] ={"黑","白","灰","蓝","黄","绿","红"};
	private int a,b,c,d,width;
	
	private int n,m;
	
	private int shape ;
	private Color color;
	
	String inputValue;
	
	private boolean dragflag = false;
	
	
	//输入宽度的文本框
	private JTextField textLineWidth;
	private JTextField textWidth;
	
	
	public Manager()
	{
		//对形状框布局
		jpanel1 = new JPanel();
		jpanel1.setPreferredSize(new Dimension(50, 200));
		jpanel1.setBackground(Color.LIGHT_GRAY);
		BoxLayout layout1=new BoxLayout(jpanel1, BoxLayout.Y_AXIS); 
		jpanel1.setLayout(layout1);
		
		for(int i=0; i<array.length; i++) {
			buttons1.add(new JButton(array[i]));
			buttons1.get(i).setPreferredSize(new Dimension(40,50));
			jpanel1.add(buttons1.get(i));
			buttons1.get(i).addActionListener(this);
			//button1.addActionListener(this);
			//就是把当前的类设成button1的Listener;
			//那么就可以在当前的类中添加方法以响应button1的点击,比如:
			//void actionPerformed(ActionEvent e)
			//{
			////响应button1的点击的代码;
			//}
		}
		
		buttons1.get(3).addActionListener(this);
		
		//对颜色框布局
		jpanel2 = new JPanel();
		jpanel2.setPreferredSize(new Dimension(50, 200));
		jpanel1.setBackground(Color.LIGHT_GRAY);
		BoxLayout layout2=new BoxLayout(jpanel2, BoxLayout.Y_AXIS); 
		jpanel2.setLayout(layout2);
		
		for(int i=0; i<colors.length; i++) {
			buttons2.add(new JButton(array2[i]));
			buttons2.get(i).setBackground(colors[i]);
			buttons2.get(i).setPreferredSize(new Dimension(40, 40));
			jpanel2.add(buttons2.get(i));
			buttons2.get(i).addActionListener(this);
		}
		
		
		//jpanel3布局
		textLineWidth=new JTextField("Line width: ");
		textLineWidth.setEditable(false);
		textLineWidth.setOpaque(false);
		//textWidth输入框
		textWidth=new JTextField(5);
		textWidth.setEditable(true);
		textWidth.setOpaque(false);
		textWidth.addActionListener(this);
		
		JButton jbutton1 = new JButton("clear");
		JButton jbutton2 = new JButton("undo");
		JButton jbutton3 = new JButton("drag");
		
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);
		jbutton3.addActionListener(this);
		
		jpanel3 = new JPanel();
		jpanel3.setPreferredSize(new Dimension(50, 200));
		jpanel1.setBackground(Color.LIGHT_GRAY);
		jpanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jpanel3.add(textLineWidth);
		jpanel3.add(textWidth);
		jpanel3.add(jbutton1);
		jpanel3.add(jbutton2);
		jpanel3.add(jbutton3);
		
		//组合到一起
		
		this.setLayout(null);
		jpanel1.setBounds(10, 20, 60, 130);
		jpanel2.setBounds(25, 175, 30, 200);
		jpanel3.setBounds(5, 400, 90, 200);
		
		this.setPreferredSize(new Dimension(800,600));
		this.add(jpanel1);
		this.add(jpanel2);
		this.add(jpanel3);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		
	
	}
	
	//paintComponent方法在JPanel初始化时执行一次。使用repaint方法会导致调用paintComponent方法.
	//如果把super.paintComponent(g)这行注释掉，会发现点击按钮时以前输出的字符串仍然存在,没有被清除掉.
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
	
		setBackground(Color.WHITE);
		for ( Shape s : shapes )
		{
			s.draw(g2d);
		}		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//选中形状响应
		for(int i=0; i<buttons1.size(); i++)
		{
			if (e.getSource()==buttons1.get(i))
				shape = i;
			
			dragflag = false;
		}
		//选中颜色响应
		for(int i=0; i<buttons2.size(); i++)
		{
			if(e.getSource()==buttons2.get(i))
				color = colors[i];
		}
		
		if(e.getSource()==textWidth)
		{
			long n=Long.parseLong(textWidth.getText()); 
			width = (int)n;

		}
		
		if(e.getActionCommand()=="clear")
		{
			shapes.clear();
			repaint();
		}
		if(e.getActionCommand()=="undo")
		{
			shapes.remove((shapes.size()-1));
			repaint();
		}
		if(e.getActionCommand()=="drag")
		{
			dragflag = true;
		}
		if(e.getActionCommand()=="文本")
		{
			JOptionPane joptionpane = new JOptionPane();
			inputValue = joptionpane.showInputDialog(this,"Please input a value","input",JOptionPane.OK_CANCEL_OPTION);	
			System.out.println(inputValue+"inputvalue");
			
			 
		}
	
		
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		if(!dragflag)
		{
			a=e.getX();
			b=e.getY();
		}
		if(dragflag)
		{
			n=e.getX();
			m=e.getY();
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(!dragflag)
		{
			c=e.getX();
			d=e.getY();
			if(shape==0)
			    shapes.add(new Line(a,b,c,d,width,color));
			else if(shape==1)
				shapes.add(new Circle(a,b,c,d,width,color));
			else if(shape==2)
				shapes.add(new Rect(a,b,c,d,width,color));
			else if(shape==3)
				shapes.add(new Word(inputValue,a,b,c,d));
		   		// new DrawOval只是生成了那个shape并没画
			repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

//	drag模块有问题
	@Override
	public void mouseDragged(MouseEvent e)
	{
		if(dragflag)
		{	
			int p = e.getX();
			int q = e.getY();
			int i=0;
			int selected = 0;
			for( i=0 ;i<shapes.size() ;i++)
			{
				if(shapes.get(i).isSelected(p, q))
				{
					selected = i;
					System.out.println(i+"is selected");

					break;
				}
			}
			//如何使他可以调用子类的isSelected？？？
//			System.out.println(selected);
//			
//			System.out.println(shapes.get(selected).isSelected(p,q));
			if(shapes.get(selected).isSelected(p, q))
			{

					shapes.get(selected).move(n,m,p,q);
					n = p;
					m = q;
					repaint();
			}
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
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
	
	
	
	
	
	

}
