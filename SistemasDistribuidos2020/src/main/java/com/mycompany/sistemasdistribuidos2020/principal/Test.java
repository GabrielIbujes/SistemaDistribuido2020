package com.mycompany.SistemasDistribuidos2020.principal;

import com.mycompany.SistemasDistribuidos2020.entidades.Producto;
import com.mycompany.SistemasDistribuidos2020.session.ProductoJpaController;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test {

    public static void main(String[] args) {
       
        //Tomar los parametros establecidos de la cadena de conexion
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
        //La clase controladora resive de parametro una cadena de conexion
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        //creamos una nueva entidad
        
        Producto p = new Producto();
        p.setCodigo(1);
        p.setNombre("SOFTWARE ERP");
        Double dl =5000.99;
        BigDecimal dbl = BigDecimal.valueOf(dl);
        p.setPrecio(dbl);
        p.setDetalle("Para la EPN");
        
        try {
            //Ejecutar el metodo de la clase controladora
            pjc.create(p);
            
           // pjc.destroy(1);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}