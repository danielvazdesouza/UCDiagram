/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.view;

import com.senac.model.Ator;
import com.senac.model.Texto;
import com.senac.model.Quadrado;
import com.senac.model.Circulo;
import com.senac.model.Linha;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Daniel
 */
public class UmlApp extends JFrame {

    JToggleButton buttonAtor, buttonCirculo, buttonQuadrado, buttonTexto, buttonSelecionar, buttonRelacionamento;
    TelaDesenho desenho;
    ButtonGroup bt;
    private int posX, posY,posX2, posY2;
    
    public static void main(String[] args) {
        UmlApp u = new UmlApp();
        u.initComponents();
    }

    public void initComponents() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Erro ao iniciar LookAndFeel\n"+ex.getMessage());
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("UML Java - 1.0");
        setLayout(new BorderLayout());
        setSize(800, 500);
        setResizable(false);

        JToolBar toolbar = new JToolBar();
        buttonAtor = new JToggleButton("Ator");
        buttonCirculo = new JToggleButton("Caso de Uso");
        buttonQuadrado = new JToggleButton("Comentário");
        buttonTexto = new JToggleButton("Texto");
        buttonSelecionar = new JToggleButton("Selecionar");
        buttonRelacionamento = new JToggleButton("Relacionamento");
        buttonAtor.setSelected(true);
        bt = new ButtonGroup();
        bt.add(buttonAtor);
        bt.add(buttonRelacionamento);
        bt.add(buttonCirculo);
        bt.add(buttonQuadrado);
        bt.add(buttonTexto);
        bt.add(buttonSelecionar);

        toolbar.add(buttonAtor);
        toolbar.add(buttonRelacionamento);
        toolbar.add(buttonCirculo);
        toolbar.add(buttonQuadrado);
        toolbar.add(buttonTexto);
        toolbar.add(buttonSelecionar);

        JButton buttonLimpar = new JButton("Limpar");
        toolbar.add(buttonLimpar);

        buttonLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                desenho.limpar();
                desenho.repaint();
            }
        });

        getContentPane().add(toolbar, BorderLayout.NORTH);
        desenho = new TelaDesenho();
        getContentPane().add(desenho);
        desenho.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (buttonAtor.isSelected()) {
                    Ator a = new Ator(me.getX(), me.getY());
                    desenho.addFigura(a);
                } else if (buttonCirculo.isSelected()) {
                    Circulo c = new Circulo(me.getX(), me.getY(), 80);
                    try {
                        String texto = JOptionPane.showInputDialog("Caso de uso:");
                        Texto t = new Texto(me.getX()+5, me.getY()+40, texto);
                        desenho.addFigura(t);
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Texto não foi inserido.");
                    }
                    desenho.addFigura(c);
                } else if (buttonQuadrado.isSelected()) {
                    Quadrado q = new Quadrado(me.getX(), me.getY(), 80);
                    desenho.addFigura(q);
                } else if (buttonTexto.isSelected()) {
                    try {
                        String texto = JOptionPane.showInputDialog("Texto:");
                        Texto t = new Texto(me.getX(), me.getY(), texto);
                        desenho.addFigura(t);
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Texto não foi inserido.");
                    }
                }else if (buttonRelacionamento.isSelected()){
                    posX = me.getX();
                    posY = me.getY();
                } else if(buttonSelecionar.isSelected()){
                    desenho.verificaSelecao(me.getX(), me.getY());
                }
                desenho.repaint();
            }
        });

        desenho.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(buttonRelacionamento.isSelected()){
                    posX2 = e.getX();
                    posY2 = e.getY();
                    Linha l = new Linha(posX, posY, posX2, posY2);
                    desenho.addFigura(l);
                }
                desenho.repaint();
            }
        });
        setVisible(true);
    }
}
