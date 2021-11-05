
package util;

import java.util.ArrayList;
import java.util.List;


public class Retorno {
    private List<List<Integer>> listaFila;
    private List<List<List<Integer>>> tabelas;
    private int id;
    private int qtde_vertices;
    private int n;
    public Retorno(int n,int qtde_vertices){
        listaFila=new ArrayList<>(n);
        for(int i=0;i<n;i++)
            listaFila.add(new ArrayList<>());
        this.n=n;
        tabelas = new ArrayList<>(n);
        this.qtde_vertices=qtde_vertices;
        id=0;
    }
    public void inserirFila(Fila f){
        NoFila no=f.getInicio();
        while(no!=null){
            listaFila.get(id).add(no.getV1().getNum());
            listaFila.get(id).add(no.getV2().getNum());
            no=no.getProx();
        }
        id++;
    }

    public void inserirListaTabela(List<List<Integer>> tab){
        List<List<Integer>> tab2=new ArrayList<>(n);
        for(int i=0;i<tab.size();i++){
            tab2.add(new ArrayList<>(qtde_vertices));
         
            for(int j=0;j<tab.get(i).size();j++){
                
                tab2.get(i).add(tab.get(i).get(j));
            }
        }
        
     
        tabelas.add(tab2);
    }
    public String toStringFila() {
        return listaFila + "";
    }
    public String toStringTabela() {
       
        return this.tabelas + "";
    }
    
}
