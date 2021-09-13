package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public void adicionar(CiaAerea cia) {
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {
		return empresas;
	}

	public CiaAerea buscarCodigo(String cod) {
		CiaAerea ciaCerta = null;
		for(CiaAerea cia : empresas) {
			String codigo = cia.getCodigo();
			if(codigo.equals(cod)) {
				ciaCerta = cia;
			}
		}
		return ciaCerta;
	}

	public CiaAerea buscarNome(String cod) {
		CiaAerea ciaCerta = null;
		for(CiaAerea cia : empresas) {
			String nome = cia.getNome();
			if(nome.equals(cod)) {
				ciaCerta = cia;
			}
		}
		return ciaCerta;
	}
}
