package view;

import controller.ControladorRequerimientosReto4;

import model.vo.AsesorPorCiudad;
import model.vo.CompraPorProveedor;
import model.vo.ProyectosCasaCampestre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class VistaRequerimientosReto5 extends JFrame {
    public static ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private final JPanel contentPane;
    private final JTextArea textArea;

    //PANEL
    public VistaRequerimientosReto5() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Tabla de Datos");
        

        //Texto en el Panel
        final JLabel lbltitulo = new JLabel("Reto 5");
        lbltitulo.setFont(new Font("Consolas", Font.BOLD, 15));
        lbltitulo.setBounds(28, 6, 61, 16);
        contentPane.add(lbltitulo);

        final JLabel lblautor = new JLabel("ESTRUCTURANDO S.A.");
        lblautor.setFont(new Font("Rockwell", Font.BOLD, 25));
        lblautor.setBounds(260, 34, 288, 16);
        contentPane.add(lblautor);
        
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 100, 737, 455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();         //Area de Texto
        scrollPane.setViewportView(textArea);

        //BOTONES
        final JButton btnConsulta1 = new JButton("Info Asesores");
        btnConsulta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsulta1.setBounds(28, 70, 117, 29);
        contentPane.add(btnConsulta1);


        final JButton btnConsulta2 = new JButton("Compras Proyectos");
        btnConsulta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsulta2.setBounds(141, 70, 130, 29);
        contentPane.add(btnConsulta2);


        final JButton btnConsulta3 = new JButton("Proyectos Campestres");
        btnConsulta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsulta3.setBounds(255, 70, 117, 29);
        contentPane.add(btnConsulta3);


        final JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 70, 117, 29);
        contentPane.add(btnLimpiar); 
    }

    public void requerimiento1() {
        try {
            final ArrayList<AsesorPorCiudad> rankingAsesorPorCiudad = controlador.consultarAsesorPorCiudad();
            String salida = "Información de Asesores por ciudad \n\nID Lider\tNombre\tPrimer Apellido\tResidencia\n\n";
            for (final AsesorPorCiudad asesorPorCiudad : rankingAsesorPorCiudad) {
                salida += asesorPorCiudad.getIdLider() + "\t";
                salida += asesorPorCiudad.getNombre() + "\t";
                salida += asesorPorCiudad.getPrimerApellido() + "\t";
                salida += asesorPorCiudad.getCiudadResidencia() + "\n";
            }
            textArea.setText(salida);
        
        }catch (final SQLException e) {
            System.err.println("Ha ocurrido un error" + e.getMessage());
        }            
    }

    public void requerimiento2() {
        try {
            final ArrayList<ProyectosCasaCampestre> rankingProyectosCasaCampestres = controlador.consultarProyectosCasaCampestres();
            String salida = "Listado de casas por Proyectos \n\nID Proyectos\tConstructora\t\tHabitaciones\tCiudad\n\n";
            for (final ProyectosCasaCampestre proyectosCasaCampestre : rankingProyectosCasaCampestres) {
                salida += proyectosCasaCampestre.getIdProyecto() + "\t";
                salida += proyectosCasaCampestre.getConstructora() + "                   \t";
                salida += proyectosCasaCampestre.getNumeroHabitaciones() + "\t";
                salida += proyectosCasaCampestre.getCiudad() + "\n";
            }
            textArea.setText(salida);
        
        }catch (final SQLException e) {
            System.err.println("Ha ocurrido un error" + e.getMessage());
        }
    }

    
    public void requerimiento3() {
        try {
            final ArrayList<CompraPorProveedor> rankingCompraPorProveedor = controlador.consultarCompraPorProveedor();
            String salida = "Proyectos casas tipo campestre \n\nID Compra\tProveedor\tConstructora\t\tBanco\t\tCiudad\n\n";
            for (final CompraPorProveedor compraPorProveedor : rankingCompraPorProveedor) {
                salida += compraPorProveedor.getIdCompra() + "\t";
                salida += compraPorProveedor.getProveedor() + "\t";
                salida += compraPorProveedor.getConstructora() + "                     \t";
                salida += compraPorProveedor.getBancoVinculado() + "                 \t";
                salida += compraPorProveedor.getCiudad() + "\n";
            }
            textArea.setText(salida);
        
        }catch (final SQLException e) {
            System.err.println("Ha ocurrido un error" + e.getMessage());
        }
    }






}



