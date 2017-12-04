/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02_01.controlador;

import java.util.List;
import practica02_01.modelo.Archivo;
import practica02_01.modelo.Carpeta_SubCarpeta;

public class GestionDato {

    private List<Carpeta_SubCarpeta> carpList;
    private List<Archivo> archivoList;

    public GestionDato(List<Carpeta_SubCarpeta> carpList, List<Archivo> archivoList) {

        this.carpList = carpList;
        this.archivoList = archivoList;
    }

    public boolean addCarp(Carpeta_SubCarpeta a) {

        return this.carpList.add(a);
    }

    public boolean addArchivo(Archivo a) {
        return this.archivoList.add(a);
    }

    public List<Carpeta_SubCarpeta> getCarpList() {
        return carpList;
    }

    public void setCarpList(List<Carpeta_SubCarpeta> carpList) {
        this.carpList = carpList;
    }

    public List<Archivo> getArchivoList() {
        return archivoList;
    }

    public void setArchivoList(List<Archivo> archivoList) {
        this.archivoList = archivoList;
    }
}
