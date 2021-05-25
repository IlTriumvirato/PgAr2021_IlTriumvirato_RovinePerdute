package arnaldo.anno2021.triumvirato.rovineperdute;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OutputXML {
	

	public static void outputPaths(Cammino cammino1, Cammino cammino2, String fileName) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db=null;
		db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		//elemento radice <output>
		Element routes = doc.createElement("routes");
		Element route1 = doc.createElement("route");
		Element route2 = doc.createElement("route");
		
		
		Attr nomeTeam1=doc.createAttribute("team");
		nomeTeam1.setValue(Constants.TEAM1_NAME);
		route1.setAttributeNode(nomeTeam1);
		
		Attr nomeTeam2=doc.createAttribute("team");
		nomeTeam2.setValue(Constants.TEAM2_NAME);
		route2.setAttributeNode(nomeTeam2);
		
		
		Attr costo1=doc.createAttribute("cost");
		costo1.setValue(String.valueOf(cammino1.getCosto()));
		route1.setAttributeNode(costo1);
		
		Attr costo2=doc.createAttribute("cost");
		costo2.setValue(String.valueOf(cammino2.getCosto()));
		route2.setAttributeNode(costo2);
		
		Attr numeroCity1=doc.createAttribute("cities");
		numeroCity1.setValue(String.valueOf(cammino1.getListaVillaggi().size()));
		route1.setAttributeNode(numeroCity1);
		
		Attr numeroCity2=doc.createAttribute("cities");
		numeroCity2.setValue(String.valueOf(cammino2.getListaVillaggi().size()));
		route2.setAttributeNode(numeroCity2);
		
		
		for(int i=0; i<cammino1.getListaVillaggi().size(); i++) {
			int id = cammino1.getListaVillaggi().get(i).getId();
			String nome = cammino1.getListaVillaggi().get(i).getNome();
			
			Element villaggio = doc.createElement("city");
			
			Attr idVillaggio=doc.createAttribute("id");
			idVillaggio.setValue(String.valueOf(id));
			villaggio.setAttributeNode(idVillaggio);
			
			Attr nomeVillaggio=doc.createAttribute("name");
			nomeVillaggio.setValue(nome);
			villaggio.setAttributeNode(nomeVillaggio);
			
			route1.appendChild(villaggio);
		}
		
		
		for(int i=0; i<cammino2.getListaVillaggi().size(); i++) {
			int id = cammino2.getListaVillaggi().get(i).getId();
			String nome = cammino2.getListaVillaggi().get(i).getNome();
			
			Element villaggio = doc.createElement("city");
			
			Attr idVillaggio=doc.createAttribute("id");
			idVillaggio.setValue(String.valueOf(id));
			villaggio.setAttributeNode(idVillaggio);
			
			Attr nomeVillaggio=doc.createAttribute("name");
			nomeVillaggio.setValue(nome);
			villaggio.setAttributeNode(nomeVillaggio);
			
			route2.appendChild(villaggio);
		}
		
		
		
		routes.appendChild(route1);
		routes.appendChild(route2);
		
		doc.appendChild(routes);
		
		
	

		// write the content into xml file
	    Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT,"yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(fileName));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		tf.transform(source, result);

	}

	
}
