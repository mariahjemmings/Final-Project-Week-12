

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;


public class TestDemo {
	
	public int addPositive(int a, int b) {
		
		if (a < 0 && b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");}
		
		else {
			return a+b;
		
		}
	}
	
	public int randomNumberSquared() {
				
		TestDemo tdemo = new TestDemo();
		
		return (int)Math.pow(getRandomInt(),2);
	}
	
	protected int getRandomInt() {
		
			  Random random = new Random();
			 return (random.nextInt(10) + 1);
	
	}
	



}
