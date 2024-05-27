public class Tablero {
    private Pieza[][] tablero;
    private int blancasComidas;
    private int negrasComidas;
    private boolean victoriaBlancas;
    private boolean victoriaNegras;

    public Tablero() {
        tablero = new Pieza[8][8];
        prepararTablero();
        contarBlancasComidas();
        contarNegrasComidas();
        victoriaBlancas = false;
        victoriaNegras = false;
    }

    public Pieza obtenerPieza(int x, int y) {
        return tablero[x][y];
    }

    public void colocarPieza(int x, int y, Pieza pieza) {
        tablero[x][y] = pieza;
    }

    public void prepararTablero() {
        // Peones
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(false);
            tablero[6][i] = new Peon(true);
        }

        // Torres
        tablero[0][0] = new Torre(false);
        tablero[0][7] = new Torre(false);
        tablero[7][0] = new Torre(true);
        tablero[7][7] = new Torre(true);

        // Caballos
        tablero[0][1] = new Caballo(false);
        tablero[0][6] = new Caballo(false);
        tablero[7][1] = new Caballo(true);
        tablero[7][6] = new Caballo(true);

        // Alfiles
        tablero[0][2] = new Alfil(false);
        tablero[0][5] = new Alfil(false);
        tablero[7][2] = new Alfil(true);
        tablero[7][5] = new Alfil(true);

        // Reinas
        tablero[0][3] = new Reina(false);
        tablero[7][3] = new Reina(true);

        // Reyes
        tablero[0][4] = new Rey(false);
        tablero[7][4] = new Rey(true);
    }

    public boolean moverPieza(int inicioX, int inicioY, int finX, int finY) {
        Pieza pieza = obtenerPieza(inicioX, inicioY);
        if (pieza != null && pieza.esMovimientoValido(this, inicioX, inicioY, finX, finY)) {
            colocarPieza(finX, finY, pieza);
            colocarPieza(inicioX, inicioY, null);
            return true;
        }
        return false;
    }

    public void mostrarTablero() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tablero[i][j];
                System.out.print((pieza != null ? pieza.obtenerSimbolo() : ".") + " ");
            }
            System.out.println();
        }
    }
    public void contarBlancasComidas() {
        blancasComidas = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tablero[i][j];
                if (pieza != null && pieza.estaComida() && pieza.esBlanco()) {
                    blancasComidas++;
                }
            }
        }
    }
    public void contarNegrasComidas() {
        negrasComidas = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tablero[i][j];
                if (pieza != null && pieza.estaComida() && !pieza.esBlanco()) {
                    negrasComidas++;
                }
            }
        }
    }
    public boolean Victoria() {
        if (blancasComidas >= 16) {
            victoriaNegras = true;
            return true;
        }
        if (negrasComidas >= 16) {
            victoriaBlancas = true;
            return true;
        }

        return false;
    }

    public boolean hayVictoriaBlancas() {
        return victoriaBlancas;
    }

    public boolean hayVictoriaNegras() {
        return victoriaNegras;
    }

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.mostrarTablero();
    }
}
