package it.polito.tdp.extflightdelays.model;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Adiacenza {
	
	private Airport partenza;
	private Airport destinazione;
	private int voliTot;
	private int distazaTot;
	private int dist_media;
	
	public Adiacenza(Airport partenza, Airport destinazione, int voliTot, int distazaTot, int dist_media) {
		super();
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.voliTot = voliTot;
		this.distazaTot = distazaTot;
		this.dist_media = dist_media;
	}

	public Airport getPartenza() {
		return partenza;
	}

	public void setPartenza(Airport partenza) {
		this.partenza = partenza;
	}

	public Airport getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(Airport destinazione) {
		this.destinazione = destinazione;
	}

	public int getVoliTot() {
		return voliTot;
	}

	public void setVoliTot(int voliTot) {
		this.voliTot = voliTot;
	}

	public int getDistazaTot() {
		return distazaTot;
	}

	public void setDistazaTot(int distazaTot) {
		this.distazaTot = distazaTot;
	}

	public int getDist_media() {
		return dist_media;
	}

	public void setDist_media(int dist_media) {
		this.dist_media = dist_media;
	}
	
	
	

}
