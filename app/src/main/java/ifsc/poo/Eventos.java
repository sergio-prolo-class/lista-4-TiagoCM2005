package ifsc.poo;
import edu.princeton.cs.algs4.DrawListener;

public class Eventos implements  DrawListener{
        private boolean preenchido;
        private int tamanho;
        private int tamanho_max = 100;
        private int tamanho_min = 100;


    // Metódo que funciona a leitura de diversos cliques rápidos
    public void mousePressed(double x, double y){
        System.out.printf("%g , %g", x,y);
    }

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
                tamanho = Math.max(tamanho - 5, tamanho_min); // Compara o maior valor, se tamanho se menor que tamanho_min, ele recebe o valor mínimo possível
                System.out.println("Tamanho atual: " + tamanho);
                break;
            case 87:  // W  - Aumenta o tamanho da fonte
                tamanho = Math.min(tamanho + 5, tamanho_max);
                System.out.println("Tamanho atual: " + tamanho);
                break;
            case 67:  // C  - Limpar
            case 112: // F1 - Círculo
            case 113: // F2 - Quadrado
            case 114: // F3 - Pentágono
            case 115: // F4 - Hexágano
            case 116: // F5 - vermelho
            case 117: // F6 - preto
            case 118: // F7 - azul
            case 119: // F8 - rosa
            
        }
    } 
}

/* Seleção de modo: Usando a tecla ‘F’, o usuário pode alternar entre impressão vazada ou preenchida.
Caso vazada, a cor da borda deve ser a cor selecionada pelo usuário. Caso preenchida, a cor da
borda deve ser preta.

Seleção de tamanho: Usando as teclas ‘Q’ e ‘W’, o usuário pode diminuir e aumentar o tamanho da
figura a ser impressa, respectivamente. Você deve limitar o tamanho de impressão a valores mínimo
e máximo, evitando a não visualização da impressão.
Movimento: Usando as setas do teclado, o usuário pode mover todas as figuras desenhadas nas
quatro direções cardinais.

Limpeza: Usando a tecla ‘C’, o usuário pode limpar todos os desenhos da tela.
Processar: Usando a tecla ‘P’, o usuário pode receber as seguintes informações sobre as figuras
atualmente impressas na tela através do terminal: número total, soma perímetros e área média. */
