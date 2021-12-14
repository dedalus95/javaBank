package bancomat;

import java.util.Vector;

public class Atm {

	private Vector<Conto> insiemeConti;
	
	public Atm() {
		this.insiemeConti = new Vector<Conto>(1000);
	}

	public Vector<Conto> getInsiemeConti() {
		return insiemeConti;
	}

	public void setInsiemeConti(Vector<Conto> insiemeConti) {
		this.insiemeConti = insiemeConti;
	}
	
	
}
