function teste(){
    vertices=[];
    vertices.push([0,1,2,1]);
    vertices.push([1,2,3,2]);
    vertices.push([2,1,4,4]);
    vertices.push([3,2,4,6]);
    vertices.push([4,2,5,4]);
    vertices.push([5,3,5,5]);
    vertices.push([6,3,6,6]);
    vertices.push([7,4,5,3]);
    vertices.push([8,5,6,8]);
    vertices.push([9,4,7,4]);
    vertices.push([10,5,7,7]);
    vertices.push([11,6,7,3]);
    MostrarVertices();
    kruskal();

}
function teste1(){
    vertices=[];
    vertices.push([0,1,2,4]);
    vertices.push([1,1,8,8]);
    vertices.push([2,2,8,11]);
    vertices.push([3,2,3,8]);
    vertices.push([4,8,9,7]);
    vertices.push([5,3,9,2]);
    vertices.push([6,8,7,1]);
    vertices.push([7,9,7,6]);
    vertices.push([8,7,6,2]);
    vertices.push([9,3,6,4]);
    vertices.push([10,3,4,7]);
    vertices.push([11,4,6,14]);
    vertices.push([12,4,5,9]);
    vertices.push([13,6,5,10]);
    MostrarVertices();
    kruskal();
}
function teste2(){
    vertices=[];
    vertices.push([0,1,2,6]);
    vertices.push([1,1,3,1]);
    vertices.push([2,1,4,5]);
    vertices.push([3,2,3,2]);
    vertices.push([4,2,5,5]);
    vertices.push([5,3,4,2]);
    vertices.push([6,3,5,6]);
    vertices.push([7,3,6,4]);
    vertices.push([8,5,6,3]);
    MostrarVertices();
    kruskal();
}
function teste3(){
    vertices=[];
    vertices.push([0,1,2,4]);
    vertices.push([1,1,6,8]);
    vertices.push([2,2,6,8]);
    vertices.push([3,2,3,8]);
    vertices.push([4,3,4,2]);
    vertices.push([5,4,6,7]);
    vertices.push([6,4,5,6]);
    vertices.push([7,5,6,1]);
    MostrarVertices();
    kruskal();
}
function teste4(){
    vertices=[];
    vertices.push([0,1,3,6]);
    vertices.push([1,2,3,3]);
    vertices.push([2,2,5,8]);
    vertices.push([3,2,6,3]);
    vertices.push([4,3,6,1]);
    vertices.push([5,3,4,9]);
    //vertices.push([6,3,7,2]);
    vertices.push([7,6,7,5]);
    vertices.push([8,4,7,1]);
    vertices.push([9,5,6,2]);
    MostrarVertices();
    kruskal();
}
function teste5(){
    vertices=[];
    vertices.push([0,1,2,35]);
    vertices.push([1,1,3,40]);
    vertices.push([2,2,3,25]);
    vertices.push([3,2,4,10]);
    vertices.push([4,3,4,20]);
    vertices.push([5,3,5,15]);
    vertices.push([6,4,5,30]);
    MostrarVertices();
    kruskal();
    
}
function teste6(){
    vertices=[];
    vertices.push([0,1,2,2]);
    vertices.push([1,1,3,3]);
    vertices.push([2,2,4,2]);
    vertices.push([3,3,4,1]);
    vertices.push([4,4,5,2]);
    vertices.push([5,4,6,4]);
    vertices.push([6,5,6,1]);
    vertices.push([7,5,7,2]);
    vertices.push([8,6,7,2]);
    vertices.push([9,6,8,1]);
    vertices.push([10,7,8,3]);
    MostrarVertices();
    kruskal();
}
function teste7(){
    vertices=[];
    vertices.push([0,1,2,16]);
    vertices.push([1,1,3,10]);
    vertices.push([2,1,10,12]);
    vertices.push([3,2,3,7]);
    vertices.push([4,2,4,13]);
    vertices.push([5,2,5,2]);
    vertices.push([6,3,5,1]);
    vertices.push([7,3,7,21]);
    vertices.push([8,4,7,15]);
    vertices.push([9,5,6,9]);
    vertices.push([10,5,11,4]);
    vertices.push([11,6,7,3]);
    vertices.push([12,6,8,20]);
    vertices.push([13,7,8,18]);
    vertices.push([14,7,9,17]);
    vertices.push([15,8,10,19]);
    
    vertices.push([16,9,10,5]);
    vertices.push([17,9,11,6]);
    vertices.push([18,9,12,14]);
    vertices.push([19,11,12,11]);
    vertices.push([20,6,11,8]);
 
    MostrarVertices();
    kruskal();
}
function mostrarLista(){
    var grafo=document.getElementById("div-grafo");
    var list=[];
    var x=0;
 
    var resp="";
    resp+="<div class='div-listaAdjacente' id='div-listaAdjacente'>";
    for(let i=0;i<vet.length;i++){
        
                    
        
        resp+="<div class='div-lista'>"
        resp+="<div class='div-no'>"+vet[i]+"</div>"+"=> ";
        for(let j=0;j<vertices.length;j++){
            if(vertices[j][1]===vet[i]){
                resp+="<div class='div-lig'>";
                resp+="<div class='div-ligno'>"+vertices[j][2]+"</div>";
                resp+="<div class='div-ligvalor'>"+vertices[j][3]+"</div>";
                resp+="</div>";
            }
            if(vertices[j][2]===vet[i]){
                resp+="<div class='div-lig'>";
                resp+="<div class='div-ligno'>"+vertices[j][1]+"</div>";
                resp+="<div class='div-ligvalor'>"+vertices[j][3]+"</div>";
                resp+="</div>";
                
            }
        }
        resp+='</div>';
    }
    resp+="</div>";
    grafo.innerHTML=resp;
}
function procurarValor(v1,v2){
    let i=0;
    let flag=true;
    
    while(i<vertices.length && !((vertices[i][1]===v1 && vertices[i][2]===v2) 
            || (vertices[i][1]===v2 && vertices[i][2])===v1)){
      
        i++;
    }
    
    return vertices[i][3];
}
var custo=0;
function montarArvore(list){
    let resp="";
    let valor=0;
    custo=0;
    
    for(let i=0;i<vet.length;i++){
        
        resp+="<div class='div-lista'>"
        resp+="<div class='div-no'>"+vet[i]+"</div>"+"=> ";
        for(let j=0;j<list.length;j++){
           
            valor=procurarValor(list[j][0],list[j][1]);
            
            if(list[j][0]===vet[i]){
                resp+="<div class='div-lig'>";
                resp+="<div class='div-ligno'>"+list[j][1]+"</div>";
                resp+="<div class='div-ligvalor'>"+valor+"</div>";
                resp+="</div>";
                custo+=valor;
            }
            if(list[j][1]===vet[i]){
                resp+="<div class='div-lig'>";
                resp+="<div class='div-ligno'>"+list[j][0]+"</div>";
                resp+="<div class='div-ligvalor'>"+valor+"</div>";
                resp+="</div>";
            }
        }
        resp+='</div>';
    }
    return resp;
}

