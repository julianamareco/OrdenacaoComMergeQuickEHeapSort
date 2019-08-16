/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2iaa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Juliana
 */
public class QuickSort {
    
    public QuickSort() throws Exception { 
        //Scanner ler = new Scanner(System.in);
        //System.out.print("Caminho: ");
        //String arq = ler.nextLine();
        
        int cont = 0;
        BufferedReader arquivo = new BufferedReader(new FileReader("inv0.txt"));
        String primeira = arquivo.readLine();
        int tamanho = Integer.parseInt(primeira);

        int vetor[] = new int[tamanho]; 
        
        while (arquivo.ready()) {
            String numero = arquivo.readLine();
            int valor = Integer.parseInt(numero);
            vetor[cont] = valor;
            cont++;
        }

        QS(vetor, 0, vetor.length-1);
        for(int i = 0; i<vetor.length; i++){
            System.out.print(vetor[i] + " - ");
        }
    }

    public void QS(int[]vetor, int inicio, int fim){
        if (inicio < fim) {
            int p = particiona(vetor, inicio, fim); //pivo
            QS(vetor, inicio, p - 1);
            QS(vetor, p + 1, fim);
        }
    }
    
    public int particiona(int[]vetor, int inicio, int fim){
        int p = inicio;
        int i = inicio+1;
        int aux, aux2;
        for (int j=inicio+1; j<fim; j++){
            if(vetor[j] < vetor[p]){
                aux = vetor[j];
                vetor[j] = vetor[i];
                vetor[i] = vetor[j];
                i++;
            }
        }
        
        aux2 = vetor[p];
        vetor[p] = vetor[i-1];
        vetor[i-1] = aux2;
        return i-1;
    }
    
    public static void main (String[] args) throws Exception{
        QuickSort QS = new QuickSort();
    }
    
    
    
}
