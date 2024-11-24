# Selainpeli

Tiimi: Jenna Räihä, Sakari Arasola, Heli Kyllinen

## Johdanto

### PalanPaikka – palapelien ystäville

PalanPaikka on käyttäjäystävällinen sovellus, jossa voit koota palapelejä helposti hakusanojen avulla. Sovellus on suunnattu kaikille palapeleistä kiinnostuneille – erityisesti heille, jotka etsivät hauskaa ja rentouttavaa tekemistä arjen kiireiden keskellä.

Alkuperäinen ideamme oli luoda pelialusta, joka tarjoaisi laajan valikoiman pelejä aina palapeleistä tasohyppelyihin. Kehitysprosessin myötä päätimme kuitenkin keskittyä yhteen ytimekkääseen kokemukseen, ja lopputuloksena syntyi PalanPaikka: sovellus, joka tuo palapelit kätesi ulottuville ulkoisen rajapinnan avulla. Projektin pääpaino oli myös kehitysprosessin hallinnassa, erityisesti omavetoisen Scrum-mallin hyödyntämisessä ja onnistuneessa projektinhallinnassa.

PalanPaikka on rakennettu käyttäen Spring Bootia, joka hoitaa palvelinpuolen logiikan ja REST-rajapintojen tarjoamisen. Sovellus hyödyntää Pixabay-rajapintaa, jonka avulla käyttäjä voi hakea palapelikuvia hakusanoilla.

Käyttöliittymä on selainpohjainen ja toteutettu HTML:n, Thymeleafin, CSS:n ja JavaScriptin avulla, mikä tekee sovelluksesta sekä visuaalisesti miellyttävän että toimivan eri laitteilla. Sovellus on julkaistu onnistuneesti Rahti-palvelussa, mikä tekee siitä helposti saavutettavan loppukäyttäjille. Lisäksi se hyödyntää Dockeria, joka mahdollistaa sovelluksen tehokkaan konttienhallinnan ja helpon käyttöönoton eri ympäristöissä.

PalanPaikka on onnistunut yhdistelmä luovuutta, teknologiaa ja huolellista projektinhallintaa – täydellinen valinta kaikille palapelifaneille!

## Järjestelmän määrittely

Järjestelmän pääasiallinen käyttäjä on pelaaja, joka käyttää sivustoa palapelien luomiseen ja kokoamiseen.

#### Käyttäjä

- Pelaa palapeliä
- Tarvittavat toiminnot:
    - sivustolle kirjautuminen
    - hakusanalla kuvan haku
    - vaikeustason valinta
    - palapelin kokoaminen
    - kuvagalleriasta valmistuneiden palapelien ja peliaikojen tarkastelu

### Käyttäjätarinoita

Käyttäjänä haluan valita palapelin vaikeustason, jotta voin säätää pelin haastavuuden omien mieltymysteni mukaan.

Käyttäjänä haluan syöttää tekstin hakukenttään ja saada siitä pixabayn kautta kuvan, jotta voin luoda palapelin.

Käyttäjänä haluan kirjautua palapelisivustolle sisään ja tarkastella tekemiäni palapelejä.

Käyttäjän haluan pystyä vertailemaan kuvagalleriassa kokoamieni palapelien kasausaikoja.

## Käyttöliittymä

### Käyttöliittymäkaaviona:
- Aloitusnäkymä
- Pelivalikko
    - Pelinäkymä
- Käyttäjätili
- Admin-näkymä

