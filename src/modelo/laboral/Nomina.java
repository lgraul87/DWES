package modelo.laboral;

public class Nomina implements INomina {
	
	/**
	 * 
	 * @param oEmpleado tipo: Empleado (Objeto)
	 * @return tipo: Float
	 */
	public static float sueldo(Empleado oEmpleado) {
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
