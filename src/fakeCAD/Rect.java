package fakeCAD;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rect extends Shape {
	int x1,y1,x2,y2;	
	Color color;
	int width;
	public Rect(int x1,int y1,int x2,int y2,int width,Color color)
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.width=width;
		this.color=color;
		
	}
	
	

	public boolean isSelected(int x, int y) {
//		if (x>(x1-0.5*width)&&x<(x1+0.5*width)&&y>(y1-0.5*width)&&y<(y1+0.5*width))
//			isselected = true ;
		boolean isselected = false ;
		if(x>(x1-0.5*width)&&x<(x2+0.5*width)&&y>(y1-0.5*width)&&y<(y2+0.5*width))
			{
//				if(!(x>(x1-0.5*width)&&x<(x2-0.5*width)&&y>(y1-0.5*width)&&y<(y2-0.5*width)))
					isselected = true;
			}
		return isselected;
		
	}

	public void draw(Graphics2D g2d)
	{
			
			g2d.setPaint(color);
			g2d.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			g2d.draw(new Rectangle2D.Float(x1, y1, x2-x1, y2-y1));
	}
	



	@Override
	public int getshape() {
		// TODO Auto-generated method stub
		return 2;
	}



	@Override
	public void move(int n, int m, int p, int q) {
		this.x1=x1+p-n;
		this.y1=y1+q-m;
		this.x2=x2+p-n;
		this.y2=y2+q-m;
		
	}
}
