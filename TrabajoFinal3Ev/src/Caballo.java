public class Caballo extends Pieza {
    public Caballo(boolean esBlanco) {
        super(esBlanco, esBlanco ? "C" : "c");
    }

    @Override
    public boolean esMovimientoValido(Tablero tablero, int inicioX, int inicioY, int finX, int finY) {
        int dx = Math.abs(finX - inicioX);
        int dy = Math.abs(finY - inicioY);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
