package calculadoraIVA;
import java.awt.Color;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculadoraIVA extends JFrame implements ActionListener{
    private JLabel mensaje;
    private JButton boton;
    private JTextField caja;
    private JComboBox iva;
    private String selectIva;
    
    public calculadoraIVA(){
        super();
        configurarVentana();
        crearComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("Calculadora IVA");
        this.setSize(500,250);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    
    private void crearComponentes(){
        mensaje = new JLabel();
        mensaje.setText("Calculadora IVA");
        mensaje.setBounds(190, 30, 100, 30);
        mensaje.setForeground(Color.pink);
        this.add(mensaje);
        
        caja = new JTextField();
        caja.setBounds(140, 60, 100, 30);
        this.add(caja);
        
        String[] ivaList = new String[] {"IVA","16","10","8"};
        JComboBox<String> iva = new JComboBox<>(ivaList);
        iva.setBounds(250, 60, 100, 30);
        iva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectIva = iva.getItemAt(iva.getSelectedIndex());
                System.out.print("El valor de IVA es:  "+selectIva+"\n");
            }
        });
        this.add(iva);
        
        boton = new JButton();
        boton.setText("Calcular");
        boton.setBounds(180, 120, 100, 20);
        boton.setForeground(Color.pink);
        boton.addActionListener(this);
        this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String numero = caja.getText();
        double valor = Double.parseDouble(numero);
        double iva = Double.parseDouble(selectIva);
        double resultado = CalcularIVA(iva,valor);
        JOptionPane.showMessageDialog(this, "El valor con IVA es:  "+resultado);
    }
    
    public static double CalcularIVA(double iva,double numero){
        double valorconIVA;
        valorconIVA = ((numero * iva) / 100) + numero;
        
        return valorconIVA;
    }
    
    public static void main(String[] args){
        calculadoraIVA calculadora = new calculadoraIVA();
        calculadora.setVisible(true);
    }
}