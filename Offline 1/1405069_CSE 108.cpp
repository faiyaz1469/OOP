#include <iostream>
#include <cmath>
using namespace std;
class Point
{
// x and y coordinate
int x, y;
public:
//Add necessary constructor(s) to initialize x and y
Point(){ x = 0; y = 0; }
Point(int i,int j){ x = i; y = j; }
//Add your set and get functions for x and y
void setX(int i){
    x = i;
}

void setY(int j){
    y = j;
}

int get_x()
{
    return x;
}
int get_y()
{
    return y;
}

void print()
{
    cout << "Coordinate: "<< x <<", " <<y <<endl;
}
};

class Circle
{
Point p;
int radius;
public:
// Add necessary constructor(s) to initialize p and radius
Circle(int m, int n, int k)
{
    int i;
    p.setX(m);
    p.setY(n);
    radius = k;
}
// Overload update functions
void update(int i, int j)
{
    p.setX(p.get_x() + i);
    p.setY(p.get_y() + j);
}

void update (int k)
{
     radius += k;
}

void update (int i, int j, int k)
{
    p.setX(p.get_x() + i);
    p.setY(p.get_y() + j);
    radius += k;
}

void print()
{
    cout << "Center ";
    p.print();
    cout << "Radius: " << radius << endl;
}
};

class Line{
Point p1,p2;
float length;
public:
Line(int a1,int b1,int a2,int b2)
{
    p1.setX(a1);
    p1.setY(b1);
    p2.setX(a2);
    p2.setY(b2);
}

void print()
{
    float a = (p1.get_x() - p2.get_x());
    float b = (p1.get_y() - p2.get_y());
    length = a*a + b*b;
    cout << "Length: " << sqrt(length) << endl;
}
};

int main()
{
    Point p(5,5);
    Circle c(2, 3, 5);
    Line l(5,-8,-23,0);
    cout << "Point Display" <<endl;
    p.print();
    cout << endl << "Circle Display" <<endl;
    c.print();
    cout << endl;
    //First update
    cout << "First Update" << endl;
    //call “update” function of Circle class to increase the center’s x
    //coordinate by 5 and y coordinate by 5
    c.update(5,5);
    c.print();
    cout <<endl;
    //Second update
    cout << "Second Update" << endl;
    //call “update” function of Circle class to increase the radius by 6;
    c.update(6);
    c.print();
    cout << endl;
    //Third update
    cout << "Third Update" << endl;
    //call “update” function of Circle class to increase the center’s x
    //coordinate by 2 and y coordinate by 2 and the radius by 2;
    c.update(2,2,2);
    c.print();
    cout << endl;
    cout << "Line Display" <<endl;
    l.print();
    return 0;
}
