import java.util.ArrayList;
import java.util.Scanner;
// se crea una clase llamada producto
class Producto {
    public final String nombre;
    public int cantidad;

    Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
// get es una convencion usada para acceder a variables privadas de una clase
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

public class GestionInventariosProductos {
    public static final ArrayList<Producto> inventario = new ArrayList<>();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
// se condicionan los metodos a usar el el ejercicio
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    actualizarCantidadProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    System.out.println("Salir del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }
// en esta parte queremos mostrar el menu del proyecto gestion de inventario de productos 
    public static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por nombre");
        System.out.println("3. Actualizar cantidad de producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Mostrar inventario");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion:");
    }
// metodosolo visible dentro de la clase, en este caso para agregar productos e imprimimos para ingresar el nombre del producto
    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        //la clase scanner permite obetner entrada de datos primitivos
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad inicial: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        inventario.add(new Producto(nombre, cantidad));
        System.out.println("Producto agregado al inventario.");
        mostrarInventario();
        
    }
    // metodo para actualizar la cantidad de productos 
    private static void actualizarCantidadProducto() {
        mostrarInventario();
        // imprimimos para pedir al usuario ingresar el dato requerido
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombre = scanner.nextLine();
        

        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            System.out.print("Ingrese la nueva cantidad: ");
            int nuevaCantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            producto.setCantidad(nuevaCantidad);
            System.out.println("Cantidad actualizada correctamente.");
            mostrarInventario();
        } else {
            System.out.println("El producto no existe en el inventario.");
        }
    }
// metodo para elimininar productos del inventario
    private static void eliminarProducto() {
        mostrarInventario();
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            inventario.remove(producto);
            System.out.println("Producto eliminado del inventario.");
            mostrarInventario();
        } else {
            System.out.println("El producto no existe en el inventario.");
        }
    }
//metodo para mostrar un productod e inventario
    private static void mostrarInventario() {
        System.out.println("Inventario:");
        for (Producto producto : inventario) {
            System.out.println(producto.getNombre() + ": " + producto.getCantidad());
        }
    }
//metodo para buscar productos por su nombre
    public static Producto buscarProducto(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}