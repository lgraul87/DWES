package laboral;

public class Empleado extends Persona {

	

	private byte bCategoria;
	private byte bAnyosTrabajados;

	/**
	 * 
	 * @param sNombre tipo: String
	 * @param sDni tipo: String
	 * @param cLetra tipo: Char
	 */
	public Empleado(String sNombre, String sDni, char cLetra) {
		super(sNombre, sDni, cLetra);
		this.bCategoria = MIN_CATEGORIA;
		this.bAnyosTrabajados = SIN_EXP;
	}

	
	/**
	 * 
	 * @param sNombre tipo: String
	 * @param sDni tipo: String
	 * @param cLetra tipo: Char
	 * @param bAnyosTrabajados tipo: Byte
	 * @param bCategoria tipo: Byte
	 */
	public Empleado(String sNombre, String sDni, char cLetra, byte bAnyosTrabajados, byte bCategoria) {
		super(sNombre, sDni, cLetra);
		setbCategoria(bCategoria);
		setbAnyosTrabajados(bAnyosTrabajados);
	}

	/**
	 * 
	 * @return tipo: Byte
	 */
	public byte getbCategoria() {
		return this.bCategoria;
	}

	/**
	 * 
	 * @param bCategoria tipo: Byte
	 * @return tipo: Boolean
	 */
	public boolean setbCategoria(byte bCategoria) {
		boolean bValido = false;

		if (bCategoria >= MIN_CATEGORIA && bCategoria <= MAX_CATEGORIA) {

			this.bCategoria = bCategoria;
			bValido = true;

		} else {
			this.bCategoria = -1;
		}

		return bValido;

	}

	/**
	 * 
	 * @return tipo: Byte
	 */
	public byte getbAnyosTrabajados() {
		return this.bAnyosTrabajados;
	}

	/**
	 * 
	 * @param bAnyosTrabajados tipo: Byte
	 * @return tipo: Boolean
	 */
	public boolean setbAnyosTrabajados(byte bAnyosTrabajados) {
		boolean bValido = false;

		if (bAnyosTrabajados >= MIN_ANIOSTRABAJADOS && bCategoria <= MAX_ANIOSTRABAJADOS) {

			this.bAnyosTrabajados = bAnyosTrabajados;
			bValido = true;

		} else {
			this.bAnyosTrabajados = -1;
		}

		return bValido;

	}

	/**
	 * 
	 * @return tipo: Boolean
	 */
	public boolean incrAnyo() {
		boolean bValido = false;

		if (this.bAnyosTrabajados >= MIN_ANIOSTRABAJADOS && this.bAnyosTrabajados < MAX_ANIOSTRABAJADOS) {
			this.bAnyosTrabajados = (byte) (this.bAnyosTrabajados + MIN_ANIOSTRABAJADOS);
			bValido = true;
		}

		return bValido;
	}

	/**
	 * 
	 * @param oEmpleado tipo: Empleado (Objeto)
	 * @return tipo: String
	 */
	public String imprimeEmpleado(Empleado oEmpleado) {

		return "##############################################################" + "\n  --Empleado: \n"
				+ Empleado.super.sImprime(super.sDni)
				//
				+ "\n  --Sexo: " + super.cLetra
				//
				+ "\n  --Categoria: " + this.bCategoria
				//
				+ "\n  --Anyos trabajados: " + this.bAnyosTrabajados;
	}

	/**
	 * 
	 * @param oEmpleado tipo: Empleado (Objeto)
	 * @return tipo: Float
	 */
	public float sueldo(Empleado oEmpleado) {
		float fSueldo = -1;
		byte bCategoria = oEmpleado.getbCategoria();
		if (bCategoria == -1) {
			bCategoria = 1;
		}
		byte bAnyosTrabajados = oEmpleado.getbAnyosTrabajados();

		if (bAnyosTrabajados == -1) {
			bAnyosTrabajados = 0;
		}
		fSueldo = (float) SUELDO_BASE[bCategoria - 1] + (float) INCENTIVO_ANYO * bAnyosTrabajados;

		return fSueldo;
	}
}
