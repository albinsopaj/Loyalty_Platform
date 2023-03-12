<p align="center">
    <img src="https://assets.website-files.com/617aa3d3451f413605c27704/617aa3d3451f411422c27889_Loyall-06.svg" alt="logo del progetto" height="300em">
</p>

---
<p align="center">
    <img src="https://forthebadge.com/images/badges/made-with-java.svg"/>
    <img src="https://forthebadge.com/images/badges/powered-by-coffee.svg"/><br><br>
    Il progetto <strong>Loyalty Platform</strong> è stato realizzato in <b>Java</b> con il supporto dei framework <strong>SpringBoot</strong> e <strong>Vue JS</strong> per il corso di <b>Laurea Triennale in Scienze e Tecnologie Informatiche L-31</b> presso l<b>'Università di Camerino</b>, nell'anno accademico <strong>2022/2023</strong> dagli studenti <b>Alessandro Maric</b>, <b>Klea Pici</b> e <b>Albin Sopaj</b>, per gli esami di <b>Ingegneria del Software</b> (IdS) e <b>Programmazione di Applicazioni Web e Mobili </b> (PAWM), utilizzando le tecnologie mostrate nella sezione Tecnologie Utilizzate
</p>

# Indice

1. [Panoramica e funzionalità](#panoramica)
2. [Processo di Sviluppo](#processo)
2. [Tecnologie Utilizzate](#tecnologie)
4. [Iterazioni](#iterazioni)
5. [Autori](#autori)

# Panoramica generale

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


- Il <b>`Cashier`</b> è colui che gestisce la cassa e convalida gli acquisiti effettuati dai clienti.


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


- Il `Titolare` una volta autenticato alla piattaforma, potrà creare delle campagne e dei programmi fedeltà.

# Funzionalità principali

---

## Titolare

- Registrazione e Autenticazione
- Creazione azienda
- Modifica Profilo
- Visualizza Profilo
- Creazione Programma Fedeltà

## Cliente

- Registrazione e Autenticazione
- Iscrizione a un Programma Fedeltà
- Modifica Profilo
- Visualizza Profilo

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

## Frontend

Il lato `Frontend` è stato sviluppato tramite l'utilizzo del framework `VueJS` ed il suo relativo
linguaggio `JavaScript`.

La scelta di utilizzare proprio questo strumento è stata fatta dopo aver considerato i vantaggi che VueJS offre, tra cue
i seguenti:

- È un framework JavaScript progressivo open source del modello Model-View-View-Model (MVVM) per la costruzione di
  interfacce utente web interattive e applicazioni a pagina singola (SPA).

- Vue.js presenta un'architettura incredibilmente adattabile che si concentra sul rendering dichiarativo e sulla
  composizione dei componenti. La libreria principale è focalizzata solo sul livello di visualizzazione. Funzionalità
  avanzate richieste per applicazioni complesse come routing, gestione dello stato e strumenti di costruzione sono
  offerte tramite librerie e pacchetti di supporto ufficialmente gestiti.

- Vue presenta un sistema di reattività che utilizza oggetti JavaScript semplici e rendering ottimizzato. Ogni
  componente tiene traccia delle sue dipendenze reattive durante il suo rendering, quindi il sistema sa esattamente
  quando riesaminare e quali componenti riesaminare.

- Ha tutte le caratteristiche e le qualità che rendono lo sviluppo liscio e facile. La sua curva di apprendimento
  delicata è il primo fattore significativo. Inoltre, è anche leggero, flessibile, modulare e altamente performante

Per quanto riguarda le rotte con cui è possibile muoversi attraverso le varie pagine dell'applicazione, esse sono:

- `.../home` pagina di default overo la homepage

- `.../client/register` pagina di registrazione dove il cliente può registrarsi

- `.../client/login` pagina di login dove il cliente può autenticarsi

- `.../client/profile` pagina che mostra i dati da visualizzare del cliente

- `.../owner/register` pagina di registrazione dove il titolare può registrarsi

- `.../owner/login` pagina di login dove il titolare può autenticarsi

- `.../owner/addCompany` pagina dove il titolare può aggiungere un'azienda

- `.../profile/modify` pagina dove si possono modificare i dati personali

- `.../owner/profile` pagina che mostra i dati da visualizzare del titolare

(I tre puntini rappresentano il dominio del backend, che quando verrà eseguito in local sarà `localhost:8081`
oppure `localhost:8082`).

Tale rotte sono protette e non si possono accedere senza aver effetuato l'autenticazione.

L'autenticazione tra il client e il server avviene attraverso l'utilizzo di un codice JWT

## Backend

Il lato <b>`Backend`</b> del sistema è stato sviluppato in <b>`Java`</b> con il supporto del framework `Spring-Boot` a
cui è stato affrontato il compito di gestire le `REST API`. Per l'autenticazione degli utenti utilizziamo i `JWT tokens` 

### Elenco API

Le seguenti sono delle API esposte dal backend:

- `POST /api/auth/client/signin` utilizzata per autenticare il cliente
- `POST /api/auth/client/signup` utilizzata per registrare il cliente
- `POST /api/auth/owner/signin` utilizzata per autenticare il titolare
- `POST /api/auth/owner/signup` utilizzata per registrare il titolare
- `GET /api/test/owner` utilizzata per visualizzare le informazioni del titolare
- `GET /api/test/client` utilizzata per visualizzare le informazioni del cliente
- `PUT /loyaltyPlatform/client/registerToFidelityProgram/{clientId}/{fidelityProgramId}` utilizzata per registrarsi ad un programma fedeltà
- `PUT /loyaltyPlatform/client/update/profile/{clientId}` utilizzata per modificare il profilo del cliente
- `GET /loyaltyPlatform/client/getDigitalCards/{clientId}` utilizzata per ottenere le carte digitale del cliente
- `POST /loyaltyPlatform/owner/addCompany/{ownerId}` utilizzata per aggiungere un'azienda
- `PUT /loyaltyPlatform/owner/update/profile/{ownerId}` utilizzata per modificare il profilo del titolare
- `POST /loyaltyPlatform/owner/addPointsFidelityProgram/{ownerId}/{companyId}` utilizzata per creare ed aggiungere un programma fedeltà a punti ad un azienda
- `POST /loyaltyPlatform/owner/addLevelFidelityProgram/{ownerId}/{companyId}` utilizzata per creare ed aggiungere un programma fedeltà a livelli ad un azienda
- `GET /loyaltyPlatform/owner/company/{ownerId}/{companyId}` utilizzata per ottenere una azienda del titolare
- `GET /loyaltyPlatform/owner/companies/{ownerId}` utilizzata per ottenere tutte le aziende del titolare
- `GET /loyaltyPlatform/company/getFidelityPrograms/{id}` utilizzata per ottenere tutti i programmi fedeltà di una azienda
- `GET /loyaltyPlatform/company/getAll` utilizzata per ottenere tutte le aziende nella piattaforma

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

