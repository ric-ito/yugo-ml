package com.yugo.ml.perceptron;

import static com.yugo.ml.perceptron.Randomizer.randomNumber;

public class PerceptronFactory {

	public static Perceptron newInstance(int theta) {

		double[] weights = new double[4];

		weights[0] = randomNumber(0, 1);
		weights[1] = randomNumber(0, 1);
		weights[2] = randomNumber(0, 1);
		weights[3] = randomNumber(0, 1);

		System.out.println("Initial weights (" + weights[0] + ", " + weights[1] + ", " + weights[2] + "), bias = " + weights[3]);

		Perceptron perceptron = new Perceptron(theta, weights);

		return perceptron;
	}
}
