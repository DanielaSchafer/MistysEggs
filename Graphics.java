ArrayList<Tools> list = new ArrayList<Tools>();
ArrayList<Integer> loops = new ArrayList<Integer>();
ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
int rectIndex = 1;


int input;
//1040,680
//780,120
Droid droid = new Droid(1020, 643, Direction.NORTH);
Runner run = new Runner(droid, droid.getDroidX(), droid.getDroidY());

void setup() {

  //sets base background
  size(1050, 720);
  noStroke();
  fill(50, 50, 50);
  rect(700, 0, 350, 720);
  fill(80, 80, 80);
  rect(0, 0, 700, 720);


  drawDroid();
  drawToolBar();
  drawPlaceGrid();

  drawWalls();
  //drawBarriers();
  drawGrid();
  drawSmallDroid(droid);
}

void draw() {
}

void drawDroid()
{
  //droid
  fill(230, 230, 230);
  //door rect
  rect(-50, 100, 250, 620);
  fill(80, 80, 80);
  //cut the door ellipse
  ellipse(75, 90, 300, 80);
  fill(230, 230, 230);
  //add to door ellipse
  // ellipse(25, 500,300,80);
  //main body rect
  rect(150, 100, 450, 620);
  //top
  ellipse(375, 100, 450, 350);
  //inside
  fill(200, 200, 200);
  rect(165, 120, 420, 620);
  //inside top shading
  fill(185, 185, 185);
  ellipse(375, 120, 420, 100);
}

void drawBlock(int x, int y) {
  strokeWeight(3);
  fill(165, 177, 204);
  stroke(96, 106, 161);
  rect(x, y, 50, 50, 10);
}
void drawForward(int x, int y) {
  drawBlock(x, y);
  strokeWeight(3);
  stroke(96, 106, 161);
  line(x+22.5, y+13, x+22.5, y+40);
  line(x+27.5, y+13, x+27.5, y+40);
  line(x+15, y+20, x+25, y+10);
  line(x+35, y+20, x+25, y+10);
}
void drawTurnLeft(int x, int y) {
  drawBlock(x, y);
  noFill();
  rect(x+12.5, y+15, 25, 30, 0, 10, 0, 0);
  rect(x+12.5, y+20, 20, 25, 0, 7.5, 0, 0);
  fill(165, 177, 204);
  noStroke();
  rect(x+10, y+12.5, 5, 35);
  rect(x+10, y+42.5, 35, 5);
  stroke(96, 106, 161);
  line(x+12.5, y+17.5, x+22.5, y+7.5);
  line(x+12.5, y+17.5, x+22.5, y+27.5);
}
void drawTurnRight(int x, int y) {
  drawBlock(x, y);
  noFill();
  rect(x+12.5, y+15, 25, 30, 10, 0, 0, 0);
  rect(x+17.5, y+20, 20, 25, 7.5, 0, 0, 0);
  fill(165, 177, 204);
  noStroke();
  rect(x+35, y+12.5, 5, 35);
  rect(x+5, y+42.5, 35, 5);
  stroke(96, 106, 161);
  line(x+37.5, y+17.5, x+27.5, y+7.5);
  line(x+37.5, y+17.5, x+27.5, y+27.5);
}
void drawLoop(int x, int y) {
  drawBlock(x, y);
  noFill();
  rect(x+12.5, y+12.5, 25, 25, 0, 10, 10, 10);
  fill(165, 177, 204);
  noStroke();
  rect(x+10, y+11, 5, 10);
  stroke(96, 106, 161);
  line(x+12.5, y+21, x+7.5, y+26);
  line(x+12.5, y+21, x+17.5, y+26);
}
void drawToolBar()
{
  //toolbar

  fill(150, 150, 150);
  rect(25, 565, 650, 130, 10);

  fill(165, 177, 204);
  stroke(96, 106, 161);
  strokeWeight(3);
  //rect(25,565,50,50,10);
  rect(40, 580, 100, 100, 10);
  rect(170, 580, 100, 100, 10);
  rect(300, 580, 100, 100, 10);
  rect(430, 580, 100, 100, 10);
  rect(560, 580, 100, 100, 10);

  //forward logo
  line(85, 606, 85, 660);
  line(95, 606, 95, 660);
  line(70, 620, 90, 600);
  line(110, 620, 90, 600);

  //turnleft logo
  noFill();
  rect(195, 610, 50, 60, 0, 20, 0, 0);
  rect(195, 620, 40, 50, 0, 15, 0, 0);
  fill(165, 177, 204);
  noStroke();
  rect(190, 605, 10, 70);
  rect(190, 665, 70, 10);
  stroke(96, 106, 161);
  line(195, 615, 215, 595);
  line(195, 615, 215, 635);

  //turnright
  noFill();
  rect(325, 610, 50, 60, 20, 0, 0, 0);
  rect(335, 620, 40, 50, 15, 0, 0, 0);
  fill(165, 177, 204);
  noStroke();
  rect(370, 605, 10, 70);
  rect(310, 665, 70, 10);
  stroke(96, 106, 161);
  line(375, 615, 355, 595);
  line(375, 615, 355, 635);

  //shoot


  //loop
  noFill();
  rect(585, 605, 50, 50, 0, 20, 20, 20);
  fill(165, 177, 204);
  noStroke();
  rect(580, 603.5, 10, 20);
  stroke(96, 106, 161);
  line(585, 623.5, 575, 633.5);
  line(585, 623.5, 595, 633.5);
}

