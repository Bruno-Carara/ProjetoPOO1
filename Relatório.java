package Eleição;

import java.util.ArrayList;
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

	public static float Calcular_QE(int votos_válidos) {
		float QE = (votos_válidos/10);
		return QE;
	}
	
	public static void Total_Votos(int[][] Votos_Urna) {
		int soma = 0;
		for (int i = 0; i < Votos_Urna.length; i++) {
			soma += Votos_Urna[i][1];
		}
		System.out.println("A soma de todos os votos é: " + soma + "\n");
	}

	public static int[][] Votos_Candidato(Map<Integer, Integer> Votos_Candidato){
		StringBuilder Votos_Map = new StringBuilder();
		for (Integer key : Votos_Candidato.keySet()) {
			Votos_Map.append(key + "=" + Votos_Candidato.get(key) + ", ");
		}
		Votos_Map.delete(Votos_Map.length()-2, Votos_Map.length());
		String Votos_Tratados = Votos_Map.toString();

		String[] pares = Votos_Tratados.split(", ");
		int[][] Matriz = new int[pares.length][2];
		for (int i = 0; i < pares.length; i++) {
			String[] split = pares[i].split("=");
			Matriz[i][0] = Integer.parseInt(split[0].trim());
			Matriz[i][1] = Integer.parseInt(split[1].trim());
		}
		ArrayList<int[]> listaCandidatos = new ArrayList<>();
		for (int i = 0; i < Matriz.length; i++) {
			if (Matriz[i][0] != 0 && Matriz[i][0] != 1) {
				listaCandidatos.add(Matriz[i]);
			}
		}
		int[][] Matriz_Candidatos = new int[listaCandidatos.size()][2];
		for (int i = 0; i < listaCandidatos.size(); i++) {
			Matriz_Candidatos[i] = listaCandidatos.get(i);
		}
		return Matriz_Candidatos;
	}
	
	public static void Mostrar_Votos_Candidato(int[][] Matriz_Candidatos) {
		System.out.println("Votos por Candidato:");
		for (int i = 0; i < Matriz_Candidatos.length; i++) {
			System.out.println("Candidato " + Matriz_Candidatos[i][0] + " = " + Matriz_Candidatos[i][1] + " votos");
		}
		System.out.println("\n");
	}
	

	

	public static int[][] Votos_Urna(Map<Integer, Integer> Votos_Urna){
		StringBuilder Votos_Map = new StringBuilder();
		for (Integer key : Votos_Urna.keySet()) {
			Votos_Map.append(key + "=" + Votos_Urna.get(key) + ", ");
		}
		Votos_Map.delete(Votos_Map.length()-2, Votos_Map.length());
		String Votos_Tratados = Votos_Map.toString();

		String[] pares = Votos_Tratados.split(", ");
		int[][] Matriz = new int[pares.length][2];
		for (int i = 0; i < pares.length; i++) {
			String[] split = pares[i].split("=");
			Matriz[i][0] = Integer.parseInt(split[0].trim());
			Matriz[i][1] = Integer.parseInt(split[1].trim());
		}
		return Matriz;
	}

	public static void Mostrar_Votos_Urna(int[][] Matriz) {
		System.out.println("Votos por Urna:");
		for (int i = 0; i < Matriz.length; i++) {
			System.out.println("Urna " + Matriz[i][0] + " = " + Matriz[i][1] + " votos");
		}
		System.out.println("\n");
	}


	public static float[][] Votos_Partido(Map<Integer, Integer> Votos_Candidato) {
		StringBuilder Votos_Map = new StringBuilder();
		for (Integer key : Votos_Candidato.keySet()) {
			Votos_Map.append(key + "=" + Votos_Candidato.get(key) + ", ");
		}
		Votos_Map.delete(Votos_Map.length()-2, Votos_Map.length());
		String Votos_Tratados = Votos_Map.toString();

		String[] pares = Votos_Tratados.split(", ");
		int[][] Matriz = new int[pares.length][2];
		for (int i = 0; i < pares.length; i++) {
			String[] split = pares[i].split("=");
			Matriz[i][0] = Integer.parseInt(split[0].trim());
			Matriz[i][1] = Integer.parseInt(split[1].trim());
		}

		ArrayList<int[]> listaPartidos = new ArrayList<>();
		for (int i = 0; i < Matriz.length; i++) {
			if (Matriz[i][0] != 0 && Matriz[i][0] != 1) {
				listaPartidos.add(Matriz[i]);
			}
		}
		int[][] Matriz_Partidos = new int[listaPartidos.size()][2];
		for (int i = 0; i < listaPartidos.size(); i++) {
			Matriz_Partidos[i] = listaPartidos.get(i);
		}

		//System.out.println("Matriz_Partidos:");
		//for (int i = 0; i < Matriz_Partidos.length; i++) {
		//	System.out.println("[" + Matriz_Partidos[i][0] + ", " + Matriz_Partidos[i][1] + "]");
		//}

		float[][] Votos_Partido = new float [6][6];

		for (int i=0;i<Matriz_Partidos.length;i++) {
			String Número_Candidato = Integer.toString(Matriz_Partidos[i][0]);
			String partido = Número_Candidato.substring(0,2);
			if (partido.equals("30")) {
				Votos_Partido[0][1]+=Matriz_Partidos[i][1];
			} else if (partido.equals("31")) {
				Votos_Partido[1][1]+=Matriz_Partidos[i][1];
			} else if (partido.equals("32")) {
				Votos_Partido[2][1]+=Matriz_Partidos[i][1];
			} else if (partido.equals("33")) {
				Votos_Partido[3][1]+=Matriz_Partidos[i][1];
			}	if (partido.equals("34")) {
				Votos_Partido[4][1]+=Matriz_Partidos[i][1];
			} 	if (partido.equals("35")) {
				Votos_Partido[5][1]+=Matriz_Partidos[i][1];
			}
		}

		Votos_Partido[0][0] = 30;
		Votos_Partido[1][0] = 31;
		Votos_Partido[2][0] = 32;
		Votos_Partido[3][0] = 33;
		Votos_Partido[4][0] = 34;
		Votos_Partido[5][0] = 35;



		//System.out.println("Votos Partido:");
		//for (int i = 0; i < Votos_Partido.length; i++) {
		//System.out.println("[" + Votos_Partido[i][0] + ", " + Votos_Partido[i][1] + "]");
		//}
		return Votos_Partido;

	}
	public static float[][] Calcular_QP(float[][] Votos_Partido, float QE ) {

		float[][] Matriz_QP = new float[6][6];
		Matriz_QP = Votos_Partido;

		for(int i=0;i<=5;i++) {
			Matriz_QP[i][1] = (Votos_Partido[i][1]/QE);
		}
		//System.out.println("Matriz QP:");
		//	for (int i = 0; i < Matriz_QP.length; i++) {
		//		System.out.println("[" + Matriz_QP[i][0] + ", " + Matriz_QP[i][1] + "]");
		//	}
		return Matriz_QP;
	}
	public static void Mostrar_QP(float[][] Matriz_QP) {
		System.out.println("Cálculo do Quociente Partidário (QP):");
		for (int i = 0; i < Matriz_QP.length; i++) {
			System.out.println("Partido " + Matriz_QP[i][0] + " = " + Matriz_QP[i][1]);
		}
		System.out.println("\n");
	}
}


