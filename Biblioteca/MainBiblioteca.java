public class MainBiblioteca {


    record LibroInfo(String titulo, String autor, String isbn) {
    }

    public static void main(String[] args) {
   
        // titulo vacio, tiene que usar el valor por defecto
        Libro libroMalo = new Libro("", "Autor de prueba", "9780000000000", 1, 10000.0);
        if (!libroMalo.getTitulo().equals("Sin título")) {
            System.out.println("Error: no se reemplazó el título");
        }

        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo", "9781234567897", 3, 22000.0);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "9780307474728", 2, 18500.0);

        // precio negativo en el setter
        boolean aceptado = libro1.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + aceptado + " (se mantiene el precio anterior)");
        System.out.println();

        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();

        // libro1 tiene 1 copia, la agoto y pido una de mas
        boolean primero = libro1.prestar();
        boolean segundo = libro1.prestar();
        if (primero == false || segundo == true || libro1.getCopiasDisponibles() < 0) {
            System.out.println("Error: los préstamos no dieron lo esperado");
        }

        libro1.devolver();

        double precioViejo = libro1.getPrecioReposicion();
        boolean cambio = libro1.setPrecioReposicion(18000.0);
        if (cambio) {
            System.out.println("Precio de reposición actualizado de \"" + libro1.getTitulo() + "\": $" + precioViejo + " -> $" + libro1.getPrecioReposicion());
        }

        // los desafios
        System.out.println();
        System.out.println("--- Extensión ---");

        // cuenta los prestar() aunque hayan sido rechazados
        System.out.println("Préstamos históricos de \"" + libro1.getTitulo() + "\": " + libro1.getPrestamosHistoricos());


        LibroInfo info = new LibroInfo("Clean Code", "Robert C. Martin", "9780132350884");
        LibroInfo info2 = new LibroInfo("Clean Code", "Robert C. Martin", "9780132350884");
        System.out.println(info);
        System.out.println("Título: " + info.titulo());
        System.out.println("¿Son iguales info e info2? " + info.equals(info2));
    }
}
