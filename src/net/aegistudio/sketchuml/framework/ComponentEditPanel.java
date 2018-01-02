package net.aegistudio.sketchuml.framework;

import java.awt.Dimension;

import javax.swing.JPanel;

import net.aegistudio.sketchuml.Configuration;

public class ComponentEditPanel<Path> extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public final EntityComponentPanel entityEditor;
	public final LinkComponentPanel<Path> linkEditor;
	private final SketchModel<Path> model;
	private Object selectedEditor;
	
	public ComponentEditPanel(SketchModel<Path> model) {
		this.model = model;
		entityEditor = new EntityComponentPanel(model);
		linkEditor = new LinkComponentPanel<Path>(model);
		
		model.registerEntityObserver(this, this::onUpdate);
		model.registerLinkObserver(this, this::onUpdate);
		onUpdate();
	}
	
	private void onUpdate() {
		if(model.getSelectedLink() != null) {
			// Transit to use link editor.
			if(selectedEditor != linkEditor) {
				removeAll();
				add(linkEditor);
				selectedEditor = linkEditor;
			}
		}
		else {
			// Transit to use entity editor.
			if(selectedEditor != entityEditor) {
				removeAll();
				add(entityEditor);
				selectedEditor = entityEditor;
			}
		}
		setPreferredSize(new Dimension(Configuration
				.getInstance().EDITPANEL_WIDTH, getHeight()));
		repaint();
	}
}