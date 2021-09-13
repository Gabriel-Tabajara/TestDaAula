package pucrs.myflight.consoleApp;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Duration;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;
import pucrs.myflight.modelo.Voo.Status;

public class App  { 

	public static void main(String[] args) {
		//Criando aeronaves para teste.
		Aeronave a1 = new Aeronave("733", "Boeing 737-300", 140);
		Aeronave a2 = new Aeronave("73G", "Boeing 737-700", 126);
		Aeronave a3 = new Aeronave("380", "Airbus Industrie A380", 644);
		Aeronave a4 = new Aeronave("764", "Boeing 767-400", 304);

		GerenciadorAeronaves aeronaves = new GerenciadorAeronaves(); //Gerenciador das aeronaves.
		aeronaves.adicionar(a1); 
		aeronaves.adicionar(a2);
		aeronaves.adicionar(a3);
		aeronaves.adicionar(a4);

		System.out.println("Aeronaves: ");
		for(Aeronave aviao : aeronaves.listarTodas()) {
			System.out.println(aviao.toString());
		}
		System.out.println("Total de Aeronaves: " + Aeronave.getTotalAeronaves());
		System.out.println();

		System.out.println("Buscando aeronave por codigo:");
		System.out.println(aeronaves.buscarPorCodigo("380"));
		System.out.println();

		//Criando cia aereas para teste.
		CiaAerea c1 = new CiaAerea("JJ", "LATAM Linhas Aéreas");
		CiaAerea c2 = new CiaAerea("G3", "Gol Linhas Aéreas SA");
		CiaAerea c3 = new CiaAerea("TP", "TAP Portugal");
		CiaAerea c4 = new CiaAerea("AD", "Azul Linhas Aéreas");

		GerenciadorCias cias = new GerenciadorCias(); //Gerenciador das cias aereas.
		cias.adicionar(c1);
		cias.adicionar(c2);
		cias.adicionar(c3);
		cias.adicionar(c4);

		System.out.println("Cias Aereas: ");
		for(CiaAerea cia : cias.listarTodas()) {
			System.out.println(cia.toString());
		}
		System.out.println("Total de Cias Aereas: " + CiaAerea.getTotalCias());
		System.out.println();

		System.out.println("Buscando cia aerea por codigo:");
		System.out.println(cias.buscarCodigo("AD"));
		System.out.println();

		System.out.println("Buscando cia aerea por nome:");
		System.out.println(cias.buscarNome("TAP Portugal"));
		System.out.println();

		//Criando geos para teste.
		Geo g1 = new Geo(-29.9939, -51.1711);
		Geo g2 = new Geo(-23.4356, -46.4731);
		Geo g3 = new Geo(38.7742, -9.1342);
		Geo g4 = new Geo(25.7933, -80.2906);

		//Criando aeroportos para teste.
		Aeroporto ap1 = new Aeroporto("POA", "Salgado Filho Intl Apt", g1);
		Aeroporto ap2 = new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", g2);
		Aeroporto ap3 = new Aeroporto("LIS", "Lisbon", g3);
		Aeroporto ap4 = new Aeroporto("MIA", "Miami International Apt", g4);

		GerenciadorAeroportos aeroportos = new GerenciadorAeroportos(); //Gerenciador dos aeroportos.
		aeroportos.adicionar(ap1);
		aeroportos.adicionar(ap2);
		aeroportos.adicionar(ap3);
		aeroportos.adicionar(ap4);

		System.out.println("Aeroportos: ");
		for(Aeroporto aero : aeroportos.listarTodos()) {
			System.out.println(aero.toString());
		}
		System.out.println("Total de Aeroportos: " + Aeroporto.getTotalAeroportos());
		System.out.println();

		System.out.println("Buscando aeroporto por codigo:");
		System.out.println(aeroportos.buscarPorCodigo("POA"));
		System.out.println();

		//Criando rotas para teste.
		Rota r1 = new Rota(c2, ap2, ap1, a2);
		Rota r2 = new Rota(c2, ap1, ap2, a2);
		Rota r3 = new Rota(c3, ap4, ap3, a3);
		Rota r4 = new Rota(c1, ap2, ap3, a4);

		GerenciadorRotas rotas = new GerenciadorRotas(); //Gerenciador das rotas.
		rotas.adicionar(r1);
		rotas.adicionar(r2);
		rotas.adicionar(r3);
		rotas.adicionar(r4);

		System.out.println("Rotas: ");
		for(Rota rota : rotas.listarTodas()) {
			Aeroporto origem = rota.getOrigem();
			Aeroporto destino = rota.getDestino();
			double distancia = Geo.distancia(origem.getLocal(), destino.getLocal()); //Testa a distancia.
			System.out.printf(rota.toString() + " {Distancia: %.2fKm}\n", distancia);
		}
		System.out.println();

		System.out.println("Buscando rotas por origem:");
		System.out.println(rotas.buscarPorOrigem(ap2));
		System.out.println();		

		//Criando datas para teste.
		LocalDateTime ldt1 = LocalDateTime.of(2016, Month.AUGUST, 10, 8, 0);
		LocalDateTime ldt2 = LocalDateTime.of(2016, Month.AUGUST, 10, 15, 0);
		LocalDateTime ldt3 = LocalDateTime.of(2016, Month.AUGUST, 15, 12, 00);

		//Criando duracoes para teste.
		Duration d1 = Duration.ofMinutes(90); 
		Duration d2 = Duration.ofMinutes(120); 
		Duration d3 = Duration.ofMinutes(120); 
		Duration d4 = Duration.ofMinutes(180);

		//Criando voos para teste.
		Voo v1 = new Voo(r1, ldt1, d1);
		Voo v2 = new Voo(r2, ldt2, d2);
		Voo v3 = new Voo(r3, ldt3, d3);
		Voo v4 = new Voo(r4,d4);

		v1.setStatus(Status.CANCELADO);
		v2.setStatus(Status.CONFIRMADO);
		v3.setStatus(Status.ATRASADO);
		v4.setStatus(Status.CONFIRMADO);

		GerenciadorVoos voos = new GerenciadorVoos(); //Gerenciador dos voos.
		voos.adicionar(v1);
		voos.adicionar(v2);
		voos.adicionar(v3);
		voos.adicionar(v4);

		System.out.println("Voos: ");
		for(Voo voo : voos.listarTodos()) {
			System.out.println(voo.toString());
		}
		System.out.println("Total de Voos: " + Voo.getTotalVoos());
		System.out.println();

		System.out.println("Buscando voos por data:");
		System.out.println(voos.buscarData(ldt3));
		System.out.println();	
	}

}
