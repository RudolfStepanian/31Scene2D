package com.rockbite.bootcamp.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;
import org.graalvm.compiler.phases.common.NodeCounterPhase;

public class Grid {
    private Array<Array<Cell>> grid = new Array<>();

    public Grid(){
        this.grid = new Array<>();
    }

    public void addGridElement(){
        grid.add(new Array<Cell>());
    }

    public void addElement(Cell cell){
        grid.get(grid.size-1).add(cell);
    }

    public boolean checkGrid(Stage stage){
        Array<Cell> check = new Array<>();
        Array<Cell> delete = new Array<>();
        boolean del = false;
        for (int i = 0; i < grid.size; i++){
            Array<Cell> row = grid.get(i);
            check.add(row.get(0));
            for (int j = 1; j <= row.size; j++){
                if (j == row.size ){
                    if (check.size >= 3){
                        for (int k = 0; k < check.size; k++){
                            delete.add(check.get(k));
                        }
                        check.clear();
                    }
                    continue;
                } else {
                    if (check.get(check.size-1).getCircle().getCircleColor() == row.get(j).getCircle().getCircleColor()){
                        check.add(row.get(j));
                    } else if ((check.size >= 3)){
                        for (int k = check.size - 1; k >= 0; k--){
                            delete.add(check.get(k));
                        }
                        check.clear();
                        check.add(row.get(j));
                    } else {
                        check.clear();
                        check.add(row.get(j));
                    }
                }
            }
            check.clear();
        }
        for (int i = 0; i < grid.get(0).size; i++){
            check.add(grid.get(0).get(i));
            for (int j = 1; j <= grid.size; j++){
                if (j == grid.size ){
                    if (check.size >= 3){
                        for (int k = 0; k < check.size; k++){
                            delete.add(check.get(k));
                        }
                        check.clear();
                    }
                    continue;
                } else {
                    if (check.get(check.size-1).getCircle().getCircleColor() == grid.get(j).get(i).getCircle().getCircleColor()){
                        check.add(grid.get(j).get(i));
                    } else if ((check.size >= 3)){
                        for (int k = check.size - 1; k >= 0; k--){
                            delete.add(check.get(k));
                        }
                        check.clear();
                        check.add(grid.get(j).get(i));
                    } else {
                        check.clear();
                        check.add(grid.get(j).get(i));
                    }
                }
            }
            check.clear();
        }
        System.out.println(delete);
                System.out.println("");
        if (delete.size != 0){
            for (int y = 0; y < delete.size; y++){
                Cell d = delete.get(y);
                d.getCircle().fade();




                System.out.println(d.getColumn() + " " + d.getRow());
                for (int l = 0; l < grid.size - d.getRow() + 1; l++){
                    if (l == 0){
                        System.out.println("1");
                        Circle circleFromHeaven = new Circle(Color.randomColor());
                        d.setCircle(circleFromHeaven);
                        circleFromHeaven.setSize(95,95);
                        circleFromHeaven.setY((d.getRow()+1) * d.getHeight() + 10);
                        circleFromHeaven.setX(d.getColumn() * d.getWidth() + 10);
                        stage.addActor(circleFromHeaven);
                        circleFromHeaven.addAction(Actions.delay(1f));
                        circleFromHeaven.changePlace(-50,0);
                    } else {
                        System.out.println("2");
//                        grid.get(grid.size-d.getRow()).get(d.getRow()).setCircle(grid.get(grid.get(0).size-d.getColumn()-1).get(d.getColumn()).getCircle());
//                        d.setCircle(grid.get(d.getColumn()).get(grid.size-d.getRow()-1).getCircle());
//                        grid.get(d.getColumn()).get(grid.size-d.getRow()-1).getCircle().changePlace(-50,0);
                    }
                }
                System.out.println("");



            }
        }
        return del;

    }


    public static void lowerTopElements(Cell cell){

    }
}

