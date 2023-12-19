# BuildingInfo

## Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

### Struktura danych
- Lokacja to budynek, poziom, lub pomieszczenie
- Budynek może składać się z poziomów a te z pomieszczeń
- Każda lokalizacja jest charakteryzowana przez:
    * id – unikalny identyfikator
    * name – opcjonalna nazwa lokalizacji
- Pomieszczenie dodatkowo jest charakteryzowane przez:
   * area = powierzchnia w m^2
   * cube = kubatura pomieszczenia w m^3
   * heating = poziom zużycia energii ogrzewania (float)
   * light – łączna moc oświetlenia

## Wersjonowanie
Przy kazdym mergu do maina tworzymy nowy tag i podnosimy wersję zarówno pomie jak i w tworzonym release

## Diagram UML
![UML-classes-diagram](https://github.com/AflaIO/BuildingInfo/assets/89967155/3c40e5ea-cc77-44b9-bac3-e2cacf5eaa96)


