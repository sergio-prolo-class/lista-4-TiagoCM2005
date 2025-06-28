package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

// Figura é uma classe abstrata que será usada por todas as figuras utilizadas no projeto: Circulo, Quadrado, Pentágono e Hexágono.
public abstract class Figura {
    
    protected double x,y;
    protected double tamanho;
    protected boolean preenchido;
    protected Color cor;

    public Figura(double x, double y, double tamanho, boolean preenchido, Color cor){
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        this.preenchido = preenchido;
        this.cor = cor;
    } 

    // Aqui será as funções de uso do polimorfismo.
    public abstract void desenhar(Draw d);
    public abstract double getArea();
    public abstract double getPerimetro();

    // Funções auxiliares para o funcionamento.
    public void mover(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Color getCor() {
        return cor;
    }

    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }

    public boolean isPreenchido() {
        return preenchido;
    }
}
