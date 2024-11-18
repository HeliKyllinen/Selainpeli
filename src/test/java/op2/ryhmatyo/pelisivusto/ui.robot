*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${URL}    http://localhost:8080
${QUERY}  koira 

*** Test Cases ***
Kuvahaku toimii
    Avaa sivusto
    Anna hakusana ja klikkaa hae
    Odota, että kuva näkyy
    Tarkista, että kuva on näytöllä

*** Keywords ***
Avaa sivusto
    Open Browser    ${URL}    Chrome
    Maximize Browser Window

Anna hakusana ja klikkaa hae
    Input Text    id=searchQuery    ${QUERY}
    Click Button    class=btn btn-success

Odota, että kuva näkyy
    Wait Until Element Is Visible    id=puzzleContainer

Tarkista, että kuva on näytöllä
    Element Should Contain    id=puzzleContainer    ${QUERY}
    Wait Until Element Contains    id=puzzleContainer    "https://pixabay.com/api/"
