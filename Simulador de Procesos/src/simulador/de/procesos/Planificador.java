/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author fvg
 */
public class Planificador {
    private int algorit;
    boolean iniciaEjecucion;
    int quantum;
    int iRR;            // Numero de proceso en ejecucion
    int iRR2;// Numero de proceso en ejecucion
    int ResiduoRafaga2; //Carga el valor del quantum aun no consumido
    int ResiduoRafaga;  //Carga el valor del quantum aun no consumido
    int idMax;
    boolean Juanlucas = false;
    Proceso JuanGuidoLucas; 
    ArrayList<String> gant1=new ArrayList <>();
    ArrayList<String> gant2=new ArrayList <>();
    ArrayList<Integer> ganttiempo = new ArrayList<Integer>();
    public Planificador() {
        this.iRR = 0;
    }

    public int getIdMax() {
        return idMax;
    }

    public void setIdMax(int idMax) {
        this.idMax = idMax;
    }

    public ArrayList<String> getGant1() {
        return gant1;
    }

    public ArrayList<String> getGant2() {
        return gant2;
    }

    public ArrayList<Integer> getGanttiempo() {
        return ganttiempo;
    }

    
    
    public boolean isJuanlucas() {
        return Juanlucas;
    }

    public void setJuanlucas(boolean Juanlucas) {
        this.Juanlucas = Juanlucas;
    }

    
    
    public void setQuantum(int quantum) {
        ResiduoRafaga = quantum;
         ResiduoRafaga2 = quantum;
        this.quantum = quantum;
    }

    public int getQuantum() {
        return quantum;
    }
    
    public int getResiduo(){
        return ResiduoRafaga;
    }
    
    public int getResiduoES(){
        return ResiduoRafaga2;
    }

    public int getAlgorit() {
        return algorit;
    }

    public void setInicio(){
        iniciaEjecucion = true;
    }
    
    public void setAlgorit(int algorit) {
        this.algorit = algorit;
    }
    
    public ArrayList <Proceso> procesoTerminado(ArrayList <Proceso> colaListos){
       
        //Busca el proceso de duración 0
        
        Iterator<Proceso> ite = colaListos.iterator();
        if (!colaListos.isEmpty()){
            int i = 0;
            Proceso p;
            while (ite.hasNext()) {
                p = ite.next();
                if (p.getDuracion()==0){
                    colaListos.remove(i);
                }
                i++;
            }
        }
        return colaListos;
    }
    
