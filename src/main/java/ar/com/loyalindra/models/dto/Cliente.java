
package ar.com.loyalindra.models.dto;

import java.util.List;

public class Cliente {

    private List<Contacto> contactos;

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

}
