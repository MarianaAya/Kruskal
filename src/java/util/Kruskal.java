
package util;

import java.util.ArrayList;
import java.util.List;


public class Kruskal {
    private int n;
    private List<Vertice> grafo,grafo2;
    private Fila f;
    private List<List<Integer>> tabela;
    private Retorno ret;
    public static List<Vertice> criarGrafo(int n) {
      List<Vertice> graph = new ArrayList<>(n);
      for (int i = 0; i < n; i++) 
          graph.add(new Vertice());
      return graph;
    }
    
    //buscao qual é a posição do vertice na lista
    public int buscarPosicaoDoVertice(int num){
        int i=0;
        while(i<n && grafo.get(i).getNum()<num)
            i++;
        return i;
    }
    public void gerar(){
        int i=0,j=0;
        f=new Fila();
        //colocando as arestas na ordem crescente na fila
        for(i=0;i<n;i++){
            for(j=0;j<grafo.get(i).getList().size();j++){
                f.enqueue(grafo.get(i), grafo.get(i).getList().get(j), grafo.get(i).getList().get(j).getValor());
            }
        }
 
        gerarArvore();
        
    }
    public List<List<Integer>> criarTabela(int qtde){
        List<List<Integer>> tab = new ArrayList<>(qtde);
        for(int i=0;i<qtde;i++)
            tab.add(new ArrayList<>(n));
        return tab;
    }
    public void gerarArvore(){
        int qtde=f.tamanho(),it=0,pos1,pos2,rotulo,j,ant;
        NoFila no;
        boolean flag=true;
        grafo2=criarGrafo(n);
        tabela=criarTabela(qtde);
        ret=new Retorno(qtde,n);
        while(!f.isEmpty() && flag){
            ret.inserirFila(f);
            no=f.dequeue();
            flag=true;
            
            pos1=buscarPosicaoDoVertice(no.getV1().getNum());
            pos2=buscarPosicaoDoVertice(no.getV2().getNum());
            
            //se é a primeira linha da tabela
            if(it==0){
                for(int i=0;i<n;i++){
                    if(i==pos1 || i==pos2)
                        tabela.get(it).add(no.getV1().getNum());
                    else
                        tabela.get(it).add(grafo.get(i).getNum());

                }
                adicionarAresta(grafo2, no.getV1().getNum(), no.getV2().getNum(), no.getValor());
                adicionarAresta(grafo2, no.getV2().getNum(), no.getV1().getNum(), no.getValor());
            }
            else{
                //linha anterior
                ant=it-1;
                while(tabela.get(ant).size()==0){
                    ant=ant-1;
                }
                
                rotulo=tabela.get(ant).get(pos2);
               
                //se não terem o mesmo rótulo
                if(!(rotulo==tabela.get(ant).get(pos1))){
                   
                    //primeiro copio a linha de cima
                    for(int i=0;i<n;i++){
                        tabela.get(it).add(tabela.get(ant).get(i));
                    }
                    tabela.get(it).set(pos2, tabela.get(it).get(pos1));
                    for(int i=0;i<n;i++){
                        if(tabela.get(it).get(i)==rotulo)
                            tabela.get(it).set(i, tabela.get(it).get(pos1));
                    }
                    
                    adicionarAresta(grafo2, no.getV1().getNum(), no.getV2().getNum(), no.getValor());
                    adicionarAresta(grafo2, no.getV2().getNum(), no.getV1().getNum(), no.getValor());
                }
                else{//se possuirem o mesmo rotulo
                  
                }
            }
            j=0;
            if(tabela.get(it).size()>0){
                rotulo=tabela.get(it).get(0);
                while(j<n && tabela.get(it).get(j)==rotulo)
                    j++;
                if(j==n)
                    flag=false;
            }
            ret.inserirListaTabela(tabela); 
            it=it+1;
            
        }
        
    }
    public void adicionarAresta(List<Vertice> grafo, int from, int to,int valor) {
        int i=0,j;
        Vertice v;
        while(i<n && grafo.get(i).getNum()<from && grafo.get(i).getNum()!=-1){
            i++;
        }
        if(grafo.get(i).getNum()==from){

            grafo.get(i).adicionarVertice(new Vertice(to,valor)); 
        }
        else
            if(grafo.get(i).getNum()==-1){
                grafo.get(i).setNum(from);
                grafo.get(i).adicionarVertice(new Vertice(to,valor)); 
            }
            else{
                j=0;
                while(j<n && grafo.get(j).getNum()!=-1)
                    j++;
                for(int x=j;x>i;x--){
                    v=new Vertice();
                    v.setNum(grafo.get(x-1).getNum());
                    v.setList(grafo.get(x-1).getList());
                    
                    grafo.set(x, v);
                }
                grafo.get(i).setNum(from);
                grafo.get(i).setList(new ArrayList());
                grafo.get(i).adicionarVertice(new Vertice(to,valor)); 
            }
        
        i=0;
        while(i<n && grafo.get(i).getNum()<to && grafo.get(i).getNum()!=-1){
            i++;
        }
       
        if(grafo.get(i).getNum()==-1){
          
            grafo.get(i).setNum(to);
            
        }
        else{
            
            if(grafo.get(i).getNum()>to){
                int x=i;
                while(x<n && grafo.get(x).getNum()!=-1)
                    x++;
                if(x<n){
                    for(int t=x;t>i;t--){
                        v=new Vertice();
                        v.setNum(grafo.get(t-1).getNum());
                        v.setList(grafo.get(t-1).getList());
                        grafo.set(t, v);
                    }
                    grafo.get(i).setNum(to);
                    grafo.get(i).setList(new ArrayList());
                }
            }
        }

    }
    
    
    
    public Retorno executarTeste1(List<List<Integer>> lista,int qtde){
        n=qtde;
        grafo=criarGrafo(n);
        for(int i=0;i<lista.size();i++){
            
            adicionarAresta(grafo, lista.get(i).get(0), lista.get(i).get(1),lista.get(i).get(2));
        }
        for(int i=0;i<n;i++){
            System.out.println("Vertice "+grafo.get(i).getNum());
            System.out.println(""+grafo.get(i));
            System.out.println("------------");
        }
        gerar();
        return ret;
    }
}
