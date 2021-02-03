package ru.geek.javacore.lesson1;

public abstract class obstruction {
    private String name;
    public obstruction (String name)
    {
        this.name = name;
    }

        protected abstract boolean moving (Actions actions);

    public String getName()
    {
        return name;
    }
}
