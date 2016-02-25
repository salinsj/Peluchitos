
package peluchitos;

import java.util.Scanner;

public class productos 
{
    private String nombre;
    private int cantidad;
    private int valor;
    private int ventas;
    
    Scanner teclado = new Scanner(System.in);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
    
    public void Loading_Data()
    {
        System.out.print("\n");
        System.out.print("ingrese nombre del producto: ");
        nombre=teclado.nextLine();
        System.out.print("\n");
        System.out.print("ingrese la cantiad del producto: ");
        cantidad=teclado.nextInt();
        teclado.nextLine();
        System.out.print("\n");
        System.out.print("ingrese el valor del producto: ");
        valor=teclado.nextInt();
        teclado.nextLine();
        System.out.print("\n");
        ventas=0;
     }
    
    public void Data_Show()
    {
        System.out.println("");
        System.out.println("El nombre es: "+nombre);
        System.out.println("Su cantidad es: "+cantidad);
        System.out.println("Su valor es: "+valor);
    }
}
