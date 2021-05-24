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
	
	/*
	public static void outputPaths(Cammino cammino1, Cammino cammino2, Veicolo veicoloTeam1, Veicolo veicoloTeam2) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db=null;
		db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		//elemento radice <output>
		Element output = doc.createElement("output");
		
		//CREAZIONE ELEMENTI DI PERSONE
		
		//elemento <persone>
		Element persone= doc.createElement("persone");
		//creo attributo numero
		Attr numero_persone=doc.createAttribute("numero");
		numero_persone.setValue(String.valueOf(dp.size()));
		//aggiungo numero a persone
		persone.setAttributeNode(numero_persone);
		//INIZIO FOR
		for(int i=0;i<dp.size();i++) {
			//creo persona
			Element persona=doc.createElement("persona");
			//creazione tutto per persona
			Attr id_persona=doc.createAttribute("id");
			Element nome=doc.createElement("nome");
			Element cognome=doc.createElement("cognome");
			Element sesso=doc.createElement("sesso");
			Element comune_nascita=doc.createElement("comune_nascita");
			Element data_nascita=doc.createElement("data_nascita");
			Element codice_fiscale=doc.createElement("codice_fiscale");
			
			//settaggio values
			id_persona.setValue(String.valueOf(i));
			nome.setTextContent(dp.get(i).getNome());
			cognome.setTextContent(dp.get(i).getCognome());
			sesso.setTextContent(String.valueOf(dp.get(i).getSesso()));
			comune_nascita.setTextContent(dp.get(i).getComune_nascita());
			data_nascita.setTextContent((dp.get(i).getData_nascita()).toString());
			
			if(dp.get(i).getCodiceAssente()) {
				codice_fiscale.setTextContent("ASSENTE");
			}else {
				codice_fiscale.setTextContent(dp.get(i).getCodiceFiscale());
			}
			//attaccare tutto a persona
			persona.setAttributeNode(id_persona);
			persona.appendChild(nome);
			persona.appendChild(cognome);
			persona.appendChild(sesso);
			persona.appendChild(comune_nascita);
			persona.appendChild(data_nascita);
			persona.appendChild(codice_fiscale);
			//attaccare persona a persone
			persone.appendChild(persona);
		}
		
		//elemento <codici>
		Element codici= doc.createElement("codici");
		//invalidi
		Element invalidi= doc.createElement("invalidi");
		Attr numero_invalidi=doc.createAttribute("numero");
		numero_invalidi.setValue(String.valueOf(listaInvlidi.size()));
		invalidi.setAttributeNode(numero_invalidi);
		//inizio for codice invalido
		for(int i=0;i<listaInvlidi.size();i++) {
			Element codice_invalido= doc.createElement("codice");
			//settaggio values
			codice_invalido.setTextContent(listaInvlidi.get(i));
			//attaccare un codice a codici invalidi
			invalidi.appendChild(codice_invalido);
			//fine for
		}
			
		//codici spaiati
		Element spaiati= doc.createElement("spaiati");
		Attr numero_spaiati=doc.createAttribute("numero");
		numero_spaiati.setValue(String.valueOf(listaSpaiati.size()));
		spaiati.setAttributeNode(numero_spaiati);
		//un codice spaiato, inizio for
		for(int i=0;i<listaSpaiati.size();i++) {
			Element codice_spaiato= doc.createElement("codice");
			//settaggio value
			codice_spaiato.setTextContent(listaSpaiati.get(i));
			//attaccare un codice ai codici spaiati
			spaiati.appendChild(codice_spaiato);
			//fine for
		}
		
			
		//attaccare tutto a codici
		codici.appendChild(invalidi);
		codici.appendChild(spaiati);
		
		//attaccare tutto ad output
		output.appendChild(persone);
		output.appendChild(codici);
		//attaccare l'output al documento principale
		doc.appendChild(output);
	

		// write the content into xml file
	    Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT,"yes");
		tf.setOutputProperty(OutputKeys.METHOD, "xml");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(Constants.PATH_RELATIVO_OUTPUT));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		tf.transform(source, result);

	}
	*/
	
}
