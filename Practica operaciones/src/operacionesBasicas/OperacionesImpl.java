package operacionesBasicas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class OperacionesImpl extends Thread implements Operaciones {

    protected Socket socketCliente;
    protected BufferedReader entrada;
    protected PrintStream salida;
    protected String opcion;

    public OperacionesImpl(Socket socketCliente) {
        this.socketCliente = socketCliente;
        try {
            entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
            salida = new PrintStream(this.socketCliente.getOutputStream());
        } catch (IOException e) {
            System.err.println(e);
            try {
                this.socketCliente.close();
            } catch (IOException e2) {
            }
            return;
        }
        start();
    }

    public void run() {
        try {
            opcion = entrada.readLine();
            System.out.println("Opcion a Ejecutar: " + opcion);
            ejecutaOpcion(opcion, entrada, salida);
        } catch (IOException e) {
        } finally {
            try {
                socketCliente.close();
            } catch (IOException e) {
            }
        }
    }

    @Override
    public float Suma(float x, float y) {
        float suma = x + y;
        return suma;
    }

    @Override
    public float Resta(float x, float y) {
        float resta = x - y;
        return resta;
    }

    @Override
    public float Multiplicacion(float x, float y) {
        float multi = x * y;
        return multi;
    }

    @Override
    public float Division(float x, float y) {
        if (y != 0) {
            float div = x / y;
            return div;
        } else {
            System.out.println("Indeterminación");
            return 0;
        }
    }

    @Override
    public float Promedio(float[] x) {
        if (x.length >= 1) {
            float suma = 0, res;
            for (int i = 0; i < x.length; i++) {
                suma += x[i];
            }
            res = suma / x.length;
            return res;
        } else {
            System.out.println("Arreglo vacio");
            return 0;
        }
    }

    @Override
    public float Desv_Estand(float[] x) {
        if (x.length > 1) {
            float suma = 0, a = 0, xProm = Promedio(x), res;
            for (int i = 0; i < x.length; i++) {
                a = x[i] - xProm;
                suma += (float) Math.pow(a, 2);
            }
            float div = suma / (x.length - 1);
            res = (float) Math.sqrt(div);
            return res;
        } else if (x.length == 1) {
            System.out.println("No se puede realizar la operacion");
            return 0;
        } else {
            System.out.println("Arreglo vacio");
            return 0;
        }
    }

    @Override
    public int Factorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * Factorial(numero - 1);
        }
    }

    @Override
    public int Fibonacci(int n) {
        if (n > 1) {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        } else if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else { //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
        }
    }

    @Override
    public float MaxNum(float[] x) {
        float max = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    @Override
    public int ParoImpar(int n) {
        if (n % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void ejecutaOpcion(String numero, BufferedReader entrada, PrintStream salida) throws IOException {
        if (numero.equals("Suma")) {
            String num1 = entrada.readLine();
            String num2 = entrada.readLine();
            float res = Suma(Float.valueOf(num1), Float.valueOf(num2));
            salida.println(String.valueOf(res));
        } 
        else if (numero.equals("Resta")) {
            String num1 = entrada.readLine();
            String num2 = entrada.readLine();
            float res = Resta(Float.valueOf(num1), Float.valueOf(num2));
            salida.println(String.valueOf(res));
        } 
        else if (numero.equals("Multi")) {
            String num1 = entrada.readLine();
            String num2 = entrada.readLine();
            float res = Multiplicacion(Float.valueOf(num1), Float.valueOf(num2));
            salida.println(String.valueOf(res));
        } 
        else if (numero.equals("Div")) {
            String num1 = entrada.readLine();
            String num2 = entrada.readLine();
            float res = Division(Float.valueOf(num1), Float.valueOf(num2));
            salida.println(String.valueOf(res));
        }
        else if (numero.equals("Promedio")) {
            int cant_numeros = Integer.valueOf(entrada.readLine());
            float [] numeros = new float[cant_numeros]; 
            for (int i = 0; i < cant_numeros; i++) {
                numeros[i]=(Float.valueOf(entrada.readLine()));
            }
            float res = Promedio(numeros);
            salida.println(String.valueOf(res));
        }
        else if (numero.equals("DesvEst")) {
            int cant_numeros = Integer.valueOf(entrada.readLine());
            float [] numeros = new float[cant_numeros]; 
            for (int i = 0; i < cant_numeros; i++) {
                numeros[i]=(Float.valueOf(entrada.readLine()));
            }
            float res = Desv_Estand(numeros);
            salida.println(String.valueOf(res));
        } 
        else if (numero.equals("MaxNum")) {
            int cant_numeros = Integer.valueOf(entrada.readLine());
            float [] numeros = new float[cant_numeros]; 
            for (int i = 0; i < cant_numeros; i++) {
                numeros[i]=(Float.valueOf(entrada.readLine()));
            }
            float res = MaxNum(numeros);
            salida.println(String.valueOf(res));
        }
        else if (numero.equals("Factorial")) {
            String num1 = entrada.readLine();
            if (Integer.valueOf(num1) > 15 ) {
                salida.println("Lo sentimos, no podemos calcular un numero mayor a 15");
            } 
            else if (Integer.valueOf(num1)<0){
                salida.println("Lo sentimos, no podemos calcular factorial de un numero negativo");
            }
            else {
                float res = Factorial(Integer.valueOf(num1));
                salida.println(String.valueOf(res));
            }
        }
        else if (numero.equals("Fibonacci")) {
            String num1 = entrada.readLine();
            float res = Fibonacci(Integer.valueOf(num1));
            salida.println(String.valueOf(res));
        }
        else if (numero.equals("ParOImpar")) {
            String num1 = entrada.readLine();
            float res = ParoImpar(Integer.valueOf(num1));
            if (res == 0) {
                salida.println("Numero impar");
            } else {
                salida.println("Numero par");
            }
        }
    }
}
