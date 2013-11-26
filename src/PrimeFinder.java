public class PrimeFinder {

	public PrimeFinder (){

	}

	public long find(int maxPrime)
	{
		boolean[] primes = new boolean[maxPrime];

		primes[0] = false;
		primes[1] = false;

		for (int i = 2; i < maxPrime; i++){
			primes[i] = true;
		}


		for (int j = 2; j < maxPrime; j++){
			if (primes[j]){
				for (int k = 2; k*j < maxPrime; k++){
					primes[j*k] = false;
				}
			}
		}

		return count (primes);


	}

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