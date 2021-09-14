package com.example.graphix.ui.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class KortesianView(context: Context, attrs: AttributeSet?): View(context,attrs) {
    constructor(context: Context): this(context,null)
    val backgroundcolor = Paint()
    var grafcolor = Paint()
    val color1 = Paint()
    val color2 = Paint()
    val osicolor = Paint()
    var f: Int = 0
        set(value){
            field=value
            invalidate()
        }
    lateinit var Convert:Convertor
    var xmin:Int=-7
        set(value){
            field=value
        }
    var xmax:Int=7
        set(value){
            field=value
        }
    var ymin:Int=2
        set(value){
            field=value
        }
    var ymax:Int=10
        set(value){
            field=value
            invalidate()
        }
    init {
        backgroundcolor.color = Color.LTGRAY
        osicolor.color = Color.BLACK
        color1.color = Color.RED
        color2.color = Color.BLUE
        //osicolor.strokeWidth = 1F
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Convert = Convertor(xmin,xmax,ymin,ymax,width.toDouble(),height.toDouble())
        canvas?.drawPaint(backgroundcolor)
        var i:Float = 1F
        //отрисовка осей
        if(xmin>=0)
        {
            if(ymin>=0)
            {
                //ось x
                canvas?.drawLine(Convert.Dx1().toFloat(),height-Convert.Dy1().toFloat(),width.toFloat(),height-Convert.Dy1().toFloat(),osicolor)
                //стрелки для x
                canvas?.drawLine(width.toFloat(),height-Convert.Dy1().toFloat(),width.toFloat()-75,height-Convert.Dy1().toFloat()-20,osicolor)
                canvas?.drawLine(width.toFloat(),height-Convert.Dy1().toFloat(),width.toFloat()-75,height-Convert.Dy1().toFloat()+20,osicolor)
                //штрихи для х
                i=Convert.Dx1().toFloat()
                while (i<=width.toFloat())
                {
                    canvas?.drawLine(i,height-Convert.Dy1().toFloat()+10F,i,height-Convert.Dy1().toFloat()-10F,osicolor)
                    i+=Convert.Dx1().toFloat()
                }
            }
            else
            {
                //ось x
                canvas?.drawLine(Convert.Dx1().toFloat(),height/2.toFloat(),width.toFloat(),height/2.toFloat(),osicolor)
                //стрелки для x
                canvas?.drawLine(width.toFloat(),height.toFloat()/2,width.toFloat()-75,height.toFloat()/2-20,osicolor)
                canvas?.drawLine(width.toFloat(),height.toFloat()/2,width.toFloat()-75,height.toFloat()/2+20,osicolor)
                //штрихи для х
                i=Convert.Dx1().toFloat()
                while (i<=width.toFloat())
                {
                    canvas?.drawLine(i,height/2+10F,i,height/2-10F,osicolor)
                    i+=Convert.Dx1().toFloat()
                }
            }
            //ось у
            canvas?.drawLine(Convert.Dx1().toFloat(),0F,Convert.Dx1().toFloat(),height.toFloat(),osicolor)
            //стрелки для у
            canvas?.drawLine(Convert.Dx1().toFloat(),0F,Convert.Dx1().toFloat()-15,75F,osicolor)
            canvas?.drawLine(Convert.Dx1().toFloat(),0F,Convert.Dx1().toFloat()+15,75F,osicolor)
            //штрихи для у
            i = Convert.Dy1().toFloat()
            while (i<=height.toFloat())
            {
                canvas?.drawLine(Convert.Dx1().toFloat()-15.toFloat(),i,Convert.Dx1().toFloat()+15.toFloat(),i,osicolor)
                i+=Convert.Dy1().toFloat()
            }
        }
        else
        {
            if(xmax<=0) {
                if (ymin >= 0) {
                    //ось x
                    canvas?.drawLine(Convert.Dx1().toFloat(), height - Convert.Dy1().toFloat(), width.toFloat(), height - Convert.Dy1().toFloat(), osicolor)
                    //стрелки для x
                    canvas?.drawLine(width.toFloat(), height - Convert.Dy1().toFloat(), width.toFloat() - 75, height - Convert.Dy1().toFloat() - 20, osicolor)
                    canvas?.drawLine(width.toFloat(), height - Convert.Dy1().toFloat(), width.toFloat() - 75, height - Convert.Dy1().toFloat() + 20, osicolor)
                    //штрихи для х
                    i=Convert.Dy1().toFloat()
                    while (i<=width.toFloat())
                    {
                        canvas?.drawLine(i,height - Convert.Dy1().toFloat()+10F,i,height - Convert.Dy1().toFloat()-10F,osicolor)
                        i+=Convert.Dx1().toFloat()
                    }
                } else {
                    //переписать, добавить проверку на ymin>=0
                    //ось x
                    canvas?.drawLine(Convert.Dx1().toFloat(), height / 2.toFloat(), width.toFloat(), height / 2.toFloat(), osicolor)
                    //стрелки для x
                    canvas?.drawLine(width.toFloat(), height.toFloat() / 2, width.toFloat() - 75, height.toFloat() / 2 - 20, osicolor)
                    canvas?.drawLine(width.toFloat(), height.toFloat() / 2, width.toFloat() - 75, height.toFloat() / 2 + 20, osicolor)
                    //штрихи для х
                    i=Convert.Dx1().toFloat()
                    while (i<=width.toFloat())
                    {
                        canvas?.drawLine(i,height/2+10F,i,height/2-10F,osicolor)
                        i+=Convert.Dx1().toFloat()
                    }
                }
                //ось у
                canvas?.drawLine(width- 2*Convert.Dx1().toFloat(), 0F, width- 2*Convert.Dx1().toFloat(), height.toFloat(), osicolor)
                //стрелки для у
                canvas?.drawLine(width- 2*Convert.Dx1().toFloat(), 0F, width- 2*Convert.Dx1().toFloat() - 15, 75F, osicolor)
                canvas?.drawLine(width- 2*Convert.Dx1().toFloat(), 0F, width- 2*Convert.Dx1().toFloat() + 15, 75F, osicolor)
                //штрихи для у
                i = Convert.Dy1().toFloat()
                while (i<=height.toFloat())
                {
                    canvas?.drawLine(width- 2*Convert.Dx1().toFloat()-15.toFloat(),i,width- 2*Convert.Dx1().toFloat()+15.toFloat(),i,osicolor)
                    i+=Convert.Dy1().toFloat()
                }
            }
            else
            {
                if(ymin>=0) {
                    //ось х без всего
                    canvas?.drawLine(0F, height - 50.toFloat(), width.toFloat(), height - 50.toFloat(), osicolor)
                    //для х
                    canvas?.drawLine(width.toFloat(), height - 50.toFloat(), width.toFloat() - 75, height - 50.toFloat() - 20, osicolor)
                    canvas?.drawLine(width.toFloat(), height - 50.toFloat(), width.toFloat() - 75, height - 50.toFloat() + 20, osicolor)
                    //штрихи для х
                    i = 1F
                    while (i <= width.toFloat()) {
                        canvas?.drawLine(i, height - 50 + 10F, i, height - 50 - 10F, osicolor)
                        i += Convert.Dx1().toFloat()
                    }
                }
                else {
                    //ось х без всего
                    canvas?.drawLine(0F, height / 2.toFloat(), width.toFloat(), height / 2.toFloat(), osicolor)
                    //для х
                    canvas?.drawLine(width.toFloat(), height.toFloat() / 2, width.toFloat() - 75, height.toFloat() / 2 - 20, osicolor)
                    canvas?.drawLine(width.toFloat(), height.toFloat() / 2, width.toFloat() - 75, height.toFloat() / 2 + 20, osicolor)
                    //штрихи для х
                    i = 1F
                    while (i <= width.toFloat()) {
                        canvas?.drawLine(i, height / 2 + 10F, i, height / 2 - 10F, osicolor)
                        i += Convert.Dx1().toFloat()
                    }
                }
                //ось у без всего
                canvas?.drawLine(width/2.toFloat(),0F,width/2.toFloat(),height-50.toFloat(),osicolor)

                //для у
                canvas?.drawLine(width.toFloat()/2,0F,width.toFloat()/2-15,75F,osicolor)
                canvas?.drawLine(width.toFloat()/2,0F,width.toFloat()/2+15,75F,osicolor)



                //штрихи для у
                i = Convert.Dy1().toFloat()
                while (i<=height.toFloat())
                {
                    canvas?.drawLine(width/2-15.toFloat(),i,width/2+15.toFloat(),i,osicolor)
                    i+=Convert.Dy1().toFloat()
                }
            }
        }
        //рисование графика
        if(f==0)
        {
            var j=1F
            while(j<width-2)
            {
                var point1 = Convert.yDecToPix(ymax,Convert.xPixToDec(xmin,j)*Convert.xPixToDec(xmin,j)+5*Math.cos(Convert.xPixToDec(xmin,j).toDouble()))
                var point2 = Convert.yDecToPix(ymax,Convert.xPixToDec(xmin,j+1)*Convert.xPixToDec(xmin,j+1)+5*Math.cos(Convert.xPixToDec(xmin,j+1).toDouble()))
                canvas?.drawLine(j,point1,j+1,point2,grafcolor)
                j++
            }
        }
        else
        {
            var j=1F
            while(j<width-2)
            {
                var point1 = Convert.yDecToPix(ymax,Math.abs(Math.sqrt(16-(16*Math.pow(Convert.xPixToDec(xmin,j).toDouble(),2.0)/36).toDouble())))
                var point2 = Convert.yDecToPix(ymax,Math.abs(Math.sqrt(16-(16*Math.pow(Convert.xPixToDec(xmin,j+1).toDouble(),2.0)/36).toDouble())))
                canvas?.drawLine(j,point1,j+1,point2,grafcolor)
                j++
            }
        }
    }
}