public class PrimeFinder {

	public PrimeFinder (){

	}

	/**
	 * Uses the Sieve of Eratosthenes to find all primes
	 * between 0 and a specified maximum value.
	 * 
	 * @param maxPrime Range 0 - maxPrime
	 * @return The number of primes in range 0 - maxPrime
	 */
	public long find(int maxPrime)
	{
		boolean[] primes = new boolean[maxPrime];

		// We know 0 and 1 are not prime.
		primes[0] = false;
		primes[1] = false;

		// Set all the values to true.
		for (int i = 2; i < maxPrime; i++){
			primes[i] = true;
		}

		// Loop through the array.
		for (int j = 2; j < maxPrime; j++){
			// If prime[j] is set to true (i.e., is prime)
			if (primes[j]){
				// For all multiples of prime[j] that are less than our max value, set them to false.
				for (int k = 2; k*j < maxPrime; k++){
					primes[j*k] = false;
				}
			}
		}

		return count (primes);
	}

	/**
	 * Reads an array and counts all of the true values.
	 * 
	 * @param primes The boolean array you want to count true values of.
	 * @return The number of true values in that array.
	 */
	public long count (boolean[] primes){
		long sum = 0;

		for (int i = 0; i < primes.length; i ++){
			if (primes[i]){
				sum += i;
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		PrimeFinder pf = new PrimeFinder();		

		System.out.println(pf.find(2000000));

	}
}