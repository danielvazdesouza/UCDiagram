package com.senac.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class Quadrado extends Figura {

    private int tam;

    public Quadrado(int x, int y, int tam) {
        super(x, y);
        this.tam = tam;
    }

    public boolean intersecta(int x, int y) {
        if (x < posX) {
            return false;
        }
        if (x > (posX + tam)) {
            return false;
        }
        if (y < posY) {
            return false;
        }
        if (y > (posY + tam)) {
            return false;
        }
        return true;
    }

    @Override
    public void desenha(Graphics g) {
        g.drawRect(posX, posY, tam, tam);
        if (this.estaSelecionado()) {
            g.drawOval(posX - 2, posY - 2, 4, 4);
            g.drawOval(posX - 2, posY + tam - 2, 4, 4);
            g.drawOval(posX + tam - 2, posY - 2, 4, 4);
            g.drawOval(posX + tam - 2, posY + tam - 2, 4, 4);
        }
    }

    @Override
    public boolean estaContido(int x, int y) {
        if (x < posX) {
            return false;
        }
        if (x > (posX + tam)) {
            return false;
        }
        if (y < posY) {
            return false;
        }
        if (y > (posY + tam)) {
            return false;
        }
        return true;
    }
}
