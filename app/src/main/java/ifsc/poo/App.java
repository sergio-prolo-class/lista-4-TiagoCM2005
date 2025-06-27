package ifsc.poo;

import edu.princeton.cs.algs4.Draw;
import ifsc.poo.figuras.Figura;

public class App {
    public static void main(String[] args) {
    Draw d = new Draw();
    d.setXscale(0, 10);
    d.setYscale(0, 10);
    d.enableDoubleBuffering();

    Eventos eventos = new Eventos();
    d.addListener(eventos);

    // LOOP DE ANIMAÇÃO ADICIONADO AQUI
    while (true) {
        d.clear();
        for(Figura figura : eventos.getFiguras()) {
            figura.desenhar(d);
        }
        d.show();
        try { Thread.sleep(20); } 
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
}

