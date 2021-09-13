package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;
	
	public GerenciadorAeronaves() {
		aeronaves = new ArrayList<>();
	}

	public void adicionar(Aeronave aviao){
		aeronaves.add(aviao);
	}

	public ArrayList<Aeronave> listarTodas() {
		return aeronaves;
	}

	public Aeronave buscarPorCodigo(String cod) {
		Aeronave aeronaveCerta = null;
		for(Aeronave aviao : aeronaves) {
			String codigo = aviao.getCodigo();
			if(codigo.equals(cod)) {
				aeronaveCerta = aviao;
			}
		}
		return aeronaveCerta;
	}
}
