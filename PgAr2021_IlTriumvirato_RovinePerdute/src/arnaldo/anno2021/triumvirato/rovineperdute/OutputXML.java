package arnaldo.anno2021.triumvirato.rovineperdute;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OutputXML {
	
	public static Document createXMLDocument() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db=null;
		db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		return doc;
	}
	
	
	private static Element createRouteElement(Document doc, String teamName, double cost, int citiesAmount){
		Element route=doc.createElement("route");
		
		Attr attributoNomeTeam=doc.createAttribute("team");
		attributoNomeTeam.setValue(teamName);
		route.setAttributeNode(attributoNomeTeam);
		
		Attr attributoCosto=doc.createAttribute("cost");
		attributoCosto.setValue(String.valueOf(cost));
		route.setAttributeNode(attributoCosto);
		
		Attr attributoNumeroVillaggi=doc.createAttribute("cities");
		attributoNumeroVillaggi.setValue(String.valueOf(citiesAmount));
		route.setAttributeNode(attributoNumeroVillaggi);
		
		return route;
	}
	
	
	private static Element createCityElement(Document doc, int id, String nome){
		Element city=doc.createElement("city");
		
		Attr attributoIdVillaggio=doc.createAttribute("id");
		attributoIdVillaggio.setValue(String.valueOf(id));
		city.setAttributeNode(attributoIdVillaggio);
		
		Attr attributoNomeVillaggio=doc.createAttribute("name");
		attributoNomeVillaggio.setValue(nome);
		city.setAttributeNode(attributoNomeVillaggio);
		
		return city;
	}
	
	
	private static Element buildRootElementWithContent(Document doc, Cammino cammino1, Cammino cammino2) {
		Element routes = doc.createElement("routes");
		
		Element route1 = createRouteElement(doc,Constants.squadra1.getNome(),cammino1.getCosto(),cammino1.getListaVillaggi().size());
		Element route2 = createRouteElement(doc,Constants.squadra2.getNome(),cammino2.getCosto(),cammino2.getListaVillaggi().size());
		
		
		//crea i contenuti delle due route: la lista di tutte le città percorse
		
		for(int i=0; i<cammino1.getListaVillaggi().size(); i++) {
			int id = cammino1.getListaVillaggi().get(i).getId();
			String nome = cammino1.getListaVillaggi().get(i).getNome();
			
			Element villaggio= createCityElement(doc,id,nome);
						
			route1.appendChild(villaggio);
		}
		
		
		for(int i=0; i<cammino2.getListaVillaggi().size(); i++) {
			int id = cammino2.getListaVillaggi().get(i).getId();
			String nome = cammino2.getListaVillaggi().get(i).getNome();
			
			Element villaggio= createCityElement(doc,id,nome);
						
			route2.appendChild(villaggio);
		}
		
		
		
		//aggiunge i contenuti
		
		routes.appendChild(route1);
		routes.appendChild(route2);
		return routes;
	}
	

	
	public static void outputPaths(Cammino cammino1, Cammino cammino2, String filename) throws Exception {
		
		Document doc=createXMLDocument();

		//scrive i contenuti e li inserisce nel document
		Element fileContents = buildRootElementWithContent(doc,cammino1,cammino2);
		doc.appendChild(fileContents);
		
		
		// write the document contents into xml file
		transformContent(doc, filename);

	}
	
	private static void transformContent(Document doc, String filename) {
		Transformer tf;
		try {
			tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT,"yes");
			tf.setOutputProperty(OutputKeys.METHOD, "xml");
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));

			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);

			tf.transform(source, result);
		
		} catch (TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
