package com.game.void_seekers.character.base;

import com.game.void_seekers.interfaces.Movable;
import com.game.void_seekers.tools.Coordinates;

public abstract class GameCharacter extends Health implements Movable {
    protected int damage; //Change from baseDamage to damage
    protected String name;
    protected Coordinates coordinate;

    public GameCharacter() {
        super();
        setDamage(0);
        setCoordinate(new Coordinates());
        setName("Untitled Character");
    }

    public GameCharacter(String name, int health, double x, double y) {
        this(name, health, new Coordinates(x, y));
    }

    public GameCharacter(String name, int health, Coordinates coordinate) {
        super(health);
        setCoordinate(coordinate);
        setName(name);
        setDamage(0);
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(damage, 1);
    } //Should deal basic damage

    public void setHealth(int health) {
        //TODO: set character health accessible from other class
    }
}
