/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
 
import java.util.ArrayList;

/**
 *
 * @author RandyGUTI
 */
public class MetodosPuntaje {
    
    private ArrayList <Puntaje> arrayList;
    ArchivoPuntaje archivos;
    public MetodosPuntaje()
    {
      archivos=new ArchivoPuntaje();
      arrayList = new ArrayList <Puntaje>();
      arrayList=archivos.leerInformacionCompleta();
    }
    public void agregarPuntaje(String nombre,int puntaje)
    {
        Puntaje temporal=new Puntaje(nombre, puntaje);
        arrayList.add(temporal);   
    }
    public int puntajeGuardar(String nombre)
    {
      int puntaje=0;
      for(int contador=0;contador<arrayList.size();contador++)
        {
            if(arrayList.get(contador).getNombre().equals(nombre))
            {
              puntaje=arrayList.get(contador).getPuntaje();
            }
        }
      return puntaje;
    }
    public void modificarPuntaje(String nombre, int puntaje)
    {
        for(int contador=0;contador<arrayList.size();contador++)
        {
            if(arrayList.get(contador).getNombre().equals(nombre))
            {
                arrayList.get(contador).setPuntaje(puntaje);
            }
        }
    }
    public boolean consultarPuntaje(String nombre)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayList.size();contador++)
        {
            if(arrayList.get(contador).getNombre().equals(nombre))
            {
                existe=true;
            }
        
        }
        return existe;
    }
    public void escribirEnArchivo()
    {
      archivos.crearArchivo();
      
      for(int contador=0;contador<arrayList.size();contador++)
      {
        archivos.escribirInformacionEnElArchivo(arrayList.get(contador));
      }
    }
    public ArrayList<Puntaje> getArreglo()
    {
      return arrayList;
    }
}