    //Dentro de este método se definirán los algoritmos de planificación
    public ArrayList <Proceso> elegirSiguiente (ArrayList<Proceso> colaListos, ArrayList <Proceso> colaES, int tiempo){
    
        ArrayList <Proceso> nuevaColaListos;
        nuevaColaListos = colaListos;
        Proceso proaux;
        if (!colaListos.isEmpty() || !colaES.isEmpty() ){
            switch(algorit){
                case(1):    //Round Robin
                    ganttiempo.add(tiempo);
                    if (!nuevaColaListos.isEmpty()) {
                        
                        
                        //Ahora, guardo el inicio de ejecución si es el primer proceso
                    
                        if (iniciaEjecucion && nuevaColaListos.get(iRR).isSjf()){ 
                            nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                            iniciaEjecucion = false;
                            nuevaColaListos.get(iRR).setSjf(false);
                        }
                        else{
                            if (nuevaColaListos.get(iRR).isSjf()){
                                nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                                nuevaColaListos.get(iRR).setSjf(false);
                            }
                        }
                        
                        if (nuevaColaListos.get(iRR).getCicloCPU()> 0){
                        
                            nuevaColaListos.get(iRR).setCicloCPU(nuevaColaListos.get(iRR).getCicloCPU()-1);
                           
                            gant1.add(nuevaColaListos.get(iRR).getDescripcion());//----------------------------------------------------------------
                            JuanGuidoLucas = nuevaColaListos.get(iRR);
                            if (nuevaColaListos.get(iRR).getCicloCPU()==0 ) {
                                
                                colaES.add(nuevaColaListos.get(iRR));
                                ResiduoRafaga = quantum;
                                nuevaColaListos.get(iRR).setES(true);
                                
                                nuevaColaListos.remove(iRR);
                                
                                if (nuevaColaListos.size()<= iRR){
                                    iRR = 0;
                                }
                            }
                            else{
                                if (ResiduoRafaga > 1){
                                    ResiduoRafaga--;
                                }else {
                                    //Si el contador es mayor al tamaño de la lista lo pongo a cero para que reinicie
                                    iRR++;
                                    if (nuevaColaListos.size()== iRR){
                                        iRR = 0;
                                    }
                                    ResiduoRafaga = quantum;
                                }
                            }
                        }
                        else{           
                            if (nuevaColaListos.get(iRR).getCicloCPU2()> 0){
                                nuevaColaListos.get(iRR).setCicloCPU2(nuevaColaListos.get(iRR).getCicloCPU2()-1);
                                gant1.add(nuevaColaListos.get(iRR).getDescripcion());
                                JuanGuidoLucas = nuevaColaListos.get(iRR);
                                if (nuevaColaListos.get(iRR).getCicloCPU2()==0) {
                                    
                                    //Se guarda el tiempo de fin
                                    nuevaColaListos.get(iRR2).setFinEjecución(tiempo);
                                    nuevaColaListos.remove(iRR);
                                    iniciaEjecucion = true;
                                    //Puede que no se haya consumido todo el quantum
                                    //Pero como el proceso termina se lo reinicia
                                    ResiduoRafaga = quantum;
                                    if (nuevaColaListos.size()== iRR){
                                        iRR = 0;
                                    }
                                }
                                else{        
                                    if (ResiduoRafaga > 1){
                                        ResiduoRafaga--;
                                    }
                                    else {
                                    //Si el contador es mayor al tamaño de la lista lo pongo a cero para que reinicie
                                        iRR++;
                                        if (nuevaColaListos.size()== iRR){
                                            iRR = 0;
                                        }
                                        ResiduoRafaga = quantum;
                                    }

                                }
                            }
                            else{
                                gant1.add("#");
                            }
                            
                            
                        }
                    }
                    else{
                        gant1.add("#");
                        JuanGuidoLucas = new Proceso();
                    
                }
                    //ESTO NO SE SI CIERRA ACA, salu2
                    //ENTRADA SALIDA
                    
                    if (!colaES.isEmpty()) {
                        if (colaES.get(iRR2).getCicloES()> 0 && JuanGuidoLucas != colaES.get(iRR2)){ 
                            
                            colaES.get(iRR2).setCicloES(colaES.get(iRR2).getCicloES()-1);//restamos la entrada/salida
                            gant2.add(colaES.get(iRR2).getDescripcion());
                            if(colaES.get(iRR2).getCicloES() == 0){ //si mi ciclo de entrada/salida ya TERMINO, lo mando a cola de LISTO                               
                                colaES.get(iRR2).setES(false);//---------------------------------------------------------------------------------7777777777777777777777777777
                                colaES.get(iRR2).setIdProceso(idMax + 1);
                                idMax = idMax +1;
                                nuevaColaListos.add(colaES.get(iRR2));
                                Juanlucas = true;
                                colaES.remove(iRR2);
                                
                                
                                if (colaES.size()== iRR2){
                                   iRR2 = 0;
                                }
                            }
                            
                            
                        }
                        else{
                        gant2.add("#");}
                    }
                     else{
                        gant2.add("#");}
                    System.out.println(ganttiempo);
                    System.out.println(gant1);
                    System.out.println(gant2);
           //Pero si no los tiene, nos fijamos si hay ciclos de ES y los consumimos
            
                    
                    break;
                case(2):    //SRTF
                    break;
                    
                    
                case (3):   //SJF
                    //Busca el proceso con menor duración
                    
                    ganttiempo.add(tiempo);
                    if (!nuevaColaListos.isEmpty()) {
                        
                        Iterator<Proceso> it = colaListos.iterator();
                        iRR = 0;
                        int resguardo = 0;
                        Proceso p1;
                        while (it.hasNext()) {
                            p1 = it.next();
                            if (p1.getDuracion()< nuevaColaListos.get(resguardo).getDuracion()){
                                resguardo = iRR;
                            }
                            iRR++;
                        }
                        iRR = resguardo;
                        
                        //Ahora, guardo el inicio de ejecución si es el primer proceso
                    
                        if (iniciaEjecucion && nuevaColaListos.get(iRR).isSjf()){ 
                            nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                            iniciaEjecucion = false;
                            nuevaColaListos.get(iRR).setSjf(false);
                        }
                        else{
                            if (nuevaColaListos.get(iRR).isSjf()){
                                nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                                nuevaColaListos.get(iRR).setSjf(false);
                            }
                        }
                        
                        if (nuevaColaListos.get(iRR).getCicloCPU()> 0){
                        
                            nuevaColaListos.get(iRR).setCicloCPU(nuevaColaListos.get(iRR).getCicloCPU()-1);
                           
                            gant1.add(nuevaColaListos.get(iRR).getDescripcion());//----------------------------------------------------------------
                            JuanGuidoLucas = nuevaColaListos.get(iRR);
                            if (nuevaColaListos.get(iRR).getCicloCPU()==0 ) {
                                
                                colaES.add(nuevaColaListos.get(iRR));
                                ResiduoRafaga = quantum;
                                nuevaColaListos.get(iRR).setES(true);
                                
                                nuevaColaListos.remove(iRR);
                            }
                            
                        }
                        else{           
                            if (nuevaColaListos.get(iRR).getCicloCPU2()> 0){
                                nuevaColaListos.get(iRR).setCicloCPU2(nuevaColaListos.get(iRR).getCicloCPU2()-1);
                                gant1.add(nuevaColaListos.get(iRR).getDescripcion());
                                JuanGuidoLucas = nuevaColaListos.get(iRR);
                                if (nuevaColaListos.get(iRR).getCicloCPU2()==0) {
                                    
                                    //Se guarda el tiempo de fin
                                    nuevaColaListos.get(iRR2).setFinEjecución(tiempo);
                                    nuevaColaListos.remove(iRR);
                                    iniciaEjecucion = true;
                                }
                                
                            }
                            else{
                                gant1.add("#");
                            }
                            
                            
                        }
                    }
                    else{
                        gant1.add("#");
                        JuanGuidoLucas = new Proceso();
                    
                }
                    //ESTO NO SE SI CIERRA ACA, salu2
                    //ENTRADA SALIDA
                    
                    if (!colaES.isEmpty()) {
                        if (colaES.get(iRR2).getCicloES()> 0 && JuanGuidoLucas != colaES.get(iRR2)){ 
                            
                            colaES.get(iRR2).setCicloES(colaES.get(iRR2).getCicloES()-1);//restamos la entrada/salida
                            gant2.add(colaES.get(iRR2).getDescripcion());
                            if(colaES.get(iRR2).getCicloES() == 0){ //si mi ciclo de entrada/salida ya TERMINO, lo mando a cola de LISTO                               
                                colaES.get(iRR2).setES(false);//---------------------------------------------------------------------------------7777777777777777777777777777
                                colaES.get(iRR2).setIdProceso(idMax + 1);
                                idMax = idMax +1;
                                nuevaColaListos.add(colaES.get(iRR2));
                                Juanlucas = true;
                                colaES.remove(iRR2);
                            }
                            
                        }
                        else{
                        gant2.add("#");}
                    }
                     else{
                        gant2.add("#");}
                    System.out.println(ganttiempo);
                    System.out.println(gant1);
                    System.out.println(gant2);
                    break;
                    
                    
                    
                case (4):   //FCFS
                     ganttiempo.add(tiempo);
                    if (!nuevaColaListos.isEmpty()) {
                        
                        
                        //Ahora, guardo el inicio de ejecución si es el primer proceso
                    
                        if (iniciaEjecucion && nuevaColaListos.get(iRR).isSjf()){ 
                            nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                            iniciaEjecucion = false;
                            nuevaColaListos.get(iRR).setSjf(false);
                        }
                        else{
                            if (nuevaColaListos.get(iRR).isSjf()){
                                nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                                nuevaColaListos.get(iRR).setSjf(false);
                            }
                        }
                        
                        if (nuevaColaListos.get(iRR).getCicloCPU()> 0){
                        
                            nuevaColaListos.get(iRR).setCicloCPU(nuevaColaListos.get(iRR).getCicloCPU()-1);
                           
                            gant1.add(nuevaColaListos.get(iRR).getDescripcion());//----------------------------------------------------------------
                            JuanGuidoLucas = nuevaColaListos.get(iRR);
                            if (nuevaColaListos.get(iRR).getCicloCPU()==0 ) {
                                
                                colaES.add(nuevaColaListos.get(iRR));
                                ResiduoRafaga = quantum;
                                nuevaColaListos.get(iRR).setES(true);
                                
                                nuevaColaListos.remove(iRR);
                                
                                if (nuevaColaListos.size()<= iRR){
                                    iRR = 0;
                                }
                            }
                            
                        }
                        else{           
                            if (nuevaColaListos.get(iRR).getCicloCPU2()> 0){
                                nuevaColaListos.get(iRR).setCicloCPU2(nuevaColaListos.get(iRR).getCicloCPU2()-1);
                                gant1.add(nuevaColaListos.get(iRR).getDescripcion());
                                JuanGuidoLucas = nuevaColaListos.get(iRR);
                                if (nuevaColaListos.get(iRR).getCicloCPU2()==0) {
                                    
                                    //Se guarda el tiempo de fin
                                    nuevaColaListos.get(iRR2).setFinEjecución(tiempo);
                                    nuevaColaListos.remove(iRR);
                                    iniciaEjecucion = true;
                                    //Puede que no se haya consumido todo el quantum
                                    //Pero como el proceso termina se lo reinicia
                                   
                                    if (nuevaColaListos.size()== iRR){
                                        iRR = 0;
                                    }
                                }
                                
                            }
                            else{
                                gant1.add("#");
                            }
                            
                            
                        }
                    }
                    else{
                        gant1.add("#");
                        JuanGuidoLucas = new Proceso();
                    
                }
                    //ESTO NO SE SI CIERRA ACA, salu2
                    //ENTRADA SALIDA
                    
                    if (!colaES.isEmpty()) {
                        if (colaES.get(iRR2).getCicloES()> 0 && JuanGuidoLucas != colaES.get(iRR2)){ 
                            
                            colaES.get(iRR2).setCicloES(colaES.get(iRR2).getCicloES()-1);//restamos la entrada/salida
                            gant2.add(colaES.get(iRR2).getDescripcion());
                            if(colaES.get(iRR2).getCicloES() == 0){ //si mi ciclo de entrada/salida ya TERMINO, lo mando a cola de LISTO                               
                                colaES.get(iRR2).setES(false);//---------------------------------------------------------------------------------7777777777777777777777777777
                                colaES.get(iRR2).setIdProceso(idMax + 1);
                                idMax = idMax +1;
                                nuevaColaListos.add(colaES.get(iRR2));
                                Juanlucas = true;
                                colaES.remove(iRR2);
                                
                                
                                if (colaES.size()== iRR2){
                                   iRR2 = 0;
                                }
                            }
                            
                            
                        }
                        else{
                        gant2.add("#");}
                    }
                     else{
                        gant2.add("#");}
                    System.out.println(ganttiempo);
                    System.out.println(gant1);
                    System.out.println(gant2);
                    break;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "La cola de listos está vacía");
            iniciaEjecucion = true;
        }
        
        return nuevaColaListos;
    } 
    
}
