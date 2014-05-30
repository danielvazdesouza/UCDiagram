/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.view;

import com.senac.model.Figura;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class TelaDesenho extends JPanel {

    List<Figura> figuras;

    public TelaDesenho() {
        figuras = new ArrayList<Figura>();
    }

    public void addFigura(Figura f) {
        figuras.add(f);
    }

    public void limpar() {
        figuras.clear();
    }

    public Figura getSelecionado() {
        for (Figura f : figuras) {
            if (f.estaSelecionado()) {
                return f;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figura f : figuras) {
            f.desenha(g);
        }
    }

    public void verificaSelecao(int x, int y) {
        for (Figura f : figuras) {
            if (f.estaContido(x, y)) {
                deselecionarFiguras();
                f.selecionar();
            }
        }
    }

    public void deselecionarFiguras() {
        for (Figura f : figuras) {
            f.deselecionar();
        }
        repaint();
    }
}
