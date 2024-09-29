package com.example.hw_3

import android.location.Address
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        problem1()
        problem2()
        problem3()

        // problem5 and problem6 utilize a list from problem4
        val items = problem4()
        problem5(items)
        problem6(items)

        problem7()
        problem8()
        problem9()
        problem10()

    }
}

/**
 * Implementation for given Problems
 */

/* Problem 1 */
class Grade(val math: Int, val science: Int, val english: Int) {
    // Calculate average of given scores
    fun average(): Int {
        return (math + science + english) / 3
    }
}

fun problem1() {
    // create Grade object with random scores
    val math = Random.nextInt(0, 101)
    val science = Random.nextInt(0, 101)
    val english = Random.nextInt(0, 101)

    // Create Instance of Grade class
    val me = Grade(math, science, english)

    /* Test Code */
    Log.d("ITM","my math: $math, my science: $science, my english: $english")
    Log.d("ITM","Average is ${me.average()}")
}

/* Problem 2 */
// Code base
open class Point(open var x: Int, open var y: Int) {
    fun move(x: Int, y: Int) {
        this.x = x //현재클래스의 x값이 move로 들어온 인자 x로 바뀌는 것
        this.y = y //현재클래스의 y값이 move로 들어온 인자 y로 바뀌는 것
    }

    open fun show(){
        Log.d("ITM","Current Point: ($x, $y)")
    }
}

fun problem2() {
    // Implement ColorPoint class overriding Point class
    class ColorPoint(x: Int, y: Int, var color: String) : Point(x,y){
        override fun show() {
            Log.d("ITM","Color: $color Point: ($x, $y)")
        }

        // Override property y to print Log when y is changed
        override var y: Int
            get() = super.y
            set(value) {
                super.y = value
                Log.d("ITM","Y has been changed to $y")
            }

        // Set the point using setPoint()
        fun setPoint(x: Int, y: Int){
            this.x = x
            this.y = y
        }
    }
    /* Test Code */
    val p = Point(5,5)
    p.x=10
    p.y=20
    p.show()

    val cp = ColorPoint(5, 5, "YELLOW")
    cp.setPoint(10, 20)
    cp.color = "GREEN"
    cp.y=100
    cp.show()
}

/* Problem 3 */
data class Item(val name:String, var share:Int = 0, var price:Int = 0)

fun problem3() {
    // Code base
    val item1 = Item(name="jiwoo1").apply{
        share = 100
        price = 500
    }

    /* Test Code */
    Log.d("ITM", "${item1.name} item was created")
    Log.d("ITM", "price set to ${item1.price}, Are you serious?")
}

/* Problem 4 */
fun problem4() : MutableList<Item> {
    // declare list of items
    val items = mutableListOf<Item>()
    val name = "jiwoo"

    // add items to list
    for (i in 1..10) {
        items.add(Item(name="$name${i}"))
        items[i-1].share = Random.nextInt(100)
        items[i-1].price = Random.nextInt(1000)
    }

    /* Test Code */
    items.forEach {
        Log.d("ITM", "price set to ${it.price}, Are you serious?")
        Log.d("ITM", "${it.name} item was created")
    }
    // Print the whole list
    items.forEach {
        Log.d("ITM", "name : ${it.name}     price : ${it.price}")
    }

    return items
}

/* Problem 5 */
fun problem5(items: MutableList<Item>){
    val filteredItems = items.filter { it.price > 500 }
    val result = filteredItems.joinToString(", ") { "Item(name=${it.name})" }
    Log.d("ITM", "[$result]")
}

/* Problem 6 */
fun problem6(items: List<Item>) {
    val str = items.run {
        // sort the list based on price
        val sortedList = sortedBy { it.price }

        // pass the sorted list to also statement
        sortedList
    }.also { sortedItems ->
        // print the list contents with capital letters
        val uppercaseResult = sortedItems.joinToString(", ") { "Item(name=${it.name.uppercase() })"}
        Log.d("ITM", "[$uppercaseResult]")
    }
}

/* Problem 7 */
fun problem7() {
    val address1 = "Nooooooo!!"
    val address2 = null
    val address3 = "jinw.jeong@seoultech.ac.kr"

    // sendEmail version1
    sendEmail(address1)
    sendEmail(address2)
    sendEmail(address3)

    // sendEmail version2
    sendEmail2(address1)
    sendEmail2(address2)
    sendEmail2(address3)
}

// Regular expression for email validation
val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()

// sendEmail version1
fun sendEmail(address: String?) {
    // Check nullability using elvis operator
    val verifiedAddress = address ?: run {
        Log.d("ITM", "Failed to send email. Please enter a valid email address")
        return
    }

    // Validate the email address
    if (emailRegex.matches(verifiedAddress)) {
        Log.d("ITM", "Email sent to $verifiedAddress")
    } else {
        Log.d("ITM", "Failed to send email. Please enter a valid email address")
    }
}

// sendEmail version2
fun sendEmail2(address: String?) {
    when {
        address == null || !emailRegex.matches(address) ->
            Log.d("ITM", "Failed to send email. Please enter a valid email address")
        else -> Log.d("ITM", "Email sent to $address")
    }
}

/* Problem 8 */
fun problem8() {
    val floor = 5
    draw_pyramid(floor)
}

fun draw_pyramid(floor: Int) {
    val pyramid = StringBuilder().run {
        for (i in 1..floor) {
            // make each line of pyramid using repeat
            val line = " ".repeat(floor - i) + "*".repeat(2 * i - 1)
            append(line)
            append("\n")
        }
        toString()
    }
    // Print pyramid in console
    println(pyramid)

    // Print pyramid in Logcat
    Log.d("ITM", "$pyramid\n")
}

/* Problem 9 */
fun problem9() {
    val input1 = listOf("hello", "world", "Kotlin", "is", "awesome") // change this line to test other string lists
    Log.d("ITM",transformStrings(input1).toString())
}

fun transformStrings(input: List<String>): Map<String, Int> {
    return input
        .map { it.uppercase() } // convert each string to uppercase
        .filter { it.length >= 4 } // filter out strings with length less than 4
        // associate function can transform the component of a list to a map.
        // Here, it(each string of the List) goes to key and it.length(length the string) goes to value
        .associate { it to it.length }
}

/* Problem 10 */
fun problem10() {
    val str = "seoul_tech_itm"
    val str2 = "main_activity_xml"
    Log.d("ITM","${snakeToCamelCase(str2)} (original: ${str2})")
}

fun snakeToCamelCase(input: String): String {
    val words = input.split("_") // split the string by "_"
    val camelString = StringBuilder()

    for (i in words.indices) {
        when {
            i == 0 -> camelString.append(words[i]) // for the first string, just add it to the camelString
            else -> camelString.append(words[i].replaceFirstChar { it.uppercase() }) // for the rest of the strings, capitalize the first letter and add it to the camelString
        }
    }
    return camelString.toString()
}

