package clas_pes;

import java.util.Random;

public class exer1 {

	private static int parte(int inicio, int fim, int[] vet) {
		int i = inicio, f = fim, chave = vet[inicio], pos = 0;
		boolean volta = true;

		while (i < f) {
			if (volta) {
				if (chave >= vet[f]) {
					vet[i] = vet[f];
					i++;
					volta = false;
				} else {
					f--;
				}
			} else {
				if (chave < vet[i]) {
					vet[f] = vet[i];
					f--;
					volta = true;
				} else {
					i++;
				}
			}
		}
		pos = i;
		vet[pos] = chave;
		return pos;
	}

	private static int parte2(int inicio, int fim, String[] vet1, long[] vet2) {
		int i = inicio, f = fim, pos = 0;
		long chave = vet2[inicio];
		boolean volta = true;

		while (i < f) {
			if (volta) {
				if (chave >= vet2[f]) {
					vet2[i] = vet2[f];
					vet1[i] = vet1[f];
					i++;
					volta = false;
				} else {
					f--;
				}
			} else {
				if (chave < vet2[i]) {
					vet2[f] = vet2[i];
					vet1[f] = vet1[i];
					f--;
					volta = true;
				} else {
					i++;
				}
			}
		}
		pos = i;
		vet2[pos] = chave;
		return pos;
	}

	private static void quick(int inicio, int fim, int[] vet) {
		int posicao;
		if (fim > inicio) {
			posicao = parte(inicio, fim, vet);
			quick(inicio, posicao - 1, vet);
			quick(posicao + 1, fim, vet);
		}
	}

	private static void quick2(int inicio, int fim, String[] vet, long[] vet2) {
		int posicao;
		if (fim > inicio) {
			posicao = parte2(inicio, fim, vet, vet2);
			quick2(inicio, posicao - 1, vet, vet2);
			quick2(posicao + 1, fim, vet, vet2);
		}
	}

	public static void seldir(int inicio, int fim, int[] vet) {
		int i = inicio + 1, maior = vet[inicio], pos = inicio, max = fim;

		while (max != inicio) {
			if (maior < vet[i]) {
				maior = vet[i];
				pos = i;
			}
			i++;
			if (i > max) {
				vet[pos] = vet[max];
				vet[max] = maior;
				pos = inicio;
				max--;
				i = inicio;
				maior = vet[inicio];
			}
		}
	}

	public static void bubble(int inicio, int fim, int[] vet) {
		int troca = 1, i, aux;
		while (troca != 0) {
			troca = 0;
			for (i = 0; i < fim; i++) {
				if (vet[i] > vet[i + 1]) {
					aux = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = aux;
					troca = 1;
				}
			}
		}
	}

	public static void shake(int inici, int fim, int[] vet) {
		int troca = 1, i, aux;
		while (troca != 0) {
			troca = 0;
			for (i = fim; i > 0; i--) {
				if (vet[i] < vet[i - 1]) {
					aux = vet[i];
					vet[i] = vet[i - 1];
					vet[i - 1] = aux;
					troca = 1;

				}
			}
		}
	}

	public static void heapSort(int[] a, int n) {
		int i = n / 2, pai, filho, t;

		for (;;) {
			if (i > 0) {
				i--;
				t = a[i];
			} else {
				n--;
				if (n == 0)
					return;
				t = a[n];
				a[n] = a[0];
			}

			pai = i;

			// Primeiro será feita a comparação com o filho da esquerda.
			filho = i * 2 + 1;

			while (filho < n) {

				// Se o filho da esquerda for menor do que o filho da
				// direita,então será feita a troca do filho que será comparado.
				if ((filho + 1 < n) && (a[filho + 1] > a[filho])) {
					filho++;
				}
				if (a[filho] > t) {
					a[pai] = a[filho];
					pai = filho;
					filho = pai * 2 + 1;
				} else {
					break;
				}
			}
			a[pai] = t;
		}
	}

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

	public static void shellSort(int[] vet, int size) {
		int i, j, value;
		int gap = 1;
		while (gap < size) {
			gap = 3 * gap + 1;
		}
		while (gap > 1) {
			gap /= 3;
			for (i = gap; i < size; i++) {
				value = vet[i];
				j = i - gap;
				while (j >= 0 && value < vet[j]) {
					vet[j + gap] = vet[j];
					j -= gap;
				}
				vet[j + gap] = value;
			}
		}
	}

	public static void insertionSort(int[] numeros, int tam) {
		int i, j, eleito;
		for (i = 1; i < tam; i++) {
			eleito = numeros[i];
			j = i - 1;
			while ((j >= 0) && (eleito < numeros[j])) {
				numeros[j + 1] = numeros[j];
				j--;
			}
			numeros[j + 1] = eleito;
		}
	}


