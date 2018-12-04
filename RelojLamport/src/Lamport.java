public class Lamport extends Thread {

	public int id_hilo; //El valor del hilo en ejecucion
	public static final int numeroDeCiclos = 4;
	public static final int numeroDeHilos = 3;
        //area critica del programa (al cual accederan todos los procesos)
	public static volatile int reloj = 0; 

        //estas variables son volatiles para que se comparta su valor entre procesos
	private static volatile boolean[] elegido = new boolean[numeroDeHilos]; //Nos indica si un hilo quiere acceder a la zona critica																				 
	private static volatile int[] ticket = new int[numeroDeHilos]; //Define la prioridad de ejecucion
	
	/*
	 * Constructor
	 */
	public Lamport(int id) {
            id_hilo = id;
	}

	public void run() {
            int scale = 2;
            for (int i = 0; i < numeroDeCiclos; i++) {
                //bloquear
                bloquear(id_hilo);
                //manipulacion de seccion critica
                reloj = reloj + 1;
                System.out.println("El hilo " + id_hilo + " esta en ejecucion / el valor de reloj es: " + reloj);
                try {
                    //ocupamos un sleep para simular una condicion de carrera
                    sleep((int) (Math.random() * scale));
                } catch (InterruptedException e) { /* nada */ }
                //desbloquear zona critica
                desbloquear(id_hilo);			
            }
	}

	/*
	 * Metodo que restringe el uso de la zona critica
	 */
	public void bloquear(int id) {
		//De esta manera anunciamos que el hilo id esta interesado en entrar a la seccion critica
		elegido[id] = true;

		//Buscamos el ticket de mayor valor, y le agregamos uno, asi esperaremos en la cola
		ticket[id] = maximo() + 1;
		elegido[id] = false;

		System.out.println("El hilo " + id + " consiguio el ticket "+ticket[id]);

		for (int j = 0; j < numeroDeHilos; j++) {
			// Si es el hilo actual, nos lo saltamos
			if (j == id)
                            continue;			
			// Si el hilo actual ha sido escojido
			while (elegido[j]) { /* nada */ }
			while (ticket[j] != 0 && (ticket[id] > ticket[j] || (ticket[id] == ticket[j] && id > j))) { /* nada */ }			 
		}
	}

	/*
	 * Despacha al hilo actual
	 */
	private void desbloquear(int id) {
		ticket[id] = 0;
		System.out.println("Hilo " + id + " salio de la seccion critica.");
	}

	/*
	 * Busca el ticket con mayor valor
	 */
	private int maximo() {
            int m = ticket[0];

            for (int i = 1; i < ticket.length; i++) {
                if (ticket[i] > m)
                m = ticket[i];
            }
            return m;
	}

	public static void main(String[] args) {
            // Inicializando variables
            for (int i = 0; i < numeroDeHilos; i++) {
                elegido[i] = false;
                ticket[i] = 0;
            }

            //Creacion de hilos
            Lamport[] threads = new Lamport[numeroDeHilos];

            //Inicializacion de hilos
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Lamport(i);
                threads[i].start();
            }

            //Esperar el termino de los hilos
            for (int i = 0; i < threads.length; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\nReloj: " + reloj);
            System.out.println("\nValor esperado del reloj: " + (numeroDeCiclos * numeroDeHilos));
	}
}