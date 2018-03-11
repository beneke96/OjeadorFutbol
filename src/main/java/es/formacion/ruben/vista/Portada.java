package es.formacion.ruben.vista;

import es.formacion.ruben.controlador.HibernateUtil;
import es.formacion.ruben.modelo.Jugadores;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Portada extends  JFrame{
    private JButton Lista;
    private JPanel panel1;
    private JButton nuevoJugadorButton;
    private JButton borraJugadorButton;

    public Portada() {

        FlowLayout DISTRIBUCION = new FlowLayout();
        this.setLayout(DISTRIBUCION);

        setBounds(200,100,200,200);

        this.nuevoJugadorButton = new JButton();
        this.nuevoJugadorButton.setText("Registro Usuario");
        this.add(this.nuevoJugadorButton);

        nuevoJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AñadirJugador nj= new AñadirJugador();
                nj.setVisible(true);
            }
        });

        this.Lista = new JButton();
        this.Lista.setText("Lista");
        this.add(this.Lista);

        Lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Session session = null;
                try {
                    session = HibernateUtil.getSession();
                    List<Jugadores> jugador = session.createQuery("from Futbol ").list();
                    System.out.println("Tabla Lista: ");
                    for (Jugadores r : jugador) {
                        System.out.println("nombre: " + r.getNombre() + " | equipo: " + r.getEquipo() +
                                " | categoria: " + r.getCategoria() + " | posicion: " + r.getPosicion()
                        );
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                session.close();
            }
        });

        this.borraJugadorButton = new JButton();
        this.borraJugadorButton.setText("Registro Usuario");
        this.add(this.borraJugadorButton);

        borraJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorraJugador bj= new BorraJugador();
                bj.setVisible(true);
            }
        });
    }
}
