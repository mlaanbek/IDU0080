package idu0080.laanbek.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tellimus implements Serializable {
	private static final long serialVersionUID = 1;
	public List<TellimuseRida> tellimusRead;
	
	public Tellimus() {
		tellimusRead = new ArrayList<TellimuseRida>();
	}
	
	public void addTellimuseRida(TellimuseRida tellimuseRida) {
		this.tellimusRead.add(tellimuseRida);
	}
	
	public List<TellimuseRida> getTellimuseRead() {
		return tellimusRead;
	}
}
