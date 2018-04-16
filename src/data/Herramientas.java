/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Herramientas {
    public static ArrayList<Integer[]> leeArchivo() throws FileNotFoundException, IOException
    {
        String aux,texto;
        int contador=0;
        
        LinkedList<String> lista= new LinkedList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        
        ArrayList<Integer[]> lista3 = new ArrayList<Integer[]>();
         
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        //abrimos el archivo seleccionado
        File abre = file.getSelectedFile();
        //recorremos el archivo y lo leemos
        if (abre != null) 
        {
            FileReader archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);

            while ((aux = lee.readLine()) != null) 
            {
                texto = aux;
                lista.add(texto);
            }
            lee.close();        
        }
        
        for (int i = 1; i < lista.size(); i++) 
        {
            StringTokenizer st = new StringTokenizer(lista.get(i), " ");
            while (st.hasMoreTokens()) 
            {
                int num= Integer.parseInt(st.nextToken());
               lista2.add(num);
            }
        }
       
        
        for(int k=0; k<lista.size()-2;k++)
        {
             Integer[] arreglo= new Integer[3];
            for(int y=0; y<arreglo.length;y++)
            {
             arreglo[y]=lista2.get(contador);
             contador++;
            }
            lista3.add(arreglo);
        }
        System.out.println();
       
        return lista3; 
    }
}
