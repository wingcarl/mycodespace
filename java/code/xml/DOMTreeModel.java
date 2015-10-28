package dom;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTreeModel implements TreeModel{

	private Document doc;
	
	public DOMTreeModel(Document doc){
		this.doc = doc;
	}
	
	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getChild(Object parent, int index) {
		Node node = (Node)parent;
		NodeList list = node.getChildNodes();
		return list.item(index);
	}

	@Override
	public int getChildCount(Object parent) {
		Node node = (Node) parent;
		NodeList list = node.getChildNodes();
		return list.getLength();
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		Node node = (Node)parent;
		NodeList list = node.getChildNodes();
		for(int i=0;i<list.getLength();i++)
			if(getChild(node,i) == child) return i;
		return -1;
	}

	@Override
	public Object getRoot() {
		return doc.getDocumentElement();
	}

	@Override
	public boolean isLeaf(Object node) {
		return getChildCount(node) == 0;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
