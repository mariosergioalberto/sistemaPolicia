
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Laboratio
 */
public class Historia {
    
    private Integer id;
    private ArrayList<LineaHistoria> historia = new ArrayList<LineaHistoria>();

    public Historia(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHistoria(ArrayList<LineaHistoria> historia) {
        this.historia = historia;
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<LineaHistoria> getHistoria() {
        return historia;
    }
    
   
}
