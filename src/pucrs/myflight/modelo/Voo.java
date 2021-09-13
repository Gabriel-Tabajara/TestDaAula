package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	private static int totalVoos = 0;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é confirmado
		totalVoos++;
	}

	public Voo(Rota rota, Duration duracao) {
		this.rota = rota;
		this.datahora = LocalDateTime.of(2016, Month.AUGUST, 12, 12, 0);
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é confirmado
		totalVoos++;
	}
	
	
	public Rota getRota() {
		return rota;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Duration getDuracao() {
		return duracao;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	public String toString(){
		DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format(datahora.format(formatado) + " Duracao: (" +
								duracao.toMinutes() + " min) " +
								rota.toString() + " {" +  
								getStatus() + "}");
	}

	public static int getTotalVoos() {
        return totalVoos;
    }
}

