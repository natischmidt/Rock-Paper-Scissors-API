Reflektion Rock Paper Scissor API 

I detta projekt har jag lärt mig att skapande av en API innebär många olika steg, såsom Säkerhet, Databas, Begränsningar,
Validering, Felhantering och Dokumentation.

Säkerhet är ytterst viktig och enligt mig det första man bör tänka på när man skapar ett API
Att använda JSON-webbtoken (JWT) och säkerhet i en REST API är en bra idé av flera skäl: JWT-token är fristående 
och kräver ingen session på serversidan för att lagra tillstånd. Detta innebär att servern inte behöver hålla reda 
på klientsessioner, vilket gör den mer skalbar och minskar sannolikheten för minnesläckor. JWT-tokens signeras, 
vilket innebär att servern kan lita på att informationen i token inte har manipulerats. Detta gör att servern kan 
lita på klienten och fatta beslut baserat på informationen i token, till exempel användarens roll eller behörigheter. 
JWT-tokens kan utfärdas av en separat autentiseringsserver och användas av flera tjänster. Detta frikopplar 
autentisering och auktorisering från de resurser som skyddas och gör det enkelt att lägga till eller ta bort tjänster
utan att påverka autentiseringsmekanismen. Utöver det är de lätt att implementera, det är bara en enkel sträng som 
möjliggör enkel integration med befintliga system. JWT-token skickas i HTTP-header, vilket innebär att de kan användas
för att autentisera begärande över olika domäner.

Säkerheten i mitt API börjar med att en användare måste registrera sig. Efter registrering sparas denna användare
i databasen, och i nästa steg autentiseras användaren endast ifall han eller hon fanns i databasen. Lyckas både 
registreringen och autentiseringen kan användaren får ett playerid (uuid) och börja spela. Det enda undantaget 
i säkerheten är registrering och autensieringssidorna, vilket innebär att alla andra sidor kan bara nås vid inmatning 
av ett giltig JWT-token. Det jag insåg när jag började med andra delen av uppgiften är det är missvisande att UUID 
kallas för token i uppgiften. Ett uuid och ett token skiljer sig och kan inte ersättas av varandra det vill säga att ett 
JWT-token inte kan ersätta ett playerId. Ett player-eller gameId är fast/konstant och skapas när en ny spelare registreras.
Ett JWT däremot genereras och returneras när en ny spelare registrerar, eller när en befintlig spelare loggar in i 
webbapplikation. 
Rate Limiting 
Att sätta "stopp" på API så att användare inte kan göra för många förfrågningar på kort tid och överväldiga
servern är otroligt viktig som skydd för DDos-attacker. Det är tyvärr inget jag har implementerat i mitt projekt. 
Det är ett mål för senare. 
