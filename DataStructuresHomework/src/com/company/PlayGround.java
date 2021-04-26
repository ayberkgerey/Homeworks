package com.company;
public class PlayGround {

    public Stack xAxis = new Stack();
    public Stack yAxis = new Stack();

    public Stack xLogs = new Stack();
    public Stack yLogs = new Stack();

    private Integer[] obstacleX = new Integer[30];
    private Integer[] obstacleY = new Integer[30];

    private Integer die;
    private Integer moveX = 0, moveY = 0;

    private Integer xKey=0 , yKey = 0;

    private Integer xDoor=100;
    private Integer yDoor=0;

    private Integer counter=0;

    //Movement method
    public void movement() {
        dice();
        if(xDoor == moveX && yDoor == moveY) System.out.println("YOU WON THE GAME!\n");

        if(moveX == xKey && moveY == yKey) setDoor();

        if (isInside() && !isCrashed()) {
            if (die == 1 || die == 5) moveX += 2;
            else if (die == 2 || die == 4) moveY += 2;
            else { moveX++;moveY++; }

            System.out.println("Coordinates "+moveX+","+moveY);
            xAxis.push(moveX);
            yAxis.push(moveY);
            xLogs.push(moveX);
            yLogs.push(moveY);
            counter++; }

        else if(isCrashed()){
            System.out.println("You have crashed the obstacle ! "+moveX+","+moveY+ " Returning to previous location.");

            xLogs.push(moveX);
            yLogs.push(moveY);

            moveX = xAxis.peek();
            moveY = yAxis.peek();

            xAxis.pop();
            yAxis.pop();


            counter++;
        }
    }

    //rolling the dice
    private int dice() {
        die = (int) (Math.random() * 6 + 1);
        return die; }

    //Creates obstacles
    public void obstacles() {
        for (int i = 0; i < 30; i++) {
            obstacleX[i] = (int) (Math.random() * 100 + 1);
            obstacleY[i] = (int) (Math.random() * 50 + 1);
        }
    }

    //sets a key into the playground
    public void setKey() {
        xKey = (int) (Math.random() * 100 + 1);
        yKey = (int) (Math.random() * 50  + 1);
    }

    //sets the door's location
    private void setDoor(){yDoor = (int)(Math.random() * 50 + 1);}

    //controls if it's inside of the playground
    public boolean isInside() {
        if (moveX <= 100 && moveY <= 50) return true;
        else return false;
    }

    //Controls if it's crashed
    private boolean isCrashed() {
        int crashCounter = 0;
        for (int i = 0; i < 30; i++) {
            if (moveX == obstacleX[i] && moveY == obstacleY[i])
                crashCounter++;
        }
        if (crashCounter != 0) return true;
        else return false;
    }

    // Writing last coordinates
    public void lastLogs(){
        System.out.println("Writing all of your locations\n");
        for(int i=0;i<counter;i++){
            System.out.println(xLogs.showCoordinates(i)+","+yLogs.showCoordinates(i));
        }
    }

}