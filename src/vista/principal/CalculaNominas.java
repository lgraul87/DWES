package vista.principal;

import controlador.database.GeneralController;
import lib.L;
import vista.empleado.AltaEmpleadoView;
import modelo.laboral.Empleado;
import modelo.laboral.Nomina;


public class CalculaNominas {
	public static GeneralController controlGeneral = new GeneralController("nomina");

	public static void main(String[] args) {
		/*
		 * Se desea desarrollar una aplicaci�n en Java para controlar las n�minas de los
		 * empleados de una empresa. Para ello, debes realizar los siguientes apartados
		 * (en principio, no se suponen errores en los datos de entrada): 1. Definir la
		 * clase p�blica Persona que pertenece al paquete Laboral. 1.1. Los atributos
		 * que definen una Persona son: un nombre (cadena), un dni (cadena) y un sexo
		 * (car�cter). Los atributos son p�blicos. 1.2. La clase tiene dos
		 * constructores, uno con los tres atributos de la Persona, y otro con s�lo el
		 * nombre y el sexo. 1.3.
		 * 
		 * 
		 * Tendr� dos m�todos p�blicos: 1.3.1. setDni para modificar el valor del dni de
		 * una persona. 1.3.2. Imprime que presenta por pantalla el nombre y el dni.
		 * 
		 * 
		 * 2. Definir la clase Empleado que extiende a Persona y que tiene: 2.1. Dos
		 * nuevos atributos: categoria (atributo privado) debe ser una valor positivo
		 * entre 1 y 10; y a�os (anyos) trabajados (atributo p�blico) que debe ser
		 * positivo.
		 * 
		 */

		/*
		 * 2.2. Dos constructores: uno que recibe todos los valores de sus atributos y
		 * otro que solo recibe el nombre, sexo y dni. En este caso, se entiende que la
		 * categor�a es 1 y el n�mero de a�os trabajados es 0. 2.3.
		 * 
		 * 
		 * 
		 * 
		 * Los siguientes m�todos p�blicos: 2.3.1. setCategoria que sirve para cambiar
		 * de categor�a de un empleado, que recibe como par�metro de entrada. 2.3.2.
		 * getCategoria que devuelve el valor del atributo categoria. 2.3.3. incrAnyo
		 * que incrementa en uno el n�mero de a�os trabajados.
		 * 
		 * 
		 * 2.3.4. imprime que presenta todos los datos del empleado. 3. La siguiente
		 * tabla contiene los sueldos base de cada Empleado, de acuerdo con su
		 * categor�a. Siendo 50000 para la categor�a 1 e increment�ndose en 20000 para
		 * cada nueva categor�a. Esta tabla debe definirse en una nueva clase de nombre
		 * Nomina: private static final int SUELDO_BASE[] = {50000, 70000, 90000,
		 * 110000, 130000, 150000, 170000, 190000, 210000, 230000} 3.1. La clase es una
		 * biblioteca y tiene un m�todo sueldo que recibe un Empleado y devuelve su
		 * sueldo obtenido como resultado de evaluar la expresi�n: sueldo = sueldoBase +
		 * 5000*a�os trabajados 4. Crear la clase CalculaNominas con un programa
		 * principal que:
		 * 
		 */
		/**
		 * #################################################3
		 */

		/*
		 * 4.1. Cree el empleado: �James Cosling�, dni=32000032G, sexo=�M�, categor�a=4,
		 * a�os=7 4.2. Cree el empleado: �Ada Lovelace�, dni=32000031R, sexo=�F� 4.3.
		 * Declare un m�todo privado escribe que reciba los valores de los dos empleados
		 * e imprima sus atributos y el sueldo que cada uno gana. 4.4. Haga una llamada
		 * en el programa principal a ese m�todo. 4.5.
		 * 
		 * 
		 * Incremente los a�os trabajados del segundo empleado y haga que la categor�a
		 * del primero sea 9. 4.6. Imprima de nuevo ambos empleados y su sueldo. 5.
		 * 
		 * 
		 * Modificar el c�digo para comprobar que los datos que se pasan son correctos
		 * cuando se crea un nuevo Empleado y en caso contrario se eleve la excepci�n
		 * DatosNoCorrectosException. Declara un manejador de excepciones que cuando se
		 * produzca dicha excepci�n, emita el mensaje �Datos no correctos�, y termine la
		 * ejecuci�n. Modifica el programa principal para que pueda elevarse esta
		 * excepci�n. Deber�s controlar las excepciones del sistema, as� como documenta
		 * convenientemente el c�digo generando el Javadoc.
		 */

		// Gitignore ?�
		byte bAnios;
		byte bCategoria;
		char cLetra = 0;

		String sNombreEmpleado1 = L.leer("Nombre (Empleado 1): ");

		String sDniEmpleado1 = L.leer("Dni (Empleado 1): ");

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

		Empleado oEmpleado1 = new Empleado(sNombreEmpleado1, sDniEmpleado1, cLetra, bAnios, bCategoria);
		if (oEmpleado1.validaEmpleado(oEmpleado1) && controlGeneral.getEmpleadoController().addEmployee(oEmpleado1)) {
			System.out.println("Aniadido correctamente");
		} else {
			System.out.println("No se pudo aniadir");
		}

		String sNombreEmpleado2 = L.leer("Nombre (Empleado 2): ");

		String sDniEmpleado2 = L.leer("Dni (Empleado 1): ");

		bOption = (byte) L.valida("Sexo: \nVaron: (1)\nMujer: (2)", 1, 2, 3);

		if (bOption == 1) {
			cLetra = 'H';
		} else if (bOption == 2) {
			cLetra = 'M';
		}

		Empleado oEmpleado2 = new Empleado(sNombreEmpleado2, sDniEmpleado2, cLetra);

		if (oEmpleado2.validaEmpleado(oEmpleado2) && controlGeneral.getEmpleadoController().addEmployee(oEmpleado2)) {
			System.out.println("Aniadido correctamente");
		} else {
			System.out.println("No se pudo aniadir");
		}
		datosTrabajadores(oEmpleado1, oEmpleado2);

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

		oEmpleado2.setbAnyosTrabajados(bAnios);
		oEmpleado1.setbCategoria(bCategoria);

		datosTrabajadores(oEmpleado1, oEmpleado2);

		/*
		 * Partiendo de la aplicaci�n en Java desarrollada en la prueba anterior para
		 * controlar las n�minas de los empleados de una empresa, realizar los
		 * siguientes apartados: 1. Modificar el c�digo para que el programa lea la
		 * informaci�n necesaria de los empleados desde un fichero de texto
		 * �empleados.txt� y escriba en un fichero binario �salarios.dat� el dni del
		 * empleado junto con su sueldo calculado. Debes: 1.1. Definir el fichero de
		 * texto de entrada �empleados.txt� creando en el mismos los empleados de los
		 * apartados 4.1 y
		 * 
		 * 
		 * 
		 * 4.2 con el formato m�s adecuado para que pueda ser le�do por el programa.
		 * Puedes incluir m�s empleados. 1.2. Actualizar dicho fichero �empleados.txt�
		 * conforme a los cambios especificados en el apartado 4.5.
		 * 
		 * 
		 * 1.3. Definir el fichero binario de salida �sueldos.dat� con el formato m�s
		 * adecuado para almacenar el dni y el sueldo resultante para cada empleado.
		 * 
		 * 
		 * 2. Modificar el c�digo para que el programa lea la informaci�n necesaria de
		 * los empleados desde una base de datos con, al menos, una tabla Empleados y
		 * una tabla Nominas. Debes:
		 * 
		 * 
		 * 2.1. Definir e implementar el modelo de tablas y relaciones necesarios para
		 * dar soporte a la aplicaci�n de control de n�minas. Definir en la tabla
		 * correspondiente de dicha base de datos los mismos los empleados de los
		 * apartados 4.1 y 4.2 de la parte 1 para que pueda ser le�do por el programa.
		 * Puedes incluir m�s registros de empleados.
		 * 
		 * 
		 * 2.2. Actualizar dicha base de datos conforme a los cambios especificados en
		 * el apartado 4.5 de la parte 1. 2.3. Actualizar la base de datos almacenando
		 * el sueldo resultante para cada empleado. 3.
		 * 
		 * 
		 * Modificar el c�digo para crear un m�todo �altaEmpleado� que permita dar de
		 * alta empleados en el sistema y que, de forma autom�tica, calcule y almacene
		 * el sueldo de los empleados en la base de datos. 3.1. Sobrecargar el m�todo
		 * �altaEmpleado� para que permita el alta de empleados de forma individual o
		 * por lotes a partir de un fichero �empleadosNuevos.txt� con los datos de los
		 * empleados a dar de alta en el sistema. 4.
		 * 
		 * 
		 * 
		 * Modificar el comportamiento de la aplicaci�n para que use como almacenamiento
		 * principal la base de datos previamente creada en el apartado 7, y como
		 * almacenamiento secundario, a modo de backup, los ficheros de texto y datos
		 * previamente creados en el apartado 1. 5. Crear un men� de opciones para
		 * permitir al usuario: 5.1.
		 * 
		 * 
		 * Mostrar la informaci�n existente en la base de datos de todos los empleados
		 * (nombre, dni, sexo, categor�a y a�os trabajados).
		 * 
		 * 
		 * 5.2. Mostrar el salario existente en la base de datos de un empleado
		 * especificado por su dni.
		 * 
		 * 
		 * 5.3. Mostrar un submen� que permita modificar todos los datos de los
		 * empleados almacenados en la base de datos.
		 * 
		 * 
		 * 
		 * El sueldo del empleado es un campo calculado y no es posible modificarlo,
		 * debiendo actualizarse autom�ticamente al modificar la categor�a o los a�os
		 * trabajados de un empleado.
		 * 
		 * 
		 * 5.4. Recalcular y actualizar el sueldo de un empleado. 5.5. Recalcular y
		 * actualizar los sueldos de todos los empleados.
		 * 
		 * 
		 * 5.6. Realizar una copia de seguridad de la base de datos en ficheros. Deber�s
		 * controlar las excepciones del sistema, as� como documenta convenientemente el
		 * c�digo generando el Javadoc.
		 */

		start();
	}

