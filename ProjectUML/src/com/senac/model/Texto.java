/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.model;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Daniel
 */
public class Texto extends Figura {

    protected String texto;
    protected Font fonte;

    public Texto(int x, int y, String texto) {
        super(x, y);
        this.texto = texto;
        this.fonte = new Font("Helvetica", Font.PLAIN, 12);
    }
    public int getAltura() {
        FontMetrics metrics = new JLabel().getFontMetrics(fonte);
        return (metrics.getHeight() + 2);
    }

    public int getLargura() {
        FontMetrics metrics = new JLabel().getFontMetrics(fonte);
        return (metrics.stringWidth(texto) + 2);
    }

    @Override
    public void desenha(Graphics g) {
        g.setFont(fonte);
        g.drawString(texto, posX, posY);
        if (selecionado) {
            int altura = this.getAltura();
            int largura = this.getLargura();

            g.drawOval(posX - 2, posY - altura, 4, 4);
            g.drawOval(posX - 2, posY, 4, 4);
            g.drawOval(posX + largura - 2, posY - altura, 4, 4);
            g.drawOval(posX + largura - 2, posY, 4, 4);
        }
    }
}
