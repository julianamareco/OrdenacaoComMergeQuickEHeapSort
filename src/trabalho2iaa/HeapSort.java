/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2iaa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.StrictMath.floor;

/**
 *
 * @author Juliana
 */
public final class HeapSort {

    int heapsize;

    public HeapSort() throws FileNotFoundException, IOException {
        int cont = 0;
        BufferedReader arquivo = new BufferedReader(new FileReader("inv0.txt"));
        String primeira = arquivo.readLine();
        int tamanho = Integer.parseInt(primeira);

        int vetor[] = new int[tamanho]; //ok

        while (arquivo.ready()) {
            String numero = arquivo.readLine();
            int valor = Integer.parseInt(numero);
            vetor[cont] = valor;
            cont++;
        }

        //HEAPIFX(vetor, tamanho);
        HEAPSORT(vetor, tamanho);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " - ");
        }
    }

    public void HEAPIFY(int A[], int N, int i) {
        int l, r, maior;

        l = ESQ(i);
        r = DIR(i);
        if ((l <= N) && (l <= heapsize) && (A[l] > A[i])) // Seleciona o maior entre  // 
        {
            maior = l;                                        // pai, filho esquerdo e filho direito // 
        } else {
            maior = i;
        }
        if ((r <= N) && (r <= heapsize) && (A[r] > A[maior])) {
            maior = r;
        }
        if (maior != i) {
            swap(A[i], A[maior]);    // troca a posicao dos elementos // 
            HEAPIFY(A, N, maior);
        }
        return;
    }

//    public void HEAPIFX(int A[], int n) {
//        for (int i = 1; i < n; i++) {
//            if (A[i] < A[(i + 1) / 2 - 1]) {
//                RollUp(A, i);
//            }
//        }
//    }
//
//    public void HEAPSORT(int A[], int n) {
//        for (int i = n - 1; i < 1; i--) {
//            int aux = A[i];
//            A[i] = A[0];
//            A[0] = aux;
//            RollDown(A, 0, i);
//        }
//    }
//    public void RollUp(int A[], int i) {
//        if (i == 0) {
//
//        }
//        while (A[i] < A[PAI(i)]) {
//            int aux = A[PAI(i)];
//            A[PAI(i)] = A[i];
//            A[i] = A[PAI(i)];
//            i = PAI(i);
//        }
//    }
//
//
//    public void RollDown(int A[], int i, int N) {
//        int j;
//        while (A[i] > A[ESQ(i)] || A[i] > A[DIR(i)]) {
//
//            if (ESQ(i) >= N) {
//                return;
//            } else if (DIR(i) >= N) {
//                j = ESQ(i);
//            } else {
//                if (A[ESQ(i)] < A[DIR(i)]) {
//                    j = ESQ(i);
//                } else {
//                    j = DIR(i);
//                }
//                int aux = A[i];
//                A[i] = A[j];
//                A[j] = aux;
//                i = j;
//
//            }
//        }
//
//    }
    public void BUILDHEAP(int A[], int N) {
        int i;
        heapsize = N;
        for (i = N / 2; i > 0; i--) // Para cada n� interno(n�o-folha),  // 
        {
            HEAPIFY(A, N, i);                  // chama HEAPIFY, seguindo o sentido folha-raiz  // 
        }
    }

    public void HEAPSORT(int A[], int N) {
        int i;

        BUILDHEAP(A, N);          // Cria o Heap // 
        for (i = N; i > 0; i--) {
            swap(A[1], A[i]);       // Coloca o maior elemento no final do vetor // 
            heapsize--;
            HEAPIFY(A, N, 1);        // Refaz o Heap, desconsiderando o elemento que foi p/ o final  // 
            //  at� que o vetor esteja ordenado  // 
        }
    }

    public int PAI(int i) {
        return (i / 2);
    }

    public int DIR(int i) {
        return (i * 2 + 1);
    }

    public int ESQ(int i) {
        return (i * 2);
    }

    
    private void swap(int i, int i0) {
        int aux;
        aux = i;
        i = i0;
        i0 = aux;
    }
    
    public static void main(String[] args) throws IOException {
        HeapSort hp = new HeapSort();
    }


}
