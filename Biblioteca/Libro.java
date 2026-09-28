public final class Libro {
    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;
    private int prestamosHistoricos;

    // constructor principal, aca se valida todo
    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {
        if (titulo == null || titulo.trim().isEmpty()) {
            this.titulo = "Sin título";
            System.out.println("Título inválido, se usó \"Sin título\" por defecto.");
        } else {
            this.titulo = titulo;
        }

        if (autor == null || autor.trim().isEmpty()) {
            this.autor = "Autor desconocido";
            System.out.println("Autor inválido, se usó \"Autor desconocido\" por defecto.");
        } else {
            this.autor = autor;
        }

        if (isbn == null || isbn.trim().isEmpty()) {
            this.isbn = "ISBN pendiente";
            System.out.println("ISBN inválido, se usó \"ISBN pendiente\" por defecto.");
        } else {
            this.isbn = isbn;
        }

        if (copiasDisponibles < 0) {
            this.copiasDisponibles = 0;
            System.out.println("Copias inválidas (" + copiasDisponibles + "), se usó 0 por defecto.");
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        // pongo el precio por defecto y despues pruebo con el setter,
        // asi la regla de precio > 0 queda en un solo lugar
        this.precioReposicion = 15000.0;
        boolean precioOk = setPrecioReposicion(precioReposicion);
        if (!precioOk) {
            System.out.println("Precio inválido (" + precioReposicion + "), se usó $15000.0 por defecto.");
        }
    }

    // constructor para libro nuevo, 1 copia y precio por defecto
    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, 15000.0);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    public int getPrestamosHistoricos() {
        return prestamosHistoricos;
    }

    public boolean setPrecioReposicion(double precio) {
        if (precio > 0) {
            this.precioReposicion = precio;
            return true;
        } else {
            return false;
        }
    }

    public boolean prestar() {
        prestamosHistoricos++;
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            System.out.println("Préstamo registrado: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
            return true;
        } else {
            System.out.println("Error: no hay copias disponibles de \"" + titulo + "\" para prestar.");
            return false;
        }
    }

    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolución registrada: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de libro ===");
        System.out.println("Título:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposición: $" + precioReposicion);
        System.out.println("=======================");
    }
}
