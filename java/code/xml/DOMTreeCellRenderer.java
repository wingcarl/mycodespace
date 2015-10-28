package dom;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMTreeCellRenderer extends DefaultTreeCellRenderer{
	public Component getTreeCellRendererComponent(JTree tree,Object value,boolean seletected,
			boolean expanded,boolean leaf,int row,boolean hasFocus){
		Node node = (Node) value;
		if(node instanceof Element) return elementPanel((Element)node);
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		if(node instanceof CharacterData) {
			setText(characterString((CharacterData) node));
		}
	}

	public static JPanel elementPanel(Element e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String characterString(CharacterData node){
		
	}
}
