public class ListaGen{
    private Node cab;

    public ListaGen() {
        this.cab = null;
    }

    public void constroiLista(String lista){
        Pilha pilha = new Pilha();
        Node aux = null;
        int i=0;
        while(i < lista.length()){
            if(i < lista.length() && lista.charAt(i) == '['){
                if(cab == null){
                    Lista novo = new Lista(null,null);
                    novo.setEhAtomo(false);
                    aux = cab = novo;
                    pilha.push(novo);
                }
                else{
                    if(lista.charAt(i+1) == ']'){
                        i++;
                    }
                    else{
                        Lista novo = new Lista(null,null);
                        novo.setEhAtomo(false);
                        pilha.push(aux);
                        ((Lista) aux).setHead(novo);
                        aux = novo;
                    }
                }
                i++;
            }
            else{
                if(i < lista.length() && lista.charAt(i) == ','){
                    Lista novo = new Lista(null,null);
                    novo.setEhAtomo(false);
                    ((Lista) aux).setTail(novo);
                    aux = novo;
                    i++;
                }
                else{
                    if(i < lista.length() && lista.charAt(i) == ']'){
                        i++;
                        aux = pilha.pop();
                    }
                    else{
                        String nova = "";
                        while(i < lista.length() && lista.charAt(i) != ',' && lista.charAt(i) != ']'){
                            nova = nova + lista.charAt(i);
                            i++;
                        }
                        Atomo novo = new Atomo(nova);
                        novo.setEhAtomo(true);
                        ((Lista) aux).setHead(novo);
                    }
                }
            }
        }
    }

    public void exibe(Node aux){
        if(aux != null){
            if(aux.isEhAtomo()){
                System.out.printf("%s",((Atomo) aux).getInfo());
            }
            else {
                System.out.printf("[");
                while(aux != null){
                    exibe(((Lista) aux).getHead());
                    aux = ((Lista) aux).getTail();
                    if(aux != null)
                        System.out.printf(",");
                    else
                        System.out.printf("]");
                }
            }
        }
        else{
            System.out.printf("[]");
        }
    }

    public void exibir(){
        Node aux = cab;
        exibe(aux);
    }

}
