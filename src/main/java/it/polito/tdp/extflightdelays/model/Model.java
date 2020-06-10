package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Map<Integer, Airport> idMapAirport; 
	private Graph<Airport, DefaultWeightedEdge> grafo;
	
	public Model() {
		this.idMapAirport = new HashMap<Integer, Airport>();
	}
	
	
	public void creaGrafo(int x) {
		this.grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao= new ExtFlightDelaysDAO();
		dao.loadAllAirports(this.idMapAirport);
	
		//aggiungo vertici
		Graphs.addAllVertices(this.grafo, idMapAirport.values());
		
		
		
		List<Adiacenza> list = dao.getAdiacenze(idMapAirport);
		
		//aggiungo archi
		for(Adiacenza a: list) {
			if(this.grafo.containsEdge(a.getPartenza(), a.getDestinazione())) {
				//aggiorno peso
				DefaultWeightedEdge e= this.grafo.getEdge(a.getPartenza(), a.getDestinazione());
				int peso= (int) this.grafo.getEdgeWeight(e);
				this.grafo.setEdgeWeight(e, (peso+a.getDist_media())/2);
			}else {
				//aggiungo arco
				Graphs.addEdge(this.grafo, a.getPartenza(), a.getDestinazione(), a.getDist_media());
			}
		}
		
		List<DefaultWeightedEdge> archiRemove = new ArrayList<>();
		for(DefaultWeightedEdge d: this.grafo.edgeSet()) {
			if(this.grafo.getEdgeWeight(d)<x) {
				archiRemove.add(d);
			}
		}
		
		this.grafo.removeAllEdges(archiRemove);
		
	}
	
	
	public int nVertici() {
		int nVertici=0;
		for(Airport a: this.grafo.vertexSet()) {
			if(this.grafo.edgesOf(a).size()>0) {
				nVertici++;
			}
		}
		
		return nVertici;
		//return this.grafo.vertexSet().size();
	}
	
	public int nEdges() {
		return this.grafo.edgeSet().size();
	}
	

}
