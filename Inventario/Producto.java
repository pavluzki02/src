public class Producto {
    public String nombre;
    public String codigo;
    public double precio;
    public int stock;

    public void venderUnidades(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            stock = stock - cantidad;
            System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre + ". Stock restante: " + stock);
        } else if (cantidad <= 0) {
            System.out.println("Error: cantidad invalida para vender " + cantidad + " unidades de " + nombre + ".");
        } else {
            System.out.println("Error: stock insuficiente para vender " + cantidad + " unidades de " + nombre + ".");
        }
    }

    public void reponerStock(int cantidad) {
        if (cantidad > 0) {
            stock = stock + cantidad;
            System.out.println("Reposición registrada: +" + cantidad + " unidades. Stock actual: " + stock);
        } else {
            System.out.println("Error: la cantidad a reponer tiene que ser mayor a cero.");
        }
    }

    public void actualizarPrecio(double precio) {
        double precioViejo = this.precio;
        this.precio = precio;
        System.out.println("Precio actualizado de " + nombre + ": $" + precioViejo + " -> $" + this.precio);
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 100) {
            double precioViejo = precio;
            precio = precio - (precio * porcentaje / 100);
            System.out.println("Descuento de " + porcentaje + "% en " + nombre + ": $" + precioViejo + " -> $" + precio);
        } else {
            System.out.println("Error: el porcentaje tiene que estar entre 0 y 100.");
        }
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de producto ===");
        System.out.println("Código:  " + codigo);
        System.out.println("Nombre:  " + nombre);
        System.out.println("Precio:  $" + precio);
        System.out.println("Stock:   " + stock);
        System.out.println("==========================");
    }
}
