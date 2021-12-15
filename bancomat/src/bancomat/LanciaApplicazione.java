package bancomat;

public class LanciaApplicazione {
public static void main(String[] args) {
	Atm atm1 = new Atm();
	
	Utente utente1 = new Utente("Emanuele", "Cerilli");
	
	utente1.apriConto(atm1, "4444444444", "22222", 2000);
	
	utente1.accediSaldo(atm1, "4444444444", "22222");
	System.out.println("--------------------------------------------------");
	utente1.prelevaDenaro(atm1, "4444444444", "22222", 1500, "yes");
	System.out.println("--------------------------------------------------");
	utente1.accediSaldo(atm1, "4444444444", "22222");
	System.out.println("--------------------------------------------------");
	utente1.versaDenaro(atm1, "4444444444", "22222", 100000, "yes");
	System.out.println("--------------------------------------------------");
	utente1.accediSaldo(atm1, "4444444444", "22222");
	
	Utente utente2 = new Utente("Mario", "Biondi");
	utente2.apriConto(atm1, "2222222222", "11111", 40000);
	
	utente2.accediSaldo(atm1, "2222222222",  "66666");
	utente2.accediSaldo(atm1, "2222222222", "11111");
	
	
	
	
	
}
}
