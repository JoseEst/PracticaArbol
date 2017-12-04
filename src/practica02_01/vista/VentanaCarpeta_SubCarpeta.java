/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02_01.vista;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import practica02_01.controlador.EventoVentanaCarpeta_SubCarpeta;
import practica02_01.controlador.GestionDato;
import practica02_01.modelo.Carpeta_SubCarpeta;


/**
 *
 * @author johne
 */
public class VentanaCarpeta_SubCarpeta extends JInternalFrame
{
    private GestionDato gestionDato;
    private JComboBox comboDirectorio;
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private JPanel panel;
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Object[] encabezado;
    private Object[][] datos;

    public VentanaCarpeta_SubCarpeta(GestionDato gestionDato) {
        super("Administar Carpeta_SubCarpeta",true,true,true,true);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
        this.setSize(900,400);
    }
    
    public void iniciaComponente() {
        
        this.etiList= new ArrayList<JLabel>();
        this.txtList= new ArrayList<JTextField>();
        this.botonList= new ArrayList<JButton>();
      
        
        JPanel panel = new JPanel(new FlowLayout());
        
        this.etiList.add(new JLabel("Directorio:"));
        this.txtList.add(new JTextField(7));
        
        this.etiList.add(new JLabel("Carpeta:"));
        this.txtList.add(new JTextField(7));
        
        this.etiList.add(new JLabel("SubCarpeta"));
        this.txtList.add(new JTextField(7));
        
        this.botonList.add(new JButton("Guardar Directorio"));
        this.botonList.add(new JButton("Guardar Carpeta"));
        this.botonList.add(new JButton("Guardar SubCarpeta"));
        
        this.encabezado = new Object[1];               
        this.encabezado[0] = "Directorio";
        
       
        
        this.datos = cargaDatosTabla(this.gestionDato.getCarpList().size(),1);

        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panel.add(this.etiList.get(0));
        panel.add(this.txtList.get(0));
        panel.add(this.botonList.get(0));
        panel.add(this.etiList.get(1));
        panel.add(this.txtList.get(1));
        panel.add(this.botonList.get(1));
        panel.add(this.etiList.get(2));
        panel.add(this.txtList.get(2));
        panel.add(this.botonList.get(2));
        
       
        panel.add(this.scroll);
        
        this.botonList.get(0).addActionListener(new EventoVentanaCarpeta_SubCarpeta (this));
        this.botonList.get(1).addActionListener(new EventoVentanaCarpeta_SubCarpeta (this));
        this.botonList.get(2).addActionListener(new EventoVentanaCarpeta_SubCarpeta (this));
        
        this.add(panel);
        
    } 
    
    public Object[][] cargaDatosTabla(int m, int n) {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Carpeta_SubCarpeta b: this.gestionDato.getCarpList()) {
            retorno[i][0] = b.getFichero();
           
            i++;
        }        
        return retorno;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public JComboBox getComboDirectorio() {
        return comboDirectorio;
    }

    public void setComboDirectorio(JComboBox comboDirectorio) {
        this.comboDirectorio = comboDirectorio;
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }
    
    
    

}
