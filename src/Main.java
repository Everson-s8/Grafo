import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice R1 = new Vertice("R1");
        Vertice R2 = new Vertice("R2");
        Vertice R3 = new Vertice("R3");
        Vertice R4 = new Vertice("R4");
        Vertice R5 = new Vertice("R5");

        grafo.adicionarVertice(R1);
        grafo.adicionarVertice(R2);
        grafo.adicionarVertice(R3);
        grafo.adicionarVertice(R4);
        grafo.adicionarVertice(R5);

        grafo.adicionarAresta(R1, R2, 2);
        grafo.adicionarAresta(R1, R3, 3);
        grafo.adicionarAresta(R2, R3, 4);
        grafo.adicionarAresta(R2,R1, 2);
        grafo.adicionarAresta(R2,R4, 1);
        grafo.adicionarAresta(R3, R4, 2);
        grafo.adicionarAresta(R3, R5, 4);
        grafo.adicionarAresta(R3, R2, 4);
        grafo.adicionarAresta(R4, R5, 1);
        grafo.adicionarAresta(R4,R3, 2);
        grafo.adicionarAresta(R4,R2, 1);
        grafo.adicionarAresta(R5,R3, 4);
        grafo.adicionarAresta(R5,R4, 1);


        Vertice origem = R3;
        Vertice destino = R2;

        grafo.dijkstra(origem, destino);

        List<Vertice> caminhoMaisCurto = grafo.getCaminhoMaisCurtoPara(destino);

        System.out.println("Caminho mais curto de " + origem.nome + " para " + destino.nome + ": " + caminhoMaisCurto);
        System.out.println("Peso total: " + destino.menorDistancia);
    }
}