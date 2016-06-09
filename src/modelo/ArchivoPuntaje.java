/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author RandyGUTI
 */
public class ArchivoPuntaje {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public ArchivoPuntaje() 
    {
        
    }
    public void crearArchivo()
    {
      try
      {
       archivoSalida = new ObjectOutputStream(new FileOutputStream("puntajes.dat"));
       System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivo(Puntaje puntaje)
    {
      try
      {
        archivoSalida.writeObject(puntaje);
          System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
        System.out.println("Error al escribir en el archivo: "+e);
      }
    }
//    public String leerInformacion()
//    {
//      Estudiante estudiante=null;
//      try
//      {
//        archivoEntrada=new ObjectInputStream(new FileInputStream("estudiantes.dat"));
//        estudiante=(Estudiante)archivoEntrada.readObject();
//      }
//      catch(Exception e)
//      {
//        System.out.println("Error al leer informacion del archivo: "+e);
//      }
//      return estudiante.getInformacion();
//    }
    public ArrayList<Puntaje> leerInformacionCompleta()
    {
      ArrayList<Puntaje> array = new ArrayList <Puntaje>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("puntajes.dat"));
        while(true)
        {
          array.add((Puntaje)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return array;
    }
    
    
}
