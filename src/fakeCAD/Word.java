package fakeCAD;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Word extends Shape {
	int x1,y1,x2,y2;
	Color color;
	int width;
	String s1;
	int height;
	int longth;


	
	public Word(String s1,int x1,int y1,int x2,int y2)
	{
		System.out.println(s1);
		this.s1 = s1 ;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setPaint(color);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN,x2-x1));
		g2d.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        height = g2d.getFontMetrics().getHeight();
        longth = g2d.getFontMetrics().stringWidth(s1);
		if (s1 != null) {

            g2d.drawString(s1,x1,y1);
        }
	}

	@Override
	public boolean isSelected(int x, int y)
	{
		boolean isselected = false ;
		if(x>x1&&x<(x1+longth)&&y>y1&&y<(y1+height))
			isselected = true ;
		return isselected;
	}

	@Override
	public int getshape() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public void move(int n, int m, int p, int q) {
		this.x1=x1+p-n;
		this.y1=y1+q-m;
		this.x2=x2+p-n;
		this.y2=y2+q-m;		
	}
	

}
