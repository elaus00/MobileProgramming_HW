package com.example.hw_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw_2.ui.theme.HW_2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            countCharacters()
        }
    }
}

@Composable
fun calculator() {
    val capacity = 100
    val numbers = listOf(1, 30, 20, 20, 0)
    val operators = listOf( '/', '+', '*', '%', '/')

    // Iterate using indices since numbers and operators are both lists
    for (i in 0 until 5) {
        val number = numbers[i]
        val operator = operators[i]
        val expression = "$capacity $operator $number"

        // Perform the operation using when expression
        val result = when (operator) {
            '+' -> capacity + number
            '-' -> capacity - number
            '*' -> capacity * number
            '/' -> try {
                capacity / number
            }
            // In case of division by zero
            catch (e: ArithmeticException) {
                "Cannot divide by zero"
            }
            '%' -> try {
                capacity % number
            } catch (e: ArithmeticException) {
                "Cannot divide by zero"
            }
            else -> "Invalid operator"
        }
        Log.d("ITM", "result: $result, (expression: $expression)")
    }
}

private fun capacityAndLog() {
    val fixedCapacityList = listOf(3, 10, 20)
    var capacity = 0

    for (i in fixedCapacityList) {
        // Initialize array1 with null values
        val array1 = mutableSetOf<Int>()

        // Fill array1 with random numbers ranged from 1 to 100
        while (array1.size < i) {
            array1.add(Random.nextInt(1, 101))
        }
        // Convert array1 to myUniqueArray and print it
        val myUniqueArray = array1.toIntArray().contentToString()

        capacity = i

        Log.d("ITM", "result: $myUniqueArray, (capacity: $capacity)")
    }
}

private fun countWords() {
    // Initialize array consists of string values
    val strLine = arrayOf(
        "Seoul national University of Science and Technology",
        "Seoul Station",
        "IT Management",
        "Android and Kotlin is not that difficult",
        "Exit"
    )

    // Print values in array and count number of words
    for (i in strLine) {
        val result = i.count { it.isWhitespace()} + 1
        Log.d("ITM", "The number of words is $result")
    }
}

private fun rotateString() {
    var str = "I Love Kotlin"
    var i = 0

    while (i < str.length+1){
        Log.d("ITM", str)

        //Rotate str by extract the first character and add it to the end of the string
        str = str.substring(1) + str[0]
        i++
    }
}

private fun isPalindrome() {
    // Initialize array consists of string values
    val str = arrayOf(
        "jinwoo",
        "SEOUL",
        "DDADD",
        "WoWoW"
    )

    //reverse string and compare
    for (i in str){
        // if matched, print palindrome
        if (i.reversed() == i) {
            Log.d("ITM", "$i is palindrome!")
        } else {
            Log.d("ITM", "$i is not palindrome!")
        }
    }
}

private fun sameNumber() {
    val testNum = 99
    val fixedNumbers = listOf(95, 99)

    // If number in array equal to testNum, print Yes! else print No!
    for (number in fixedNumbers) {
        if (number == testNum) {
            Log.d("ITM", "Yes! two numbers are same! (Number: $number)")
        } else {
            Log.d("ITM", "No! two numbers are not same! (Number: $number)")
        }
    }
}


private fun countCharacters() {
    val sequence = "abcabcdefabc"
    val charCountMap = mutableMapOf<Char, Int>()

    // Count occurrences of each character
    for (char in sequence) {
        charCountMap[char] = charCountMap.getOrDefault(char, 0) + 1
    }

    // Log the count of each character
    for ((char, count) in charCountMap) {
        Log.d("ITM", "$char: $count")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HW_2Theme {
        Greeting("Android")
    }
}