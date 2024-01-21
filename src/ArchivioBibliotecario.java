import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ArchivioBibliotecario {
    private List<CatalogoElemento> catalogo;

    public ArchivioBibliotecario() {
        this.catalogo = new ArrayList<>();
    }

    public void aggiungiElemento(CatalogoElemento elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String isbn) {
        catalogo.removeIf(e -> e.getIsbn().equals(isbn));
    }

    public Optional<CatalogoElemento> ricercaPerISBN(String isbn) {
        return catalogo.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<CatalogoElemento> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<Libro> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(l -> l.getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public void salvaSuDisco(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(catalogo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaDaDisco(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            catalogo = (List<CatalogoElemento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
