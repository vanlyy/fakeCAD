package fakeCAD;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class Circle extends Shape {
	int x1,y1,x2,y2;
	double r;
	double originx,originy;
	Color color;
	int width;
	public Circle(int x1,int y1,int x2,int y2,int width,Color color)
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.width=width;
		this.color=color;
		this.r = (double)(x2-x1)/2;
		originx =(double) (x1+x2)/2;
		originy =(double)y1+r+(double)width;
		System.out.println("(x1,y1)=("+x1+","+y1+")");
		System.out.println("(x2,y2)=("+x2+","+y2+")");
		System.out.println("r:"+r);
		System.out.println("("+originx+","+originy+")");
	}
	@Override
	public boolean isSelected(int x, int y) {
		boolean isselected = false;
		if(((x-originx)*(x-originx)+(y-originy)*(y-originy))>(r-width)*(r-width))
		{
			if(((x-originx)*(x-originx)+(y-originy)*(y-originy))<(r+width)*(r+width))
			{
				isselected = true ;
				System.out.println("Circle is selected");
			}
		}
		return isselected;
	}
	@Override
	public void draw(Graphics2D g2d) 
	{
		
			
		g2d.setPaint(color);
		g2d.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g2d.draw(new Ellipse2D.Float(x1, y1, x2-x1, x2-x1));
		
	}
	@Override
	public int getshape() {
		return 1;
	}
	@Override
	public void move(int n, int m, int p, int q) {
		this.x1=x1+p-n;
		this.y1=y1+q-m;
		this.x2=x2+p-n;
		this.y2=y2+q-m;	
		System.out.println("move Circle");
	}
	
	
	
	
}
