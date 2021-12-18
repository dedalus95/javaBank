package bancomat;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Vector;

public class Conto {
	
		private int passwordUtente;
		private String passwordCriptata;
		private int numeroCC;
		private int saldo;
		private Vector<Movimento> listaMovimenti;
		private String nomeUtente;
		private String cognomeUtente;
		private int numeroMovimenti;
	
	public Conto(String nome, String cognome, int saldo) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		this.numeroCC = generateInt();
		this.passwordUtente = generateUserPassword();
		this.passwordCriptata = comparePassword(passwordUtente);
		this.saldo = saldo;
		this.listaMovimenti = new Vector<Movimento>();
		this.numeroMovimenti = listaMovimenti.size();
		this.nomeUtente = nome;
		this.cognomeUtente = cognome;
	}
	

	public int getPasswordUtente() {
		return passwordUtente;
	}




	public void setPasswordUtente(int passwordUtente) {
		this.passwordUtente = passwordUtente;
	}




	public String getPasswordCriptata() {
		return passwordCriptata;
	}




	public void setPasswordCriptata(String passwordCriptata) {
		this.passwordCriptata = passwordCriptata;
	}




	public int getNumeroCC() {
		return numeroCC;
	}


	public void setNumeroCC(int numeroCC) {
		this.numeroCC = numeroCC;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public Vector<Movimento> getListaMovimenti() {
		return listaMovimenti;
	}


	public void setListaMovimenti(Vector<Movimento> listaMovimenti) {
		this.listaMovimenti = listaMovimenti;
	}


	public String getNomeUtente() {
		return nomeUtente;
	}


	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}


	public String getCognomeUtente() {
		return cognomeUtente;
	}


	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}


	public int getNumeroMovimenti() {
		return numeroMovimenti;
	}


	public void setNumeroMovimenti(int numeroMovimenti) {
		this.numeroMovimenti = numeroMovimenti;
	}



	private int generateInt() {
		return (int) Math.ceil(Math.random() * 1_000_000_000);
	}
	
	private int generateUserPassword() {
		return (int) Math.ceil(Math.random() * 1_000_000);

	}
	

	public String comparePassword(int password) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		return createPassword(password);
	}
	
	
	
	public boolean requestPassword(Scanner tastiera) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		System.out.println("PREGO, INSERIRE PASSWORD.");
		int password = tastiera.nextInt();
		if (this.passwordCriptata.equals(comparePassword(password))) {
			return true;
		} 
		System.err.println("Password non valida.");
		return false;
	}
	
	

	public String createPassword(int password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String myString = "" + password;
		byte[] bytesOfMessage = myString.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] theMD5Digest = md.digest(bytesOfMessage);
		BigInteger bi = new BigInteger(1, theMD5Digest);
		return String.format("%0" + (theMD5Digest.length << 1) + "X", bi);
		 
	}
	
	
	public void muoviDenaro(String causale, int importo, int key) {
		
		
		if (key == 2) {
		this.saldo += importo;
		Movimento nuovoMovimento = new Movimento(causale, importo, "Deposito");
		listaMovimenti.add(nuovoMovimento);

		} else if (key == 3) {
			this.saldo -= importo;
			Movimento nuovoMovimento = new Movimento(causale, importo, "Prelievo");
			listaMovimenti.add(nuovoMovimento);
		}
		
	}
	
	

	
	public void stampaSaldo() {
		System.out.println(getNomeUtente() + " " + getCognomeUtente() +  ": il suo saldo è di " + getSaldo() + " €.");
	}
	

	
	
}