function kruskal(){
    var resposta=document.getElementById("div-resposta");
    
    if(vertices.length>0){
        listarVertices();
        
        mostrarLista();
        var formData = new FormData();
        let list;

        formData.append('vertices',vertices);
      
        
        fetch('analisarGrafo?acao=kruskalfila',{method:'post', body: formData}).then(function(response)
        {
            response.text().then(function(result)  //response é um promisse
            {
                
                obj_fila=JSON.parse(result);
                fetch('analisarGrafo?acao=kruskaltabela',{method:'post', body: formData}).then(function(response){
                    response.text().then(function(result)
                    {
                        custo=0;
                        obj_tabelas=JSON.parse(result);
                        var resp='';
                        for(let i=0;i<obj_fila.length;i++){
                            list=[]
                            if(obj_fila[i].length>0){
                                let fila='';
                                for(let j=0;j<obj_fila[i].length;j+=2){
                                    fila+="{"+obj_fila[i][j]+","+obj_fila[i][j+1]+"} "
                                }
                                
                                let tabela='';
                                tabela+="<table class='tabela'><thead><tr>"
                                tabela+="<th>Arestas</th>"
                                for(let i=0;i<vet.length;i++){
                                    tabela+="<th>"+vet[i]+"</th>";
                                }
                                tabela+="</tr></thead>";
                                tabela+="<tbody>";

                                for(let x=0;x<i+1;x++){
                                    let aresta=''
                                    aresta=obj_fila[0][x*2]+","+obj_fila[0][x*2+1]
                                    tabela+="<tr>"
                                    tabela+="<td>"+aresta+"</td>"
                                    for(let t=0;t<obj_tabelas[i][x].length;t++){
                                      
                                        tabela+="<td>"+obj_tabelas[i][x][t]+"</td>"
                                        
                                    }
                                    if(obj_tabelas[i][x].length>0){
                                        
                                        
                                        list.push([obj_fila[0][x*2],obj_fila[0][x*2+1]]);
                                    }
                                    tabela+="</tr>";
                                }
                                tabela+="</tbody></table>";
                                let listaAdjacencia=montarArvore(list);
                                resp+="<div class='div-bloco'>"+
                                                        "<div class='div-fila'>Fila: "+
                                                            fila+

                                                        "</div>"+  
                                                        "<div class='div-tabela'>"+
                                                            tabela+
                                                        "</div>"+
                                                        "<div class='div-resplista'>"+
                                                            listaAdjacencia+
                                                        "</div>"+
                                                        
                                                  "</div>";
                            }
                        }
                        resp+="<p class='p-custo'>Custo Total: "+custo+"</p>";
                        resposta.innerHTML=resp;
                        
                    });
                    
                }).catch(function(err){console.error(err);});
                
                

            });
        }).catch (function(err) {console.error(err);});
    }
}


