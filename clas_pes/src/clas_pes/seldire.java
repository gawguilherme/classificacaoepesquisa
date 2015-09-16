package clas_pes;

public class seldire {

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

		seldir(0, 4, vet);

		System.out.println("Vetor ordenado");
		imprime(vet);
	}
}
