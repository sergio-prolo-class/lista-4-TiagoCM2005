package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public abstract class Figura {
    
    ///////////////////////
    protected double x,y;
    protected int tamanho;
    protected boolean preenchido;
    protected Color cor;

    ///////////////////////
    public Figura(double x, double y, int tamanho, boolean preenchido, Color cor){
        this.x = x;
        this.y = y;
        this.tamanho = tamanho;
        this.preenchido = preenchido;
        this.cor = cor;
    } 

    ///////////////////////
    // Funções abstratas // 
    ///////////////////////
    
    public abstract void desenhar(Draw d);
    public abstract double getArea();
    public abstract double getPerimetro();

    ///////////////////////                   
    // Funções GET e SET // 
    ///////////////////////
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
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
