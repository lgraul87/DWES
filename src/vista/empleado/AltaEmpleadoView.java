package vista.empleado;

import controlador.database.GeneralController;
import laboral.Empleado;
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

	private static void addEmployee(GeneralController controlGeneral) {
		byte bOption;
		do {
			bOption = (byte) L.valida(""
					//
					+ "*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n					Seleccione tipo (Empleado)"
					//
					+ "\n*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n"
					//
					+ "\n  --Empleado (Sin experiencia y categoria 1): 	(1)"
					//
					+ "\n  --Empleado (Con Experiencia): 	(2)"
					//
					+ "\n  --Salir: (3)", 1, 3, 3);
			//

			if (bOption == 1) {
				addEmployeeNE(controlGeneral);
			} else if (bOption == 2) {
				addEmployeeE(controlGeneral);
			}
		} while (bOption != 3);
	}

	private static void addEmployeeE(GeneralController controlGeneral) {
		byte bAnios;
		byte bCategoria;
		char cLetra = 0;

		String sNombreEmpleado = L.leer("Nombre (Empleado 1): ");

		String sDniEmpleado = L.leer("Dni (Empleado 1): ");

		byte bOption = (byte) L.valida("Sexo: \nVaron: (1)\nMujer: (2)", 1, 2, 3);

		if (bOption == 1) {
			cLetra = 'H';
		} else if (bOption == 2) {
			cLetra = 'M';
		}

		boolean bError = true;
		do {
			try {
				bAnios = Byte.parseByte(L.leer("Introduzca Anios (1 a 80): "));
				if (bAnios >= 1 && bAnios <= 80) {
					bError = false;
				}

			} catch (NumberFormatException e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bAnios = 0;
				bError = false;
			} catch (Exception e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bAnios = 0;
				bError = false;
			}

		} while (bError);

		bError = true;
		do {
			try {
				bCategoria = Byte.parseByte(L.leer("Introduzca Categoria (1 a 10): "));
				if (bCategoria >= 1 && bCategoria <= 10) {
					bError = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bCategoria = 0;
				bError = false;
			} catch (Exception e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bCategoria = 0;
				bError = false;
			}

		} while (bError);

		Empleado oEmpleado = new Empleado(sNombreEmpleado, sDniEmpleado, cLetra, bAnios, bCategoria);

		controlGeneral.getEmpleadoController().addEmployeeE(oEmpleado);
	}

	private static void addEmployeeNE(GeneralController controlGeneral) {

		char cLetra = 0;

		String sNombreEmpleado = L.leer("Nombre (Empleado 2): ");

		String sDniEmpleado = L.leer("Dni (Empleado 1): ");

		byte bOption = (byte) L.valida("Sexo: \nVaron: (1)\nMujer: (2)", 1, 2, 3);

		if (bOption == 1) {
			cLetra = 'H';
		} else if (bOption == 2) {
			cLetra = 'M';
		}

		Empleado oEmpleado = new Empleado(sNombreEmpleado, sDniEmpleado, cLetra);
		controlGeneral.getEmpleadoController().addEmployeeNE(oEmpleado);

	}

	private static void checkEmployee(GeneralController controlGeneral) {
		byte bOption;
		do {
			bOption = (byte) L.valida(""
					//
					+ "*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n					Mostrar (Empleado)"
					//
					+ "\n*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n"
					//
					+ "\n  --Empleado (Busqueda por DNI): 	(1)"
					//
					+ "\n  --Empleados (Todos): 	(2)"
					//
					+ "\n  --Salir: (3)", 1, 3, 3);
			//

			if (bOption == 1) {
				showEmployee(controlGeneral);
			} else if (bOption == 2) {
				showAll(controlGeneral);
			}
		} while (bOption != 3);
	}

	private static void showAll(GeneralController controlGeneral) {
		controlGeneral.getEmpleadoController().showAll();
	}

	private static void showEmployee(GeneralController controlGeneral) {
		String sDni = L.leer("DNI (Empleado):	");

		Empleado oEmpleado = new Empleado(sDni);

		controlGeneral.getEmpleadoController().showEmployee(oEmpleado);

	}

	private static void editEmployee(GeneralController controlGeneral) {
		String sDni = L.leer("DNI (Empleado a modificar):	");

		Empleado oEmpleado = new Empleado(sDni);

		byte bAnios;
		byte bCategoria;
		char cLetra = 0;

		String sNombreEmpleado = L.leer("Nuevo Nombre (Empleado): ");

		String sDniEmpleado = L.leer("Nuevo Dni (Empleado): ");

		byte bOption = (byte) L.valida("Nuevo sexo: \nVaron: (1)\nMujer: (2)", 1, 2, 3);

		if (bOption == 1) {
			cLetra = 'H';
		} else if (bOption == 2) {
			cLetra = 'M';
		}

		boolean bError = true;
		do {
			try {
				bAnios = Byte.parseByte(L.leer("Introduzca Anios (1 a 80): "));
				if (bAnios >= 1 && bAnios <= 80) {
					bError = false;
				}

			} catch (NumberFormatException e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bAnios = 0;
				bError = false;
			} catch (Exception e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bAnios = 0;
				bError = false;
			}

		} while (bError);

		bError = true;
		do {
			try {
				bCategoria = Byte.parseByte(L.leer("Nueva categoria (1 a 10): "));
				if (bCategoria >= 1 && bCategoria <= 10) {
					bError = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bCategoria = 0;
				bError = false;
			} catch (Exception e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bCategoria = 0;
				bError = false;
			}

		} while (bError);

		Empleado oEmpleadoModificado = new Empleado(sNombreEmpleado, sDniEmpleado, cLetra, bAnios, bCategoria);

		controlGeneral.getEmpleadoController().editEmployee(oEmpleado, oEmpleadoModificado);
	}

	private static void upDateEmployee(GeneralController controlGeneral) {
		byte bOption;
		do {
			bOption = (byte) L.valida(""
					//
					+ "*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n					Actualizar Sueldo (Empleado)"
					//
					+ "\n*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
					//
					+ "\n"
					//
					+ "\n  --Empleado (Actualizar): 	(1)"
					//
					+ "\n  --Empleados (Actualizar todos): 	(2)"
					//
					+ "\n  --Salir: (3)", 1, 3, 3);
			//

			if (bOption == 1) {
				upDateSalary(controlGeneral);
			} else if (bOption == 2) {
				upDateSalaryAll(controlGeneral);
			}
		} while (bOption != 3);
	}

	private static void upDateSalaryAll(GeneralController controlGeneral) {
		controlGeneral.getEmpleadoController().upDateSalaryAll();
	}

	private static void upDateSalary(GeneralController controlGeneral) {

		byte bCategoria;
		byte bAnios;

		String sDni = L.leer("DNI (Empleado a modificar su categoria y anios):	");

		boolean bError = true;
		do {

			try {
				bCategoria = Byte.parseByte(L.leer("Introduzca Categoria (1 a 10): "));
				if (bCategoria >= 1 && bCategoria <= 10) {
					bError = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bCategoria = 0;
				bError = false;
			} catch (Exception e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bCategoria = 0;
				bError = false;
			}

		} while (bError);

		bError = true;
		do {

			try {
				bAnios = Byte.parseByte(L.leer("Introduzca Anios (1 a 80): "));
				if (bAnios >= 1 && bAnios <= 80) {
					bError = false;
				}

			} catch (NumberFormatException e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bAnios = 0;
				bError = false;
			} catch (Exception e) {
				System.out.println("  \n**  **  **  Datos no correctos  **  **  ** \n");
				bAnios = 0;
				bError = false;
			}

		} while (bError);

		Empleado oEmpleado = new Empleado(sDni);

		Empleado oEmpleadoEncontrado = controlGeneral.getEmpleadoController().bringEmployee(oEmpleado);

		String sNombre = oEmpleadoEncontrado.getsNombre();
		String sDniEncontrado = oEmpleadoEncontrado.getsDni();
		char cLetra = oEmpleadoEncontrado.getcLetra();
		byte bAnyosTrabajados = oEmpleadoEncontrado.getbAnyosTrabajados();
		Empleado oEmpleadoEditado = new Empleado(sNombre, sDniEncontrado, cLetra, bAnyosTrabajados, bCategoria);

		controlGeneral.getEmpleadoController().upDateSalary(oEmpleado, oEmpleadoEditado);

	}
}
