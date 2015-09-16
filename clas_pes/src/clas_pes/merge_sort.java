package clas_pes;

import java.util.Random;

public class merge_sort {

	public static void mergeSort(int[] array, int inicio, int fim) {
		if (fim <= inicio) {
			return;
		}
		int meio = (inicio + fim) / 2;
		mergeSort(array, inicio, meio);
		mergeSort(array, meio + 1, fim);
		int[] A = new int[meio - inicio + 1];
		int[] B = new int[fim - meio];
		for (int i = 0; i <= meio - inicio; i++) {
			A[i] = array[inicio + i];
		}
		for (int i = 0; i <= fim - meio - 1; i++) {
			B[i] = array[meio + 1 + i];
		}
		int i = 0;
		int j = 0;
		for (int k = inicio; k <= fim; k++) {
			if (i < A.length && j < B.length) {
				if (A[i] < B[j]) {
					array[k] = A[i++];
				} else {
					array[k] = B[j++];
				}
			} else if (i < A.length) {
				array[k] = A[i++];
			} else if (j < B.length) {
				array[k] = B[j++];
			}
		}
	}

	public static void main(String[] args) {

		Random gerador = new Random();
		int tv = 100; // Define quantos valores deverá ter dentro do vetor
		int vet[] = new int[tv];
		int i;
		System.out.println("Vetor desordenado");
		for (i = 0; i < tv; i++) {
			vet[i] = gerador.nextInt(tv);
			System.out.println(" " + vet[i]);
		}
		
		mergeSort (vet, 0, tv-1);
		
		System.out.println("Vetor ordenado");
		for (i = 0; i < tv; i++) {
			System.out.println(" " + vet[i]);
		}
	}
}
