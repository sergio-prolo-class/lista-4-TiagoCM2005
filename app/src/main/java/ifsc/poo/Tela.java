package ifsc.poo;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

public class Tela implements  DrawListener{
    private final int dimensao = 10;
    Draw draw;

    public Tela(){
        draw = new Draw();
        draw.addListener(this);
        draw.setXscale(0, dimensao);
        draw.setYscale(0 , dimensao);
        draw.enableDoubleBuffering();        
    }

    public void desenharTela(){
        draw.clear();
        draw.show();
    }
}
