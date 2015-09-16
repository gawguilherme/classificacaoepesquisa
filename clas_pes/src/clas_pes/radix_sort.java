package clas_pes;

import java.util.Random;
import java.util.Scanner;

public class radix_sort {

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

	public static void radixsort(int[] vetor, int tamanho) {
		int i;
		int b[] = new int[tamanho];
		int maior = vetor[0];
		int exp = 1;

		for (i = 0; i < tamanho; i++) {
			if (vetor[i] > maior)
				maior = vetor[i];
		}

		while (maior / exp > 0) {
			int bucket[] = new int[10];
			for (i = 0; i < tamanho; i++)
				bucket[(vetor[i] / exp) % 10]++;
			for (i = 1; i < 10; i++)
				bucket[i] += bucket[i - 1];
			for (i = tamanho - 1; i >= 0; i--)
				b[--bucket[(vetor[i] / exp) % 10]] = vetor[i];
			for (i = 0; i < tamanho; i++)
				vetor[i] = b[i];
			exp *= 10;
		}
	}

	public static void main(String[] args) {

		Random gerador = new Random();
		int tv = 100000; // Define quantos valores deverá ter dentro do vetor
		int vet[] = new int[tv];
		int i, op, cc = 0;
		System.out.println("Vetor desordenado");
		for (i = 0; i < tv; i++) {
			vet[i] = gerador.nextInt(tv);
			System.out.println(" " + vet[i]);
		}
		long inicio = System.currentTimeMillis();
		while (cc < 5) {
			mergeSort(vet, 0, tv - 1);
			radixsort(vet, tv);

			long fim = System.currentTimeMillis() - inicio;
			System.out.println("Vetor ordenado");
			for (i = 0; i < tv; i++) {
				System.out.println(" " + vet[i]);
			}
			System.out.println("O Vetor demorou: " + fim + " mili segundos com o mergsort");
			cc++;
		}
		cc = 0;
		while (cc < 5) {
			radixsort(vet, tv);

			long fim = System.currentTimeMillis() - inicio;
			System.out.println("Vetor ordenado");
			for (i = 0; i < tv; i++) {
				System.out.println(" " + vet[i]);
			}
			System.out.println("O Vetor demorou: " + fim + " mili segundos com o radixsort");
			cc++;
		}
	}
}
