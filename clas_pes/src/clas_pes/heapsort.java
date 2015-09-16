package clas_pes;

import java.util.Random;

public class heapsort {

	private static void troca(int i, int j, int[] vet) {
		int aux;
		aux = vet[i];
		vet[i] = vet[j];
		vet[j] = aux;
	}

	private static int keyval(int n, int i, int[] vet) {
		if (i > n) {
			return -32768; // 2^15 para abranger um int 2 bytes
		} else {
			return vet[i];
		}
	}

	private static void heap(int n, int r, int[] vet) {
		int i, h;
		boolean troca = true;
		i = r;
		while (troca) {
			if (keyval(n, 2 * i, vet) > keyval(n, 2 * i + 1, vet)) { // Procura
																		// maior
																		// arvore
				h = 2 * i; // subarvore da esquerda
			} else {
				h = 2 * i + 1;
			} // subarvore da direita
			if (vet[i] < keyval(n, h, vet)) { // compara raiz com o maior
												// sucessor
				troca(i, h, vet);
				i = h; // desce para a raiz da subàrvore afetada pela troca
			} else {
				troca = false; // nao houve troca
			}
		}
	}

	public static void heapsort(int n, int[] vet) {
		int i, n1, r;
		i = n / 2; // raiz da ultima subarvore
		for (r = i; r >= 0; r--) {
			heap(n, r, vet);
		}
		// formacao do heap inicial
		for (n1 = n - 1; n1 >= 0; n1--) {
			troca(0, n1 + 1, vet); // coloca a maior chave em sua posicao
			heap(n1, 0, vet); // refaz heap a partir da raiz da arvore
		}
	}

	// heapsort alternativo
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

		// heapsort(tv - 1, vet);
		heapSort(vet, tv);

		System.out.println("Vetor ordenado");
		for (i = 0; i < tv; i++) {
			System.out.println(" " + vet[i]);
		}
	}
}
