package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;
	
	public GerenciadorAeroportos() {
		aeroportos = new ArrayList<>();
	}

	public void adicionar(Aeroporto aero) {
		aeroportos.add(aero);
	}

	public ArrayList<Aeroporto> listarTodos() {
		return aeroportos;
	}

	public Aeroporto buscarPorCodigo(String cod) {
		Aeroporto aeroCerto = null;
		for(Aeroporto aero : aeroportos) {
			String codigo = aero.getCodigo();
			if(codigo.equals(cod)) {
				aeroCerto = aero;
			}
		}
		return aeroCerto;
	}
}
