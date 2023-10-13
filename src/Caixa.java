public class Caixa {
    Node info;
    Caixa prox;

    public Caixa(Node info) {
        this.info = info;
    }

    public Node getInfo() {
        return info;
    }

    public void setInfo(Node info) {
        this.info = info;
    }

    public Caixa getProx() {
        return prox;
    }

    public void setProx(Caixa prox) {
        this.prox = prox;
    }
}
