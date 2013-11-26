import java.util.ArrayList;


public class PrimeFinder {


	public PrimeFinder (){

	}

	public boolean[] find(int maxPrime)
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

		return primes;

	}

	public static void main(String[] args) {
		PrimeFinder pf = new PrimeFinder();
		boolean[] primes = pf.find(2000000);
		
		long sum = 0;
		
		for (int i = 0; i < 2000000; i ++){
			if (primes[i]){
				sum += i;
			}
		}
		
		System.out.println(sum);
		
	}
}