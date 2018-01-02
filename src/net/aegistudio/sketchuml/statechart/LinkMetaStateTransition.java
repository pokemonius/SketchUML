package net.aegistudio.sketchuml.statechart;

import java.awt.Component;
import java.util.function.Consumer;

import net.aegistudio.sketchuml.Entity;
import net.aegistudio.sketchuml.LinkView;
import net.aegistudio.sketchuml.PropertyView;
import net.aegistudio.sketchuml.framework.PropertyPanel;
import net.aegistudio.sketchuml.path.PathView;

public class LinkMetaStateTransition implements PropertyView, LinkView {
	private PropertyPanel<LinkStateTransition> viewObject;
	
	@Override
	public Component getViewObject(Consumer<Entity> notifier) {
		if(viewObject == null) {
			viewObject = new PropertyPanel<>();
			
			// Add the guard condition.
			viewObject.registerTextField("Guard: ", 
					(entity) -> entity.guard, 
					(entity, guard) -> entity.guard = guard);
			
			// Add the action.
			viewObject.registerTextField("Action: ",
					(entity) -> entity.action, 
					(entity, action) -> entity.action = action);
		}
		viewObject.setNotifier(notifier);
		return viewObject;
	}

	@Override
	public void updateEntity(Entity entity) {
		viewObject.updateEntity((LinkStateTransition)entity);
	}

	@Override
	public LinkRender render(Entity source, Entity destination, Entity link) {
		return new LinkView.LinkRender() { {
			beginStyle = PathView.ArrowStyle.NONE;
			endStyle = PathView.ArrowStyle.FISHBONE;
			lineStyle = PathView.LineStyle.COHERENT;
		} };
	}

}
