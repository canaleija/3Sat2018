/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    
    public static ArrayList<Integer[]> clausulas;
    private int[] genotipo;
    private int fitness;
    
    public Individuo(int dimGen) {
        this.genotipo = new int[dimGen];
        // todo: agregar un criterio de creación aleatoria
    }
    public Individuo(int[]genotipo){
        this.genotipo = genotipo.clone();
        calcularFitness();
    }
    public void calcularFitness(){
      this.fitness = 0;
      // recorrer las diferentes clausulas 
      for (Integer[] c: this.clausulas){
      boolean resultado  = verificarClausula(c);
      if(resultado)this.fitness++;
      }
    
    }

    private boolean verificarClausula(Integer[] c) {
        // recorrer la clausula 
        for (int x=0; x<c.length;x++){
        // obtener el valor de la clausula
        int valorC = c[x];
        int valorG = this.getGenotipo()[checarSigno(valorC)-1];
        if(valorC<0){
          if(valorG==0){
              valorG=1;
          }else{
          valorG=0;
          }
         }
        if(valorG==1){
        return true;
        }
        }
        return false;
    }

    private int checarSigno(int valorC) {
       if(valorC<0){
       
       valorC =valorC*-1;
       }
       return valorC;
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }
    
    
}