void drawPlaceGrid()
{
  stroke(204, 138, 81);
  for (int i=0; i<4; i++) {
    line(217, 215+(i*100), 530, 215+(i*100));
  }
  for (int i=0; i<3; i++) {
    line(535, 235+(i*100), 217, 295+(i*100));
  }

  noStroke();
  fill(150, 150, 150);
  for (int j=0; j<4; j++) {
    for (int i=0; i<4; i++) {
      rect(192.5+(i*105), 190+(j*100), 50, 50, 10);
      Rectangle r = new Rectangle((int)((192.5+(i*105))), 190+(j*100));
      rects.add(r);
    }
  }
  fill(175, 234, 112);
  rect(192.5, 190, 50, 50, 10);
  fill(222, 66, 60);
  rect(507.5, 490, 50, 50, 10);
  fill(255, 255, 255);
  rect(524, 507, 17, 17, 5);
  triangle(209, 207, 209, 223, 226, 215);
}

void redrawDroid(Droid d)
{
  fill(50, 50, 50);
  noStroke();
  rect(700, 0, 350, 720);
  drawGrid();
  drawWalls();
  drawSmallDroid(d);
}

void mouseClicked() {
  int[] pos = {mouseX, mouseY};
  if ((40<pos[0])&&(pos[0]<140)&&(580<pos[1])&&(pos[1]<680)) { //forward has been clicked
    list.add(Tools.tFORWARD);
    drawForward(rects.get(rectIndex).getX(), rects.get(rectIndex).getY());
    rectIndex++;
  }
  if ((170<pos[0])&&(pos[0]<270)&&(580<pos[1])&&(pos[1]<680)) { //left has been clicked
    list.add(Tools.tLEFT);
    drawTurnLeft(rects.get(rectIndex).getX(), rects.get(rectIndex).getY());
    rectIndex++;
  }
  if ((300<pos[0])&&(pos[0]<400)&&(580<pos[1])&&(pos[1]<680)) { //right has been clicked
    list.add(Tools.tRIGHT);
    drawTurnRight(rects.get(rectIndex).getX(), rects.get(rectIndex).getY());
    rectIndex++;
  }
  if ((430<pos[0])&&(pos[0]<530)&&(580<pos[1])&&(pos[1]<680)) { //shoot has been clicked
    System.out.println("shoot");
  }
  if ((560<pos[0])&&(pos[0]<660)&&(580<pos[1])&&(pos[1]<680)) { //loop has been clicked
    if (list.size()>0 && list.get(list.size()-1) == Tools.tLOOP)
    {
      loops.set((loops.size()-1), (loops.get(loops.size()-1) +1));
      drawNumBox(rects.get(rectIndex-1).getX(), rects.get(rectIndex-1).getY(), loops.get(loops.size()-1));
    } else
    {
      list.add(Tools.tLOOP);
      loops.add(1);
      drawLoop(rects.get(rectIndex).getX(), rects.get(rectIndex).getY());
      drawNumBox(rects.get(rectIndex).getX(), rects.get(rectIndex).getY(), 1);
      rectIndex++;
    }
  }

  if ((192.5<pos[0])&& (pos[0]<242.5) && (190<pos[1]) && (pos[1]<240))
  {
    run.parseFull(list, loops);
    list.add(0,Tools.tHOME);
  }

  if ((507<pos[0]) && (pos[0]<557) && (490<pos[1]) && (pos[1]<540))
  {
    list.clear();
    loops.clear();
    rectIndex = 1;
    run.resetGame();
    noStroke();
    drawDroid();
    drawToolBar();
    drawPlaceGrid();
  }
}

