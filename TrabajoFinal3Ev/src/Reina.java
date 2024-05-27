public class Reina extends Pieza {
    public Reina(boolean esBlanco) {
        super(esBlanco, esBlanco ? "R" : "r");
    }

    @Override
    public boolean esMovimientoValido(Tablero tablero, int inicioX, int inicioY, int finX, int finY) {
        int dx = Math.abs(finX - inicioX);
        int dy = Math.abs(finY - inicioY);

        if (dx == dy || inicioX == finX || inicioY == finY) {
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
                int stepX = (finX > inicioX) ? 1 : -1;
                int stepY = (finY > inicioY) ? 1 : -1;
                for (int i = inicioX + stepX, j = inicioY + stepY; i != finX; i += stepX, j += stepY) {
                    if (tablero.obtenerPieza(i, j) != null) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }
}
