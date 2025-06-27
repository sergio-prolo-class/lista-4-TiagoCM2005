package ifsc.poo.figuras;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Pentagono extends Figura {
    public Pentagono(double x, double y, double tamanho, boolean preenchido, Color cor){
        super(x, y, tamanho, preenchido, cor);
    }

    @Override
    public void desenhar(Draw d){
        // é preciso calcular 5 vértices igualmente espaçadas em um círculo.

        double[] xs = new double[5];
        double[] ys = new double[5];

        for(int i = 0; i < 5; i++){
            // Cada ponto gira 72° em relação ao anterior, a váriavel i é responsável por isso, cada interação existe a "rotação" de 72°
            // Ponto inicial é no topo;
            double angulo = Math.toRadians(90 + i *72);
    
            xs[i] = x + tamanho * Math.cos(angulo);
            ys[i] = y + tamanho * Math.sin(angulo);
            // tamanho é o raio
        }

       d.setPenColor(cor);
        if (preenchido) {
            d.setPenColor(cor);
            d.filledPolygon(xs, ys); // Pinta o polígono preenchido
            d.setPenColor(Color.BLACK); // pinta a borda de preto
            d.polygon(xs, ys);
        } else {
            d.polygon(xs, ys);
        }

    }

    @Override
    public double getArea(){
        return(5 * tamanho * tamanho * Math.tan(Math.PI / 5)) / 4;
    }

    @Override
    public double getPerimetro(){
        double lado = 2 * tamanho * Math.sin(Math.PI / 5);
        return 5 * lado;
    }
}
