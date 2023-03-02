# Meal App (Herexamen Android Development 2022-2023)
## Assignment
Je maakt een app waarbij je recepten kan opzoeken. We maken hierbij gebruik van de API:

"https://www.themealdb.com/api/json/v1/1/search.php?f=\(startingLetter)"

We beginnen met een loginscherm. 
Aangezien we geen DB gebruiken moet je bij de start een array van gebruikers aanmaken die je dan kan gebruiken om te controleren of je correct bant ingelogd. 

In de Array voorzie je alvast volgende gebruikers:
Username: admin
Password: admin

De array kan je in een Singelton bewaren en zo overal ter beschikking hebben.
Je toont een foutmelding indien ik een veld leeg laat of wanneer username/paswoord niet correct is.


Na het inloggen kom je op het volgende scherm en kan je de eerste letter ingeven van het recept en roep je de API aan. 
Het resultaat toon je in een recyclerview op hetzelfde scherm. 
Maak gebruik van databinding, ook in je adapter klasse wanneer je op een recept klikt, krijg je de details in een ander scherm. 
Met de back knop keer je terug naar het vorig scherm

