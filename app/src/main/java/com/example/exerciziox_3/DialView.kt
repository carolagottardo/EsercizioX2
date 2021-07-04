package com.example.exerciziox_3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class DialView : View {
    //initialize painting and drawing values.
    private var stateText = "OFF"

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    //ON state.
    private var onColorPaint = Color.GREEN
    private var onTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var onStateText = "I"

    //OFF state.
    private var offColorPaint = Color.RED
    private var offTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var offStateText = "0"

    private var mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var stateSwitch = false



    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }



    private fun init() {
        //default state.
        paint.color = offColorPaint

        mTextPaint.setColor(Color.BLACK)
        mTextPaint.setTextAlign(Paint.Align.CENTER)
        mTextPaint.setTextSize(85f)
        mTextPaint.style = Paint.Style.FILL_AND_STROKE

        onTextPaint.setColor(Color.rgb(170, 28, 28))
        onTextPaint.setTextAlign(Paint.Align.CENTER)
        onTextPaint.setTextSize(100f)
        onTextPaint.style = Paint.Style.FILL_AND_STROKE

        offTextPaint.setColor(Color.WHITE)
        offTextPaint.setTextAlign(Paint.Align.CENTER)
        offTextPaint.setTextSize(100f)
        offTextPaint.style = Paint.Style.FILL_AND_STROKE



        setOnClickListener {
            if (stateSwitch) {
                stateSwitch = false
                paint.color = offColorPaint
                stateText = "OFF"
                onTextPaint.setColor(Color.rgb(170, 28, 28))
                offTextPaint.setColor(Color.WHITE)
            } else {
                stateSwitch = true
                paint.color = onColorPaint
                stateText = "ON"
                onTextPaint.setColor(Color.WHITE)
                offTextPaint.setColor(Color.rgb(84, 168, 27))
            }
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //main rectangle.
        canvas.drawRect(700f, 450f, 400f, 1150f, paint)

        //state text.
        canvas.drawText(stateText, 550f, 350f, mTextPaint)

        //state "button"
        canvas.drawText(onStateText, 550f, 1050f, onTextPaint)
        canvas.drawText(offStateText, 550f, 600f, offTextPaint)
    }
}