public class MainInventarioExtension {
    public static void main(String[] args) {
        Producto productoUno = new Producto();
        productoUno.codigo = "P-001";
        productoUno.nombre = "Teclado mecánico";
        productoUno.precio = 45000.0;
        productoUno.stock = 12;

        Producto productoDos = new Producto();
        productoDos.codigo = "P-002";
        productoDos.nombre = "Libro de como ser millonario";
        productoDos.precio = 134000.0;
        productoDos.stock = 30;

        Producto productoTres = new Producto();
        productoTres.codigo = "P-003";
        productoTres.nombre = "Labubu";
        productoTres.precio = 5000.0;
        productoTres.stock = 5;

        // aplicarDescuento
        System.out.println("--- Descuentos ---");
        productoTres.aplicarDescuento(10);
        productoDos.aplicarDescuento(150);
        productoUno.aplicarDescuento(-1);
        System.out.println();

        System.out.println("--- Inventario completo ---");
        Producto[] productos = new Producto[3];
        productos[0] = productoUno;
        productos[1] = productoDos;
        productos[2] = productoTres;

        for (int i = 0; i < productos.length; i++) {
            productos[i].mostrarFicha();
        }
    }
}
