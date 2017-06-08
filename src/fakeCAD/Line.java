package fakeCAD;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Line extends Shape {
	int x1,y1,x2,y2,width;
	Color color;
	public Line(int x1,int y1,int x2,int y2,int width,Color color)
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.width=width;
		this.color=color;

	}
	public void draw(Graphics2D g2d)
	{
			g2d.setPaint(color);
			g2d.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		    g2d.draw(new Line2D.Float(x1, y1, x2, y2));
	}
	@Override
	public boolean isSelected(int x, int y) {
//		if ()
		boolean isselected = false ;
		
		double distance = pointtoline(x1,y1,x2,y2,x,y) ;
		
		if(distance < width)
			{
				isselected = true ;
				System.out.println("line is selected");
			}
		
		return isselected;
	}
	
	@Override
	public int getshape() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void move(int n, int m, int p, int q) {
		this.x1=x1+p-n;
		this.y1=y1+q-m;
		this.x2=x2+p-n;
		this.y2=y2+q-m;		
	}
	
	
	private double pointtoline(int x12, int y12, int x22, int y22, int x0, int y0)
	{
		double space = 0;  
		  
	    double a, b, c;  
	
	    a = lineSpace(x12, y12, x22, y22);// �߶εĳ���  
	
	    b = lineSpace(x12, y12, x0, y0);// (x1,y1)����ľ���  
	
	    c = lineSpace(x22, y22, x0, y0);// (x2,y2)����ľ���  
	
	    if (c+b == a)
	    {//�����߶���  
	
	       space = 0;  
	
	       return space;  
	
	    }  
	
	    if (a <= 0.000001)
	    {//�����߶Σ���һ����  
	
	       space = b;  
	
	       return space;  
	
	    }  
	
	    if (c * c >= a * a + b * b)
	    { //���ֱ�������λ�۽������Σ�(x1,y1)Ϊֱ�ǻ�۽�  
	
	       space = b;  
	
	       return space;  
	
	    }  
	
	    if (b * b >= a * a + c * c) {//���ֱ�������λ�۽������Σ�(x2,y2)Ϊֱ�ǻ�۽�  
	
	       space = c;  
	
	       return space;  
	
	    }  
	//�����������Σ����������εĸ�  
	    double p = (a + b + c) / 2;// ���ܳ�  
	
	    double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));// ���׹�ʽ�����  
	
	    space = 2 * s / a;// ���ص㵽�ߵľ��루���������������ʽ��ߣ�  
	
	    return space;  
	
	}  
	
	
	// ��������֮��ľ���  
	
	    private double lineSpace(int x12, int y12, int x22, int y22) 
	    {  
	
	    double lineLength = 0;  
	
	    lineLength = Math.sqrt((x12 - x22) * (x12 - x22) + (y12 - y22)  
	
	           * (y12 - y22));  
	
	    return lineLength;  
	

	    }  
	

}
