
package util;

import java.util.ArrayList;
import java.util.List;


public class Vertice {
    private int num;
    private List<Vertice> list;
    private int valor;

    public Vertice(int num,int valor) {
        this.num = num;
        this.list=new ArrayList();
        this.valor=valor;
    }
    public Vertice() {
        this.num = -1;
        this.list=new ArrayList();
        this.valor=0;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Vertice> getList() {
        return list;
    }

    public void setList(List<Vertice> list) {
        this.list = list;
    }
    public int getGrau(){
        return list.size();
    }
    
    public void adicionarVertice(Vertice v){
        int j=0;
        Vertice aux;
        while(j<list.size() && list.get(j).getNum()<v.getNum())
            j++;
        if(j==list.size()){
            list.add(v);
        }
        else{
            list.add(new Vertice());
            for(int x=list.size()-1;x>j;x--){
                aux=new Vertice();
                aux.setNum(list.get(x-1).getNum());
                aux.setList(list.get(x-1).getList());
                aux.setValor(list.get(x-1).getValor());
                list.set(x, aux);
            }
            list.set(j, v);
          
            
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Vertice{" + "num=" + num+", valor=" + valor  + ", list=" + list +  '}';
    }
}
