package ifsc.poo;

import java.util.ArrayList;

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

    // LOOP DE ANIMAÇÃO
    while (true) {
        d.clear();
        // por estar ocorrendo um erro por estar modificando a lista de figuras enquanto ela está sendo iterada, usarei uma cópia da lista de figuras
        ArrayList<Figura> figurasCopia = new ArrayList<>(eventos.getFiguras());
        for(Figura figura : figurasCopia) {
            figura.desenhar(d);
        }
        d.show();

        // O trecho a seguir foi implementado para limitar o FPS da tela, ele pausa a execução do programa por 20 milissegundos.
        // Sem ele, os desenhos ficam com pequenos cortes, como se fosse "falhas" no desenho.
        try { Thread.sleep(20); } 
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
}

