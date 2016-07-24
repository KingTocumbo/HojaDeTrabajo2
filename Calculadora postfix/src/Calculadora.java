import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class Calculadora implements I_Calculadora {
	/*Atributos: */
	Pila pila = new Pila();
	String operaciones;
	
	@Override
	public int Calcular(String ops) {
		/* variables locales: */
		int resultado = 0; // resultado a devolver
		
		String[] splitedOps = ops.split(" "); //Se utiliza un arreglo con cada caracter de la instruccion
		for(int i=0; i<splitedOps.length; i++){ //Se recorre el arreglo para realizar los calculos
			try{
				pila.Push(Integer.parseInt(splitedOps[i])); //Si se puede convertir a entero entonces se manda a la pila
			}
			catch(Exception e){ // si no, es porque es un operador
				switch(splitedOps[i]){
				case "+":
					resultado = (int)pila.Pop() + (int)pila.Pop();
					pila.Push(resultado);
					break;
					
				case "*":
					resultado = (int)pila.Pop() * (int)pila.Pop();
					pila.Push(resultado);
					break;
					
				case "/":
					resultado = (int)pila.Pop() / (int)pila.Pop();
					pila.Push(resultado);
					break;
				}
			}
			}
		
		return resultado;
	}

	@Override
	public String LeerArrchivo(String direccion) {
		String instrucciones = "";
		try{
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String temp = "";
			String bfRead;
			while((bfRead = bf.readLine()) != null){
				// El ciclo se realizara mientras bfRead tenga datos
				temp = temp + bfRead;				
			}
			
		instrucciones = temp;
		
		}
		catch(Exception e){
			System.err.println("No es posible leer el archivo");
		}
		return instrucciones;
		
		// El codigo anterior fue adaptado del tutorial encontrado en: https://www.youtube.com/watch?v=0ceHv2niNR4
	}

	@Override
	public String ToString() {
		return null;
	}

}
