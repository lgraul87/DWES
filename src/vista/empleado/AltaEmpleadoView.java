package vista.empleado;

import controlador.database.GeneralController;
import lib.L;


public class AltaEmpleadoView {

	public static void seleccionOperaciones(GeneralController controlGeneral) {
		byte bOption;
		do {
			bOption = (byte) L.valida(""
					//
					+ "*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n					OPERACIONES DE EMPLEADOS"
					//
					+ "\n*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n"
					//
					+ "\n  --Empleado (Aniadir nuevo): 	(1)"
					//
					+ "\n  --Empleado (Mostrar Datos): 	(1)"
					//
					+ "\n  --Empleado (Modificar Datos): 	(1)"
					//
					+ "\n  --Empleado (Actualizar sueldo): 	(1)"
					//
					+ "\n  --Salir: (5)", 1, 5, 3);
			//

			if (bOption == 1) {
				addEmployee(controlGeneral);
			} else if (bOption == 2) {
				checkEmployee(controlGeneral);
			} else if (bOption == 3) {
				editEmployee(controlGeneral);
			} else if (bOption == 4) {
				upDateEmployee(controlGeneral);
			}
		} while (bOption != 5);
	}

	private static void upDateEmployee(GeneralController controlGeneral) {
		// TODO Auto-generated method stub
		
	}

	private static void editEmployee(GeneralController controlGeneral) {
		// TODO Auto-generated method stub
		
	}

	private static void checkEmployee(GeneralController controlGeneral) {
		// TODO Auto-generated method stub
		
	}

	private static void addEmployee(GeneralController controlGeneral) {
		// TODO Auto-generated method stub
		
	}

}