	public static void main(String[] args) {
		// Gera valores aleatórios para o vetor.
		Random gerador = new Random();
		int tv = 10000; // Define quantos valores deverá ter dentro do vetor
		int vet0[] = new int[tv];
		int vet1[] = new int[tv];
		int vet2[] = new int[tv];
		int vet3[] = new int[tv];
		int vet4[] = new int[tv];
		int vetA[] = new int[tv];
		int vetB[] = new int[tv];
		int vetC[] = new int[tv];
		int vetD[] = new int[tv];
		int vetE[] = new int[tv];
		int i;

		long med1, med2, med3, med4, med5, med6, med7, med8, med9 = 0;

		// System.out.println("Vetor 1 desordenado");
		for (i = 0; i < tv; i++) {
			vet0[i] = gerador.nextInt(tv);
			vetA[i] = vet0[i];
			// System.out.println(" " + vet0[i]);
		}
		// System.out.println("Vetor 2 desordenado");
		for (i = 0; i < tv; i++) {
			vet1[i] = gerador.nextInt(tv);
			vetB[i] = vet1[i];
			// System.out.println(" " + vet1[i]);
		}
		// System.out.println("Vetor 3 desordenado");
		for (i = 0; i < tv; i++) {
			vet2[i] = gerador.nextInt(tv);
			vetC[i] = vet2[i];
			// System.out.println(" " + vet1[i]);
		}
		// System.out.println("Vetor 4 desordenado");
		for (i = 0; i < tv; i++) {
			vet3[i] = gerador.nextInt(tv);
			vetD[i] = vet3[i];
			// System.out.println(" " + vet1[i]);
		}
		// System.out.println("Vetor 5 desordenado");
		for (i = 0; i < tv; i++) {
			vet4[i] = gerador.nextInt(tv);
			vetE[i] = vet4[i];
			// System.out.println(" " + vet1[i]);
		}

		// quick
		long inicio1 = System.currentTimeMillis();
		quick(0, tv - 1, vet0);
		long fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por quick");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por quick demorou: " + fim1 + " mili segundos");

