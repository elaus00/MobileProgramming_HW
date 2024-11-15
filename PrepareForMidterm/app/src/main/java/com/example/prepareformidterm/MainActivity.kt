package com.example.prepareformidterm

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        problem7()
    }


}

fun temp(){
        //        val sum = {x:Int, y:Int -> x+y}
    //        val multiply:(Int, Int)->Unit = {x, y ->
    //            Log.d("ITM", "x*y=${x+y}")
    //        }
    //
    //        Log.d("ITM", "by lambda: ${sum(2,3)}")
    //        Log.d("ITM", "by function: ${sum1(2,3)}")
    //        multiply(3,4)
    //        Log.d("ITM", highOrderFun({ x:Int, y:Int -> x.toString()+y.toString()}))
    //
    //        val numbers = listOf("one", "two", "three", "four", "five", "six")
    //        Log.d("ITM", numbers.first { it.length > 3 })
    //
    //        data class User(val name: String, val age: Int)
    //
    //        val uData = User("jinwoo",38)
    //        Log.d("ITM",uData.toString())
    //        val uData2 = uData.copy(age=28)
    //        Log.d("ITM","this is real: ${uData2.toString()}")

        val arr = IntArray(5) { it*2}
        for (i in arr){
            Log.d("ITM", "$i")
        }


        println("나는 바보다")

        val a: String? = null
        val b: String? = null
        val c = b?.length ?: "noooo"
        val property1 = a?.compareTo((b ?: 0).toString()) ?: "뭐"

        Log.d("ITM","$property1")
        Log.d("ITM","${(b?.length)}")
        Log.d("ITM","${(a?.length)}") // A에 대해서는 필수적이지 않은 콜. 왜냐? 애초에 null을 허용하지 않는 변수니까.
        Log.d("ITM","$c") // A에 대해서는 필수적이지 않은 콜. 왜냐? 애초에 null을 허용하지 않는 변수니까.
    fun sum1(x:Int, y:Int) : Int{
        return x+y
    }

    fun highOrderFun(f:(Int, Int)->(String)) : String{
        return f(2,3)
    }
}

open class Base(val name: String) {
    init {
        Log.d("ITM", "Initializing a base class")
    }

    open val size: Int =
        name.length.also { Log.d("ITM", "Initializing size in the base class: $it") }
}

class Derived(name: String, val lastName: String) :
    Base(name.replaceFirstChar { it.uppercase() }
        .also { Log.d("ITM", "Argument for the base class: $it") }) {

    init {
        Log.d("ITM", "Initializing a derived class")
    }

    override val size: Int =
        (super.size + lastName.length).also {
            Log.d(
                "ITM",
                "Initializing size in the derived class: $it"
            )
        }
}



//     val arr: IntArray = IntArray(10) { it + 1 } // 1부터 10까지의 IntArray 생성
//     val first = arr[0]       // 첫 번째 요소 접근
//     val first2 = arr.first() // 첫 번째 요소 접근 (first() 사용)
//     val first3 = arr.get(0)  // 첫 번째 요소 접근 (get() 사용)
//     val last = arr.last()    // 마지막 요소 접근

//     println(Arrays.toString(arr)) // 배열 내용 출력
//     println("first: $first $first2 $first3 last: $last")

//     arr[0] = 100       // 첫 번째 요소를 100으로 변경
//     arr.set(1, 200)    // 두 번째 요소를 200으로 설정 (set() 사용)
//     println(Arrays.toString(arr)) // 변경된 배열 출력

//     arr.sort() // 배열을 오름차순으로 정렬
//     val arr2 = arr.sortedArrayDescending() // 내림차순 정렬된 새 배열 생성

//     println(Arrays.toString(arr))  // 오름차순 정렬된 배열 출력
//     println(Arrays.toString(arr2)) // 내림차순 정렬된 새 배열 출력

