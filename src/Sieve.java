import java.util.concurrent.TimeUnit;
public class Sieve {
	

	public static void main(String[] args) {
		long startTime, endTime, timeElapsed, avgTime;
		int trials = 50;
		avgTime = 0;
		
		for (int trialNum = 0; trialNum<trials; trialNum++) {
			startTime = System.currentTimeMillis();
			findPrimes(10000);
			endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
			avgTime += timeElapsed;
			System.out.println();
			System.out.println(trialNum + ": Execution time: " + timeElapsed + " milliseconds.");
			System.out.println();
		}
		
		avgTime = avgTime / trials;
		System.out.println("Average execution time: " + avgTime + " milliseconds.");
		

	}
	
	public static void findPrimes(int n) {
		//create boolean array 0..n, set all true
		boolean prime[] = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			prime[i] = true;
		}
		
		//iterate until the square of p is greater than n
		for(int p = 2; p*p <= n; p++) {
			//if prime[p] holds value of true, find all of its multiples
			if (prime[p]) {
				for(int i = p*p; i<=n; i += p) {
					prime[i] = false;
				}
				
			}
		}
		for (int i = 2; i<prime.length; i++) {
			if (prime[i]) {
				System.out.print(i + " ");
			}
		}
	}

}