	public static void start() {

		byte bOption = 0;
		boolean errorContol = true;
		do {
			do {

				try {
					bOption = (byte) L.valida("\n\n"
							//
							+ "*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
							//
							+ "\n�  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �"
							//
							+ "\n		BIENVENIDO AL GESTOR DE NOMINAS"
							//
							+ "\n�  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �"
							//
							+ "\n*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *"
							//
							+ "\n"
							//
							+ "\n  --Operaciones de empleados:    	(1)"
							//
							+ "\n  --Salir:           		(2)"
					//
							, 1, 2, 3);

					errorContol = false;

				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} while (errorContol);

			//

			if (bOption == 1) {
				AltaEmpleadoView.seleccionOperaciones(controlGeneral);

			}
		} while (bOption != 2);
	}

	/**
	 * 
	 * @param oEmpleado1 tipo: Empleado (Objeto)
	 * @param oEmpleado2 tipo: Empleado (Objeto)
	 */
	private static void datosTrabajadores(Empleado oEmpleado1, Empleado oEmpleado2) {
		String sSueldo = "  --Sueldo : ";
		System.out.println(oEmpleado1.imprimeEmpleado(oEmpleado1));
		System.out.println(sSueldo + Nomina.sueldo(oEmpleado1));
		System.out.println(oEmpleado2.imprimeEmpleado(oEmpleado2));
		System.out.println(sSueldo + Nomina.sueldo(oEmpleado2));

	}

}
