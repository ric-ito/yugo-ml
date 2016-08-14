package com.yugo.ml.perceptron.bin;

import static com.yugo.ml.perceptron.Randomizer.randomNumber;

import com.yugo.ml.perceptron.Perceptron;
import com.yugo.ml.perceptron.point.Point;
import com.yugo.ml.perceptron.point.PointFactory;

public class PerceptronMain {

	private static final int THETA = 8;
	
	private static final int NUM_INSTANCES = 100;
	
	public static void main(String[] args) {
		
		Point[] samples = generateSamples();
		
		double[] weights = new double[4];
		
		weights[0] = randomNumber(0, 1);
		weights[1] = randomNumber(0, 1);
		weights[2] = randomNumber(0, 1);
		weights[3] = randomNumber(0, 1);
		
		System.out.println("Initial weights ("+ weights[0] +", "+ weights[1] +", "+ weights[2] +"), bias = "+ weights[3]);
	
		Perceptron perceptron = new Perceptron(THETA, weights);
		
		perceptron.doTraining(samples);
		
		apply(perceptron, 10);
	}

	private static void apply(Perceptron perceptron, int maxTests) {
		
		for (int j = 0; j < maxTests; j++){
			
			Point point = PointFactory.getClassX();
			
			int output = perceptron.calculateOutput(point);
		
			System.out.println("Random point ("+ point +"), class = "+ output);
		}
	}

	private static Point[] generateSamples() {
		
		Point[] samples = new Point[NUM_INSTANCES];
		
		/*
		 * 50 random points class 1
		 */
		for (int i = 0; i < NUM_INSTANCES/2; i++){
			
			Point p = PointFactory.getClass1();
			samples[i] = p;

			System.out.println(p);
		}
		
		/*
		 * 50 random points class 0
		 */
		for (int i = NUM_INSTANCES/2; i < NUM_INSTANCES; i++){
			
			Point p = PointFactory.getClass0();
			samples[i] = p;
		
			System.out.println(p);
		}
		
		return samples;
	}


}
