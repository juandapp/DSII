/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import logica.Bus;
import logica.Empleado;

/**
 *
 * @author JUANPAULO
 */
@ManagedBean
@SessionScoped
public class LoginController {

    Empleado empleado;
    private int selectedItemIndex;
    public LoginController() {
    }
    
     public Empleado getSelected() {
        if (empleado == null) {
            empleado = new Empleado();
            selectedItemIndex = -1;
        }
        return empleado;
    }
    
    public String ingresar(){
        
        return "/index";
    }
}

