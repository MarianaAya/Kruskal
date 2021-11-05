
package util;


public class Fila {
    private NoFila inicio;

    public Fila() {
        inicio=null;
    }
    public void enqueue(Vertice v1,Vertice v2, int valor){
        NoFila novo=new NoFila(v1,v2,valor),aux,ant;
        if(!procurarAresta(v1,v2,valor)){
            if(inicio==null){
                inicio=novo;

            }
            else{
                if(inicio.getValor()>valor){
                    novo.setProx(inicio);
                    inicio=novo;
                }
                else{
                    aux=inicio;
                    ant=inicio;
                    while(aux.getProx()!=null && aux.getValor()<=valor){
                        ant=aux;
                        aux=aux.getProx();
                    }
                    if(aux.getValor()>valor){
                        ant.setProx(novo);
                        novo.setProx(aux);

                    }
                    else{
                        novo.setProx(aux.getProx());
                        aux.setProx(novo);
                    }
                }

            }
        }
    }
    public boolean procurarAresta(Vertice v1,Vertice v2,int valor){
        NoFila aux;
        boolean achou=false;
        aux=inicio;
        while(aux!=null && !achou){
            if((aux.getV1().getNum()==v1.getNum() && aux.getV2().getNum()==v2.getNum()) ||
               (aux.getV1().getNum()==v2.getNum() && aux.getV2().getNum()==v1.getNum())){
                
                achou=true;
            }
            aux=aux.getProx();
                
        }
        return achou;
    }
    public void exibirFila(){
        NoFila aux=inicio;
        while(aux!=null){
            System.out.println(""+aux.getV1().getNum()+", "+aux.getV2().getNum()+" Valor="+aux.getValor());
            
            aux=aux.getProx();
        }
    }
    public boolean isEmpty(){
        return inicio==null;
    }
    public NoFila dequeue(){
        NoFila aux=null;
        if(inicio!=null){
            aux=inicio;
            inicio=inicio.getProx();
        }
        return aux;
    }
    public NoFila getInicio(){
        return inicio;
    }
    
    public int tamanho(){
        int i=0;
        NoFila aux=inicio;
        while(aux!=null){
            i=i+1;
            aux=aux.getProx();
        }
        
        return i;
        
    }
}
