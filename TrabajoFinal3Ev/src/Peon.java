public class Peon extends Pieza {
    private boolean primerMovimiento;

    public Peon(boolean esBlanco) {
        super(esBlanco, esBlanco ? "P" : "p");
        primerMovimiento = true;
    }

    @Override
    public boolean esMovimientoValido(Tablero tablero, int inicioX, int inicioY, int finX, int finY) {
        int direccion = esBlanco() ? -1 : 1;
        int deltaX = finX - inicioX;
        int deltaY = finY - inicioY;

        if (deltaX == direccion && deltaY == 0 && tablero.obtenerPieza(finX, finY) == null) {
            primerMovimiento = false;
            return true;
        }

        if (primerMovimiento && deltaX == 2 * direccion && deltaY == 0 && tablero.obtenerPieza(finX, finY) == null &&
                tablero.obtenerPieza(inicioX + direccion, inicioY) == null) {
            primerMovimiento = false;
            return true;
        }

        if (Math.abs(deltaX) == 1 && deltaY == 1 && tablero.obtenerPieza(finX, finY) != null &&
                tablero.obtenerPieza(finX, finY).esBlanco() != esBlanco()) {
            primerMovimiento = false;
            return true;
        }

        return false;
    }
}
