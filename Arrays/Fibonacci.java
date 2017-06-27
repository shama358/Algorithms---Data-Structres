/* In mathematics, the Fibonacci numbers or Fibonacci series or Fibonacci sequence 
are the numbers in the following integer sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 
34, 55, 89, 144... By definition, the first two numbers in the Fibonacci 
sequence are 0 and 1, and each subsequent number is the sum of the previous two.
Below example shows how to create fibonacci series. 
*/

//Generate Fibonacci upto N numbers

public class Fibonacci {
	public int[] fibo (int N) {
		int[] fibo = new int[N];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < N; ++i) {
			fibo[i] = fibo[i - 2] + fibo[1 - 1];
		}
		return fibo;
	}
}