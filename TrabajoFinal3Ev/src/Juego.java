import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private boolean turnoBlanco;

    public Juego() {
        tablero = new Tablero();
        turnoBlanco = true;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            tablero.mostrarTablero();

            String colorTurno = turnoBlanco ? "Blanco" : "Negro";
            System.out.println("Turno de las piezas " + colorTurno);
            System.out.println("Ingrese las coordenadas de la pieza que desea mover (fila columna):");
            String inicioPos = scanner.next();
            String finPos = scanner.next();

            int inicioX = 8 - Character.getNumericValue(inicioPos.charAt(1));
            int inicioY = (int) inicioPos.charAt(0) - 'a';
            int finX = 8 - Character.getNumericValue(finPos.charAt(1));
            int finY = (int) finPos.charAt(0) - 'a';

            if (tablero.moverPieza(inicioX, inicioY, finX, finY)) {
                turnoBlanco = !turnoBlanco;
            } else {
                System.out.println("Movimiento no válido, intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}