### Aloitusnäkymä
![image](https://github.com/user-attachments/assets/488a257a-61fe-4263-9dd5-074bd14d983c)

### Kuvagalleria

![image](https://github.com/user-attachments/assets/8555a9e8-5d4e-4e65-a641-174b5ae290d3)

## Tietokanta

![image](https://github.com/user-attachments/assets/c27f6e42-2c19-4d64-90b9-63ad8b36f76f)

> ### _User_
> _User-taulu sisältää pelisivuston käyttäjät. Käyttäjällä voi olla vain yksi tili.
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> user_id | PK* AN | Käyttäjän idnumero
> username | *C/100 | Käyttäjänimi, jota käytetään pelisivustolla
> password | *C/50 | Salasana, jolla kirjaudutaan pelisivustolle
> createDate | *DATE | Päivämäärä milloin käyttäjä on luotu

> ### _GameSession_
> _GameSession-taulu sisältää pelisession tiedot._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> gameSession_id | PK* AN | Pelisession idnumero
> user_id | FK* N | Käyttäjän idnumero, viittaus [User](#User)-tauluun
> status | * C/50 | Pelin status, kesken tai valmis

> ### _Image_
> _Image-taulu sisältää palapeliä varten luodun kuvan tiedot._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> image_id | PK* AN | Luodun kuvan idnumero
> image_url| * C/550 | Kuvan url-osoite
> description| *C/500 | Kuvaus millä kuva on luotu
> createDate | *DATE | Päivämäärä milloin kuva on luotu

## Tekninen kuvaus

Teknisessä kuvauksessa esitetään järjestelmän toteutuksen suunnittelussa tehdyt tekniset
ratkaisut, esim.

-   Missä mikäkin järjestelmän komponentti ajetaan (tietokone, palvelinohjelma)
    ja komponenttien väliset yhteydet (vaikkapa tähän tyyliin:
    https://security.ufl.edu/it-workers/risk-assessment/creating-an-information-systemdata-flow-diagram/)
-   Palvelintoteutuksen yleiskuvaus: teknologiat, deployment-ratkaisut yms.
-   Keskeisten rajapintojen kuvaukset, esimerkit REST-rajapinta. Tarvittaessa voidaan rajapinnan käyttöä täsmentää
    UML-sekvenssikaavioilla.
-   Toteutuksen yleisiä ratkaisuja, esim. turvallisuus.

Tämän lisäksi

-   ohjelmakoodin tulee olla kommentoitua
-   luokkien, metodien ja muuttujien tulee olla kuvaavasti nimettyjä ja noudattaa
    johdonmukaisia nimeämiskäytäntöjä
-   ohjelmiston pitää olla organisoitu komponentteihin niin, että turhalta toistolta
    vältytään

## Testaus

Sovellukseen suoritettiin muutama Robot Framework -testaus osana Ojhelmistokehityksen teknologioita -kurssin seminaarityön osuutta:

Testit kirjautumiselle, pääsivun näyttämiselle, hakusanalle ja kuvan näyttämiselle ovat kaikki koostettuna tässä ui.robot-testitiedostossa:
![image](https://github.com/user-attachments/assets/2588258b-dbe0-488e-9a81-571832da8e5a)

Testit onnistuivat:
![image](https://github.com/user-attachments/assets/1a381324-61c1-404b-9b8e-1720c5f4d5d4)

Robotin ottamat kuvakaappaukset:
![Blank 4 Panel Rectangles Comic Strip](https://github.com/user-attachments/assets/accc4c10-0a62-471b-9aec-af2ddabc7b5b)

## Asennustiedot

Järjestelmän kehitysympäristön asennus:
- Jos haluat käyttää sivustoa paikallisesti niin asenna Docker Desktop, MariaDB ja esimerkiksi VS Code koneellesi. Tarvitset käyttösi myös Githubin. Kloonaa projekti käskyllä "git clone https://github.com/HeliKyllinen/Selainpeli.git". Luo .env-tiedosto ja sinne tarvittavat ympäristömuuttujat.  

## Käynnistys- ja käyttöohje

### Paikallinen
Avaa Docker Desktop ja esimerkiksi VS Code. Käynnistä sovellus terminaalissa komennolla "docker compose up --build". Avaa linkki ja sovellus käynnistyy. Käyttäjänimi on user ja salasana password. Sulje sovellus terminaalissa komennolla "docker compose down -v".

### Rahti
Sovellus on julkaistu rahdin kautta: https://selainpeli-git-pelisivusto-2024.2.rahtiapp.fi. Käyttäjänimi on user ja salasana password.

### Codespace
Githubin codespacessa on helppo käyttää dockeria, koska mitään ei tarvitse ladata paikallisesti. Avaa codespace. Anna terminaalissa käsky "docker compose up --build". Porttien auettua muuta niiden näkyvyys yksityisestä julkiseksi. Avaa linkki ja sovellus käynnistyy. Käyttäjänimi on user ja salasana password. Sulje sovellus terminaalissa komennolla "docker compose down -v". 
