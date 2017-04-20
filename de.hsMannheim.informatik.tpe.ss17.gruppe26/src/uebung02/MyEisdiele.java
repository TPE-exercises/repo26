package uebung02;

abstract public class MyEisdiele implements Eisdiele {

	protected String name;
	protected String region;

	MyEisdiele(String name, String region) {
		this.name = name;
		this.region = region;
	}
	
	public String getRegion(){
		return this.region;
	}

	public void bestellen() {
		begruesen();
		
		Eis eis = erstellen(this.getRegion());

		if(eis == null){
			entschuldigen();
			return;
		}

		eis.vorbereiten();
		eis.fuellen();
		eis.dekorieren();

		kassieren(eis);

		verabschieden(eis.toString());

	}

	abstract public void begruesen();

	abstract public void kassieren(Eis eis);

	abstract public void verabschieden(String eis);

	abstract public void entschuldigen();

	public abstract Eis erstellen(String typ);

}
