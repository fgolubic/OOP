/**
 * 
 */
package hr.fer.oop.lab6.first;

/**
 * @author Filip
 *
 */
public class Uvjeti {
	private boolean skip,leave, pFilter,distLimit;
	private int skipN,leaveN;
	private double distLimitValue;
	private String  distLimitMod;
	private PaymentMethod pType;
	
	
	public static enum PaymentMethod{
		CRD,UNK,CSH;
	}
	/**
	 * Getter
	 * @return the skip
	 */
	public boolean isSkip() {
		return skip;
	}

	/**
	 * Setter
	 * @param skip the skip to set
	 */
	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	/**
	 * Getter
	 * @return the leave
	 */
	public boolean isLeave() {
		return leave;
	}

	/**
	 * Setter
	 * @param leave the leave to set
	 */
	public void setLeave(boolean leave) {
		this.leave = leave;
	}

	/**
	 * Getter
	 * @return the pFilter
	 */
	public boolean ispFilter() {
		return pFilter;
	}

	/**
	 * Setter
	 * @param pFilter the pFilter to set
	 */
	public void setpFilter(boolean pFilter) {
		this.pFilter = pFilter;
	}

	/**
	 * Getter
	 * @return the distLimit
	 */
	public boolean isDistLimit() {
		return distLimit;
	}

	/**
	 * Setter
	 * @param distLimit the distLimit to set
	 */
	public void setDistLimit(boolean distLimit) {
		this.distLimit = distLimit;
	}

	/**
	 * Getter
	 * @return the skipN
	 */
	public int getSkipN() {
		return skipN;
	}

	/**
	 * Setter
	 * @param skipN the skipN to set
	 */
	public void setSkipN(int skipN) {
		this.skipN = skipN;
	}

	/**
	 * Getter
	 * @return the leaveN
	 */
	public int getLeaveN() {
		return leaveN;
	}

	/**
	 * Setter
	 * @param leaveN the leaveN to set
	 */
	public void setLeaveN(int leaveN) {
		this.leaveN = leaveN;
	}

	/**
	 * Getter
	 * @return the pType
	 */
	public PaymentMethod getpType() {
		return pType;
	}

	/**
	 * Setter
	 * @param pType the pType to set
	 */
	public void setpType(PaymentMethod pType) {
		this.pType = pType;
	}

	/**
	 * Getter
	 * @return the distLimitMod
	 */
	public String getDistLimitMod() {
		return distLimitMod;
	}

	/**
	 * Setter
	 * @param distLimitMod the distLimitMod to set
	 */
	public void setDistLimitMod(String distLimitMod) {
		this.distLimitMod = distLimitMod;
	}

	/**
	 * Getter
	 * @return the distLimitValue
	 */
	public double getDistLimitValue() {
		return distLimitValue;
	}

	/**
	 * Setter
	 * @param distLimitValue the distLimitValue to set
	 */
	public void setDistLimitValue(double distLimitValue) {
		this.distLimitValue = distLimitValue;
	}

}
