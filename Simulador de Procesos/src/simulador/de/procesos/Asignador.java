
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Asignador {
    private int algoritmo;
     int finalparticion =0;
     int cont =0;
     int contadorProcesos = 1;
     boolean Juanlucas;
     int idMax;
    public boolean isJuanlucas() {
        return Juanlucas;
    }

    public void setJuanlucas(boolean Juanlucas) {
        this.Juanlucas = Juanlucas;
    }

    public int getIdMax() {
        return idMax;
    }
     
     
     
     
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
            //particion.CrearParticion(inicio, fin, true);
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
    ArrayList <Particion> Asignar (Memoria _mem, Proceso _proceso, int _idMax){
        idMax = _idMax;
        Memoria memoria = new Memoria();
        ArrayList <Particion> listaParticionesNueva;
        listaParticionesNueva = _mem.getListaParticiones();//auxiliar de la lista de particion, creada porque saltaba errores. 
                    
                    //Bucle de selección de algoritmo según elección del usuario
                    Iterator<Particion> it = listaParticionesNueva.iterator();
                     Iterator<Particion> it2 = listaParticionesNueva.iterator();//este iterador es para la aprte de defragmentar
                    Iterator<Particion> it3 = listaParticionesNueva.iterator();
                    //crea variables que utilizaremos mas abajo. 
                    int posicion = 0;//POSICION DE LA LISTA DE PARTICIONES
                    boolean banderita = true;//bandera para controlar el while, para que una vez que entre el proceso no siga ejecutandose
                    boolean banderaBF = true;
                    boolean banderaV = true;
                    int resg1 = 99999;
                    int resg2 = 99999;
                    Particion resg3 = null;
                    int memdisp = 0;
                   
                    /*//Este codigo verifica si hay particiones contiguas libres en memoria VARIABLE para juntarlas
                    if(_mem.isTipo()){ //Si es Variable
                        boolean flag = true; //Bandera para saber cuando es la primera vez que entra al codigo
                        Particion resguardo = null; //resguardo de la particion
                        int contpos =0; //contador para saber la posicion de la particion de memoria
                        while (it2.hasNext()) { //Mientras que no se acabe la memoria
                            Particion partaux = it2.next(); //particion auxliar en la que estoy parado actualmente
                            if(flag){ //si es la primera vez que entra, no hace nada, solo el resguardo
                               flag = false;
                            }
                            else{
                               if(resguardo != null && resguardo.isEstado() && partaux.isEstado()){ //si la particion anterior estuvo libre y la actual tambien
                                 partaux.setTamaño((partaux.Tamaño() + resguardo.Tamaño()));//modificamos el inicio de la aprticion actual con el inicio de la particion anterior
                                 listaParticionesNueva.remove(contpos); // eliminamos la particion anterior, la cual sabemos la posicion gracias al contador
                                 contpos = contpos -1; // como eliminamos una particion, actualizamos el contador
                                 listaParticionesNueva.add(contpos, partaux); //añadimos la particion actual a la lista de particiones original
                               }
                               
                            } 
                         resguardo = partaux;//resguardamos la particion actual antes de que termine el ciclo while
                         contpos= contpos +1;    //actualizamos el contador con la posicion del siguiente    
                        }
                    }*/
                    
         switch (algoritmo){
                case(1): //Algoritmos bf
                    if(_mem.isTipo()){ //Si es Variable
                            while (it3.hasNext() && (banderita)){
                           Particion partaux = it3.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& ( partaux.Tamaño()>= _proceso.getTamaño())){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                if(banderaBF){//aca solo va a entrar la primera vez, es para darnos cuenta de que encontro por lo menos 1 lugar disponible
                                    resg1= partaux.Tamaño();
                                    resg2= posicion;
                                    resg3 = partaux;
                                    banderaBF = false;
                                }
                                else{
                                    if(partaux.Tamaño()<resg1){//aca entrara cada vez que encuentre un lugar mejor, es decir, mas ajustado-
                                        resg1= partaux.Tamaño();
                                        resg2= posicion;
                                        resg3 = partaux;
                                    }
                                } 
                               
                            }
                            posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                           }
                            //--------------------------- SUPONGATRES QUE FUNCIONA
                          if(resg1!=99999) {  
                            Particion Nuevaparticion = new Particion();
                            cont=resg3.Tamaño();
                            resg3.CrearParticion(_proceso.getTamaño()); //modifico el tamaño de la particion original
                            listaParticionesNueva.get(resg2).setProces(_proceso); //meto el proceso en la particion
                            int a = resg3.Tamaño() - _proceso.getTamaño();
                                    Nuevaparticion.CrearParticion(a); //creo una nueva particion con el sobrante de memoria
                            listaParticionesNueva.add(resg2+1,Nuevaparticion); //añado esa particion a la lista de particiones
                            banderita = false;
                          }
                           //------------------------------- //Podria no funcar al angau anda
                                   
                        }    
                       else{ //Si es Fija
                           while (it.hasNext() && (banderita) ){
                           Particion partaux = it.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& partaux.Tamaño()>= _proceso.getTamaño()){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                if(banderaBF){//aca solo va a entrar la primera vez, es para darnos cuenta de que encontro por lo menos 1 lugar disponible
                                    resg1= partaux.Tamaño();
                                    resg2= posicion;
                                    banderaBF = false;
                                }
                                else{
                                    if(partaux.Tamaño()<resg1){//aca entrara cada vez que encuentre un lugar mejor, es decir, mas ajustado-
                                        resg1= partaux.Tamaño();
                                        resg2= posicion;
                                        
                                    }
                                } 
                               
                            }
                            posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                        }
                    }
                       
                    
                    if(resg1!=99999) {//aca entra solo si encontro un lugar.
                        //Pone el proceso en la lista de particiones
                        _proceso.setIdProceso(contadorProcesos);
                        listaParticionesNueva.get(resg2).setProces(_proceso);
                        contadorProcesos++;
                        banderita = false; //bandera para que no vuelva a entrar en el while
                    }
                    memoria = _mem;
                    
                break;
                case (2)://ff
                   
                       if(_mem.isTipo()){ //Si es Variable
                           while (it.hasNext() && (banderita) ) {
                                Particion partaux = it.next();
                                Particion Nuevaparticion = new Particion();//particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                                if(partaux.isEstado()&& partaux.Tamaño()> _proceso.getTamaño()){//pregunta si la particion de 1024 esta vacia y si entra el proceso
                                    
                                    int a = partaux.Tamaño() - _proceso.getTamaño();
                                    Nuevaparticion.CrearParticion(a); //creo una nueva particion con el sobrante de memoria
                                        
                                    partaux.CrearParticion(_proceso.getTamaño()); //modifico el tamaño de la particion original
                                    if(Juanlucas){
                                    _proceso.setIdProceso(idMax);  
                                    idMax = idMax +1;
                                        }
                                    else{
                                        _proceso.setIdProceso(contadorProcesos);
                                        contadorProcesos++;
                                        }
                                    listaParticionesNueva.get(posicion).setProces(_proceso); //meto el proceso en la particion
                                       
                                    listaParticionesNueva.add(Nuevaparticion); //añado esa particion a la lista de particiones
                                       
                                    banderita = false;//para que no vuelva a entrar al while
                                }
                                 if(partaux.isEstado()&& partaux.Tamaño()== _proceso.getTamaño()){ //si la particion esta vacia y el proceso entra ahi
                                    listaParticionesNueva.get(posicion).setProces(_proceso); //mete el proceso en la particion
                                }
                               posicion ++;        
                             }    
                        }    
                       else{ //Si es Fija
                            while (it.hasNext() && (banderita) ) {
                           Particion partaux = it.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& partaux.Tamaño()>= _proceso.getTamaño()){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                //aca preguntamos si lo que tenemos en el resguardo, es de tamaño mayor a la actual
                                if(Juanlucas){
                                  _proceso.setIdProceso(idMax);  
                                  idMax = idMax +1;
                                }
                                else{
                                _proceso.setIdProceso(contadorProcesos);
                                contadorProcesos++;
                                }
                                listaParticionesNueva.get(posicion).setProces(_proceso); //Pone el proceso en la lista de particiones
                                
                                banderita = false; //bandera para que no vuelva a entrar en el while
                            }
                            posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                       
                        }
                       
                    }
                    
                    memoria = _mem;
                    
                    
                break;
                case (3): //WF
                   if(_mem.isTipo()){ //Si es Variable
                            while (it3.hasNext() && (banderita)){
                           Particion partaux = it3.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& ( partaux.Tamaño()>= _proceso.getTamaño())){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                if(banderaBF){//aca solo va a entrar la primera vez, es para darnos cuenta de que encontro por lo menos 1 lugar disponible
                                    resg1= partaux.Tamaño();
                                    resg2= posicion;
                                    resg3 = partaux;
                                    banderaBF = false;
                                }
                                else{
                                    if(partaux.Tamaño()>resg1){//aca entrara cada vez que encuentre un lugar mejor, es decir, mas ajustado-
                                        resg1= partaux.Tamaño();
                                        resg2= posicion;
                                        resg3 = partaux;
                                    }
                                } 
                               
                            }
                            posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                           }
                            //--------------------------- SUPONGATRES QUE FUNCIONA

                          if(resg1!=99999) {  
                            Particion Nuevaparticion = new Particion();
                            cont=resg3.Tamaño();
                            resg3.CrearParticion(_proceso.getTamaño()); //modifico el tamaño de la particion original
                            listaParticionesNueva.get(resg2).setProces(_proceso); //meto el proceso en la particion
                            int a = resg3.Tamaño() - _proceso.getTamaño();
                                    Nuevaparticion.CrearParticion(a); //creo una nueva particion con el sobrante de memoria
                            listaParticionesNueva.add(resg2+1,Nuevaparticion); //añado esa particion a la lista de particiones
                            banderita = false;
                          }

                           //------------------------------- //Podria no funcar al angau anda
                                   
                        } 
                       else{ //Si es Fija
                           while (it.hasNext() && (banderita) ){
                           Particion partaux = it.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& partaux.Tamaño()>= _proceso.getTamaño()){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                if(banderaBF){//aca solo va a entrar la primera vez, es para darnos cuenta de que encontro por lo menos 1 lugar disponible
                                    resg1= partaux.Tamaño();
                                    resg2= posicion;
                                    banderaBF = false;
                                }
                                else{
                                    if(partaux.Tamaño()>resg1){//aca entrara cada vez que encuentre un lugar mejor, es decir, mas ajustado-
                                        resg1= partaux.Tamaño();
                                        resg2= posicion;
                                    }
                                } 
                               
                            }
                            posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                           }
                        }
                       
                    if(resg1!=99999) {
                        //Pone el proceso en la lista de particiones
                        _proceso.setIdProceso(contadorProcesos);
                        listaParticionesNueva.get(resg2).setProces(_proceso);
                        contadorProcesos++;
                        banderita = false; //bandera para que no vuelva a entrar en el while
                    }
                    memoria = _mem;
                break;
                default:
                    JOptionPane.showMessageDialog(null, "404: Not found inteligencia en ti, vuelve a intentar");
                break;
            }
        return listaParticionesNueva;
    }
}
    

    
        

