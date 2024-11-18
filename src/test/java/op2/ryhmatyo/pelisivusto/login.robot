*** Settings ***
Library    SeleniumLibrary  # Varmistaa, että käytetään Seleniumia

*** Variables ***
${USERNAME}    user
${PASSWORD}    password
${URL}         http://localhost:8080

*** Test Cases ***
Kirjaudu Ja Siirry Pääsivulle
    [Documentation]    Tämä testi kirjaa käyttäjän sisään ja tarkistaa, että pääsivulle siirrytään
    Open Browser    ${URL}    chrome
    Maximize Browser Window
    Wait Until Element Is Visible    name=username    10s    # Odottaa, että käyttäjätunnus-kenttä tulee näkyviin
    Input Text    name=username    ${USERNAME}    # Syöttää käyttäjätunnuksen kenttään
    Input Text    name=password    ${PASSWORD}    # Syöttää salasanan kenttään
    Click Button    name=btn.btn-lg.btn-primary.btn-block   # Klikkaa kirjautumispainiketta
    Wait Until Page Contains    /home    10s    # Odottaa, että pääsivun URL sisältää '/home'
    Capture Screenshot    kirjautuminen_onnistui.png    # Ota kuvakaappaus kirjautumisen jälkeen
    Close Browser
