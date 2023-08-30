package com.company.area;

//원의 넓이를 계산하기 위한 클래스
public class Circle
{
    double rad;
    final double PI;
    
    public Circle(double r)
    {
        rad = r;
        PI = 3.14;
    }
    
    // 원의 넓이 반환
    public double getArea()
    {
        return (rad * rad) * PI;
    }
}