void reset()
{
  list.clear();
  loops.clear();
  rectIndex = 1;
}

void drawSmallDroid (Droid droid)
{
  if (droid.getDirection()==Direction.SOUTH)
  {
    stroke(255, 255, 255);
    line(droid.getDroidX(), droid.getDroidY()+10, droid.getDroidX(), droid.getDroidY()+15);
  } else if (droid.getDirection()==Direction.WEST)
  {
    stroke(255, 255, 255);
    line(droid.getDroidX()-10, droid.getDroidY(), droid.getDroidX()-15, droid.getDroidY());
  } else if (droid.getDirection()==Direction.EAST)
  {
    stroke(255, 255, 255);
    line(droid.getDroidX()+10, droid.getDroidY(), droid.getDroidX()+15, droid.getDroidY());
  } else
  {
    stroke(255, 255, 255);
    line(droid.getDroidX(), droid.getDroidY()-10, droid.getDroidX(), droid.getDroidY()-15);
  }
  fill(165, 177, 204);
  stroke(255, 255, 255);
  ellipse (droid.getDroidX(), droid.getDroidY(), 20, 20);
}


//  if(start button)
//    Runner.ParseFull(list);
Wall wall1= new Wall (720, 100, 120, true);
Wall wall2=new Wall (720, 220, 120, false);
Wall wall3=new Wall (840, 220, 120, true);
Wall wall4= new Wall (800, 100, 80, true);
Wall wall5=new Wall (800, 140, 120, false);
Wall wall6=new Wall (920, 140, 320, true);
Wall wall7 = new Wall (760, 340, 120, false);
Wall wall8= new Wall (760, 380, 160, true);
Wall wall9 = new Wall (800, 500, 200, false);
Wall wall10= new Wall (840, 420, 200, false);
Wall wall11 = new Wall (960, 500, 160, true);


PhysicalBarrier barrier1= new PhysicalBarrier(760, 140);
PhysicalBarrier barrier2 = new PhysicalBarrier(880, 260);
PhysicalBarrier barrier3 = new PhysicalBarrier(1000, 620);
PhysicalBarrier barrier4 = new PhysicalBarrier(800, 420);

Wall[] w = {wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11};
PhysicalBarrier [] b = {barrier1, barrier2, barrier3};
Maze level1 = new Maze (w, b);





void drawGrid()
{
  stroke (255, 255, 255);
  for (int i = 720; i<=1040; i=i+40)
  {
    line(i, 100, i, 660);
  }
  for (int i = 100; i<680; i=i+40)
  {
    line (720, i, 1040, i);
  }
}

void drawWalls()
{
  Wall[] allWalls = level1.getWalls();
  fill(255, 255, 255);
  for (int i = 0; i <allWalls.length; i++)
  {
    Wall drawnWall = allWalls[i];
    if (drawnWall.getDirection() == true)
    {
      for (int j = drawnWall.getYPos(); j<drawnWall.getYPos() + drawnWall.getLength(); j=j+40)
      {
        rect( drawnWall.getXPos(), j, 40, 40);
      }
    } else
    {
      for (int j = drawnWall.getXPos(); j<drawnWall.getXPos() + drawnWall.getLength(); j=j+40)
      {
        rect( j, drawnWall.getYPos(), 40, 40);
      }
    }
  }
}

void drawBarriers()
{
  PhysicalBarrier[] allBarriers= level1.getBarriers();
  for (int i = 0; i <allBarriers.length; i++)
  {
    fill(140);
    noStroke();
    rect(allBarriers[i].getXPos()+5, allBarriers[i].getYPos()+5, 30, 30);
  }
}

void drawNumBox(int x, int y, int num)
{
  PFont Font1 = createFont("Arial Bold", 14);
  PFont Font2 = createFont("Arial Bold", 12);
  noStroke();
  fill(200, 50, 50);
  rect(x+40, y+40, 15, 15, 4);
  fill(255, 255, 255);
  textFont(Font1);
  if (num<10)
    text(str(num), x+44, y+52);
  else
  {
    textFont(Font2);
    text(str(num), x+40, y+51);
  }
}

void loopErrorText()
{
  PFont Font = createFont("Arial Bold", 16);
  fill(255,0,0);
  textFont(Font);
  text("Loops Must Be Followed By An Action",720,700);
}

void ranIntoWallErrorText()
{
  PFont Font = createFont("Arial Bold", 16);
  fill(150,150,150);
  textFont(Font);
  text("Your Droid Ran Into A Wall!",730,700);
}
