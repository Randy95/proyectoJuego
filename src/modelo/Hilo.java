/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.FRM_VentanaJuego;


public class Hilo extends Thread
{
    FRM_VentanaJuego ventana;
    public int i=0;
    
    public Hilo(FRM_VentanaJuego ventana)
    {
      this.ventana=ventana;   
    }
    public void run()
    {
      while(true)
      {
        try
        {
          if(!ventana.gameOver)
          {
            sleep(100);
            ventana.tiempo();
            ventana.moverFondo();
            ventana.comprobarColision();
            if(!ventana.kill)
               ventana.moverObstaculo();
            else
            {
              ventana.detenerEnemigo();
               i++;
               if(i>10)
               {
                 i=0;
                 ventana.kill=false;
                 ventana.jl_enemigo1.setVisible(false);
               }
            }
            if(ventana.esDisparo)
            {
              ventana.disparoMisil();
              ventana.eliminarEnemigo();
            }
          }
          else
          {
            this.stop();
          }
          
        }
        catch(Exception e)
        {
          System.out.println("Hubo un error en el hilo de ejecución: "+e);
        }
      }
    }
}
