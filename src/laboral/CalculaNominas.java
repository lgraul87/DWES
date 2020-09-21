package laboral;
import laboral.Empleado;

public class CalculaNominas {

	public static void main(String[] args) {
		/*
		 * Se desea desarrollar una aplicación en Java para controlar las nóminas de los
		 * empleados de una empresa. Para ello, debes realizar los siguientes apartados
		 * (en principio, no se suponen errores en los datos de entrada): 1. Definir la
		 * clase pública Persona que pertenece al paquete Laboral. 1.1. Los atributos
		 * que definen una Persona son: un nombre (cadena), un dni (cadena) y un sexo
		 * (carácter). Los atributos son públicos. 1.2. La clase tiene dos
		 * constructores, uno con los tres atributos de la Persona, y otro con sólo el
		 * nombre y el sexo. 1.3.
		 * 
		 * 
		 * Tendrá dos métodos públicos: 1.3.1. setDni para modificar el valor del dni de
		 * una persona. 1.3.2. Imprime que presenta por pantalla el nombre y el dni.
		 * 
		 * 
		 * 2. Definir la clase Empleado que extiende a Persona y que tiene: 2.1. Dos
		 * nuevos atributos: categoria (atributo privado) debe ser una valor positivo
		 * entre 1 y 10; y años (anyos) trabajados (atributo público) que debe ser
		 * positivo.
		 * 
		 */

		/*
		 * 2.2. Dos constructores: uno que recibe todos los valores de sus atributos y
		 * otro que solo recibe el nombre, sexo y dni. En este caso, se entiende que la
		 * categoría es 1 y el número de años trabajados es 0. 2.3.
		 * 
		 * 
		 * 
		 * 
		 * Los siguientes métodos públicos: 2.3.1. setCategoria que sirve para cambiar
		 * de categoría de un empleado, que recibe como parámetro de entrada. 2.3.2.
		 * getCategoria que devuelve el valor del atributo categoria. 2.3.3. incrAnyo
		 * que incrementa en uno el número de años trabajados.
		 * 
		 * 
		 * 2.3.4. imprime que presenta todos los datos del empleado. 3. La siguiente
		 * tabla contiene los sueldos base de cada Empleado, de acuerdo con su
		 * categoría. Siendo 50000 para la categoría 1 e incrementándose en 20000 para
		 * cada nueva categoría. Esta tabla debe definirse en una nueva clase de nombre
		 * Nomina: private static final int SUELDO_BASE[] = {50000, 70000, 90000,
		 * 110000, 130000, 150000, 170000, 190000, 210000, 230000} 3.1. La clase es una
		 * biblioteca y tiene un método sueldo que recibe un Empleado y devuelve su
		 * sueldo obtenido como resultado de evaluar la expresión: sueldo = sueldoBase +
		 * 5000*años trabajados 4. Crear la clase CalculaNominas con un programa
		 * principal que:
		 * 
		 */
		/**
		 * #################################################3
		 */

		/*
		 * 4.1. Cree el empleado: “James Cosling”, dni=32000032G, sexo=’M’, categoría=4,
		 * años=7 4.2. Cree el empleado: “Ada Lovelace”, dni=32000031R, sexo=’F’ 4.3.
		 * Declare un método privado escribe que reciba los valores de los dos empleados
		 * e imprima sus atributos y el sueldo que cada uno gana. 4.4. Haga una llamada
		 * en el programa principal a ese método. 4.5.
		 * 
		 * 
		 * Incremente los años trabajados del segundo empleado y haga que la categoría
		 * del primero sea 9. 4.6. Imprima de nuevo ambos empleados y su sueldo. 5.
		 * 
		 * 
		 * Modificar el código para comprobar que los datos que se pasan son correctos
		 * cuando se crea un nuevo Empleado y en caso contrario se eleve la excepción
		 * DatosNoCorrectosException. Declara un manejador de excepciones que cuando se
		 * produzca dicha excepción, emita el mensaje “Datos no correctos”, y termine la
		 * ejecución. Modifica el programa principal para que pueda elevarse esta
		 * excepción. Deberás controlar las excepciones del sistema, así como documenta
		 * convenientemente el código generando el Javadoc.
		 */

		byte bAnios;
		byte bCategoria;

		boolean bError = true;
		do {
			try {
				bAnios = Byte.parseByte("7");
				bError = false;
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
				bCategoria = Byte.parseByte("4");
				bError = false;
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

		Empleado oEmpleado1 = new Empleado("James Cosling", "32000032G", 'M', bAnios, bCategoria);
		Empleado oEmpleado2 = new Empleado("Ada Lovelace", "32000031R", 'F');

		datosTrabajadores(oEmpleado1, oEmpleado2);

		bError = true;
		do {
			try {
				bAnios = Byte.parseByte("5");
				bError = false;
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
				bCategoria = Byte.parseByte("9");
				bError = false;
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
	}

	/**
	 * 
	 * @param oEmpleado1 tipo: Empleado (Objeto)
	 * @param oEmpleado2 tipo: Empleado (Objeto)
	 */
	private static void datosTrabajadores(Empleado oEmpleado1, Empleado oEmpleado2) {
		String sSueldo = "  --Sueldo : ";
		System.out.println(oEmpleado1.imprimeEmpleado(oEmpleado1));
		System.out.println(sSueldo + oEmpleado1.sueldo(oEmpleado1));
		System.out.println(oEmpleado2.imprimeEmpleado(oEmpleado2));
		System.out.println(sSueldo + oEmpleado2.sueldo(oEmpleado2));
	}
}
