package arnaldo.anno2021.triumvirato.rovineperdute;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class InputXML {

	
	private static XMLStreamReader getXmlReader(String filename) {
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
			
		} catch (Exception e){
			System.out.println(Constants.ERROR_MESSAGE_FILE_ASSENTI);
			//DataProcessor.errorOccourrence();
			//DataProcessor.setUnexecutable();
			//System.out.println(e.getMessage());
		}
		
		return xmlr;
	}
	
	
	
	public static Mappa inputMappa(String filename) {
		
		Mappa daRitornare=new Mappa();
		ArrayList<Villaggio> villaggiMappa=daRitornare.getVillaggi();
		ArrayList<Sentiero> sentieriMappa=daRitornare.getSentieri();
		
		XMLStreamReader xmlr=getXmlReader(filename);
		int n_villaggi=0;
		String selezione="";
		boolean mustRemove=false;
		
		if(xmlr!=null)
		try {
					
			
			
			while (xmlr.hasNext()) {
				
				 switch (xmlr.getEventType()) { 
					 case XMLStreamConstants.START_ELEMENT:
						 selezione=xmlr.getLocalName();
						 
						 if(selezione.equals("map")) {
							 n_villaggi=Integer.parseInt(xmlr.getAttributeValue(0));
							 
						 }else if(selezione.equals("city")) {
							 
							 int identificativo=Integer.parseInt(xmlr.getAttributeValue(0));
							 String nomeVillaggio=xmlr.getAttributeValue(1);
							 Posizione coordinate=new Posizione(Integer.parseInt(xmlr.getAttributeValue(2)),Integer.parseInt(xmlr.getAttributeValue(3)),Integer.parseInt(xmlr.getAttributeValue(4)));
							 System.out.println("citta'("+identificativo+"): "+nomeVillaggio);
							 villaggiMappa.add(new Villaggio(identificativo,nomeVillaggio,coordinate));
							 

						 }else if(selezione.equals("link")) {
							 
							 int idDestinazione=Integer.parseInt(xmlr.getAttributeValue(0));
							 Villaggio attuale=daRitornare.getVillaggi().get(daRitornare.getVillaggi().size()-1);
							 //attuale.getIdCollegati().add(idDestinazione);
							 //System.out.println("sentiero'("+attuale.getId()+","+idDestinazione+")");
							 sentieriMappa.add(new Sentiero(attuale.getId(),idDestinazione));
						 }
						 
					 break;
					 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
						 //non ce ne sono, quindi, almeno per ora il programma non fa niente

					 break;
					 case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
						 /*if(xmlr.getLocalName().equals("persona")&&mustRemove&&datiPersone.size()>0) {
							 System.out.print(String.format(Constants.ERROR_MESSAGE_PERSONA_NON_ANALIZZABILE, datiPersone.get(datiPersone.size()-1).getNome(), datiPersone.get(datiPersone.size()-1).getCognome()));
							 DataProcessor.errorOccourrence();
							 datiPersone.remove(datiPersone.size()-1);
							 mustRemove=false;
						 };*/
						 
							 //dovrebbero essere già ordinati, ma in caso li ordina
							 if(xmlr.getLocalName().equals("map")) {
								 
								 
							 
							 
							 daRitornare.sortMappa();
							 
							 
							 int lastCheckedPosition=0;
							 
							 for(int i=0;i<villaggiMappa.size();i++) {
								 Villaggio attuale=villaggiMappa.get(i);
								 
								 for(int j=lastCheckedPosition;j<sentieriMappa.size();j++) {
									 								 
									 if(sentieriMappa.get(j).getIdPartenza()!=attuale.getId()) {
										 lastCheckedPosition=j;
										 break;
									 }else {
										 
										 int idAltroVillaggio=sentieriMappa.get(j).getIdDestinazione();
										 System.out.println("link: ("+attuale.getId()+","+idAltroVillaggio+")");
										 Villaggio altroVillaggio=daRitornare.findCityById(idAltroVillaggio);
										 
										 sentieriMappa.get(j).aggiornaSentiero(attuale,altroVillaggio);
										 attuale.getCollegamenti().add(sentieriMappa.get(j));
									 }
								 }
							 }
						 
						 }
					 break;
				 }
				 
				 
				 xmlr.next();
				
				 
			}
		
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		System.out.println("villaggi: "+daRitornare.getVillaggi().size());
		System.out.println("sentieri: "+daRitornare.getSentieri().size());
		
		return daRitornare;
		
	}
	
	

}
