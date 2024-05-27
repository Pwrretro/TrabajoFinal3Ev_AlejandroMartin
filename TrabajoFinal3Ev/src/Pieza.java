public abstract class Pieza {
    private boolean esBlanco;
    private String simbolo;

    public Pieza(boolean esBlanco, String simbolo) {
        this.esBlanco = esBlanco;
        this.simbolo = simbolo;
    }

    public abstract boolean esMovimientoValido(Tablero tablero, int inicioX, int inicioY, int finX, int finY);

    public boolean esBlanco() {
        return esBlanco;
    }

    public String obtenerSimbolo() {
        return simbolo;
    }

    public void capturarPieza(Pieza piezaCapturada) {
        if (piezaCapturada != null) {
            String mensaje = esBlanco ? "Las blancas han capturado una " : "Las negras han capturado una ";
            mensaje += piezaCapturada.getClass().getSimpleName();
            System.out.println(mensaje);
        }
    }
    private boolean comida;

    public boolean estaComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }
}
