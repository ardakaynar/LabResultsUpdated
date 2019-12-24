/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ardakaynar
 */
public class idrar {
    private String name;
    private String ph;
    private String pro;
    private String glu;

    public idrar(String name, String ph, String pro, String glu) {
        this.name = name;
        this.ph = ph;
        this.pro = pro;
        this.glu = glu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getGlu() {
        return glu;
    }

    public void setGlu(String glu) {
        this.glu = glu;
    }
    
}
