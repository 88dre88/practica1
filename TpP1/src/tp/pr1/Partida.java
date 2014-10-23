package tp.pr1;

public class Partida {

	private final int TAM = 7;
	private final int MAXMV = 10;
	
	private Tablero tablero;
	private Ficha turno;
	private Ficha ganador;
	private boolean terminada;
	
	//Atributos para almacenar los movimientos
	private int[] undoStack;
	private int numUndo;
	
	
	//Constructor
	/**
	 * Construye una partida (inicializa todos los atributos de la clase)
	 */
	public Partida(){
		
		tablero = new Tablero(TAM, TAM);//Instanciamos el tablero(Se crea el tablero)
		turno = Ficha.BLANCA; //Empiezan las blancas por defecto
		ganador = null; //Color indeterminador
		terminada = false;
		undoStack = new int [MAXMV];//Guarda los MAXMV movimientos
		numUndo = -1; //El primer elemento guardado sera 0
		
	}
	/**
	 * Reinicia la partida en curso(todos los atributos)
	 */
	public void reset(){
		
		reset();//Inicializa el tablero en la clase Tablero
		
		/*
		 * 888TENDRIA QUE CAMBIAR EL NUMUNDO
		 * EL TURNO VOLVERIA A SER EL BLANCO?
		 * 
		 * */
	}
	
	public boolean ejecutaMovimiento(Ficha color, int col){
		boolean movOk = false;
		/*
		 * Error:
		 *  -Ficha que no le toca pone
		 * - partida terminada( is terminda true)
		 * - Columna llena
		 * - Casilla no valida
		 * 
		 * 
		 * 
		 * */
		
		//Obtenemos las columnas en tablero
		int colTable = tablero.getAncho() ; //7
		int filaTable = tablero.getAlto();//7
		
		//Compruebo si el color es igual al color del jugador
		if(getTurno() == color){ //KKKK ¿referencian al mismo objeto?   ¿== o equals? KKKKKKKK
			
			//Comprobamos si col esta en el rango
			if( col <= colTable){ //1..7
				
				while (!movOk && filaTable >0){
					//Compruebo si casilla esta vacia
					if(tablero.casillaVacia(colTable-1, filaTable-1)){
						
					}
				}
			
				
				
			}
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		return movOk;
	}

	
	
	public boolean undo(){
		
		boolean undoOk = false;
		
		
		
		return undoOk;
	}
	
	
	
	/**
	 * Devuelve el color del jugador que tiene el turno
	 * @return Color del jugador.(VACIA si la partida termina)
	 */
	public Ficha getTurno(){
		
		if(isTerminada()){
			//Si partida terminada = ficha vacia
			turno = Ficha.VACIA;
		}
		
		return turno;
	}
	
	
	
	public boolean isTerminada(){
		boolean fin = false;
		
		
		return fin;
	}
	
	
}
