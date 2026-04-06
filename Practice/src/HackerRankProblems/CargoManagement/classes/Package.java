package HackerRankProblems.CargoManagement.classes;

import HackerRankProblems.CargoManagement.interfaces.IPackage;

public class Package implements IPackage {
    private int id;
    private String name;
    private int weight;
    private int length;
    private int width;
    private int height;

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setWeight(int weight) {
        this.weight=weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setLength(int length) {
        this.length=length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setWidth(int width) {
        this.width=width;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setHeight(int height) {
        this.height=height;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
