package com.rockbite.bootcamp.game;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {
    RED("circle/red.png"),
    BLUE("circle/blue.png"),
    GREEN("circle/green.png"),
    YELLOW("circle/yellow.png"),
    CYAN("circle/cyan.png");

    private final String link;

    Color(String link) { this.link = link; }
    public String getValue() { return link; }

    private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Color randomColor()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
