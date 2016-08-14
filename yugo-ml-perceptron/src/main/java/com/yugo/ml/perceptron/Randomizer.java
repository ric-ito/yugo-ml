package com.yugo.ml.perceptron;

public class Randomizer {

	public static final double randomNumber(int min, int max){
		
		double d = min + Math.random() * (max - min);
		
		return d;
	}
}
