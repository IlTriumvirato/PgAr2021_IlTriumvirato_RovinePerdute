package arnaldo.anno2021.triumvirato.rovineperdute;

public class Constants {

	public static final String TEAM1_NAME = "Tonatiuh";
	public static final String TEAM2_NAME = "Metztli";

	
	public static final String PATH_RELATIVO_INPUT_FOLDER="xmlInputFiles/";
	public static final String NOME_FILE_MAPPA="PgAr_Map_5.xml";
	public static final String PATH_RELATIVO_MAPPA=PATH_RELATIVO_INPUT_FOLDER+NOME_FILE_MAPPA;
	
	public static final String PATH_RELATIVO_OUTPUT_FOLDER="";
	public static final String NOME_FILE_OUTPUT="Routes.xml";
	public static final String PATH_RELATIVO_OUTPUT=PATH_RELATIVO_OUTPUT_FOLDER+NOME_FILE_OUTPUT;
	
	
	public static final String ALERT_MESSAGE_SUCCESSFUL_EXECUTION="L'esecuzione del programma è avvenuta con successo.";
	//public static final String ERROR_MESSAGE_EXECUTION_STOPPED="ERRORE: a causa di uno o più errori(sopra indicati se è stato possibile individuarli) il programma ha dovuto terminare la sua esecuzione anzitempo, si raccomanda di ricontrollare i file di input per evitare che questo si verifichi di nuovo";
	//public static final String ERROR_MESSAGE_VILLAGGIO_NON_ANALIZZABILE="ERRORE: a causa di un errore di lettura non sarà possibile analizzare l'individuo %s %s";
	public static final String ERROR_MESSAGE_FILE_ASSENTI=String.format("ERRORE: il file cercato risulta assente, si prega di controllare di averlo inserito nella cartella corretta e con il nome previsto, si ricorda di seguito il path previsto: %s", PATH_RELATIVO_MAPPA);
	public static final String INFORMATION_MESSAGE=String.format("Benvenuto nel nostro programma, per ottenere le informazioni sui cammini da seguire per entrambe le squadre(%s e %s) per raggiungere le rovine perdute."
	+"\nInserire le seguenti informazioni nel file %s, che si trova in %s all'interno della directory principale:"
	+"\n una mappa(tag map) contenente la lista di citta' da visitare(tag city);"
	+"\n ciascuna citta' deve avere gli attributi id e name indicanti un intero che faccia da identificativo univoco e un nome a piacere e all'interno del tag scrivere i sentieri(tag link);"
	+"\n ciascun sentiero(link) contiene un attributo indicante l'id della citta' a cui porta a partire da quella in cui e' contenuto questo tag link;"
	+"\n si noti in fine che la citta' con l'id maggiore rappresenta sicuramente le rovine perdute."
	+"\n\nI dati da lei forniti verranno elaborati e restituiti in formato xml nel file %s presente nella directory principale del programma."
	+"\nIl file di output conterrà i percorsi da seguire per ciascuna delle due squadre e i relativi costi in carburante."
	+"\nSi consideri che la prima squadra(%s) ha un veicolo che consuma carburante solo in base alla distanza orizzontale e la seconda squadra(%s) ha un veicolo che consuma carburante solo in base alla distanza verticale.",
	TEAM1_NAME,TEAM2_NAME,NOME_FILE_MAPPA,PATH_RELATIVO_INPUT_FOLDER, NOME_FILE_OUTPUT,TEAM1_NAME,TEAM2_NAME);
	
	
	
	
	
}
