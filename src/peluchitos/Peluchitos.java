
package peluchitos;

import java.util.Scanner;

public class Peluchitos {

    static Scanner teclado = new Scanner(System.in);
     static productos producto[]=new productos[20];
     static int indice=0;
     static int posicion;
     static boolean confir=false;
    
    public static void main(String[] args)
    {
       boolean ciclo=true;
       int menu,cantidad;
       int acumulador_producto=0,acumulador_total=0;
       
       while(ciclo)
       {
            System.out.println("\nBIENVENIDO A PELUCHITOS SUCURSAL DE VENTAS.\n");
            System.out.println("1. Agregar producto.");
            System.out.println("2. Buscar producto.");
            System.out.println("3. Eliminar producto.");
            System.out.println("4. Mostrar inventario.");
            System.out.println("5. Realizar venta.");
            System.out.println("6. Mostrar Ganancias totales.");
            System.out.println("7. Salir.\n");
            
            System.out.print("Digite la opcion que desea ejecutar: ");
            menu=teclado.nextInt();
            teclado.nextLine();
            
             switch(menu)
            {
                case 1:
                   producto[indice]=new productos();
                   producto[indice].Loading_Data();
                   indice++;
                   break;
                   
                   case 2:
                     confir=busqueda();
                     if(confir==false)
                     {
                         System.out.println("El producto buscado no existe, intente nuevamente.\n");
                     }
                     else
                     {
                        producto[posicion].Data_Show();
                     }
                    break;
                    
                    case 3:
                     confir=busqueda();
                     if(confir==false)
                     {
                         System.out.println("El producto buscado no existe, intente nuevamente.\n");
                     }
                     else
                     {
                         indice--;
                         for(int i=posicion;i<indice;i++)
                         {
                             producto[i].setNombre(producto[i+1].getNombre());
                             producto[i].setCantidad(producto[i+1].getCantidad());
                             producto[i].setValor(producto[i+1].getValor());
                             producto[i].setVentas(producto[i+1].getVentas());
                         }
                         System.out.println("prudcto eliminado.\n");
                         
                         //Para eliminar la ultima posicion
                         producto[indice].setNombre("");
                         producto[indice].setCantidad(0);
                         producto[indice].setValor(0);
                         producto[indice].setVentas(0);
                     }
                    break;
                    
                    case 4:
                        System.out.println("\nINVENTARIO.");
                        for(int i=0;i<indice;i++)
                        {
                            producto[i].Data_Show();
                        }
                        break;
                        
                    case 5:
                     confir=busqueda();
                     if(confir==false)
                     {
                         System.out.println("El producto buscado no existe, intente nuevamente.\n");
                     }
                     else
                     {
                         System.out.print("\n¿Que cantidad desea vender?: ");
                         cantidad = teclado.nextInt();
                         teclado.nextLine();
                         if(cantidad>producto[posicion].getCantidad())
                         {
                             System.out.println("\nDesea vender mas unidades de las que tiene.\nTiene "+producto[posicion].getCantidad()+" unidades unicamente.\n");
                         }
                         else
                         {
                            System.out.println("\nVendio "+cantidad+" exitosamente.\n");
                            producto[posicion].setVentas(cantidad);
                            cantidad=producto[posicion].getCantidad()-cantidad;
                            producto[posicion].setCantidad(cantidad);
                         }
                     }
                     break;
                     
                    case 6:
                        System.out.println("VENTAS REALIZADAS.\n");
                        System.out.println("Nombre      Vendidos        Total\n");
                        for(int i=0;i<indice;i++)
                        {
                            acumulador_producto=producto[i].getVentas()*producto[i].getValor();
                            System.out.println(producto[i].getNombre()+"              "+producto[i].getVentas()+"            "+acumulador_producto);
                            acumulador_total=acumulador_total+acumulador_producto; 
                        }
                        System.out.println("\nLas ganancias totales son: "+acumulador_total+"\n");
                        acumulador_total=0;
                        break;
                        
                    case 7:
                        System.out.println("\nFlue Un Placer Servirle, lo esperamos nuevamente.\n");
                        ciclo=false;
                    break;
                    default:
                        System.out.println("\nNo ingreso una opcion valida, digite nuevamente.\n");
                    break;
             }
            
       }
    }
    
     static boolean busqueda()
      {
          System.out.print("\nIngrese el nombre del producto: ");
          String name = teclado.nextLine();
          System.out.println("");
          for(int i=0;i<indice;i++)
          {
            if(name.equals(producto[i].getNombre()))
            {
                System.out.println("producto encontrado en la posicion: "+i+"\n");
                posicion=i;
                return true;
            }
          }
          return false;
      }
    
}
