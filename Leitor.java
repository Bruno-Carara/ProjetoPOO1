package Eleição;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Leitor extends Main{

	private static int Nulos = 0;
	private static int Brancos = 0;
	private static int Válidos = 0;

	public int getNulos() {
		return Nulos;
	}

	public void setNulos(int nulos) {
		Nulos = nulos;
	}

	public int getBrancos() {
		return Brancos;
	}

	public void setBrancos(int brancos) {
		Brancos = brancos;
	}

	public int getVálidos() {
		return Válidos;
	}

	public void setVálidos(int válidos) {
		Válidos = válidos;
	}

	@SuppressWarnings("rawtypes")
	public static HashMap ler_votos(String arquivo) {

		Map<Integer, Integer> Candidatos = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				int candidato = Integer.parseInt(partes[1]);
				Candidatos.put(candidato, Candidatos.getOrDefault(candidato, 0) + 1);
				if (candidato == 0) {
					Nulos++;
				} else if (candidato == 1) {
					Brancos++;
				} else {
					Válidos++;
				} 
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		return (HashMap) Candidatos;
	}
	@SuppressWarnings("rawtypes")
	public static HashMap ler_urna(String arquivo) {

		Map<Integer, Integer> Candidatos = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				int candidato = Integer.parseInt(partes[0]);
				Candidatos.put(candidato, Candidatos.getOrDefault(candidato, 0) + 1);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		return (HashMap) Candidatos;
	}
	public static int ler_válidos(String arquivo) {

		Map<Integer, Integer> Candidatos = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				int candidato = Integer.parseInt(partes[1]);
				Candidatos.put(candidato, Candidatos.getOrDefault(candidato, 0) + 1);
				if ((candidato != 0) && (candidato != 1)) {
					Válidos++;
				} 
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		return Válidos;
	}
}
