public class Torre extends Pieza {
    public Torre(boolean esBlanco) {
        super(esBlanco, esBlanco ? "T" : "t");
    }

    @Override
    public boolean esMovimientoValido(Tablero tablero, int inicioX, int inicioY, int finX, int finY) {
        if (inicioX == finX) {
            int step = (inicioY < finY) ? 1 : -1;
            for (int i = inicioY + step; i != finY; i += step) {
                if (tablero.obtenerPieza(inicioX, i) != null) {
                    return false;
                }
            }
            return true;
        } else if (inicioY == finY) {
            int step = (inicioX < finX) ? 1 : -1;
            for (int i = inicioX + step; i != finX; i += step) {
                if (tablero.obtenerPieza(i, inicioY) != null) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
