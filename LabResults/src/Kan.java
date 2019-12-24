
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ardakaynar
 */
public class Kan {
    private String name;
    private String hemogram;
    private String rbc;
    private String hgb;

    public Kan(String name, String hemogram, String rbc, String hgb) {
        this.name = name;
        this.hemogram = hemogram;
        this.rbc = rbc;
        this.hgb = hgb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHemogram() {
        return hemogram;
    }

    public void setHemogram(String hemogram) {
        this.hemogram = hemogram;
    }

    public String getRbc() {
        return rbc;
    }

    public void setRbc(String rbc) {
        this.rbc = rbc;
    }

    public String getHgb() {
        return hgb;
    }

    public void setHgb(String hgb) {
        this.hgb = hgb;
    }
    
    
}
