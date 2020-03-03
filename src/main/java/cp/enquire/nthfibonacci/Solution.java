package cp.enquire.nthfibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This program returns nth fibonacci number in O(1) time
 * 
 * @author bipra
 *
 */
public class Solution {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			System.out.println("For n = " +i+" --fib(n)-- "+nthfib(i));
		}
	}

	//Bitnet's formula
	public static BigInteger nthfib(int n) {
		BigDecimal rootfive = new BigDecimal(Math.sqrt(5));
		BigDecimal one = new BigDecimal(1);
		BigDecimal two = new BigDecimal(2);
		return (((((one.add(rootfive)).divide(two)).pow(n)).subtract(  ((one.subtract(rootfive)).divide(two)).pow(n) )).divide(rootfive)).toBigInteger();
		/*
		 * return ((Math.pow(((one + rootfive) / two), n) - Math.pow(((one - rootfive) /
		 * two), n)) / rootfive);
		 */
	}

}
