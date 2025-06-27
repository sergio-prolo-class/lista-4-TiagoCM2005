package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Circulo extends Figura {
    public Circulo(double x, double y, double tamanho, boolean preenchido, Color cor){
        super(x, y, tamanho, preenchido, cor);
    }

    @Override
    public void desenhar(Draw d){
        d.setPenColor(cor); 

        if(preenchido){
            d.setPenColor(Color.BLACK);
            d.filledCircle(x, y, tamanho);
            d.setPenColor(cor);
            d.filledCircle(x, y, (tamanho - 0.05));
        } else {
            d.circle(x, y, tamanho);
        }
    }

    @Override
    public double getArea(){
        return Math.PI * tamanho * tamanho;
    }

    @Override
    public double getPerimetro(){
        
        return 2 * Math.PI * tamanho;
    }
}
