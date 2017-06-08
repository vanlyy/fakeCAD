package fakeCAD;


import java.awt.Color;
import java.awt.Graphics2D;

public abstract class  Shape {
	


	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	public abstract boolean isSelected(int x,int y);
	public abstract int getshape();
	public abstract void move(int n,int m,int p, int q);
	
}
