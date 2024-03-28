package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var text: TextView
    lateinit var one: Button
    lateinit var two: Button
    lateinit var twozero: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var zero: Button
    lateinit var point: Button
    lateinit var plus: Button
    lateinit var equal: Button
    lateinit var CE: Button
    lateinit var minus: Button
    lateinit var per: Button
    lateinit var multi: Button
    lateinit var div: Button
    lateinit var del: Button

    var array = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        twozero = findViewById(R.id.twozero)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        point = findViewById(R.id.point)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)
        CE = findViewById(R.id.CE)
        minus = findViewById(R.id.minus)
        per = findViewById(R.id.per)
        multi = findViewById(R.id.multi)
        div = findViewById(R.id.div)
        del = findViewById(R.id.del)


        array.add(one)
        array.add(two)
        array.add(three)
        array.add(four)
        array.add(five)
        array.add(six)
        array.add(seven)
        array.add(eight)
        array.add(nine)
        array.add(zero)
        array.add(twozero)
        array.add(point)
        array.add(plus)
        array.add(equal)
        array.add(CE)
        array.add(minus)
        array.add(multi)
        array.add(div)
        array.add(per)
        array.add(del)

        click(0)
        click(1)
        click(2)
        click(3)
        click(4)
        click(5)
        click(6)
        click(7)
        click(8)
        click(9)
        click(10)
        click(11)
        click(12)
        click(13)
        click(14)
        click(15)
        click(16)
        click(17)
        click(18)
        click(19)
    }

    var firstvalue = 0.0
    var secondvalue = 0.0
    var tempvalue = 0.0
    var anss = 0.0

    fun click(i: Int) {
        array[i].setOnClickListener {

            if (array[i].text.toString().equals("+") || array[i].text.toString()
                    .equals("-") || array[i].text.toString().equals("x") || array[i].text.toString()
                    .equals("/")
            ) {
                try {
                    procees(array[i].text.toString(), i)
                } catch (i: Exception) {

                }
            } else if (array[i].text.toString().equals("=")) {
                try {
                    answer(i)
                } catch (i: Exception) {

                }

            } else if (array[i].text.toString().equals("C")) {
                firstvalue = 0.0
                secondvalue = 0.0
                tempvalue = 0.0
                anss = 0.0
                text.setText("")
                OperatorSign.plus = false
                OperatorSign.minus = false
                OperatorSign.multi = false
                OperatorSign.div = false
            } else if (array[i].text.toString().equals(".")) {
                if (1 > text.text.indexOf(".")) {
                    if (text.text.isEmpty()) {
                        text.setText(text.text.toString() + "0.")
                    } else {
                        text.setText(text.text.toString() + ".")
                    }
                }
            } else if (array[i].text.toString().equals("%")) {
                try {
                    firstvalue = text.text.toString().toDouble() / 100
                    text.setText(firstvalue.toString())
                } catch (i: Exception) {

                }
            } else if (array[i].text.toString().equals("⌫")) {
                try {
                    text.setText(text.text.substring(0, text.text.length - 1))
                } catch (i: Exception) {

                }
            } else if (array[i].text.toString().equals("0")) {

                if (text.text.toString().isEmpty()) {
                    text.setText("0")
                } else if (text.text.equals("0")) {
                    text.setText("0")
                } else if (text.text.toString() != "0") {
                    text.setText(text.text.toString() + "0")
                }

            } else if (array[i].text.toString().equals("00")) {

                if (text.text.toString().isEmpty()) {
                    text.setText("0")
                } else if (text.text.equals("0")) {
                    text.setText("0")
                } else if (text.text.toString() != "0") {
                    text.setText(text.text.toString() + "00")
                }
            } else {
                text.setText(text.text.toString() + array[i].text)
            }
        }
    }

    private fun answer(i: Int) {
        secondvalue = text.text.toString().toDouble()
        if (OperatorSign.plus) {
            anss = firstvalue + secondvalue
        } else if (OperatorSign.minus) {
            anss = firstvalue - secondvalue
        } else if (OperatorSign.multi) {
            anss = firstvalue * secondvalue
        } else if (OperatorSign.div) {
            anss = firstvalue / secondvalue
        }
        text.setText(anss.toString())
        firstvalue = 0.0
        secondvalue = 0.0
        anss = 0.0
        OperatorSign.plus = false
        OperatorSign.minus = false
        OperatorSign.multi = false
        OperatorSign.div = false
    }

    private fun procees(s: String, i: Int) {

        tempvalue = text.text.toString().toDouble()

        if (OperatorSign.plus) {
            firstvalue = tempvalue + firstvalue
        } else if (OperatorSign.minus) {
            firstvalue = tempvalue - firstvalue
        } else if (OperatorSign.multi) {
            firstvalue = tempvalue * firstvalue
        } else if (OperatorSign.div) {
            firstvalue = tempvalue / firstvalue
        } else {
            firstvalue = tempvalue
        }

        if (array[i].text.toString().equals("+")) {
            OperatorSign.plus = true
        } else if (array[i].text.toString().equals("-")) {
            OperatorSign.minus = true
        } else if (array[i].text.toString().equals("x")) {
            OperatorSign.multi = true
        } else if (array[i].text.toString().equals("/")) {
            OperatorSign.div = true
        }

        text.setText("")
    }
}

class OperatorSign {
    companion object {
        var plus: Boolean = false
        var minus: Boolean = false
        var multi: Boolean = false
        var div: Boolean = false
    }
}
