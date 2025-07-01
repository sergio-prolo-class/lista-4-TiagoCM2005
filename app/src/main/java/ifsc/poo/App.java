package ifsc.poo;

import edu.princeton.cs.algs4.Draw;

public class App {
    public static void main(String[] args) {
    Draw d = new Draw();
    d.setXscale(0, 10);
    d.setYscale(0, 10);
    d.enableDoubleBuffering();

    Eventos eventos = new Eventos();
    eventos.setDraw(d);
    d.addListener(eventos);
   
}
}

