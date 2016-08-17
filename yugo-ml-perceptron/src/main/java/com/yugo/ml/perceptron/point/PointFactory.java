package com.yugo.ml.perceptron.point;

import static com.yugo.ml.perceptron.Randomizer.randomNumber;

public class PointFactory {

	private static final int NUM_INSTANCES = 100;

	public static Point[] generateSamples() {

		Point[] samples = new Point[NUM_INSTANCES];

		/*
		 * 50 random points class 1
		 */
		for (int i = 0; i < NUM_INSTANCES / 2; i++) {

			Point p = PointFactory.getClass1();
			samples[i] = p;

			System.out.println(p);
		}

		/*
		 * 50 random points class 0
		 */
		for (int i = NUM_INSTANCES / 2; i < NUM_INSTANCES; i++) {

			Point p = PointFactory.getClass0();
			samples[i] = p;

			System.out.println(p);
		}

		return samples;
	}

	public static final Point getClass1() {

		double x = randomNumber(5, 10);
		double y = randomNumber(4, 8);
		double z = randomNumber(2, 9);

		Point p = new Point(x, y, z);
		p.setOutput(1);

		return p;
	}

	public static final Point getClass0() {

		double x = randomNumber(-1, 3);
		double y = randomNumber(-4, 2);
		double z = randomNumber(-3, 5);

		Point p = new Point(x, y, z);

		p.setOutput(0);

		return p;
	}

	public static final Point getClassX() {

		double x = randomNumber(-10, 10);
		double y = randomNumber(-10, 10);
		double z = randomNumber(-10, 10);

		return new Point(x, y, z);
	}
}
