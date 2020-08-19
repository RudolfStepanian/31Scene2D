package com.rockbite.bootcamp.game;

public class User {
    private static User instance;
    private static Cell selectedCell;

    private User(){}

    public static User getInstance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }

    public static void setSelectedCell(Cell cell){
        if (selectedCell == null){
            selectedCell = cell;
        } else if (selectedCell.canBeChanged(cell)){
            if (selectedCell.getRow() - cell.getRow() == 0){
                if (selectedCell.getColumn() - cell.getColumn() == 1){
                    selectedCell.getCircle().changePlace(0,-50);
                    cell.getCircle().changePlace(0,50);
                    Circle temp = selectedCell.getCircle();
                    selectedCell.setCircle(cell.getCircle());
                    cell.setCircle(temp);
                } else if (selectedCell.getColumn() - cell.getColumn() == -1){
                    selectedCell.getCircle().changePlace(0,50);
                    cell.getCircle().changePlace(0,-50);
                    Circle temp = selectedCell.getCircle();
                    selectedCell.setCircle(cell.getCircle());
                    cell.setCircle(temp);
                }
            } else {
                if (selectedCell.getRow() - cell.getRow() == 1){
                    selectedCell.getCircle().changePlace(-50,0);
                    cell.getCircle().changePlace(50,0);
                    Circle temp = selectedCell.getCircle();
                    selectedCell.setCircle(cell.getCircle());
                    cell.setCircle(temp);
                } else if (selectedCell.getRow() - cell.getRow() == -1){
                    selectedCell.getCircle().changePlace(50,0);
                    cell.getCircle().changePlace(-50,0);
                    Circle temp = selectedCell.getCircle();
                    selectedCell.setCircle(cell.getCircle());
                    cell.setCircle(temp);
                }
            }
            selectedCell = null;
        }
    }


    public static Cell getSelectedCell() {
        return selectedCell;
    }

}
