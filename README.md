<p align="center">
    <img src="https://assets.website-files.com/617aa3d3451f413605c27704/617aa3d3451f411422c27889_Loyall-06.svg" alt="logo del progetto" height="300em">
</p>

---
<p align="center">
    <img src="https://forthebadge.com/images/badges/made-with-java.svg"/>
    <img src="https://forthebadge.com/images/badges/powered-by-coffee.svg"/><br><br>
    Il progetto <strong>Loyalty Platform</strong> è stato realizzato in <b>Java</b> con il supporto del framework <strong>SpringBoot</strong> per il corso di <b>Laurea Triennale in Scienze e Tecnologie Informatiche L-31</b> presso l<b>'Università di Camerino</b>, nell'anno accademico <strong>2022/2023</strong> dagli studenti <b>Alessandro Maric</b>, <b>Klea Pici</b> e <b>Albin Sopaj</b>, per gli esami di <b>Ingegneria del Software</b> (IdS) e <b>Programmazione di Applicazioni Web e Mobili </b> (PAWM), utilizzando le tecnologie mostrate nella sezione Tecnologie Utilizzate
</p>

# Indice

1. [Panoramica e funzionalità](#panoramica)
2. [Processo di Sviluppo](#processo)
2. [Tecnologie Utilizzate](#tecnologie)
4. [Iterazioni](#iterazioni)
5. [Autori](#autori)

# Panoramica e funzionalità

---
Lo scopo dell’applicativo proposto è quello di realizzare un'applicazione che permetta alle aziende, ai negozi e a tutte
le attività commerciali di aumentare il tasso di fidelizzazione, ritenere i clienti i acquisirne di nuovi.
I ruoli ricoperti dagli utenti nell’applicativo sono: <b>Utente Non-Registrato, Utente Registrato, Cliente Registrato,
Titolare, Manager e Cassiere</b>.

- L'<b>`Utente Registrato`</b> rappresenta un'entità/account registrata/o all'interno della piattaforma. Esso avrà un
  ruolo che descrive i permessi necessari che l'utente possiede all'interno della piattaforma. Tali permessi indicano le
  funzionalità e le limitazioni che ciascun utente potrà effetuare.


- Il <b>`Cliente Non-Registrato`</b> rappresenta un cliente che ancora non si è registrato/a alla piattaforma.


- Il <b>`Cliente Registrato`</b> è colui che si iscrive a un programma fedeltà per usufruire dei servizi di
  fidelizzazione e scontistica offriti da un'azienda o negozio.


- Un <b>`Owner`</b> rappresenta un titolare del negozio o dell'azienda, ed è colui che decide i parametri della campagna
  e successivamente anche la creazione dei permessi, dei programmi fedeltà e invitare altri esercenti.


- Il <b>`Manager`</b> è colui che gestisce gli clienti (i.e aggiorna le loro informazioni), crea promozioni e crea
  messaggi pesonalizzati.


- Il <b>`Cashier`</b> è colui che gestisce la cassa e convalida gli acquisiti effettuati dai clienti. Quando i clienti
  acquistano un prodotto o servizio, alla cassa verranno chiesti dal commesso se appartengono già a un qualsiasi
  programma fedeltà. Se la risposta è no, allora il cliente può iscriversi direttamente in loco oppure ancha da remoto (
  accedendo all pagina della piattaforma), altrimenti il cassiere procede con la convalidazione dell'acquisto e il
  sistema aggiorna lo stato fedeltà del cliente (in base ai punti, livelli, ecc).


- L'<b>`Amministratore`</b> si occupa di gestire la piattaforma nel suo complesso, bensi essa funzioni in modo
  automatico, un amministratore può effettuare alcune modifiche manuali all'interno della piattaforma


- La <b>`Company`</b> (noto anche come <b>Azienda</b>) è interessata ad usufruire della piattaforma per offrire
  programmi fedeltà ai priori clienti.


- Il <b>`Modulo di Marketing`</b> rappresenta un'entità esterna che interagisce direttamente con la piattaforma di
  fidelizzazione. Quando i clienti vanno ad acquistare prodotti o servizi online, avranno due possibilità: <i>possono
  usufruire dei punti correnti se ne sono in possesso</i> o <i>possono acquistare senza punti, e dopo l'acquisto
  verranno accreditati dei punti in base a quanto ha speso.</i>


- Il `Cliente` una volta autenticato potrà visualizzare il suo profilo, visualizzare la sua tessera digitale e può anche
  lasicare una recensione su un programma fedeltà a cui è stato aderito.


- Il `Titolare` una volta autenticato alla piattaforma, potrà creare delle campagne e dei programmi fedeltà, può
  invitare altri esercenti per collaborare in programmi fedeltà coalizione e può anche registrare nuovi dipendenti con
  permessi specifici-

# Processo di Sviluppo

---
Per sviluppare l'applicativo è stato scelto di seguire il processo standardizzato **`Unified Process (UP)`**, processo
iterativo incrementale, utilizzando come strumento di lavoro **`Visual Paradigm`** basato sul
linguaggio **`UML` (`Unified Modeling Language`)**.

In totale sono state svolte 4 iterazioni dove è stato possibile effettuare l'analisi dei requisiti, la progettazione del
sistema e l'implementazione.

Come strumento di versioning è stato utilizzato **`Git`** e **`GitHub`** attraverso i quali è stato distinto un'unico
branch per lo sviluppo.

- `main`: utilizzato per pubblicare la baseline (artefatti) sviluppati a fine iterazione e per lo sviluppo in
  corrispondenza alla consegna per **Ingegneria del Software**.

Le varie iterazioni hanno dato origine ai seguenti artefatti:

- Diagramma dei casi d'uso: raccolta e specifica dei requisiti e funzionalità del sistema.
- Diagramma classi di analisi: identificano i concetti che è necessario il sistema rappresenti e sia capace di
  manipolare.
- Diagrammi di sequenza: descrivono come le classi di analisi interagiscono tra di loro per realizzare il comportamento
  definito nei casi d'uso.
- Diagramma classi di progetto: realizzato per derivare le classi di progetto partendo dalle classi di analisi, il
  diagramma verrà utilizzato per le attività di implementazione.
- Code Base

# Tecnologie Utilizzate <a name = "tecno"></a>

---
Il lato <b>`Backend`</b> del sistema è stato sviluppato in <b>`Java`</b> con il supporto del framework `Spring-Boot` a
cui è stato affrontato il compito di gestire le `REST API`.

Come strumento per il building automatizzato del sistema si è impiegato **`Gradle`**.

Per la persistenza dei dati ci si è affidati al database relazionale <b>`MySQL`</B>.

Nella cartella [Documentation](https://github.com/albinsopaj/Loyalty_Platform/tree/main/Documentation) si possono
osservare i modelli sviluppati e come si è proceduto durante le varie iterazioni del processo.

# Iterazioni

---
Il progetto è stato implementato in `4 iterazioni`, della durata massima di 2 settimane per le prime due iterazioni e di
3 settimane per le ultime due iterazioni, rispettando gli standard del `Processo Unificato` e l'utilizzo di alcuni
Design Pattern.

Nella prima iterazione, la fase di avvio, si è discusso dei possibili attori che potessero partecipare e quindi
usufruire dell'applicazione, attraverso la partecipazione a differenti workshop e brainstorming individuali e di
gruppo. <br>

Una volta identificati tutti gli attori, nelle successive iterzaioni si è proceduto ad identificare i casi d'uso ad essi
corellati, fino ad arrivare alla III iterazione con il 90% dei casi d'uso sviluppati.

La III e IV iterazione si sono focalizzate sull'implementazione del codice e progettazione di tutto il sistema. In
particolar modo nella IV iterazione sono stati prefezionate alcune funzionalità ritenute più importanti. <br>

Alla fine della progettazione è stato proceduto con la fase di testing, utilizzando il software <b>Postman</b>, una
piattaforma API per gli sviluppatori per progettare, creare, testare e iterare le API. <br>
Grazie ad esso è stato possibile replicare le chiamate e verificarne la correttezza.

# Autori <a name = "autori"></a>

---

- [Alessandro Maric](https://github.com/GitSsandro)
- [Klea Pici](https://github.com/KleaPici)
- [Albin Sopaj](https://github.com/albinsopaj)
