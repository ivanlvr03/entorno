
package eclipse;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportarFichero {
  public class Alimento {
    private String nombre;
    private double precio;
    
    public Alimento(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
     public Alimento() {
        this.nombre = "";
        this.precio = 0.0;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public String toString(){
        return nombre + "," + precio;
    }
  }
  public class ListaCompra {
    private Alimento[] listaAlimentos;
    private int numeroAlimentos;
    private double precioTotal;
    
    public ListaCompra(){
        this.listaAlimentos = new Alimento[10];
        this.numeroAlimentos = 0;
        this.precioTotal = 0.0;
    }
    public Alimento[] getListaAlimentos(){
        return listaAlimentos;
    }
    public void setListaAlimentos(Alimento[] listaAlimento){
        this.listaAlimentos = listaAlimento;
    }
    public int getNumeroAlimentos(){
        return numeroAlimentos;
    }
    public void setNumeroAlimentos(int numeroAlimentos){
        this.numeroAlimentos = numeroAlimentos;
    }
    public double getPrecioTotal(){
        return precioTotal;
    }
    public void setPrecioTotal(double precioTotal){
        this.precioTotal = precioTotal;
    }
    public void agregarAlimento(Alimento alimento){
        if(numeroAlimentos < listaAlimentos.length){
        listaAlimentos[numeroAlimentos] = alimento;
        precioTotal += alimento.getPrecio();
        numeroAlimentos++;
        }else{
        System.out.print("La lista esta llena");
        }
    }
    public void exportar(){
        File fichero = null;
        FileWriter writer = null;
        PrintWriter pw = null;
        try {
            fichero = new File("lista.txt");
            writer = new FileWriter(fichero);
            pw = new PrintWriter(writer);
            for(int i = 0; i < numeroAlimentos; i++){
                pw.println(listaAlimentos[i].toString());
            }
            System.out.println("Lista exportada a lista.txt");
        } catch(IOException e){
            System.out.println("Error al exportar lista " + e.getMessage());
        } finally {
            if (pw != null){
            pw.close();
            }
            if (writer != null){
                try{
                    writer.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        
          
    }
    public void imprimirLista(){
        if(numeroAlimentos == 0){
            System.out.println("Lista vacia");
        }else{
            System.out.println("Lista");
            for(int i = 0; i < numeroAlimentos; i++){
                System.out.println(listaAlimentos[i].toString());
            }
        }
    }
  }
}
    