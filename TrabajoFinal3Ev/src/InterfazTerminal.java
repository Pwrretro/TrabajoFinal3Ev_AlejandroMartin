public class InterfazTerminal {
    private Tablero tablero;

    public InterfazTerminal() {
        tablero = new Tablero();
    }

    public void mostrarTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = tablero.obtenerPieza(fila, columna);
                String simbolo = (pieza != null) ? pieza.obtenerSimbolo() : ".";
                System.out.print(simbolo + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        InterfazTerminal interfaz = new InterfazTerminal();
        interfaz.mostrarTablero();
    }
}
