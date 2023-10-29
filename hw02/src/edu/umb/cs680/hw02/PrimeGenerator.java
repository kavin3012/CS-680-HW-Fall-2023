package edu.umb.cs680.hw02;


import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGenerator {
    private static PrimeGenerator singleton;
	protected long from, to;
	protected LinkedList<Long> primes = new LinkedList<Long>();

	private PrimeGenerator(){
	}

    public static PrimeGenerator getInstance() {
        if (singleton == null) { 
            singleton = new PrimeGenerator();
        }
        return singleton;
    }

    private void setLimits(long from, long to) {
        if(from >= 1 && to > from){
			this.from = from;
			this.to = to;
		}else{
			throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
		}
    }
	
	public LinkedList<Long> getPrimes(){ 
        
        return primes; 
    }
	
	protected boolean isEven(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}
	
	protected boolean isPrime(long n){
		// 1 or lower numbers are not prime. 
		if(n <= 1){ return false; }
		// Even numbers are not prime, except for 2.  
		if( n > 2 && isEven(n) ){ return false; }
		long i;
		// Find a number "i" that can divide "n" 
        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
        // If such a number "i" is found, n is not prime. Otherwise, n is prime. 
        if (i == 1){ return true; }
        else{ return false; }
	}

	public void generatePrimes(long from, long to){
        this.primes.clear();
        setLimits(from, to);
		for (long n = from; n <= to; n++) {
			if( isPrime(n) ){ primes.add(n); }
        }
	}
	
}
