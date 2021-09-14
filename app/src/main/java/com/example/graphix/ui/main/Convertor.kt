package com.example.graphix.ui.main

class Convertor(xmin:Int,xmax:Int,ymin:Int,ymax:Int, width:Double, height:Double) {
    val _xmin: Int = xmin
    val _xmax: Int = xmax
    val _ymin: Int = ymin
    val _ymax: Int = ymax
    val _width:Double = width
    val _height:Double = height

    public fun Dx1() = _width / (_xmax - _xmin)
    public fun Dy1() = _height / (_ymax - _ymin)
    public fun Dx(Xmin: Int, Xmax: Int, Width: Double) = Width / (Xmax - Xmin)
    public fun Dy(Ymin: Int, Ymax: Int, Height: Double) = Height / (Ymax - Ymin)

    public fun xPixToDec(Xmin: Int, Xpx: Float) = (Xmin + (Xpx - 1) / Dx(_xmin,_xmax,_width)).toFloat()
    public fun xDecToPix(Xmin:Int, Xdec:Float) = (((Xdec-Xmin)*Dx(_xmin,_xmax,_width))+1).toFloat()
    public fun yPixToDec(Ymax:Int, Ypx:Float) = (Ymax - Ypx/Dy(_ymin,_ymax,_height)).toFloat()
    public fun yDecToPix(Ymax:Int, Ydec: Double) = ((Ymax-Ydec)*Dy(_ymin,_ymax,_height)).toFloat()
}