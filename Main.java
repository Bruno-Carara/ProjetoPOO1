package Eleição;

import java.util.Map;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		final String arquivo = ("C:\\Dev\\Java\\Faculdade\\src\\Eleição\\votos.txt");
		
		Map<Integer, Integer> Votos_Candidato= Leitor.ler_votos(arquivo);		
		Map<Integer, Integer> Votos_Urna= Leitor.ler_urna(arquivo);	
		int votos_válidos = Leitor.ler_válidos(arquivo);
		
		
		
		System.out.println(Leitor.ler_urna(arquivo));
		
		System.out.println(Leitor.ler_votos(arquivo));
		
		float QE = Relatório.Calcular_QE(votos_válidos);
		
		Relatório.Calcular_QP(Votos_Candidato);
	}

}
