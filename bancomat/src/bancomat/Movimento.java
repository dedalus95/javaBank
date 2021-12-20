package bancomat;
import java.util.Date;

public class Movimento {
	
	private Date dataMovimento;
	private String causale;
	private int importo;
	private String deposito;
	
	
	public 	Movimento (String causale, int importo, String deposito) {
		this.dataMovimento = new Date();
		this.causale = causale;
		this.importo = importo;
		this.deposito = deposito;
	}


	public Date getDataMovimento() {
		
		return dataMovimento;
	}


	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}


	public String getCausale() {
		return causale;
	}


	public void setCausale(String causale) {
		this.causale = causale;
	}


	public int getImporto() {
		return importo;
	}


	public void setImporto(int importo) {
		this.importo = importo;
	}


	public String getDeposito() {
		return deposito;
	}


	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
	
	

		
	
	
	
}
