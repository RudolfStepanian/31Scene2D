package com.rockbite.bootcamp.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.graalvm.compiler.phases.common.NodeCounterPhase;

import javax.swing.*;
import java.awt.*;

public class GdxGame extends ApplicationAdapter {
	private Stage stage;
	private Grid grid = new Grid();
	private Array<Actor> actors = new Array<>();
	private Array<Circle> circles = new Array<>();

	private Image getImage(String name){
		Image image = new Image(new Texture(name));
		return image;
	}
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		for(int i = 1; i <= 8; i++){
			grid.addGridElement();
			for (int j = 1; j <= 10; j++){
				final Circle circle = new Circle(Color.randomColor());
				final Cell cell = new Cell(i,j, circle);
				grid.addElement(cell);
				cell.setSize(50,50);
				cell.setY(i * cell.getHeight() + 10);
				cell.setX(j * cell.getWidth() + 10);
				cell.setZIndex(1);
				circle.setSize(95,95);
				circle.setY(i * cell.getHeight() + 10);
				circle.setX(j * cell.getWidth() + 10);
				circle.setZIndex(0);
				final Group group = new Group();
				group.setSize(100,100);
				group.addActor(circle);
				group.addActor(cell);
				stage.addActor(circle);
				stage.addActor(cell);
				cell.addListener(new ClickListener(){
					@Override
					public void clicked(InputEvent event, float x, float y) {
						if ((User.getSelectedCell() != null)) {
							System.out.println(User.getSelectedCell().toString());
						}
						User.setSelectedCell(cell);
						System.out.println(grid.checkGrid(stage));
						super.clicked(event, x, y);
					}
				});
			}
		}

		grid.checkGrid(stage);

		stage.addListener(new ClickListener(){
			@Override
			public boolean scrolled(InputEvent event, float x, float y, int amount) {
				OrthographicCamera orthographicCamera = (OrthographicCamera) stage.getViewport().getCamera();
				orthographicCamera.zoom += amount*0.3f;
				return super.scrolled(event, x, y, amount);
			}
		});
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}


