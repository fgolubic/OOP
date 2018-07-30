/**
 * 
 */
package hr.fer.oop.lab5.second;

/**
 * @author Filip
 *
 */
public class Artikl {

	private String naziv;
	private String cijena;
	private Integer prodanoKomada;

	/**
	 * Constructor using:
	 * naziv
	 * cijena
	 */
	public Artikl(String naziv, String cijena, int prodanoKomada) {
		this.naziv=naziv;
		this.cijena=cijena;
		this.prodanoKomada=prodanoKomada;
	}

	/**
	 * Getter
	 * @return the prodanoKomada
	 */
	public Integer getProdanoKomada() {
		return prodanoKomada;
	}

	/**
	 * Setter
	 * @param prodanoKomada the prodanoKomada to set
	 */
	public void setProdanoKomada(Integer prodanoKomada) {
		this.prodanoKomada = prodanoKomada;
	}

	/**
	 * Getter
	 * @return  naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Getter
	 * @return  cijena
	 */
	public String getCijena() {
		return cijena;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "naziv:" + naziv + ", prodanoKomada:" + prodanoKomada + "";
	}



	






}
