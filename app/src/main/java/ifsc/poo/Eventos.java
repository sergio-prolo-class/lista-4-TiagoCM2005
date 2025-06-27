package ifsc.poo;

import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.figuras.*;

public class Eventos implements  DrawListener{
    // Atributos
        private boolean preenchido = false;
        private double tamanho = 0.5;
        private double tamanho_max = 2.0;
        private double tamanho_min = 0.2;
        private int figura_selecionada = 1;
        private Color corAtual = Color.BLACK; // Cor padrão para a borda quando preenchido
    private ArrayList<Figura> figuras = new ArrayList<>(); // Uma lista de figuras desenhadas

    // ========================MOUSE========================

    public void mousePressed(double x, double y){    // Metódo que funciona a leitura de diversos cliques rápidos
        Figura figura = null;
        switch(figura_selecionada){
            case 1:
                figura = new Circulo(x,y, tamanho, preenchido, corAtual); 
                break;
            case 2: 
                figura = new Quadrado(x,y, tamanho, preenchido, corAtual);
                break;
        }

        if(figura != null){
            figuras.add(figura);
            System.out.printf("Figura adicionada em (%.2f, %.2f)%n", x, y);

        }
    }

    // ========================TECLADO========================

    // 
     @Override
    public void keyReleased(int i){
        switch(i){  
            case 37:  // seta esquerda
            case 38:  // seta cima
            case 39:  // seta direita
            case 40:  // seta baixo
            case 70:  // F  - Alternar entre preenchido e vazio
                preenchido = !preenchido;
                System.out.println("Modo de preechimento: " + (preenchido ? "preenchido" : "vazado"));
                break;
            case 80:  // P  - Retorna os valores matématicos
            case 81:  // Q  - Diminuiu o tamanho da fonte
                tamanho = Math.max(tamanho - 0.2, tamanho_min); // Compara o maior valor, se tamanho se menor que tamanho_min, ele recebe o valor mínimo possível
                System.out.println("Tamanho atual: " + tamanho);
                break;
            case 87:  // W  - Aumenta o tamanho da fonte
                tamanho = Math.min(tamanho + 0.2, tamanho_max);
                System.out.println("Tamanho atual: " + tamanho);
                break;
            case 67:  // C  - Limpar
                figuras.clear(); // Limpa a lista de figuras
                System.out.println("Todas as figuras foram removidas.");
                break;
            case 112: // F1 - Círculo
                figura_selecionada = 1; // Seleciona o círculo
                System.out.println("Figura selecionada: Círculo");
                break;
            case 113: // F2 - Quadrado
                figura_selecionada = 2; // Seleciona o quadrado
                System.out.println("Figura selecionada: Quadrado");
                break;
            case 114: // F3 - Pentágono
            case 115: // F4 - Hexágano
            case 116: // F5 - vermelho
                corAtual = Color.RED; // Define a cor atual como vermelho
                System.out.println("Cor atual: Vermelho");
                break;
            case 117: // F6 - preto
                corAtual = Color.BLACK; // Define a cor atual como preto
                System.out.println("Cor atual: Preto");
                break;
            case 118: // F7 - azul
                corAtual = Color.BLUE; // Define a cor atual como azul
                System.out.println("Cor atual: Azul");
                break;
            case 119: // F8 - rosa
                corAtual = Color.PINK; // Define a cor atual como rosa
                System.out.println("Cor atual: Rosa");
                break;
            
        }

        }
        public ArrayList<Figura> getFiguras() {
            return figuras; // Retorna a lista de figuras desenhadas
    }
}
    


