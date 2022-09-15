package projeto_grafos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class grafo_1{

    public static void main(String[] args) throws FileNotFoundException {
        String nomearquivo = "/home/fernandobellelis/DataSets/pequenoG.txt";
        String[][] listaAdj = new String[13][13]; //Matriz [12][12]
        // int[][] listaVert = new int[13][13]; //Matriz [12][12]
        boolean[] listaES = new boolean[13];
        int entradaCount=0;
        int saidaCount=0;
        int countiso = 0;
        int countsaida = 0;

    //Preencher matriz com 0

        for( int linha = 0; linha < listaAdj.length; linha++) {
            for( int coluna = 0; coluna < listaAdj[linha].length; coluna++) {
            //Gera um numero qualquer para a matriz
            listaAdj[linha][coluna] = "0";
            }
        }

        
        Scanner scanner = new Scanner(new FileReader(nomearquivo)).useDelimiter("\\s+|\\n");


        String Vtotal = scanner.next(); //vertices totais 13
        String Atotal = scanner.next(); //arestas totais 13

        while(scanner.hasNext()){
            
            String v1 = scanner.next();
            String v2 = scanner.next();

            int linhav = Integer.parseInt(v1);
            int colunav= Integer.parseInt(v2);

            listaAdj[linhav][colunav] = "1";
        }   


        System.out.println("Numero total de Vertices: " + Vtotal);
        System.out.println("Numero total de Arestas: " + Atotal);

        System.out.println("Imprimindo matriz de adjacencia: ");

        for (int l = 0; l < listaAdj.length; l++)  {  
            for (int c = 0; c < listaAdj[0].length; c++)     { 
                System.out.print(listaAdj[l][c] + " "); //imprime caracter a caracter
            }  
            System.out.println(" "); //muda de linha
        }
        System.out.println();
        System.out.println("ordem = "+ Vtotal);
        System.out.println("tamanho = "+ Atotal);
        System.out.println("graus de entrada: ");
        System.out.println();

        for(int p = 0; p<listaAdj.length;p++){
            for(int w = 0; w<listaAdj[0].length;w++){
                if(listaAdj[w][p].equals("1")){
                    entradaCount++;

                }

                if(listaAdj[p][w].equals("1")){
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