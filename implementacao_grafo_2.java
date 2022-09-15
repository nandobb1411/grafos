package projeto_grafos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class implementacao_grafo_2{

    public static void main(String[] args) throws FileNotFoundException {

        //COLOCA O ARQUIVO NA VARIAVEL NOME ARQUIVO 
        String nomearquivo = "/home/fernandobellelis/DataSets/pequenoG.txt";
        String[][] Adj = new String[13][13]; 
        
        boolean[] listaES = new boolean[13];
        int entradaCount=0;
        int saidaCount=0;
        int countiso = 0;
        int countsaida = 0;

    

        for( int linha = 0; linha < Adj.length; linha++) {
            for( int coluna = 0; coluna < Adj[linha].length; coluna++) {
            
            Adj[linha][coluna] = "0";
            }
        }

        
        Scanner scanner = new Scanner(new FileReader(nomearquivo)).useDelimiter("\\s+|\\n");


        String Vtotal = scanner.next(); 
        String Atotal = scanner.next(); 

        while(scanner.hasNext()){
            
            String v1 = scanner.next();
            String v2 = scanner.next();

            int linhav = Integer.parseInt(v1);
            int colunav= Integer.parseInt(v2);

            Adj[linhav][colunav] = "1";
        }   


        System.out.println("Numero total de Vertices: " + Vtotal);
        System.out.println("Numero total de Arestas: " + Atotal);

        
        for (int l = 0; l < Adj.length; l++)  {  
            for (int c = 0; c < Adj[0].length; c++)     { 
                System.out.print(Adj[l][c] + " "); 
            }  
            System.out.println(" "); 
        }
        System.out.println();
        System.out.println("ordem = "+ Vtotal);
        System.out.println("tamanho = "+ Atotal);
        System.out.println("graus de entrada: ");
        System.out.println();

        for(int p = 0; p<Adj.length;p++){
            for(int w = 0; w<Adj[0].length;w++){
                if(Adj[w][p].equals("1")){
                    entradaCount++;

                }

                if(Adj[p][w].equals("1")){
                    saidaCount++;

                }

            }
            System.out.println("grau de entrada para vertice " + p + " e igual a " + entradaCount + " e o grau de saida e igual a " + saidaCount);

            if(entradaCount == 0 && saidaCount == 0){
                System.out.println("Vertice " + p + " e isolado");
                countiso++;

            }else{
                System.out.println("Vertice " + p + " não e isolado");
            }

            if(saidaCount == 0){
                System.out.println("Vertice " + p + " e um vertice de extremidade");
                countsaida++;

            }else{
                System.out.println("Vertice " + p + " não e um vertice de extremidade");
            }

            entradaCount = 0;
            saidaCount = 0;
        }
        System.out.println("Numero de vertices isolados = " + countiso);
        System.out.println("Numero de vertices de extremidade = " + countsaida);

        
        
}
}
