/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2iaa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Juliana Mareco Medeiros
 */
public class Trabalho2IAA {

    long inversao;

    public static void main(String[] args) throws IOException {
                Trabalho2IAA tabalho = new Trabalho2IAA();
    }   
    
    public Trabalho2IAA() throws IOException { 
        Scanner ler = new Scanner(System.in);
        System.out.print("Caminho: ");
        String arq = ler.nextLine();
        
        int cont = 0;
        BufferedReader arquivo = new BufferedReader(new FileReader(arq));
        String primeira = arquivo.readLine();
        int tamanho = Integer.parseInt(primeira);

        int v[] = new int[tamanho];
        
        while (arquivo.ready()) {
            String numero = arquivo.readLine();
            int valor = Integer.parseInt(numero);
            v[cont] = valor;
            cont++;
        }

        mergeSort(v, 0, tamanho-1);
        System.out.println("Inversões: " + inversao);

    }

    private void mergeSort(int[] v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(v, inicio, meio);
            mergeSort(v, meio + 1, fim);
            intercalar(v, inicio, meio, fim);
            
            
        }
    }

    private void intercalar(int[] v, int inicio, int meio, int fim) {
        int n1 = meio - inicio +1;
        int n2 = fim - meio;        
        int[] B = new int[n1];
        int[] C = new int[n2]; 
        
        for (int i=0; i<n1; ++i)
            B[i] = v[inicio + i];
        for (int j=0; j<n2; ++j)
            C[j] = v[meio + 1+ j];
        
        int i=0, j=0, k = inicio;
        
        while(i<n1 && j<n2){
            if(B[i]<C[j]){
                v[k] = B[i];
                k++;
                i++;
            }else{
                v[k] = C[j];
                k++;
                j++;
                inversao += n1- i;
                
            }
        }
        
        while(i<n1){
            v[k] = B[i];
            k++;
            i++;
        }
        
        while(j<n2){
            v[k] = C[j];
            k++;
            j++;
        }
        
    }
}
