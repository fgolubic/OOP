/**
 * 
 */
package hr.fer.oop.lab4.prob2;

import java.util.Arrays;


import hr.fer.oop.lab4.data.prob1.Ispitivac;

/**
 * @author Filip
 *
 */
public class SimpleHashtable<K,V> {

	private static class TableEntry<K,V> {
		private  K key;
		private  V value;
		private TableEntry<K,V> next;
		

		/**
		 * Constructor
		 * @param key
		 * @param value
		 */
		public TableEntry(K key, V value,TableEntry<K,V> tableEntry) {
			super();
			this.key = key;
			this.value = value;

			if(tableEntry!=null){
				this.next=tableEntry;
			}
			else{
				this.next=null;
			}
		}

		/**
		 * Getter
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * Getter
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * Setter
		 * @param value the value to set
		 */
		public void setValue(V value) {
			this.value = value;
		}


		@Override
		public String toString() {
			return "TableEntry [key=" + key + ", value=" + value + "]";
		}
	}

	private static  int size;
	private  TableEntry<K, V>[] table;


	/**
	 * Constructor for SimpleHashtable
	 * 
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashtable() {
		size=16;
		this.table= new TableEntry[size];
	}

	/**
	 * Constructor for SimpleHashTable
	 * Size is set to the closest pow of 2 number from given number
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashtable(int size){
		int lower=0 ;
		int higher=0;

		for(int i=1;i<=size;i++){
			if(isPower(i)){
				lower=i;
			}
		}

		int i=0;
		while(higher==0){
			i++;
			if(isPower(size+i)){
				higher=size+i;
			}
		}

		if(higher-size<size-lower){
			SimpleHashtable.size=higher;
		}
		else{
			SimpleHashtable.size=lower;
		}
		this.table= new TableEntry[SimpleHashtable.size];

	}

	/**Checks if number is power of 2
	 * @param number
	 * @return true/false
	 */
	private boolean isPower(int number) {
		while(number>1){
			if(number%2!=0){
				return false;
			}
			number/=2;
		}
		return true;
	}


	/**
	 * Getter
	 * @return the size
	 */
	public static int getSize() {
		return size;
	}

	/**
	 * Setter
	 * @param size the size to set
	 */
	public static void setSize(int size) {
		SimpleHashtable.size = size;
	}

	/**
	 * Associates the specified value with the specified key in this map.
	 * @param key
	 * @param value
	 */
	public void put(K key, V value){
		int hash=Math.abs(key.hashCode())%SimpleHashtable.getSize();

		if(this.containsKey(key)){
			TableEntry<K,V> temp=table[hash];
			while(!temp.key.equals(key)){
				temp=temp.next;
			}
			temp.setValue(value);
		}
		else{

			this.table[hash]=new TableEntry<K, V>(key, value, this.table[hash]);
		}

	}

	/**
	 * Getter
	 * @return the table
	 */
	public TableEntry<K, V>[] getTable() {
		return table;
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
	 * @param key
	 * @return value
	 */
	public V get(K key){
		if(key==null){
			return null;
		}
		else if(this.containsKey(key)){
			for(int i=0;i<SimpleHashtable.getSize();i++){
				TableEntry<K,V> temp=table[i];
				while(temp!=null){
					if(temp.getKey().equals(key)){
						return temp.getValue();
					}
					temp=temp.next;
				}
			}
		}
		return null;
	}


	/**
	 * Checks if given key already exists in Hashtable
	 * @param key
	 * @return true/false
	 */
	public boolean containsKey(K key) {
		if(key==null){
			return false;
		}
		for(int i=0;i<SimpleHashtable.getSize();i++){
			TableEntry<K,V> temp=table[i];
			while(temp!=null){
				if(temp.getKey().equals(key)){
					return true;
				}
				temp=temp.next;
			}
		}

		return false;
	}

	/**
	 * 
	 * @return number of key-value pairs in map
	 */
	public int size(){
		int counter=0;

		for(int i=0;i<SimpleHashtable.getSize();i++){
			TableEntry<K,V> temp=table[i];
			while(temp!=null){
				counter++;
				temp=temp.next;
			}
		}
		return counter;
	}


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * @param value
	 * @return
	 */
	public boolean containsValue(V value){

		if(value==null){
			return false;
		}
		for(int i=0;i<SimpleHashtable.getSize();i++){
			TableEntry<K,V> temp=table[i];
			while(temp!=null){

				if(temp.value.equals(value)){
					return true;
				}
				temp=temp.next;
			}
		}
		return false;
	}

	/**
	 * Removes the mapping for the specified key from this map if present.
	 * @param key
	 */
	public void remove(K key){
		if(!this.containsKey(key) || key==null){
			return;
		}
		TableEntry<K,V> temp;
		TableEntry<K,V> temp2;
		temp=table[Math.abs(key.hashCode()%size)];
		if(temp==null){
			return;
		}
		if(temp.getKey().equals(key)){
			table[Math.abs(key.hashCode()%size)]=temp.next;
			return;
		}
		
		temp2=temp.next;
		while(!temp2.getKey().equals(key)){

			temp=temp.next;
			temp2=temp2.next;
			
		}
		temp.next=temp2.next;

	}

	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return
	 */
	public boolean isEmpty(){
		for(int i=0;i<SimpleHashtable.getSize();i++){
			if(table[i]!=null){
				return false;
			}
		}
		return true;
	}

	public void removeIfValue(Ispitivac<V> ispitivac){
		TableEntry<K,V> temp;

		for(int i=0;i<size;i++){
			temp=table[i];
			while(temp!=null){
				if(ispitivac.prolazi(temp.getValue())){
					remove(temp.key);
				}
				temp=temp.next;
			}

		}
	}


	@Override
	public String toString() {
		return "SimpleHashtable [table=" + Arrays.toString(table) + "]";
	}

	/**
	 * 
	 */
	public void print() {
		TableEntry<K,V> temp;
		
		for(int i=0;i<size;i++){
			temp=table[i];
			while(temp!=null){
				System.out.println(temp.getKey() +  " " + temp.getValue());
				temp=temp.next;
			}
		}
	}


}
