package es.formacion.ruben.vista;

import es.formacion.ruben.controlador.HibernateUtil;
import es.formacion.ruben.modelo.Jugadores;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AñadirJugador extends  JFrame {
    private JLabel txtNombre;
    private JTextField textnombre;
    private JLabel txtEquipo;
    private JTextField texEquipo;
    private JLabel txtCategoria;
    private JTextField texCategoria;
    private JLabel txtPosicion;
    private JTextField texPosicion;
    private JButton añadirButton;
    private JButton cancelarButton;



    public AñadirJugador() {
        FlowLayout DISTRIBUCION = new FlowLayout();
        this.setLayout(DISTRIBUCION);

        setBounds(100,100,200,200);

        this.txtNombre= new JLabel();
        this.txtNombre.setText("Nombre");
        this.add(this.txtNombre);

        this.textnombre= new JTextField("",10);
        this.add(this.textnombre);

        this.txtEquipo= new JLabel();
        this.txtEquipo.setText("Equipo");
        this.add(this.txtEquipo);

        this.texEquipo= new JTextField("",10);
        this.add(this.texEquipo);

        this.txtCategoria= new JLabel();
        this.txtCategoria.setText("Nombre");
        this.add(this.txtCategoria);

        this.texCategoria= new JTextField("",10);
        this.add(this.texCategoria);

        this.txtPosicion= new JLabel();
        this.txtPosicion.setText("Nombre");
        this.add(this.txtPosicion);

        this.texPosicion= new JTextField("",10);
        this.add(this.texPosicion);

        this.añadirButton= new JButton();
        this.añadirButton.setText("Aceptar");
        this.add(this.añadirButton);

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                Session session = HibernateUtil.getSession();
                Transaction tx = session.beginTransaction();

                String nombre=txtNombre.getText();
                String equipo= txtEquipo.getText();
                String categoria= txtCategoria.getText();
                String posicion= txtPosicion.getText();

                Jugadores j= new Jugadores(nombre,equipo,categoria,posicion);

                session.save(j);

                tx.commit();

            }
        });

        this.cancelarButton= new JButton();
        this.cancelarButton.setText("Aceptar");
        this.add(this.cancelarButton);

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtEquipo.setText("");
                txtCategoria.setText("");
                txtPosicion.setText("");
            }
        });
    }
}
