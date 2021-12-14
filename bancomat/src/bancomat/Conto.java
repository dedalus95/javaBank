package bancomat;
import java.util.Date;

public class Conto {
	private String passwordValida;
	private String numeroCarta;
	private int saldo;
	
	public Conto(String passwordValida, int saldo, String numeroCarta) {
		this.numeroCarta = numeroCarta;
		this.passwordValida = passwordValida;
		this.saldo = saldo;
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
	
	public void prelevaDenaro(int denaro, String ricevuta) {
		this.saldo -= denaro;
		if(ricevuta.toUpperCase().equals("yes".toUpperCase())) {
			Date date = new Date();
			System.out.println("Hai prelevato " + denaro + " € in data " + date + ".");
		}
	}
	


	public void versaDenaro(int denaro, String ricevuta) {
		this.saldo += denaro;
		if(ricevuta.toUpperCase().equals("yes".toUpperCase())) {
			Date date = new Date();
			System.out.println("Hai versato " + denaro + " € in data " + date + ".");
		}
	}
	
	public void stampaSaldo() {
		System.out.println("Il tuo saldo è di " + getSaldo() + " €.");
	}
	
}
