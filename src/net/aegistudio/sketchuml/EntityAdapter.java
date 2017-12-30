package net.aegistudio.sketchuml;

import java.awt.Component;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * The simplest entity that stores no data or state, and will be 
 * represented as a single icon on screen.
 * 
 * @author Haoran Luo
 */
public abstract class EntityAdapter implements Entity, PropertyView, SketchView, EntityFactory {
	public Entity create() { return this; }
	
	@Override
	public void load(DataInputStream inputStream) throws IOException {
		
	}

	@Override
	public void save(DataOutputStream outputStream) throws IOException {
		
	}
	
	@Override
	public Component getViewObject(Consumer<Entity> notifier) {
		return null;
	}

	@Override
	public void updateEntity(Entity entity) {
		
	}

	@Override
	public String overlayEntity(Entity entity, OverlayDirection old) {
		return null;
	}
	
	@Override
	public abstract void renderEntity(Graphics g, Entity entity, boolean preview);
}