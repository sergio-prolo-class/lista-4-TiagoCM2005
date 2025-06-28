/*
    Classe responsável por gerenciar os eventos, como os clicks do mouse e clicks do teclado.
        - Foi utilizado a função mousePressed, pois ela aceita diversos cliques seguidos.
        - KeyReleased para capturar ação do teclado, funcionou muito bem no primeiro teste e permanceu.
 */

package ifsc.poo;

import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.figuras.Circulo;
import ifsc.poo.figuras.Figura;
import ifsc.poo.figuras.Hexagono;
import ifsc.poo.figuras.Pentagono;
import ifsc.poo.figuras.Quadrado;

public class Eventos implements  DrawListener{
    // Atributos
        private boolean preenchido = false;
        private double tamanho = 1.0; // tamanho inicial 
        private final double tamanho_max = 2.0; // tamanho máximo que a figura pode chegar
        private final double tamanho_min = 0.2; // tamanho mínimo que a figura pode chegar
        private int figura_selecionada = 1; // tipo de figurada, por padrão é o Círculo
        private Color corAtual = Color.MAGENTA; // Cor padrão
        private final ArrayList<Figura> figuras = new ArrayList<>(); // Uma lista de figuras desenhadas

    // ========================MOUSE========================
    // Uso de polimorfismo! (Da interface DrawListener)
    @Override
    public void mousePressed(double x, double y){    // Metódo que funciona a leitura de diversos cliques rápidos
        // Quando o mouse é pressionado, ele verifica em qual figura está selecionada.
        Figura figura = null;
        switch(figura_selecionada){
            case 1:
                figura = new Circulo(x,y, tamanho, preenchido, corAtual); 
                break;
            case 2: 
                figura = new Quadrado(x,y, tamanho, preenchido, corAtual);
                break;
        
            case 3:
                figura = new Pentagono(x, y, tamanho, preenchido, corAtual);
                break;
            case 4: figura = new Hexagono(x, y, tamanho, preenchido, corAtual);
                break;
        }
        if(figura != null){
            figuras.add(figura);
            System.out.printf("Figura adicionada em (%.2f, %.2f)%n", x, y);

        }
    }
    

    // ========================TECLADO========================
    // Uso de polimorfismo! (Da interface DrawListener)
    @Override
    public void keyReleased(int i){
        switch(i){  

            case 37:  // seta esquerda
                moverFigura(-0.2, 0); break;

            case 38:  // seta cima
                moverFigura(0, 0.2); break;

            case 39:  // seta direita
                moverFigura(0.2, 0); break;

            case 40:  // seta baixo
                moverFigura(0, -0.2); break;

            case 70:  // F  - Alternar entre preenchido e vazio
                preenchido = !preenchido;
                System.out.println("Modo de preechimento: " + (preenchido ? "preenchido" : "vazado"));
                break;

            case 80:  // P  - Retorna os valores matématicos
                processarFiguras(); // Chama o método para processar as figuras desenhadas
                break;

            case 81:  // Q  - Diminuiu o tamanho da fonte
                tamanho = Math.max(tamanho - 0.5, tamanho_min); // Compara o maior valor, se tamanho se menor que tamanho_min, ele recebe o valor mínimo possível
                System.out.println("Tamanho atual: " + tamanho);
                break;

            case 87:  // W  - Aumenta o tamanho da fonte
                tamanho = Math.min(tamanho + 0.5, tamanho_max);
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
                figura_selecionada = 3; // Seleciona o Pentágono
                System.out.println("Figura selecionada: Pentágono");
                break;

            case 115: // F4 - Hexágano
                figura_selecionada = 4; // Seleciona o Hexágono
                System.out.println("Figura selecionada: Hexágono");
                break;

            case 116: // F5 - vermelho
                corAtual = Color.RED; // Define a cor atual como vermelho
                System.out.println("Cor atual: Vermelho");
                break;

            case 117: // F6 - laranja
                corAtual = Color.ORANGE; // Define a cor atual como Laranja, que parece amarelo
                System.out.println("Cor atual: Laranja(que parece amarelo)");
                break;

            case 118: // F7 - azul
                corAtual = Color.BLUE; // Define a cor atual como azul
                System.out.println("Cor atual: Azul");
                break;

            case 119: // F8 - magenta
                corAtual = Color.MAGENTA; // Define a cor atual como magenta
                System.out.println("Cor atual: MAGENTA");
                break;
        }
    }
    public ArrayList<Figura> getFiguras() {
        return figuras; // Retorna a lista de figuras desenhadas
    }

    private void processarFiguras(){

        int total = figuras.size();
        double soma_area = 0, soma_perimetro = 0;

        for(Figura f : figuras){ // Acessa a lista de figuras e soma todas os perimetros e areas delas.
            soma_perimetro += f.getPerimetro();
            soma_area += f.getArea();
        }

        if(total == 0){
            System.out.println("Nenhuma figura foi desenhada ainda!");
        }
        else{
            System.out.printf("Total de figuras: %d%n", total);
            System.out.printf("Soma dos perímetros: %.2f%n", soma_perimetro);
            System.out.printf("Área: %.2f%n", soma_area / total);
        }
    }

    private void moverFigura(double dx, double dy){
        for(Figura figura : figuras){ // Acessa a lista de figuras, e em cada figura adiciona 0.5 na coordenada desejada.
            figura.mover(dx, dy); // Move cada figura na lista
        }
    }
}


    


