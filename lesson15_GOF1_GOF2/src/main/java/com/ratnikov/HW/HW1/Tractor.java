package com.ratnikov.HW.HW1;


public class Tractor {
    private Position position = new Position(0, 0);
    private Field field = new Field(5,5);
    private Orientation orientation = Orientation.NORTH;

    public void move(Command command) {
        if (command == Command.FORWARDS) {
            moveForwards();
        } else if (command == Command.TURN) {
            turnClockwise();
        }
    }

    public void moveForwards() {
        if (orientation == Orientation.NORTH) {
            position = new Position(position.getX(), position.getY()+1);
        } else if (orientation == Orientation.EAST) {
            position = new Position(position.getX()+1, position.getY());
        } else if (orientation == Orientation.SOUTH) {
            position = new Position(position.getX(), position.getY()-1);
        } else if (orientation == Orientation.WEST) {
            position = new Position(position.getX()-1, position.getY());
        }
        if (position.getX() > field.getxField() | position.getY() > field.getyField()) {
            throw new TractorInDitchException();
        }
    }

    public void turnClockwise() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void printPosition() {
        System.out.printf("Трактор находиться в координатах (%s,%s) и повернул в направлении - " + orientation +", ", position.getX(), position.getY());
    }
}
