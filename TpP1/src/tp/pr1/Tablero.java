package tp.pr1;

public class Tablero {

	//Atributos
	private Ficha[][] tablero;
	private int ancho;
	private int alto;
	
	//Constructora
	/**
	 * Construye un tablero vacio
	 * @param tx- Tamaño de columnas
	 * @param ty- Tamaño de filas
	 */
	public Tablero(int tx,int ty){
		
		ancho = tx;//Columna
		alto = ty;//Fila
		
		//Creamos el array bidimensional
		tablero = new Ficha[alto][ancho];
		
		//Inicializamos las fichas
		inicializaTa();
		
	}
	/**
	 * Inicializa las casillas del tablero
	 * con fichas vacias
	 */
	private void inicializaTa(){
		//Cada casilla estara Vacia
		for(int c = 0; c < alto; c++){
			for(int f = 0;f < ancho; f++){
				tablero[c][f] = Ficha.VACIA;
			}
		}
	}
	
	
	//Metodos de consulta
	/**
	 * Metodo para obtener el alto del tablero
	 * @return Numero de filas del tablero
	 */
	public int getAlto(){
		return alto;
	}
	
	/**
	 * Metodo para obtener el alto del tablero
	 * @return Numero de columnas del tablero
	 */
	public int getAncho(){
		return ancho;
	}
	/**
	 * Metodo para acceder a la informacion de una casita
	 * @param x-Numero de columnas(ancho=
	 * @param y-Numero de fila(alto)
	 * @return Infomacion de la casilla. Si la casilla no valida, devuelve
	 * una Ficha VACIA
	 */
	public Ficha getCasilla(int x, int y){
		
		Ficha casilla = Ficha.VACIA;
		//Compruebo que la casilla es valida
		if(casillaOk(x,y)){
			//Si casilla valida devuelvo
			casilla = tablero[x-1][y-1];
		}
		return casilla;
		
	}
	/**
	 * Metodo privado, que se utiliza para comprobar si una
	 * coordenada esta fuera del rango del tablero
	 * @param x-Numero de columnas(ancho)
	 * @param y-Numero de fila(alto))
	 * @return Si esta en el rango True, en caso contrario False
	 */
	private boolean casillaOk(int x, int y){
		/*
		 * Si elegimos una casilla fuera del rango
		 * devolveremos false
		 * */
		boolean ok = false;
		
		if(( x-1 <= ancho && x >= 0) || ( y-1 <= alto && y >= 0) )
		{
			ok = true;
		}
		
		return ok;
	}
	/**
	 * Permite especificar el nuevo contenido de una casilla.
	 * Tambien puede utilizarse para quitar una ficha
	 * @param x- Numero de colomunas(ancho)
	 * @param y-Numero de filas(alto)
	 * @param color-Color de casilla.Si es VACIA, celda sin ficha
	 */
	public void setCasilla(int x, int y, Ficha color){
		
		if(casillaOk(x,y)){
			
			if(color == Ficha.VACIA){ //APUNTAN AL MISMO OBJETO?
				tablero[x][y] = Ficha.VACIA;
			}
			else{
				tablero[x][y] = color;
			}
		}
		
		/*
		 * SI LA CASILLA NO EXISTE? QUE HACE CON EL COLOR88888
		 */
	}
	
	/**
	 * Todo el contenido del tablero lo vacia(todo casilla con ficha VACIA)
	 */
	public void reset(){
		//Inicializamos todas las casillas a VACIA
		inicializaTa();
	}
	/**
	 * Comprueba si una casilla esta vacia
	 * @param x-coordenada fila
	 * @param y-coordenada columna
	 * @return true si esta vacia
	 */
	public boolean casillaVacia(int x, int y){
		return (tablero[x][y]== Ficha.VACIA);
	}
	
	
	public String toString(){
		
		String table = " ";
		Ficha ficha = null;
		
		//Pintamos las filas desde arriba(alto)
		for( int fila = 0; fila < alto; fila++){
			table+= "|"; //Concatenamos
			
			//Pintamos las columnas desde arriba(ancho)
			for(int columna = 0; columna < ancho; columna++){
				//Comprobaos si existen fichas
				ficha = tablero[fila][columna];
				//Elegimos que pintar
				switch(ficha){
				case VACIA:
					table +=" ";
				break;
				case BLANCA:
					table +="X";
				break;
				case NEGRA:
					table +="0";
				break;
				}
			}
			
			table +="|\n";
		}
		//Pintamos la parte de abajo
		//Necesitamos dos filas mas para +---+ y las posiciones
		for( int i = 0 ; i < 2; i++){
			
			if( i == 0){
				table += "+";//El primer + de la izquierda
				for(int colum = 0; colum < ancho; colum++){
					table += "-";
				}
				table += "+\n";//El segundo + de la izquierda
			}
			else{
				table += " ";
				for(int pos = 0; pos <ancho; pos++){
					table += pos+1;//Empieza desde el 1
				}
				table += " \n";
			}
		}
		
		return table;
	}

	/*
	//Pruebas
	public static void main(String[] args){
		
		
		
		
		Tablero pras = new Tablero(7,7);
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
}
