package com.mygdx.game;

import static com.mygdx.game.Planner.teamBlack;
import static com.mygdx.game.Planner.teamWhite;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Units.Unit;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan, bandit;
	Music music;

	public static final int GANG_SIZE = 10;
	public static int step = 0;
	private static float dx, dy;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fons/"+ new Random().nextInt(5) +".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-0"+ (new Random().nextInt(4) + 1) +".mp3"));
		music.setVolume(.125f);
		music.setLooping(true);
		music.play();
		Planner.createTeams();

		int my = 0;
		crossBowMan = new Texture("units/CrossBowMan.png");
		my = crossBowMan.getHeight();
		mage =  new Texture("units/Mage.png");
		if (my < mage.getHeight()) my = mage.getHeight();
		peasant = new Texture("units/Peasant.png");
		if (my < peasant.getHeight()) my = peasant.getHeight();
		monk = new Texture("units/Monk.png");
		if (my < monk.getHeight()) my = monk.getHeight();
		rouge = new Texture("units/Rouge.png");
		if (my < rouge.getHeight()) my = rouge.getHeight();
		sniper = new Texture("units/Sniper.png");
		if (my < sniper.getHeight()) my = sniper.getHeight();
		spearMan = new Texture("units/SpearMan.png");
		if (my < spearMan.getHeight()) my = spearMan.getHeight();
		dx = dy = Gdx.graphics.getHeight() / 12;
	}

	@Override
	public void render () {
		if (step == 0) Gdx.graphics.setTitle("Первый ход "); else Gdx.graphics.setTitle("Ход №"+step);

		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		for (Unit unit : teamBlack) {
			switch (unit.getInfo()) {
				case "Robber": if (unit.isAlive()) batch.draw(rouge, unit.getPosition().getX() * dx, (unit.getPosition().getY() - 1) * dy); break;
				case "Peasant": if (unit.isAlive()) batch.draw(peasant, unit.getPosition().getX() * dx, (unit.getPosition().getY() - 1) * dy); break;
				case "Sniper": if (unit.isAlive()) batch.draw(sniper, unit.getPosition().getX() * dx, (unit.getPosition().getY() - 1) * dy); break;
				case "Witch": if (unit.isAlive()) batch.draw(mage, unit.getPosition().getX() * dx, (unit.getPosition().getY() - 1) * dy); break;
			}
		}
		for (Unit n : teamWhite) {
			switch (n.getInfo()) {
				case "Monk": if (n.isAlive()) batch.draw(monk, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy); break;
				case "Peasant": if (n.isAlive()) batch.draw(peasant, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy); break;
				case "Spearman": if (n.isAlive()) batch.draw(spearMan, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy); break;
				case "Crossbowman": if (n.isAlive()) batch.draw(crossBowMan, n.getPosition().getX() * dx, (n.getPosition().getY() - 1) * dy); break;
			}
		}

		batch.end();

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			step++;
			Planner.makeStep();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}