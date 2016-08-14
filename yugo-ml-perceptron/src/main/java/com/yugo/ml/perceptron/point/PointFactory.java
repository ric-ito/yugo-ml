package com.yugo.ml.perceptron.point;
import static com.yugo.ml.perceptron.Randomizer.randomNumber;

public class PointFactory {

	public static final Point getClass1(){
		
		double x = randomNumber(5, 10);
		double y = randomNumber(4, 8);
		double z = randomNumber(2, 9);
	
		Point p = new Point(x, y, z);
		p.setOutput(1);
		
		return p;
	}
	
	public static final Point getClass0(){
		
		double x = randomNumber(-1, 3);
		double y = randomNumber(-4, 2);
		double z = randomNumber(-3, 5);
	
		Point p = new Point(x, y, z);
	
		p.setOutput(0);
		
		return p;
	}
	
	public static final Point getClassX(){
		
		double x = randomNumber(-10, 10);
		double y = randomNumber(-10, 10);
		double z = randomNumber(-10, 10);
	
		return new Point(x, y, z);
	}
}
