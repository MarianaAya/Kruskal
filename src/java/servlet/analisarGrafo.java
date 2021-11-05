
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Kruskal;
import util.Retorno;


@WebServlet(name = "analisarGrafo", urlPatterns = {"/analisarGrafo"})
public class analisarGrafo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao = request.getParameter("acao");
        Retorno r;
        
        String vertices=request.getParameter("vertices");
       
        String[] partes=vertices.split(",");
        //crio a lista para guardar os vertices
        List<List<Integer>> listaV=new ArrayList<>((int)partes.length/4);
        
       
       
        int tam=0;

        tam=(int)(partes.length/4)*2;
      
        for(int i=0;i<tam;i++)//em cada posição de listaV vai ter uma aresta, que é uma lista de dois números de vértice
            listaV.add(new ArrayList<>((int)partes.length/4));
        
        int id=0;
        
        if(partes.length>1){//se existe vertices que veio do front
            for(int i=0;i<partes.length;i+=4){
                listaV.get(id).add(Integer.parseInt(partes[i+1]));
                listaV.get(id).add(Integer.parseInt(partes[i+2]));
                listaV.get(id).add(Integer.parseInt(partes[i+3]));
                id++;
          
                listaV.get(id).add(Integer.parseInt(partes[i+2]));
                listaV.get(id).add(Integer.parseInt(partes[i+1]));
                listaV.get(id).add(Integer.parseInt(partes[i+3]));
                id++;
                
             
                
            }
        }
   
        //Esse código serve para contar a quantidade de vertices que existe
        int qtdev=0,x=0;
        List<Integer> list=new ArrayList<>(tam);

        for(int i=0;i<listaV.size();i++){
            for(int j=0;j<listaV.get(i).size()-1;j++){
                x=0;
                while(x<list.size() && listaV.get(i).get(j)!=list.get(x))
                    x++;
                if(x==list.size()){
                    list.add(listaV.get(i).get(j));
                }
            }
            
        }
        Kruskal p;
        switch (acao.toLowerCase()) {
            case "kruskalfila":
                            
                            p=new Kruskal();
                            r=p.executarTeste1(listaV, list.size());
                            //mando a lista e a quantidade de vertices
                            //p.executarTeste1(listaV, list.size());
                            response.getWriter().print(r.toStringFila());
                    break;
            case "kruskaltabela":
                            p=new Kruskal();
                            r=p.executarTeste1(listaV, list.size());
                            response.getWriter().print(r.toStringTabela());
         
               
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
