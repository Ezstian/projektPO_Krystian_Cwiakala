# Projekt: Elektroniczny system oceniania Zarządzanie wstawianiem i wyświetlaniem ocen cząstkowych z różnych przedmiotów  

## Autor: Krystian Ćwiąkała


## Opis programu

Projekt konsolowy w języku **Java**, umożliwiający nauczycielowi wstawianie ocen, generowanie statystyk, a uczniowi przegląd ocen.

## Uruchomienie projektu

1. Skompiluj projekt (np. w IntelliJ lub przez terminal).
2. Uruchom klasę `Main`.
3. Zaloguj się jako `Nauczyciel` (login: admin haslo: admin123) lub `Uczeń` (np. login: Kamil haslo: haslo) (dane w `loginy.txt`).
4. Wybierz opcję z menu.

## Funkcjonalności

  Logowanie użytkownika
- Rola **Nauczyciel**: może dodawać oceny i generować statystyki.
- Rola **Uczeń**: może przeglądać tylko swoje oceny.

  Oceny
- Możliwość przypisywania ocen cząstkowych do konkretnego przedmiotu.
- Oceny są zapisywane w pliku `oceny.txt`.

  Statystyki
- Obliczanie średnich ocen uczniów.

 Pliki danych
- `loginy.txt`: dane logowania (`login;haslo;rola;id`)
- `oceny.txt`: oceny (`uczenId;przedmiot;ocena`)
- `uczniowie.txt`: dane uczniów (`id;imie;nazwisko`)


## Struktura
- Main
- Menu
- Nauczyciel
- OperacjeNaPlikach
- Statystyki
- Uzytkownik
- Uczen


## Wymagania
- Java 8 lub wyższa  
- Konsola do obsługi interaktywnego menu
