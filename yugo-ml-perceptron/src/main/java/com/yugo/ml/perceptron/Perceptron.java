package com.yugo.ml.perceptron;

import com.yugo.ml.perceptron.point.Point;

public class Perceptron {

	private static final int ITERATIONS_LIMIT = 100;
	private static final double LEARNING_RATE = 0.001d;

	private int theta;
	private double[] weights;
	
	public Perceptron(int theta, double[] w){
		this.theta = theta;
		this.weights = w;
	}
	
	public void doTraining(Point[] points) {
		
		double localError;
		double globalError;
		int p;
		int iteration;
		int output;
		iteration = 0;
		
		do {
			iteration++;
			globalError = 0;
			
			for (p = 0; p < points.length; p++){
				
				Point current = points[p];
				
				output = calculateOutput(current);
				localError = current.getOutput() - output;
				
				double oldW0 = weights[0];
				double oldW1 = weights[1];
				double oldW2 = weights[2];
				double oldW3 = weights[3];
				
				weights[0] += LEARNING_RATE * localError * current.getX();
				weights[1] += LEARNING_RATE * localError * current.getY();
				weights[2] += LEARNING_RATE * localError * current.getZ();
				weights[3] += LEARNING_RATE * localError;
				
				if (weights[0] != oldW0 || weights[1] != oldW1 || weights[2] != oldW2 || weights[3] != oldW3){
					System.out.println("Iteration ["+ iteration +", "+ p +"] Adjusted weights ("+ weights[0] +", "+ weights[1] +", "+ weights[2] +"), bias = "+ weights[3]);
				}
				globalError += localError * localError;
			}
			
			System.out.println("Iteration "+ iteration +" : RMSE = "+ Math.sqrt(globalError / points.length));
			
		} while (globalError != 0 && iteration < ITERATIONS_LIMIT);
		
		System.out.println("#### Training complete in "+ iteration +" iterations");
	}
	
	public int calculateOutput(Point p){
		
		double sum = p.getX() * weights[0] + p.getY() * weights[1] + p.getZ() * weights[2] + weights[3];
		
		return sum >= theta ? 1 : 0; 
	}
}
