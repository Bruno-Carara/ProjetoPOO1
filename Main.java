package Eleição;

import java.util.Map;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		final String arquivo = ("C:\\Dev\\Java\\Faculdade\\src\\Eleição\\votos.txt");
		
		Map<Integer, Integer> Votos_Candidato= Leitor.ler_votos(arquivo);		
		Map<Integer, Integer> Votos_Urna= Leitor.ler_urna(arquivo);	
		int votos_válidos = Leitor.ler_válidos(arquivo);
		int votos_brancos = Leitor.ler_brancos(arquivo);
		int votos_nulos = Leitor.ler_nulos(arquivo);
		float[][] votos_partido = Relatório.Votos_Partido(Votos_Candidato);
		int[][] votos_por_candidato = Relatório.Votos_Candidato(Votos_Candidato);
		int[][] votos_por_urna = Relatório.Votos_Urna(Votos_Urna);
		float QE = Relatório.Calcular_QE(votos_válidos);
		float[][] QP = Relatório.Calcular_QP(votos_partido, QE);
		int votos_total = Relatório.Total_Votos(votos_por_urna);
		
		//Resultados
		
		System.out.println("Cálculo do Quociente Eleitoral (QE):" + QE + "\n");
		Relatório.Mostrar_QP(QP);
		Relatório.Mostrar_Votos_Urna(votos_por_urna);
		System.out.println("Total de Votos: " + votos_total + "\n");
		Relatório.Mostrar_Votos_Candidato(votos_por_candidato);
		System.out.println("Total de Votos Brancos: " + votos_brancos + "\n");
		System.out.println("Total de Votos Nulos: " + votos_nulos + "\n");
		
		System.out.println("Percentual de Votos Brancos: " + (float)votos_brancos/votos_total + "%\n");
		System.out.println("Percentual de Votos Nulos: " + (float)votos_nulos/votos_total + "%\n");
		System.out.println("Percentual de Votos Válidos: " + (float)votos_válidos/votos_total + "%\n");
		
		System.out.println("Candidatos Mais Votados:");
		Relatório.Maiores_Candidatos(votos_por_candidato);
		
		Relatório.Eleitos();
	}

}
