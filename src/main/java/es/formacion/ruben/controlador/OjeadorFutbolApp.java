package es.formacion.ruben.controlador;

import es.formacion.ruben.modelo.Jugadores;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class OjeadorFutbolApp {

    public static void main (String...args) throws Exception {

        Class.forName("org.sqlite.JDBC");

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        Jugadores j1= new Jugadores("juan","Laguna","preferente","defensa");


        //TODO:GUARDAR
        session.save(j1);

        //TODO:ELIMINAR
        //session.delete(j1);

        //TODO:ACTUALIZAR
        //j1.setNombre("Paco");
        //session.update(j1);

        //TODO:CONSULTA
        List<Jugadores> registrosList = (List<Jugadores>)session.createQuery("from Jugadores").list();
        System.out.println(Arrays.toString(registrosList.toArray()));

        tx.commit();

        session.close();
        HibernateUtil.shutdown();

    }
}