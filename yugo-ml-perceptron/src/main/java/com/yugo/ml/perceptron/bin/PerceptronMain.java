package com.yugo.ml.perceptron.bin;

import com.yugo.ml.perceptron.Perceptron;
import com.yugo.ml.perceptron.PerceptronFactory;
import com.yugo.ml.perceptron.point.Point;
import com.yugo.ml.perceptron.point.PointFactory;

public class PerceptronMain {

	private static final int THETA = 3;

	public static void main(String[] args) {

		Point[] samples = PointFactory.generateSamples();

		Perceptron perceptron = PerceptronFactory.newInstance(THETA);

		perceptron.doTraining(samples);

		apply(perceptron, 10);
	}

	private static void apply(Perceptron perceptron, int maxTests) {

		for (int j = 0; j < maxTests; j++) {

			Point point = PointFactory.getClassX();

			int output = perceptron.calculateOutput(point);

			System.out.println("Random point (" + point + "), class = " + output);
		}
	}

}
