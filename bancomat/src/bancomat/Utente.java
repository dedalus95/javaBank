package bancomat;

public class Utente {
	private String name;
	private String surname;
	
	public Utente(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void apriConto(Atm atm, String numeroCarta, String password, int money) {
		Conto conto = new Conto(this, password, money, numeroCarta);
		atm.getInsiemeConti().add(conto);
	}
	
	
	public void prelevaDenaro(
							Atm atm, 
							String numeroCarta,
							String password, 
							int denaro, 
							String ricevuta
							) 
	
		{
		if(checkPassword(atm, numeroCarta, password) == null) {
			return;
		}
			checkPassword(atm, numeroCarta, password).prelevaDenaro(denaro, ricevuta);

		}
	
	


	public void versaDenaro(Atm atm, 
							String numeroCarta,
							String password, 
							int denaro, 
							String ricevuta
							) 
	{	
		if(checkPassword(atm, numeroCarta, password) == null) {
		return;
	}
		checkPassword(atm, numeroCarta, password).versaDenaro(denaro, ricevuta);
	}
	
	
	
	
	public void accediSaldo(Atm atm, String numeroCarta, String password) {
		if(checkPassword(atm, numeroCarta, password) == null) {
			return;
		}
		checkPassword(atm, numeroCarta, password).stampaSaldo();
	}
	
	
	private Conto checkPassword(Atm atm, String numeroCarta, String password) {
		for (int i = 0; i < atm.getInsiemeConti().size(); i++) {
			Conto c = atm.getInsiemeConti().get(i);
			
			if((c.getPasswordValida().equals(password)) 
				&& (c.getNumeroCarta().equals(numeroCarta))) {
				return c;
			} 
		}
		System.out.println("Password errata");
		return null;
		
	}
		

}
