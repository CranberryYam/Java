package playground;

import java.awt.Color;

public class ColoredCircle extends Circle {
	public int color =126; 
	
	public static void main(String[] args) {
        Circle c = new Circle();
        ColoredCircle d = new ColoredCircle();
        c = d;
        c.draw();
//        d = c;
//        d.draw();
	}

	public void draw() { 
		System.out.println("draw a colored circle with a "+color+" color");
	}
}

class Circle {
	public double center_x, center_y; 
	public double radius; 

	public void draw() { 
	   System.out.println("draw a circle");
	} 

	public void draw(Color color) { 
	   System.out.println("draw a circle with a "+color.getRGB()+" color");
	}
}