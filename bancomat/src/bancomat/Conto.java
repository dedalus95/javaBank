package bancomat;
import java.util.Date;

public class Conto {
	private String passwordValida;
	private String numeroCarta;
	private int saldo;
	private String nomeUtente;
	private String cognomeUtente;
	
	public Conto(Utente utente, String passwordValida, int saldo, String numeroCarta) {
		this.numeroCarta = numeroCarta;
		this.passwordValida = passwordValida;
		this.saldo = saldo;
		nomeUtente = utente.getName();
		cognomeUtente = utente.getSurname();
	}

	public String getPasswordValida() {
		return passwordValida;
	}

	public void setPasswordValida(String passwordValida) {
		this.passwordValida = passwordValida;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	
	private String getNomeUtente() {
		
		return "Egregio/a " + nomeUtente + " " + cognomeUtente;
	}
	
	public void prelevaDenaro(int denaro, String ricevuta) {
		this.saldo -= denaro;
		if(ricevuta.toUpperCase().equals("yes".toUpperCase())) {
			Date date = new Date();
			System.out.println(getNomeUtente() + ": ha prelevato " + denaro + " € in data " + date + ".");
		}
	}
	


	public void versaDenaro(int denaro, String ricevuta) {
		this.saldo += denaro;
		if(ricevuta.toUpperCase().equals("yes".toUpperCase())) {
			Date date = new Date();
			System.out.println(getNomeUtente() + ": ha versato " + denaro + " € in data " + date + ".");
		}
	}
	
	public void stampaSaldo() {
		System.out.println(getNomeUtente() + ": il suo saldo è di " + getSaldo() + " €.");
	}
	

	
}
