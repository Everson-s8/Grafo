import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Grafo {
    public List<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void adicionarAresta(Vertice origem, Vertice alvo, double peso) {
        Aresta aresta = new Aresta(alvo, peso);
        origem.adicionarVizinho(aresta);
    }

    public void dijkstra(Vertice inicio, Vertice destino) {
        inicio.menorDistancia = 0;
        PriorityQueue<Vertice> fila = new PriorityQueue<>((v1, v2) -> Double.compare(v1.menorDistancia, v2.menorDistancia));
        fila.addAll(vertices);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();

            // Se o vértice atual for o destino desejado, interrompa a busca
            if (atual == destino) {
                break;
            }

            for (Aresta vizinho : atual.vizinhos) {
                Vertice v = vizinho.alvo;
                double novaDistancia = atual.menorDistancia + vizinho.peso;

                if (novaDistancia < v.menorDistancia) {
                    fila.remove(v);
                    v.menorDistancia = novaDistancia;
                    v.anterior = atual;
                    fila.add(v);
                }
            }
        }
    }

    public List<Vertice> getCaminhoMaisCurtoPara(Vertice destino) {
        List<Vertice> caminho = new ArrayList<>();
        for (Vertice vertice = destino; vertice != null; vertice = vertice.anterior) {
            caminho.add(vertice);
        }
        Collections.reverse(caminho);
        return caminho;
    }
}
