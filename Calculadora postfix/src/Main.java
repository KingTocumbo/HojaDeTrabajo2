
public class Main {
	public static void main(String[] args){
		Calculadora calc = new Calculadora();
		/* Aqui se introduce la ruta del archivo con doble slash en vez de simple */
		int resultado = calc.Calcular(calc.LeerArrchivo("C:\\Users\\Fredo\\Documents\\Test_txt\\helloworld.txt"));
		System.out.println(String.valueOf(resultado));
	}
}
