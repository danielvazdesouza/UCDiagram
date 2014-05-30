/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.model;

import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class Linha extends Figura {

    public Linha(int posX, int posY, int posX2, int posY2) {
        super(posX, posY, posX2, posY2);
    }

    @Override
    public void desenha(Graphics g) {
        g.drawLine(posX, posY, posX2, posY2);
    }

    @Override
    public boolean estaContido(int x, int y) {
        return true;
    }
}
