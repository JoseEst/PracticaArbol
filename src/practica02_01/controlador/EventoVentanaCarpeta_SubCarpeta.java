/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02_01.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import practica02_01.modelo.Carpeta_SubCarpeta;
import practica02_01.vista.VentanaCarpeta_SubCarpeta;

/**
 *
 * @author johne
 */
public class EventoVentanaCarpeta_SubCarpeta implements ActionListener {

    private VentanaCarpeta_SubCarpeta VentCarp;
    private String dir;
    private String carp;
    private String subcarp;

    public EventoVentanaCarpeta_SubCarpeta(VentanaCarpeta_SubCarpeta VentCarp) {
        this.VentCarp = VentCarp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            this.dir = this.VentCarp.getTxtList().get(0).getText();
            this.carp = this.VentCarp.getTxtList().get(1).getText();
            this.subcarp = this.VentCarp.getTxtList().get(2).getText();

           

            if (e.getSource().equals(this.VentCarp.getBotonList().get(0))) {
                
                Carpeta_SubCarpeta Car = new Carpeta_SubCarpeta(dir);
                Car.setFichero(new File("C:\\" + this.dir));
                File fichero = Car.getFichero();
                System.out.println(Car.getFichero());

                if (fichero.exists() == false) {

                    Car.getFichero().mkdir();
                    this.VentCarp.getGestionDato().addCarp(Car);
                    Object[][] datoCarp = this.VentCarp.cargaDatosTabla(this.VentCarp.getGestionDato().getCarpList().size(), 1);
                    this.VentCarp.setDatos(datoCarp);
                    this.VentCarp.getModeloTabla().setDataVector(this.VentCarp.getDatos(), this.VentCarp.getEncabezado());

                } else {
                    JOptionPane.showMessageDialog(null, "Directorio Repetido");

                }
            }

            if (e.getSource().equals(this.VentCarp.getBotonList().get(1))) {

                Carpeta_SubCarpeta Car = new Carpeta_SubCarpeta(carp);
                Car.setFichero(new File("C:\\" + this.dir + "\\" + this.carp));

                if (Car.getFichero().exists() == false) {
                    Car.getFichero().mkdir();

                    this.VentCarp.getGestionDato().addCarp(Car);

                    Object[][] datoCarp = this.VentCarp.cargaDatosTabla(this.VentCarp.getGestionDato().getCarpList().size(), 1);
                    this.VentCarp.setDatos(datoCarp);
                    this.VentCarp.getModeloTabla().setDataVector(this.VentCarp.getDatos(), this.VentCarp.getEncabezado());

                } else {
                    JOptionPane.showMessageDialog(null, "Directorio Repetido .");
                }
            }

            if (e.getSource().equals(this.VentCarp.getBotonList().get(2))) {

                Carpeta_SubCarpeta Car = new Carpeta_SubCarpeta(subcarp);
                Car.setFichero(new File("C:\\" + this.dir + "\\" + this.carp + "\\" + this.subcarp));
                File fichero = Car.getFichero();
                System.out.println(Car.getFichero());

                if (fichero.exists() == false) {

                    Car.getFichero().mkdir();
                    this.VentCarp.getGestionDato().addCarp(Car);
                    Object[][] datoCarp = this.VentCarp.cargaDatosTabla(this.VentCarp.getGestionDato().getCarpList().size(), 1);
                    this.VentCarp.setDatos(datoCarp);
                    this.VentCarp.getModeloTabla().setDataVector(this.VentCarp.getDatos(), this.VentCarp.getEncabezado());

                } else {
                    JOptionPane.showMessageDialog(null, "Directorio Repetido");

                }
            }

        } catch (ArrayIndexOutOfBoundsException ae) {
            JOptionPane.showMessageDialog(null, "No se Permiten campos vacios .");
        }

    }

    public VentanaCarpeta_SubCarpeta getVentCarp() {
        return VentCarp;
    }

    public void setVentCarp(VentanaCarpeta_SubCarpeta VentCarp) {
        this.VentCarp = VentCarp;
    }

}
