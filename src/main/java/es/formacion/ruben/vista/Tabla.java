package es.formacion.ruben.vista;


        import es.formacion.ruben.controlador.HibernateUtil;
        import es.formacion.ruben.modelo.Jugadores;
        import org.hibernate.Session;
        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.util.List;

public class Tabla {
    private JPanel panel1;
    private JTable table1;

    public static void addTable() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            List<Jugadores> jugador = session.createQuery("from Futbol ").list();
            System.out.println("Tabla Jugadores: ");
            for (Jugadores r : jugador) {
                System.out.println("nombre: " + r.getNombre() + " | equipo: " + r.getEquipo() +
                        " | categoria: " + r.getCategoria() + " | posicion: " + r.getPosicion()
                );
                String[] columnNames = {"nombre", "equipo", "categoria", "posicion"};

                Object[][] data = new Object[jugador.size()][4];

                int index = 0;
                for (Jugadores s : jugador) {
                    data[index][0] = s.getNombre();
                    data[index][1] = s.getEquipo();
                    data[index][2] = s.getCategoria();
                    data[index][3] = s.getPosicion();
                    index++;
                }
                DefaultTableModel modelo = new DefaultTableModel(data, columnNames);

            }

        } catch(Exception e1){
            e1.printStackTrace();
            session.close();
        }
    }
}