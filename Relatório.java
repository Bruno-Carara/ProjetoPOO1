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
	public static void Calcular_QP(Map<Integer, Integer> Votos_Candidato) {
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

		System.out.println("Matriz_Partidos:");
		for (int i = 0; i < Matriz_Partidos.length; i++) {
			System.out.println("[" + Matriz_Partidos[i][0] + ", " + Matriz_Partidos[i][1] + "]");
		}

		int[][] Votos_Partido = new int [6][6];

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

		System.out.println("Votos_Partidos:");
		for (int i = 0; i < Votos_Partido.length; i++) {
			System.out.println("[" + Votos_Partido[i][0] + ", " + Votos_Partido[i][1] + "]");

		}

	}
}


