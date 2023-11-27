import java.util.ArrayList;
import java.util.List;

class Vertice {
    public String nome;
    public List<Aresta> vizinhos;
    public boolean visitado;
    public double menorDistancia = Double.POSITIVE_INFINITY;
    public Vertice anterior;

    public Vertice(String nome) {
        this.nome = nome;
        this.vizinhos = new ArrayList<>();
    }

    public void adicionarVizinho(Aresta aresta) {
        vizinhos.add(aresta);
    }

    @Override
    public String toString() {
        return nome;
    }
}
