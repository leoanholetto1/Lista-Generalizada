public class Pilha {
    Caixa topo;

    public Pilha() {
        this.topo = null;
    }

    public void push(Node no){
        Caixa novo = new Caixa(no);
        if(topo == null){
            topo = novo;
        }
        else{
            novo.setProx(topo);
            topo = novo;
        }
    }

    public Node pop(){
        Node aux = topo.getInfo();
        topo = topo.getProx();
        return aux;
    }

    public boolean empty(){
        if(topo == null) return true;
        else return false;
    }
}
