package projeto_grafos;


import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


 
class DFS {
    
    static int[][] MatrizAdjecencia;
    
 
    
    static void AddAresta(int x, int y)
    {

        MatrizAdjecencia[x][y] = 1;
        MatrizAdjecencia[y][x] = 1;
    }
 
    
    static void dfs(int start, boolean[] visitado)
    {
 
        
        System.out.print(start + " ");
 
        
        visitado[start] = true;
 
        
        for (int i = 0; i < MatrizAdjecencia[start].length; i++) {
 
            
            if (MatrizAdjecencia[start][i] == 1 && (!visitado[i])) {
                dfs(i, visitado);
            }
        }
        
    }
 
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        String nomearquivo = "/home/fernandobellelis/DataSets/pequenoG.txt";
        Scanner scanner = new Scanner(new FileReader(nomearquivo)).useDelimiter("\\s+|\\n");
        
        String vertex = scanner.next(); //vertices totais 13
        String edge = scanner.next(); //arestas totais 13
        int v = Integer.parseInt(vertex);
        int e = Integer.parseInt(edge);


        
 
        // MatrizAdjecenciaacency matrix
        MatrizAdjecencia = new int[v][v];

        while(scanner.hasNext()){
        
            String v1 = scanner.next();
            String v2 = scanner.next();
    
            int linhav = Integer.parseInt(v1);
            int colunav= Integer.parseInt(v2);
    
            AddAresta(linhav,colunav);

        }
 
    
        boolean[] visitado = new boolean[v];
 
        // fazer bfs singular
        System.out.println("Imprimindo matriz de adjacencia: ");

    for (int l = 0; l < MatrizAdjecencia.length; l++)  {  
        for (int c = 0; c < MatrizAdjecencia[0].length; c++)     { 
            System.out.print(MatrizAdjecencia[l][c] + " "); //imprime caracter a caracter
        }  
        System.out.println(" "); //muda de linha
      }
        System.out.println();
        System.out.println("para conseguir ver as outras vertices, entrar no codigo e alterar o numero da vertice inicial chamada na função na linha 89");
        System.out.println();
        dfs(1, visitado);

        
        
        
        

        
    }
}