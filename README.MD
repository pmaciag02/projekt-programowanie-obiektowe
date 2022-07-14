# Projekt na Programowanie Obiektowe

### autor: Patryk Maciąg
### rodzaj projektu: gra "kolorowe kulki"
### język: Java



## Zasady
* Gra rozgrywa się na planszy 9x9.
* Co turę na planszy pojawiają się 3 nowe kulki, o losowych kolorach i w losowych miejscach. Pod planszą, w sekcji "Następna tura", widnieją wylosowane kolory na następną turę.
* Na samym dole znajduje się sekcja "Dane", zawierająca sumę zdobytych punktów oraz przyciski zapisujące i wczytujące stan gry.
* Ruch polega na wybraniu kulki, a następnie docelowego miejsca, do którego przesunie się kulka. Może to być dowolne miejsce na planszy, pod warunkiem, że istnieje do niego "wolna" (bez kolorów po drodze) ścieżka, składająca się z ruchów pionowych i poziomych.
* Jeśli na planszy zostanie ustawione przynajmniej 5 kulek w cięgłej linii (pion, poziom, skos), to za każdą kulkę zostaje przyznany 1 punkt, a kolory znikają z planszy.
* Cel gry: jak największa liczba zdobytych punktów.
* Gra kończy się, przy braku możliwości kolejnej tury.
* Uruchomienie gry:
	java -jar gra.jar
    //lub z folderu bin
    java App