var vertices=[];
var vet=[];
function verticeNaLista(v){
    let i=0;
    while(i<vet.length && v!==vet[i]){
        i++;
    }
    return i<vet.length;
}
function listarVertices(){
    vet=[];
    let aux;
    for(let i=0;i<vertices.length;i++){
        for(let j=1;j<vertices[i].length-1;j++){
            if(!verticeNaLista(parseInt(vertices[i][j])) && parseInt(vertices[i][j])!==-1)
                vet.push(parseInt(vertices[i][j]));
        }
    }
    for(let i=0;i<vet.length-1;i++){
        for(let j=i+1;j<vet.length;j++){
            if(vet[i]>vet[j]){
                aux=vet[i];
                vet[i]=vet[j]
                vet[j]=aux
            }
        }
    }
 
   
}
function addVertice(){
    var v1=document.getElementById("v1").value;
    var v2=document.getElementById("v2").value;
    var valor=document.getElementById("valor").value;
    var msg=document.getElementById("msg-erro")
    var Vcod;
    if(v1.length===0 || v2.length===0 || valor.length===0){
        
        msg.innerHTML="<p>Dado inválido</p>"
    }
    else{
        msg.innerHTML="";
        var Vcod=0;
            if(vertices.length>0)
                Vcod=vertices[vertices.length-1][0]+1;
            vertices.push([Vcod,parseInt(v1),parseInt(v2),parseInt(valor)]);
            document.getElementById("corpoTabela").innerHTML+="<tr>"+
            "<td>"+vertices[vertices.length-1][1]+"</td>"+
            "<td>"+vertices[vertices.length-1][2]+"</td>"+
            "<td>"+vertices[vertices.length-1][3]+"</td>"+
            "<td>"+
            "<button type='button' onClick='removerVertice("+vertices[vertices.length-1][0]+")'>Excluir</button>"+
            "</td>"+
            "</tr>";
    }
}
function removerVertice(codV){
    
    let i=0;
  
    while(i<vertices.length && vertices[i][0]!==codV){
        i++;
    }
    
    vertices=vertices.filter(vertices=>vertices[0]!==codV);
    
    MostrarVertices();
}
function MostrarVertices(){
    document.getElementById("corpoTabela").innerHTML="";
    for(var i=0;i<vertices.length;i++){
        document.getElementById("corpoTabela").innerHTML+="<tr>"+
        "<td>"+vertices[i][1]+"</td>"+
        "<td>"+vertices[i][2]+"</td>"+
        "<td>"+vertices[i][3]+"</td>"+
        "<td>"+
        "<button type='button' class='btn btn-outline-danger' onClick='removerVertice("+vertices[i][0]+")'>Excluir</button>"+
        "</td>"+
        "</tr>";
    }
            
}



