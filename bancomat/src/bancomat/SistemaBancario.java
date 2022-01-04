package bancomat;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Vector;


public class SistemaBancario {
		private Vector<Conto> listaConti; 
		
	    
		public SistemaBancario() {
			listaConti = new Vector<Conto>();
		}
		
	
		public Vector<Conto> getListaConti() {
			return listaConti;
		}
	
	
		public void setListaConti(Vector<Conto> listaConti) {
			this.listaConti = listaConti;
		}


		protected Conto ricercaConti(int numeroConto) {
			for (int i = 0; i < listaConti.size(); i++) {
				if (listaConti.get(i).getNumeroCC() == numeroConto) {
					return listaConti.get(i);
				}
			}
			return null;
		}
	
	
	
		private void stampaMovimenti(Conto conto) {
			System.out.println("LISTA MOVIMENTI: \n");
				
			for (int i = 0; i < conto.getListaMovimenti().size(); i++) {
				
				Movimento movimentoFiltrato = conto.getListaMovimenti().get(i);
				templateStampaMovimenti(movimentoFiltrato);
	
			}}
		
	
		
		private void stampaMovimenti(Conto conto, String tipoMovimento) {
			System.out.println("LISTA " + tipoMovimento + ": \n");
			
			for (int i = 0; i < conto.getListaMovimenti().size(); i++) {
			
			if (tipoMovimento.toUpperCase().equals(conto.getListaMovimenti().get(i).getDeposito().toUpperCase())) {
				Movimento movimentoFiltrato = conto.getListaMovimenti().get(i);
				templateStampaMovimenti(movimentoFiltrato);
			}}
			}
	
		
		private void templateStampaMovimenti(Movimento movimento) {
			System.out.println(
					movimento.getDeposito() + " di " + movimento.getImporto() + "€ in data " 
							+ movimento.getDataMovimento() + ". CAUSALE: " +
							 movimento.getCausale() +"."
					);
		}
		
		
		private Conto inserisciNumeroConto(Scanner tastiera) {
			
			System.out.println("Inserisca il numero del suo conto");
			int numeroConto = tastiera.nextInt();
			
			Conto contoTrovato = this.ricercaConti(numeroConto);
			return contoTrovato;
		}
		
		
		
		
		private void inserisciCausaleEImporto(Scanner tastiera, Conto contoTrovato, int key) {
			
			if(contoTrovato != null) {
				
			System.out.println("Inserisca la causale.");
			String causale = tastiera.next();
			
			System.out.println("Inserisca l'importo");
			int importo = tastiera.nextInt();
			
			contoTrovato.muoviDenaro(causale, importo, key);
			
			} else {
				
				System.err.println("Conto non trovato.");
				
			}
		}
		
		
		
		
	
	

public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	
	

	
	Scanner tastiera = new Scanner(System.in);
	int key;
	SistemaBancario sistemaBancario = new SistemaBancario();
	
			do {
				
				System.out.println("PREMI 0 PER USCIRE") ;
				System.out.println("PREMI 1 PER APRIRE UN NUOVO CONTO");
				System.out.println("PREMI 2 PER VERSARE DEL DANARO" );
				System.out.println("PREMI 3 PER RITIRARE DEL DANARO");
				System.out.println("PREMI 4 PER OTTENERE IL SALDO");
				System.out.println("PREMI 5 PER STAMPARE LA LISTA MOVIMENTI COMPLETA");
				System.out.println("PREMI 6 PER STAMPARE LA LISTA DEI DEPOSITI O LA LISTA DEI PRELIEVI");
				
				key = tastiera.nextInt();
				
				
				switch(key) {
				
				// UN PO' LUNGHETTO, MA NON SONO RIUSCITO A FARE DI MEGLIO. I SYSOUTPRINT 
				// SONO TUTTI NECESSARI.
				
				case 1: 
					System.out.println("Inserisca il suo nome");
					String nome = tastiera.next();
					System.out.println("Inserisca il suo cognome");
					String cognome = tastiera.next();
					System.out.println("Inserisca il suo saldo iniziale");
					int saldo = tastiera.nextInt();
					Conto nuovoConto = new Conto(nome, cognome, saldo, sistemaBancario);
					sistemaBancario.listaConti.add(nuovoConto);
					Movimento nuovoMovimento = new Movimento("Inizializzazione conto", saldo, "Deposito");
					nuovoConto.getListaMovimenti().add(nuovoMovimento);
					System.out.println("Questo è il suo numero di conto: " + nuovoConto.getNumeroCC());
					System.out.println("Questa è la sua password: " + nuovoConto.getPasswordUtente());

					break;
					
					
					
		
					// DEPOSITA DENARO
					
					// SFRUTTA LO STESSO METODO DEL CASO 3, 
					// MA HA COME PARAM IN INGRESSO IL DIVERSO VALORE DI KEY
					
				case 2:	
					Conto contoTrovato = sistemaBancario.inserisciNumeroConto(tastiera);
					
					if(contoTrovato == null) {
						System.err.println("Conto corrente non trovato.");
						break;
					} 
				
					if (contoTrovato.requestPassword(tastiera)) { 
					sistemaBancario.inserisciCausaleEImporto(tastiera, contoTrovato, key);
					}
					break;
					
					
					
				
					// PRELEVA
					// SFRUTTA LO STESSO METODO DEL CASO 2, 
					// MA HA COME PARAM IN INGRESSO IL DIVERSO VALORE DI KEY
					
				case 3:
					Conto contoTrovato1 = sistemaBancario.inserisciNumeroConto(tastiera);	
					
					if(contoTrovato1 == null) {
						System.err.println("Conto corrente non trovato.");
						break;
					} 
					
					if (contoTrovato1.requestPassword(tastiera)) {
					sistemaBancario.inserisciCausaleEImporto(tastiera, contoTrovato1, key);
					}
					break;
					
					
					
					
					// STAMPA IL SALDO
					
				case 4: 
					Conto contoTrovato2 = sistemaBancario.inserisciNumeroConto(tastiera);
					
					if(contoTrovato2 == null) {
						System.err.println("Conto corrente non trovato.");
						break;
					} 
						if (contoTrovato2.requestPassword(tastiera)) {
							contoTrovato2.stampaSaldo();
							}
					break;
					
					
					
					
					//STAMPA TUTTI I MOVIMENTI
					
				case 5: 
					Conto contoTrovato3 = sistemaBancario.inserisciNumeroConto(tastiera);
					
					if(contoTrovato3 == null) {
						System.err.println("Conto corrente non trovato.");
						break;
					} 
						if(contoTrovato3.requestPassword(tastiera)) {
						sistemaBancario.stampaMovimenti(contoTrovato3);
					}
					break;
					
					
					
					
					//FILTRA I MOVIMENTI IN BASE ALL'INPUT String DENOMINATO scelta
			
				case 6: 
					Conto contoTrovato4 = sistemaBancario.inserisciNumeroConto(tastiera);
				
					if(contoTrovato4 == null) {
						System.err.println("Conto corrente non trovato.");
						break;
					} 
					
					if(contoTrovato4.requestPassword(tastiera)) {
						System.out.println("Inserisca 'DEPOSITO' o 'PRELIEVO'");
						String scelta = tastiera.next();
						if (scelta.toUpperCase().equals("DEPOSITO") ||  scelta.toUpperCase().equals("PRELIEVO")) {
							sistemaBancario.stampaMovimenti(contoTrovato4, scelta);
						} else {
							System.err.println("INPUT ERROR");
						break;
					}}
					break;
					}//switch
				
				
				} while(key != 0); //do
			

	

	}//method


}//class
			 

