public class Rey extends Pieza {
    public Rey(boolean esBlanco) {
        super(esBlanco, esBlanco ? "K" : "k");
    }

    @Override
    public boolean esMovimientoValido(Tablero tablero, int inicioX, int inicioY, int finX, int finY) {
        int dx = Math.abs(finX - inicioX);
        int dy = Math.abs(finY - inicioY);
        return dx <= 1 && dy <= 1;
    }
}