		long inicio2 = System.currentTimeMillis();
		quick(0, tv - 1, vet1);
		long fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por quick");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 2 ordenado por quick demorou: " + fim2 + " mili segundos");

		long inicio3 = System.currentTimeMillis();
		quick(0, tv - 1, vet2);
		long fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por quick");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 3 ordenado por quick na demorou: " + fim3 + " mili segundos");

		long inicio4 = System.currentTimeMillis();
		quick(0, tv - 1, vet3);
		long fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por quick ");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 4 ordenado por quick demorou: " + fim4 + " mili segundos");

		long inicio5 = System.currentTimeMillis();

		quick(0, tv - 1, vet4);
		long fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por quick");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 5 ordenado por quick demorou: " + fim5 + " mili segundos");

		med1 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo quick é de " + med1);

		// seldir

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		seldir(0, tv - 1, vet0);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por seldir ");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por seldir demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		seldir(0, tv - 1, vet1);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por seldir");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por seldir demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		seldir(0, tv - 1, vet2);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por seldir ");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por seldir demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		seldir(0, tv - 1, vet3);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por seldir ");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por seldir demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		seldir(0, tv - 1, vet4);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por seldir");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por seldir demorou: " + fim5 + " mili segundos");

		med2 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo seldir é de " + med2);

		// bubble

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		bubble(0, tv - 1, vet0);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por bubble");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por bubble demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		bubble(0, tv - 1, vet1);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por bubble");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por bubble demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		bubble(0, tv - 1, vet2);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por bubble");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por bubble demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		bubble(0, tv - 1, vet3);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por bubble");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por bubble demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		bubble(0, tv - 1, vet4);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por bubble ");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por bubble demorou: " + fim5 + " mili segundos");

		med3 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo bubble é de " + med3);

		// shake

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		shake(0, tv - 1, vet0);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por shake");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por shake demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		shake(0, tv - 1, vet1);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por shake");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por shake demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		shake(0, tv - 1, vet2);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por shake");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por shake demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		shake(0, tv - 1, vet3);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por shake");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por shake demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		shake(0, tv - 1, vet4);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por shake");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por shake demorou: " + fim5 + " mili segundos");

		med4 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo shake é de " + med4);

		// heapSort

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		heapSort(vet0, tv);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por heapSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por heapSort demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		heapSort(vet1, tv);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por heapSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por heapSort demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		heapSort(vet2, tv);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por heapSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por heapSort demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		heapSort(vet3, tv);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por heapSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por heapSort demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		heapSort(vet4, tv);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por heapSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por heapSort demorou: " + fim5 + " mili segundos");

		med5 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo heapSort é de " + med5);

		// mergeSort

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		mergeSort(vet0, 0, tv - 1);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por mergeSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por mergeSort demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		mergeSort(vet1, 0, tv - 1);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por mergeSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por mergeSort demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		mergeSort(vet2, 0, tv - 1);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por mergeSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por mergeSort demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		mergeSort(vet3, 0, tv - 1);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por mergeSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por mergeSort demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		mergeSort(vet4, 0, tv - 1);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por mergeSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por mergeSort demorou: " + fim5 + " mili segundos");

		med6 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo mergSort é de " + med6);

		// radixsort

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		radixsort(vet0, tv);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por radixsort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por radixsort demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		radixsort(vet1, tv);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por radixsort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por radixsort demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		radixsort(vet2, tv);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por radixsort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por radixsort demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		radixsort(vet3, tv);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por radixsort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por radixsort demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		radixsort(vet4, tv);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por radixsort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por radixsort demorou: " + fim5 + " mili segundos");

		med7 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo radixsort é de " + med7);

		// insertionSort

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		insertionSort(vet0, tv);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por insertionSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por insertionSort demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		insertionSort(vet1, tv);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por insertionSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por insertionSort demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		insertionSort(vet2, tv);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por insertionSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por insertionSort demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		insertionSort(vet3, tv);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por insertionSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por insertionSort demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		insertionSort(vet4, tv);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por insertionSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por insertionSort demorou: " + fim5 + " mili segundos");

		med8 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo insertionSort é de " + med8);

		// ShellSort

		for (i = 0; i < tv; i++) {
			vet0[i] = vetA[i];
			vet1[i] = vetB[i];
			vet2[i] = vetC[i];
			vet3[i] = vetD[i];
			vet4[i] = vetE[i];
		}

		inicio1 = System.currentTimeMillis();
		shellSort(vet0, tv);
		fim1 = System.currentTimeMillis() - inicio1;
		// System.out.println("Vetor 1 ordenado por shellSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet0[i]);
		}
		System.out.println("Vetor 1 ordenado por shellSort demorou: " + fim1 + " mili segundos");

		inicio2 = System.currentTimeMillis();
		shellSort(vet1, tv);
		fim2 = System.currentTimeMillis() - inicio2;
		// System.out.println("Vetor 2 ordenado por shellSort ");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet1[i]);
		}
		System.out.println("Vetor 2 ordenado por shellSort demorou: " + fim2 + " mili segundos");

		inicio3 = System.currentTimeMillis();
		shellSort(vet2, tv);
		fim3 = System.currentTimeMillis() - inicio3;
		// System.out.println("Vetor 3 ordenado por shellSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet2[i]);
		}
		System.out.println("Vetor 3 ordenado por shellSort demorou: " + fim3 + " mili segundos");

		inicio4 = System.currentTimeMillis();
		shellSort(vet3, tv);
		fim4 = System.currentTimeMillis() - inicio4;
		// System.out.println("Vetor 4 ordenado por shellSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet3[i]);
		}
		System.out.println("Vetor 4 ordenado por shellSort demorou: " + fim4 + " mili segundos");

		inicio5 = System.currentTimeMillis();
		shellSort(vet4, tv);
		fim5 = System.currentTimeMillis() - inicio5;
		// System.out.println("Vetor 5 ordenado por shellSort");
		for (i = 0; i < tv; i++) {
			// System.out.println(" " + vet4[i]);
		}
		System.out.println("Vetor 5 ordenado por shellSort demorou: " + fim5 + " mili segundos");

		med9 = (fim1 + fim2 + fim3 + fim4 + fim5) / 5;

		System.out.println("A média de tempo gasto pelo shellSort é de " + med9);

		long vetmn[] = new long[9];
		vetmn[0] = med1;
		vetmn[1] = med2;
		vetmn[2] = med3;
		vetmn[3] = med4;
		vetmn[4] = med5;
		vetmn[5] = med6;
		vetmn[6] = med7;
		vetmn[7] = med8;
		vetmn[8] = med9;

		String vetm[] = new String[9];
		vetm[0] = "quick";
		vetm[1] = "seldir";
		vetm[2] = "bubble";
		vetm[3] = "shake";
		vetm[4] = "heapSort";
		vetm[5] = "mergSort";
		vetm[6] = "radixsort";
		vetm[7] = "insertionSort";
		vetm[8] = "shellSort";

		quick2(0, 8, vetm, vetmn);

		for (i = 0; i < 9; i++) {
			System.out.println(" " + vetm[i] + "|" + vetmn[i]);
		}
	}
}
