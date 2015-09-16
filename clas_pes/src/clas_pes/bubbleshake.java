package clas_pes;

public class bubbleshake {

	public static void imprime(int[] vet) {
		int i;
		for (i = 0; i < 5; i++) {
			System.out.println(" " + vet[i]);
		}
	}

	public static void main(String[] args) {
		int[] vet = { 7, 4, 32, 99, 12 };
		int troca = 1, i, aux;
		System.out.println("Vetor desordenado:");
		imprime(vet);
		// troca comum = bubble sort
		while (troca != 0) {
			troca = 0;
			for (i = 0; i < 4; i++) {
				if (vet[i] > vet[i + 1]) {
					aux = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = aux;
					troca = 1;
				}
			}
		}
		System.out.println("Vetor ordenado");
		imprime(vet);
		// troca de traz pra frente = shake sort
		while (troca != 0) {

			troca = 0;
			for (i = 4; i > 0; i--) {
				if (vet[i] < vet[i - 1]) {
					aux = vet[i];
					vet[i] = vet[i - 1];
					vet[i - 1] = aux;
					troca = 1;

				}
			}
		}
		System.out.println("Vetor ordenado");
		imprime(vet);
	}
}
