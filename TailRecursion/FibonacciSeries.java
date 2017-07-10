/* Fibonacci series upto a given N */


public class Fibonacci {		
	public int[] fibo(int N) {
		int[] arr = new int[N];
		// the first 2 elements are alwasy 0 and 1.
		arr[0] = 0;
		arr[1] = 1;
		return fiboRec(arr, N - 2,1,0); 
		//N - 2 as the calculation is going to start from index 3
	}
	private int[] fiboRec(int[] arr, int N, int Idx, int prevIdx) {
		if (N == 0) {
			return arr;
		}
		int currIdx = Idx + 1;
		//adding the previous 2 elements to get the current element.
		arr[currIdx] = arr[Idx] + arr[prevIdx];
		return fiboRec(arr, --N, currIdx, Idx);
	}
}