/**
 * 
 */
package hr.fer.oop.lab6.first;

import hr.fer.oop.lab6.first.Uvjeti.PaymentMethod;

/**
 * @author Filip
 *
 */
public class TaxiRecord {

	private String medallion;	
	private String hack_license	;
	private String pickup_datetime	 ;
	private String dropoff_datetime	;
	private String trip_time_in_secs;	
	private String trip_distance	;
	private String pickup_longitude	;
	private String pickup_latitude	;
	private String dropoff_longitude;	
	private String dropoff_latitude	;
	private PaymentMethod payment_type	;
	private String fare_amount;
	private String surcharge	;
	private String mta_tax;
	private String tip_amount;	
	private String tolls_amount;
	private String total_amount;
	
	
	/**
	 * Constructor using:
	 * @param medallion
	 * @param hack_license
	 * @param pickup_datetime
	 * @param dropoff_datetime
	 * @param trip_time_in_secs
	 * @param trip_distance
	 * @param pickup_longitude
	 * @param pickup_latitude
	 * @param dropoff_longitude
	 * @param dropoff_latitude
	 * @param payment_type
	 * @param fare_amount
	 * @param surcharge
	 * @param mta_tax
	 * @param tip_amount
	 * @param tolls_amount
	 * @param total_amount
	 */
	public TaxiRecord(String line) {
		
		String[] info=line.split(",");
		
		this.medallion=info[0];
		this.hack_license =info[1];
		this.pickup_datetime =info[2];
		this.dropoff_datetime =info[3];
		this.trip_time_in_secs = info[4];
		this.trip_distance = info[5];
		this.pickup_longitude =info[6];
		this.pickup_latitude =info[7];
		this.dropoff_longitude =info[8];
		this.dropoff_latitude = info[9];
		this.fare_amount = info[11];
		this.surcharge =info[12];
		this.mta_tax =info[13];
		this.tip_amount =info[14];
		this.tolls_amount =info[15];
		this.total_amount =info[16];
		
		if(info[10].equals("CSH")){
			this.payment_type =PaymentMethod.CSH;
			
		}
		else if(info[10].equals("CRD")){
			this.payment_type=PaymentMethod.CRD;
			
		}
		else if(info[10].equals("UNK")){
			this.payment_type=PaymentMethod.UNK;
		}
	}


	/**
	 * Getter
	 * @return the medallion
	 */
	public String getMedallion() {
		return medallion;
	}


	/**
	 * Getter
	 * @return the hack_license
	 */
	public String getHack_license() {
		return hack_license;
	}


	/**
	 * Getter
	 * @return the pickup_datetime
	 */
	public String getPickup_datetime() {
		return pickup_datetime;
	}


	/**
	 * Getter
	 * @return the dropoff_datetime
	 */
	public String getDropoff_datetime() {
		return dropoff_datetime;
	}


	/**
	 * Getter
	 * @return the trip_time_in_secs
	 */
	public String getTrip_time_in_secs() {
		return trip_time_in_secs;
	}


	/**
	 * Getter
	 * @return the trip_distance
	 */
	public String getTrip_distance() {
		return trip_distance;
	}


	/**
	 * Getter
	 * @return the pickup_longitude
	 */
	public String getPickup_longitude() {
		return pickup_longitude;
	}


	/**
	 * Getter
	 * @return the pickup_latitude
	 */
	public String getPickup_latitude() {
		return pickup_latitude;
	}


	/**
	 * Getter
	 * @return the dropoff_longitude
	 */
	public String getDropoff_longitude() {
		return dropoff_longitude;
	}


	/**
	 * Getter
	 * @return the dropoff_latitude
	 */
	public String getDropoff_latitude() {
		return dropoff_latitude;
	}


	/**
	 * Getter
	 * @return the payment_type
	 */
	public PaymentMethod getPayment_type() {
		return payment_type;
	}


	/**
	 * Getter
	 * @return the fare_amount
	 */
	public String getFare_amount() {
		return fare_amount;
	}


	/**
	 * Getter
	 * @return the surcharge
	 */
	public String getSurcharge() {
		return surcharge;
	}


	/**
	 * Getter
	 * @return the mta_tax
	 */
	public String getMta_tax() {
		return mta_tax;
	}


	/**
	 * Getter
	 * @return the tip_amount
	 */
	public String getTip_amount() {
		return tip_amount;
	}


	/**
	 * Getter
	 * @return the tolls_amount
	 */
	public String getTolls_amount() {
		return tolls_amount;
	}


	/**
	 * Getter
	 * @return the total_amount
	 */
	public String getTotal_amount() {
		return total_amount;
	}
	
	

}
