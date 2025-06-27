package ifsc.poo.figuras;
import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Quadrado extends Figura{

    public Quadrado(double x, double y, double  tamanho, boolean preenchido, Color cor){
        super(x, y, tamanho, preenchido, cor);
    }

    @Override
    public void desenhar(Draw d){

        d.setPenColor(cor);
        d.setPenRadius(0.002); // Espessura da borda

        if(preenchido){
            d.setPenColor(Color.BLACK); // borda preta
            d.filledSquare(x, y, tamanho);
            d.setPenColor(cor); // preenchimento
            d.filledSquare(x, y, tamanho - 0.05);
        } else {
            d.square(x, y, tamanho);
        }
    }

    @Override
    public double getArea(){
        return tamanho * tamanho;
    }

    @Override
    public double getPerimetro(){
        return 4 * tamanho;
    }

}
