package pucrs.myflight.modelo;

public class Aeroporto {
	private String codigo;
	private String nome;
	private Geo loc;
	private static int totalAeroportos = 0;
	
	public Aeroporto(String codigo, String nome, Geo loc) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
		totalAeroportos++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Geo getLocal() {
		return loc;
	}

	public String toString() {
		return String.format("Codigo: (%s) Nome: (%s) localizacao: ", codigo, nome) + loc.toString();
	}

	public static int getTotalAeroportos(){
		return totalAeroportos;
	}
}
