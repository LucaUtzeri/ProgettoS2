public class Main {
    public static void main(String[] args) {
        ArchivioBibliotecario archivio = new ArchivioBibliotecario();

        Libro libro1 = new Libro("123456", "Il Signore degli Anelli", 1954, 1000, "J.R.R. Tolkien", "Fantasy");
        Libro libro2 = new Libro("789012", "1984", 1949, 300, "George Orwell", "Distopia");

        Rivista rivista1 = new Rivista("345678", "National Geographic", 2022, 50, Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("901234", "Time", 2022, 60, Periodicita.SETTIMANALE);

        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);
        archivio.aggiungiElemento(rivista1);
        archivio.aggiungiElemento(rivista2);

        archivio.ricercaPerAutore("J.R.R. Tolkien").forEach(System.out::println);

        archivio.rimuoviElemento("789012");

        archivio.ricercaPerAnnoPubblicazione(2022).forEach(System.out::println);

        archivio.salvaSuDisco("archivio.dat");

        ArchivioBibliotecario archivioCaricato = new ArchivioBibliotecario();
        archivioCaricato.caricaDaDisco("archivio.dat");
        archivioCaricato.catalogo.forEach(System.out::println);
    }
}
