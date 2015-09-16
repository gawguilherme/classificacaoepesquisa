package clas_pes;

import java.util.Random;
import java.util.Scanner;

public class random {

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

	private static void quick(int inicio, int fim, int[] vet) {
		int posicao;
		if (fim > inicio) {
			posicao = parte(inicio, fim, vet);
			quick(inicio, posicao - 1, vet);
			quick(posicao + 1, fim, vet);
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

	public static void main(String[] args) {

		// Gera valores aleatórios para o vetor.
		Random gerador = new Random();
		int tv = 10; // Define quantos valores deverá ter dentro do vetor
		int vet[] = new int[tv];
		int i, op;
		System.out.println("Vetor desordenado");
		for (i = 0; i < tv; i++) {
			vet[i] = gerador.nextInt(tv);
			System.out.println(" " + vet[i]);
		}

		long inicio = System.currentTimeMillis();
		System.out.println("Digite 1 para fazer a ordenação pelo método quick." + "\n"
				+ "Digite 2 para fazer a ordenação pelo método de seleção direta." + "\n"
				+ "Digite 3 para fazer a ordenação pelo método bolha.");
		Scanner sc = new Scanner(System.in);
		op = sc.nextInt();

		switch (op) {
		case 1:
			quick(0, tv - 1, vet);
			break;

		case 2:
			seldir(0, tv - 1, vet);
			break;

		case 3:
			bubble(0, tv - 1, vet);
			break;
		}

		long fim = System.currentTimeMillis() - inicio;
		System.out.println("Vetor ordenado");
		for (i = 0; i < tv; i++) {
			System.out.println(" " + vet[i]);
		}
		System.out.println("O Vetor demorou: " + fim + " mili segundos");
	}
}
