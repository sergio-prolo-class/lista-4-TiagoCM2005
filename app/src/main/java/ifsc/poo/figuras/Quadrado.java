package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Quadrado extends Figura{

    public Quadrado(double x, double y, double  tamanho, boolean preenchido, Color cor){
        super(x, y, tamanho, preenchido, cor);
    }

    // Uso de polimorfismo!
    @Override
    public void desenhar(Draw d){

        d.setPenColor(cor);

        if(preenchido){
            d.setPenColor(cor); // borda preta
            d.filledSquare(x, y, tamanho);
            d.setPenColor(Color.BLACK); // borda preta
            d.square(x, y, tamanho);
        } else {
            d.square(x, y, tamanho);
        }
    }

    // Uso de polimorfismo!
    @Override
    public double getArea(){
        return tamanho * tamanho;
    }

    // Uso de polimorfismo!
    @Override
    public double getPerimetro(){
        return 4 * tamanho;
    }

}
