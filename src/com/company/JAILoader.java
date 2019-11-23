package com.company;
// JAILoader.java
// Andrew Davison, May 2014, ad@fivedots.coe.psu.ac.th

/* Simple use of JAI to test if JAI is installed correctly.
   Use JAI to load and display an image.
*/


import com.sun.media.jai.widget.DisplayJAI;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.awt.image.renderable.ParameterBlock;


public class JAILoader extends JFrame {

  public JAILoader(String fnm) {
    super("JAI Loader: " + fnm);

    // load the image
    ParameterBlock pb = new ParameterBlock();
    pb.add(fnm);
    PlanarImage plim = JAI.create("fileload", pb);
    // PlanarImage plim = JAI.create("fileload", fnm);

    // print information about the image
    System.out.println("Dimensions: " + plim.getWidth() + "x" + plim.getHeight() + "; Bands:" + plim.getNumBands());

    Container c = getContentPane();
    c.add(new DisplayJAI(plim));    // display in a panel

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    pack();
    setVisible(true);
  }  // end of JAILoader()


}

 