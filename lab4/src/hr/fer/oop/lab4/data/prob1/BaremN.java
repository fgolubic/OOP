/**
 * 
 */
package hr.fer.oop.lab4.data.prob1;

/**
 * @author Filip
 * @param <K>
 *
 * 
 *
 */
public class BaremN implements Ispitivac<Integer> {
	private int N;
	
	/**
	 * @param n
	 */
	public BaremN(int n) {
		super();
		N = n;
	}

	@Override
	public boolean prolazi(Integer data) {
		if(data>=N)return true;
		return false;
	}
	
}
