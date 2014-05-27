/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.senac.model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


/**
 *
 * @author Daniel
 */
public class Ator extends Figura{

    public Ator(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void desenha(Graphics g) {
        URL url = Ator.class.getResource("/com/senac/icon/ator.png");
        try {
            Image img = ImageIO.read(url);
            g.drawImage(img, posX, posY, null);
        } catch (IOException ex) {
            System.out.println("Erro ao ler ator");
        }
    }    
}
