package laboral;

public class Persona implements Nomina {


	public String sNombre;
	public String sDni;
	public char cLetra;

	/**
	 * 
	 * @param sNombre tipo: String
	 * @param sDni tipo: String
	 * @param cLetra tipo: Char
	 */
	public Persona(String sNombre, String sDni, char cLetra) {

		setsNombre(sNombre);
		setsDni(sDni);
		setcLetra(cLetra);

	}

	
	/**
	 * 
	 * @param sNombre tipo: String
	 * @param cLetra tipo: Char
	 */
	public Persona(String sNombre, char cLetra) {

		setsNombre(sNombre);
		setcLetra(cLetra);
	}

/**
 * 
 * @return tipo: String
 */
	public String getsNombre() {
		return this.sNombre;
	}

	/**
	 * 
	 * @param sNombre tipo: String
	 * @return Boolean
	 */
	public boolean setsNombre(String sNombre) {
		boolean bValido = false;
		if (sNombre != null && sNombre.length() >= MIN_STRING && sNombre.length() <= MAX_STRING_NOMBRE) {
			this.sNombre = sNombre;
			bValido = true;
		} else {
			this.sNombre = null;
		}
		return bValido;
	}

	
	/**
	 * 
	 * @return tipo: String
	 */
	public String getsDni() {
		return this.sDni;
	}

	
	
	/**
	 * MODIFICA EL DNI DE UNA PERSONA
	 * @param sDni tipo: String
	 * @return tipo: Boolean
	 */
	public boolean setsDni(String sDni) {
		boolean bValido = false;
		if (sDni != null && sDni.length() == 9) {
			this.sDni = sDni;
			bValido = true;
		} else {
			this.sDni = null;
		}

		return bValido;
	}

	/**
	 * 
	 * @return tipo: Char
	 */
	public char getcLetra() {
		return this.cLetra;
	}

	/**
	 * 
	 * @param cLetra tipo: Char
	 */
	public void setcLetra(char cLetra) {

		this.cLetra = cLetra;

	}

	/**
	 * 
	 * @param sDni tipo: String
	 * @return tipo: String
	 */
	public String sImprime(String sDni) {
		return "  --Nombre: " + this.sNombre + "  --Dni: " + this.sDni;
	}

}
