
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Asignador {
    private int algoritmo;

    public int getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(int algoritmo) {
        this.algoritmo = algoritmo;
    }
    
    //Funcion que crea una nueva partición
    ArrayList Particionar (Memoria _mem, int _tamParticion){
        
        //Vamos a devolver la lista de particiones nueva que creamos aca
        ArrayList <Particion> NuevaListaParticiones;
        
        //La lista actual la copiamos para trabajar mejor
        NuevaListaParticiones = (ArrayList<Particion>) _mem.getListaParticiones();
        
        int total, inicio, fin;
        //Para este ejemplo suponemos una memoria vacía
        inicio=0;
        //Para este ejemplo, el fin es el tamaño de la particion pero si ya existen otras
        //debería tener eso en cuenta
        fin=_tamParticion;
        if (_mem.getTamaño() >= _tamParticion){
            Particion particion = new Particion();
            particion.CrearParticion(inicio, fin, true);
            NuevaListaParticiones.add(particion);
        }
        //Si la persona pone un valor muy alto ponemos lo máximo que tengamos
        if(_mem.getTamaño() < _tamParticion){
            JOptionPane.showMessageDialog(null,"Excedió el tamaño de la memoria."); 
            //Hace falta un método en la clase memoria que diga memoria disponible.
        }
        return NuevaListaParticiones;
    }
    //Desfragmentar: las particiones vacías consecutivas se convierten en una sola
    //Sólo es válido para partiocionamiento que no sea estático
    public void Desfragmentar (Memoria _mem){
        
    }
    
    //Asigna un proceso a una partición creada
    Memoria Asignar (Memoria _mem, Proceso _proceso){
        Memoria memoria = new Memoria();
        int finalparticion =0;
        int cont =0;
         switch (algoritmo){
                case(1): //Algoritmos FF
                    Iterator<Particion> it = _mem.getListaParticiones().iterator();
                    while (it.hasNext()) {
                       if(_mem.isTipo()){ //Si es Variable
                            if(_mem.getListaParticiones().isEmpty()){ //La primera vez cuando no hay particiones
                                it.next().CrearParticion(0, _proceso.getTamaño(), true);
                                _mem.getListaParticiones().add(it.next());
                                it.next().setProces(_proceso);
                                finalparticion = it.next().getFin();
                                cont = cont + finalparticion;
                            }
                            else{
                                if((cont + _proceso.getTamaño()) <= _mem.getTamaño()){
                                    it.next().CrearParticion(finalparticion, _proceso.getTamaño(), true);
                                    _mem.getListaParticiones().add(it.next());
                                    it.next().setProces(_proceso);
                                    finalparticion = it.next().getFin();
                                    cont = cont + finalparticion;
                                }
                             }
                        }    
                       else{ //Si es Fija
                            if(it.next().isEstado()){
                               if(it.next().Tamaño()>= _proceso.getTamaño()){
                                   it.next().setProces(_proceso);
                                }
                            }    
                        } 
                    }
                
                    memoria = _mem;
                    
                break;
                case (2):
                    
                break;
                case (3):
                    
                break;
                default:
                    JOptionPane.showMessageDialog(null, "404: Not found inteligencia en ti, vuelve a intentar");
                break;
            }
        return memoria;
    }
    //Acá van los algoritmos BESTFIT, WORSTFIT Y FIRSTFIT como métodos
        
}
