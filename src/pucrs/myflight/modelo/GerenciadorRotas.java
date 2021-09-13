package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;
	
	public GerenciadorRotas() {
		rotas = new ArrayList<>();
	}

	public void adicionar(Rota rota) {
		rotas.add(rota);
	}

	public ArrayList<Rota> listarTodas() {
		return rotas;
	}

	public ArrayList<Rota> buscarPorOrigem(Aeroporto orig) {
		ArrayList<Rota> msmOrigem = new ArrayList<>();
		for(Rota rota : rotas){
			if(rota.getOrigem() == orig) {
				msmOrigem.add(rota);
			}
		}
		return msmOrigem;
	}
}
