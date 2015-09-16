package clas_pes;

public class quicksort {

	private static void troca(int i, int j, int[] vet) {
		int aux;
		aux = vet[i];
		vet[i] = vet[j];
		vet[j] = aux;
	}

	private static int parte(int inicio, int fim, int[] vet) {
		int i = inicio, j, chave = vet[fim];

		for (j = inicio; j < fim + 1; j++) {
			if (vet[j] < vet[inicio]) {
				i++;
				troca(i, j, vet);
			}
		}
		troca(i, inicio, vet);
		return (i);
	}
	
	private static int parte2(int inicio, int fim, int[] vet) {
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
	

	private static void quick(int inicio, int fim, int[] vet) {
		int posicao;
		if (fim > inicio) {
			posicao = parte(inicio, fim, vet);
			quick(inicio, posicao - 1, vet);
			quick(posicao + 1, fim, vet);
		}
	}

	public static void imprime(int[] vet) {
		int i;
		for (i = 0; i < 5; i++) {
			System.out.println(" " + vet[i]);
		}
	}

	public static void main(String[] args) {
		int[] vet = { 7, 4, 32, 99, 12 };

		System.out.println("Vetor desordenado:");
		imprime(vet);

		quick(0, 4, vet);

		System.out.println("Vetor ordenado");
		imprime(vet);
	}
}
