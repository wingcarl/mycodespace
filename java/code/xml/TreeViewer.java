package dom;
import java.awt.*;

import javax.swing.*;


/**
 * This program displays an XML document as a tree.
 * @version 1.12 2012-06-03
 * @author Cay Horstmann
 */
public class TreeViewer
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new DOMTreeFrame();
               frame.setTitle("TreeViewer");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
