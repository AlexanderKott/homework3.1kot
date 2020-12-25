import java.lang.IllegalArgumentException

//Задача №1 - "Только что"

/*
 от 0 до 60  "только что"
 от 61 до 3600 (один час)   "минут назад"
 от 3601 до 86400 (сутки)  "часов назад"
 от 86401 до двух 172800 "сегодня"
 от 172801 двух суток до трёх 259201, то - "вчера"
 больше трёх суток 259202, >  "давно"

 */

const val time_0_60 = "только что"
const val time_61_3600 = " назад" //"минуту назад"
const val time_3601_86400 = " назад" //часа назад
const val time_86401_172800 = "сегодня"
const val time_172801_259201 = "вчера"
const val time_more_259202 = "давно"

val secArray = arrayOf<String>("секунда","секунды","секунд")
val minArray = arrayOf<String>("минута","минуты","минут")
val hourArray = arrayOf<String>("час","часа","часов")
val dayArray = arrayOf<String>("день","дня","дней")


fun getTimeLabel(time: Int = 0)  {
    val msg = when (time) {
        in 0..60  -> {
            print(timePhrase(time, secArray))
            time_0_60}

        in 61..3600 -> {
            var numberOfMinutes: Int = ((time % 86400) % 3600) / 60
            print(timePhrase(numberOfMinutes, minArray))
            time_61_3600
        }

        in 3601..86400 -> {
            var numberOfHours = (time % 86401) / 3600
            print(timePhrase(numberOfHours,hourArray))

            time_3601_86400
        }
        in 86401..172800 -> {
            var numberOfDays = time / 86400
            print(timePhrase(numberOfDays, dayArray))
            time_86401_172800
        }
        in 172801..259201 -> {
            var numberOfDays = time / 86400
            print(timePhrase(numberOfDays ,dayArray))
            time_172801_259201
        }
        in 259202..Long.MAX_VALUE -> {
            var numberOfDays = time / 86400
            print(timePhrase(numberOfDays,dayArray))
            time_more_259202
        }
        else -> throw IllegalArgumentException("wrong time")
    }

    print(" $msg ")
    println("  $time")
}


fun timePhrase(count: Int, words: Array<String>): String? {
    print(" $count ")
    var remaining = count % 100
    if (remaining < 11 || remaining > 14) {
        remaining = count % 10
        if (remaining == 1) return words[0]
        if (remaining >= 2 && remaining <= 4) return words[1]
    }
    return words[2]
}

fun main() {
 println("Time      message     time in secs:")
    getTimeLabel(0)
    getTimeLabel(1)
    getTimeLabel(2)
    getTimeLabel(3)
    getTimeLabel(60)
    getTimeLabel(61)
    getTimeLabel(3660)
    getTimeLabel(3661)
    getTimeLabel(3665)
    getTimeLabel(9665)
    getTimeLabel(86400)
    getTimeLabel(86401)
    getTimeLabel(86402)
    getTimeLabel(86401)
    getTimeLabel(86402)
    getTimeLabel( 172800)
    getTimeLabel( 172801)
    getTimeLabel( 172802)
    getTimeLabel(  259201) 
    getTimeLabel(  259202) 
    getTimeLabel(  259206) 
}