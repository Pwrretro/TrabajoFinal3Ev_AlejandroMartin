public class Alfil extends Pieza {
    public Alfil(boolean esBlanco) {
        super(esBlanco, esBlanco ? "A" : "a");
    }

    @Override
    public boolean esMovimientoValido(Tablero tablero, int inicioX, int inicioY, int finX, int finY) {
        int dx = Math.abs(finX - inicioX);
        int dy = Math.abs(finY - inicioY);
        if (dx != dy) {
            return false;
        }

        int stepX = (finX > inicioX) ? 1 : -1;
        int stepY = (finY > inicioY) ? 1 : -1;
        for (int i = inicioX + stepX, j = inicioY + stepY; i != finX; i += stepX, j += stepY) {
            if (tablero.obtenerPieza(i, j) != null) {
                return false;
            }
        }
        return true;
    }
}
