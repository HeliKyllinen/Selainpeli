*** Settings ***
Library    SeleniumLibrary  

*** Variables ***
${USERNAME}    user
${PASSWORD}    password
${URL}         http://localhost:8080
${QUERY}       koira

*** Test Cases ***
Kirjaudu ja siirry pääsivulle ja hae kuva
    Open Browser    ${URL}    chrome
    Maximize Browser Window
    Kirjaudu sisään
    Tarkista pääsivu
    Vaihda palapelin koko 6x6
    Kuvahaku
    Odota palojen sekoittuminen

*** Keywords ***
Kirjaudu sisään
    Wait Until Element Is Visible    name=username    10s
    Input Text    name=username    ${USERNAME}    
    Input Text    name=password    ${PASSWORD}   
    Click Button    class=btn-login

Tarkista pääsivu
    Wait Until Page Contains    PalanPaikka    timeout=20s
    SeleniumLibrary.Capture Page Screenshot    kirjautuminen_onnistui.png

Vaihda palapelin koko 6x6
    Select From List By Value    id=puzzleSize    6
    ${selected_value}=    Get Selected List Value    id=puzzleSize
    Should Be Equal As Numbers    ${selected_value}    6
    SeleniumLibrary.Capture Page Screenshot    palapelin_koko_muuttunut.png

Kuvahaku
    Input Text    id=searchQuery    ${QUERY}
    Click Button    class=custom-button
    Wait Until Element Is Visible    id=puzzleContainer
    SeleniumLibrary.Capture Page Screenshot    kuvan_haku_onnistui.png

Odota palojen sekoittuminen
    Sleep    5s
    SeleniumLibrary.Capture Page Screenshot    palapeli_sekoittunut.png

Close Browser


