package es.formacion.ruben.vista;

import es.formacion.ruben.controlador.HibernateUtil;
import es.formacion.ruben.modelo.Jugadores;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorraJugador extends JFrame {
    private JTextField txtNombre;
    private JButton borrarButton;
    private JButton cancelarButton;

    public BorraJugador(){

        this.txtNombre= new JTextField("",10);
        this.add(this.txtNombre);

        this.cancelarButton= new JButton();
        this.cancelarButton.setText("Cancelar");
        this.add(this.cancelarButton);

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
            }
        });


        this.borrarButton = new JButton();
        this.borrarButton.setText("Registro Usuario");
        this.add(this.borrarButton);

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Session session = HibernateUtil.getSession();
                    Transaction tx = session.beginTransaction();

                    String a = txtNombre.getText();
                    Jugadores j = new Jugadores(a, "", "", "");
                    session.delete(j);
                    JOptionPane.showMessageDialog(null, "Jugador borrado");


            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                HibernateUtil.getSession().close();
            }
            dispose();
        }
    });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
