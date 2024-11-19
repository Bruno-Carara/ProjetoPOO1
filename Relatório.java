package Eleição;

import java.util.HashMap;
import java.util.Map;

public class Relatório extends Main{

	private int votos_urna;
	private int votos_válidos;
	private int votos_candidato;
	private int votos_partido;
	private int votos_nulos;
	private int votos_brancos;
	private int total_votos;
	private float porcentagem_válidos;
	private float porcentagem_brancos;
	private float porcentagem_nulos;
	private int partido;

	public static void Calcular_QE(Map<Integer, Integer> Votos_Candidato) {
		int soma = 0;
		for (Integer chave : Votos_Candidato.keySet()) {
			if (chave != 0 && chave != 1) {
				soma += Votos_Candidato.get(chave);
				System.out.println(soma);
			}
		}
	}
}

