package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Circulo extends Figura {
    public Circulo(double x, double y, double tamanho, boolean preenchido, Color cor){
        super(x, y, tamanho, preenchido, cor);
    }

    // Uso de polimorfismo!
    @Override
    public void desenhar(Draw d){
        d.setPenColor(cor); 

        if(preenchido){
            d.setPenColor(cor);
            d.filledCircle(x, y, tamanho);
            d.setPenColor(Color.BLACK);
            d.circle(x, y, tamanho);
        } else {
            d.circle(x, y, tamanho);
        }
    }

    // Uso de polimorfismo!
    @Override
    public double getArea(){
        return Math.PI * tamanho * tamanho;
    }

    // Uso de polimorfismo!
    @Override
    public double getPerimetro(){
        
        return 2 * Math.PI * tamanho;
    }
}
