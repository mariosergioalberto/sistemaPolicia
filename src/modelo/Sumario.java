//
//package modelo;
//
//import java.util.ArrayList;
//
///**
// *
// * @author Laboratio
// */
//public class Sumario extends Expediente{
//    
//    private Integer nroSumario;
//    private Integer año;
//    private ArrayList<Oficio> oficios = new ArrayList<Oficio>();
//    private ArrayList<Nota> notas = new ArrayList<Nota>();
//
//    public Sumario(Integer nroSumario, Integer año,String descripcion, ArrayList<Elemento> elementos, ArrayList<Tramite> tramites,Integer libro,Integer folio) {
//        
//        super(descripcion,elementos,tramites,libro,folio);
//        this.nroSumario = nroSumario;
//        this.año = año;
//    }
//
//    public void setNroSumario(Integer nroSumario) {
//        this.nroSumario = nroSumario;
//    }
//
//    public void setAño(Integer año) {
//        this.año = año;
//    }
//
//    public Integer getNroSumario() {
//        return nroSumario;
//    }
//
//    public Integer getAño() {
//        return año;
//    }
//
//    public void setOficios(ArrayList<Oficio> oficios) {
//        this.oficios = oficios;
//    }
//
//    public void setNotas(ArrayList<Nota> notas) {
//        this.notas = notas;
//    }
//
//    public ArrayList<Oficio> getOficios() {
//        return oficios;
//    }
//
//    public ArrayList<Nota> getNotas() {
//        return notas;
//    }
//    
//    
//    
//}
